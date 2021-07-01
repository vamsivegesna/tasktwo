package com.tasktwo.service;

import com.tasktwo.dto.RelationRequest;
import com.tasktwo.model.Relation;

import java.util.List;

public interface RelationService {

    Relation create(RelationRequest relation);
    List<Object> getAll();
}
