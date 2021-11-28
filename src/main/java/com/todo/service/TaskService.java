package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.todo.dao.mapper.TaskMapper;
import com.todo.dto.TaskDto;
import com.todo.entity.Task;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  TaskMapper taskMapper;

  public List<TaskDto> getTaskList() {
    List<TaskDto> taskListDto = new ArrayList<TaskDto>();
    List<Task> taskListEntity = taskMapper.getTaskList();
    for (Task taskEntity : taskListEntity) {
      TaskDto taskDto = new TaskDto();
      BeanUtils.copyProperties(taskEntity, taskDto);
      taskListDto.add(taskDto);
    }
    return taskListDto;
  }

  public Boolean saveTask(Task task) {
    Boolean result = taskMapper.saveTask(task);
    return result;
  }

  public Boolean editTask(Task task) {
    Boolean result = taskMapper.editTask(task);
    return result;
  }

  public Boolean changeCompletedFlg(Integer taskId, Boolean isCompleted) {
    Boolean result = taskMapper.changeCompletedFlg(taskId, isCompleted);
    return result;
  }

  public Boolean deleteTask(Integer taskId) {
    Boolean result = taskMapper.deleteTask(taskId);
    return result;
  }
}
