package com.todo.dao.mapper;

import java.util.List;

import com.todo.entity.Task;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {
  List<Task> getTaskList();

  Boolean saveTask(Task task);

  Boolean editTask(Task task);

  Boolean changeCompletedFlg(Integer taskId, Boolean isCompleted);

  Boolean deleteTask(Integer taskId);
}
