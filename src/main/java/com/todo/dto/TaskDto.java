package com.todo.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TaskDto {
  private Integer id;
  private Integer categoryId;
  private String name;
  private String description;
  private Boolean isCompleted;
  private Integer status;
  private Date dueDate;
}
