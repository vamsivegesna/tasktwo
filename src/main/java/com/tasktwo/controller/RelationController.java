package com.tasktwo.controller;

import com.tasktwo.dto.RelationRequest;
import com.tasktwo.model.Relation;
import com.tasktwo.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relations")
public class RelationController {

    @Autowired
    private RelationService relationService;

    @PostMapping
    public ResponseEntity<Relation> create(@RequestBody RelationRequest relation) {
        return new ResponseEntity(relationService.create(relation), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Object>> getAll() {
        return new ResponseEntity(relationService.getAll(), HttpStatus.OK);
    }
}
