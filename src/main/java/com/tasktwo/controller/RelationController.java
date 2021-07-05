package com.tasktwo.controller;

import com.tasktwo.dto.RelationRequest;
import com.tasktwo.model.Relation;
import com.tasktwo.service.RelationService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relations")
public class RelationController {

  @Autowired private RelationService relationService;

  @PostMapping
  @ApiOperation(value = "Add Relation")
  public ResponseEntity<Relation> create(@RequestBody RelationRequest relation) {
    if (relation == null
        || relation.getColor() == null
        || relation.getName() == null
        || relation.getParentId() == null) {
      return new ResponseEntity("Invalid Input", HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity(relationService.create(relation), HttpStatus.CREATED);
  }

  @GetMapping
  @ApiOperation(value = "Get all Relations")
  public ResponseEntity<List<Object>> getAll() {
    return new ResponseEntity(relationService.getAll(), HttpStatus.OK);
  }
}
