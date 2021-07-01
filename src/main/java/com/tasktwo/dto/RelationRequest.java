package com.tasktwo.dto;

import lombok.Data;

@Data
public class RelationRequest {

    private Integer parentId;
    private String name;
    private String color;
}
