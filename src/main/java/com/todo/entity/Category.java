package com.todo.entity;

import lombok.Data;

@Data
public class Category {
  private Integer id;
  private String name;
  private String color;
  private Integer status;
}
