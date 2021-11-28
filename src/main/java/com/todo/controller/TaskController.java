package com.todo.controller;

import java.util.List;

import com.todo.dto.TaskDto;
import com.todo.entity.Task;
import com.todo.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/tasks")
public class TaskController {

  @Autowired
  TaskService taskService;

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET)
  public List<TaskDto> getTaskList() {
    List<TaskDto> taskList = taskService.getTaskList();
    return taskList;
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.POST)
  public Boolean saveTask(@RequestBody Task task) {
    Boolean result = taskService.saveTask(task);
    return result;
  }

  @ResponseBody
  @RequestMapping(method = RequestMethod.PUT)
  public Boolean editTask(@RequestBody Task task) {
    Boolean result = taskService.editTask(task);
    return result;
  }

  @ResponseBody
  @RequestMapping(path = "/{taskId}", method = RequestMethod.DELETE)
  public Boolean deleteTask(@PathVariable("taskId") Integer taskId) {
    Boolean result = taskService.deleteTask(taskId);
    return result;
  }

  @ResponseBody
  @RequestMapping(path = "/{taskId}/is_completed", method = RequestMethod.PUT)
  public Boolean changeCompletedFlg(@PathVariable("taskId") Integer taskId, @RequestBody Task task) {
    Boolean result = taskService.changeCompletedFlg(taskId, task.getIsCompleted());
    return result;
  }
}
