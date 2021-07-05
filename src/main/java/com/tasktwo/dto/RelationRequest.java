package com.tasktwo.dto;

import lombok.Data;

@Data
public class RelationRequest {

  private Integer parentId;
  private String name;
  private String color;

  public String toString() {
    return "parentId : " + this.parentId + ", name : " + this.name + ", color : " + this.color;
  }
}
