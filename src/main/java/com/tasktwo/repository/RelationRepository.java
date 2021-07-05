package com.tasktwo.repository;

import com.tasktwo.model.Relation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationRepository extends JpaRepository<Relation, Integer> {

  @Query(
      value =
          "SELECT p.name as parent, s.name as subClass from relation s JOIN relation p ON s.parent_id = p.id;",
      nativeQuery = true)
  List<Object[]> getRelations0();

  default Map<String, Set<String>> getRelations() {
    List<Object[]> resultSet = getRelations0();
    Map<String, Set<String>> relationsMap = new HashMap<>();
    for (Object[] objArr : resultSet) {
      String parent = (String) objArr[0];
      Set<String> subClasses;
      if (relationsMap.containsKey(parent)) {
        subClasses = relationsMap.get(parent);
      } else {
        subClasses = new HashSet<>();
      }
      subClasses.add((String) objArr[1]);
      relationsMap.put(parent, subClasses);
    }
    return relationsMap;
  }
}
