package com.tasktwo.service;

import com.tasktwo.dto.RelationRequest;
import com.tasktwo.model.Relation;
import com.tasktwo.repository.RelationRepository;
import com.tasktwo.utils.LogMethodParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RelationServiceImpl implements RelationService {

  @Autowired private RelationRepository relationRepository;

  @Override
  @LogMethodParam
  public Relation create(RelationRequest relation) {
    return relationRepository.save(
        Relation.builder()
            .parentId(relation.getParentId())
            .name(relation.getName())
            .color(relation.getColor())
            .build());
  }

  @Override
  public List<Object> getAll() {
    Map<String, Set<String>> relationsMap = relationRepository.getRelations();
    Set<String> subClasses = new HashSet<>();
    relationsMap.values().stream().forEach(x -> subClasses.addAll(x));
    return buildHierarchy(relationsMap.keySet(), subClasses, relationsMap, true);
  }

  private boolean isParent(Map<String, Set<String>> relationsMap, String entity) {
    return relationsMap.containsKey(entity);
  }

  private boolean isSubClass(Set<String> subClasses, String entity) {
    return subClasses.contains(entity);
  }

  private List<Object> buildHierarchy(
      Collection<String> entities,
      Set<String> subClassesSet,
      Map<String, Set<String>> relationsMap,
      boolean isRoot) {
    List<Object> list = new ArrayList<>();
    for (String entity : entities) {
      if (isParent(relationsMap, entity) && isSubClass(subClassesSet, entity) && isRoot) {
        continue;
      }
      Map<String, Object> map = new TreeMap<>();
      map.put("name", entity);
      if (relationsMap.containsKey(entity)) {
        List<Object> subClasses =
            buildHierarchy(relationsMap.get(entity), subClassesSet, relationsMap, false);
        map.put("subClasses", subClasses);
      }
      list.add(map);
    }
    return list;
  }
}
