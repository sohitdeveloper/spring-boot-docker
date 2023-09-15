package com.todo.todo.service;

import com.todo.todo.dto.TaskDto;

import java.util.List;

public interface TaskService  {
    TaskDto addTask(TaskDto taskDto);

    List<TaskDto> getTasks();

    void deleteTask(String id);

    TaskDto updateTask(String userId, TaskDto taskDto);
}
