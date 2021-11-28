package com.todo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Task {
  private Integer id;
  private Integer categoryId;
  private String name;
  private String description;
  private Boolean isCompleted;
  private Integer status;
  private Date dueDate;
}
