package com.todo.todo.service.serviceImpl;

import com.todo.todo.dao.TaskDao;
import com.todo.todo.data.Task;
import com.todo.todo.dto.TaskDto;
import com.todo.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        Task task = new Task();
        UUID id = UUID.randomUUID();
        task.setTaskId(String.valueOf(id));
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDescription(taskDto.getTaskDescription());
        taskDao.save(task);
        taskDto.setTaskId(String.valueOf(id));
        return taskDto;
    }

    @Override
    public List<TaskDto> getTasks() {
        List<TaskDto> taskDtoList = new ArrayList<>();
        List<Task> tasks = taskDao.findAll();

        tasks.forEach(task -> {
            TaskDto taskDto = new TaskDto(String.valueOf(task.getTaskId()), task.getTaskName(), task.getTaskDescription());
            taskDtoList.add(taskDto);
        });
        return taskDtoList;
    }

    @Override
    public void deleteTask(String id) {
        taskDao.deleteById(id);
    }

    @Override
    public TaskDto updateTask(String taskId, TaskDto taskDto) {
        Task task = taskDao.getById(taskDto.getTaskId());
        if(task != null){
            task.setTaskName(taskDto.getTaskName());
            task.setTaskDescription(taskDto.getTaskDescription());
            taskDao.save(task);
            return taskDto;
        } else {
            return null;
        }
    }
}
