package com.todo.todo.controller;

import com.todo.todo.dto.TaskDto;
import com.todo.todo.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task")
public class TaskEndpoint {
    private static Logger logger = LoggerFactory.getLogger(TaskEndpoint.class);
    @Autowired
    TaskService taskService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity addTask(@RequestBody TaskDto taskDto) {
        logger.info("POST request access '/task/add' path.", taskDto);
        Map<String, Object> response = new HashMap<>();
        TaskDto taskData = taskService.addTask(taskDto);
        response.put("message", "Task added successfully");
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateTask(@PathVariable String taskId, @RequestBody TaskDto taskDto) {
        logger.info("PUT request access '/task/update/:id' path." + taskId, taskId);
        Map<String, Object> response = new HashMap<>();
        TaskDto taskData = taskService.updateTask(taskId, taskDto);
        response.put("message", "Task updated successfully");
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTasks() {
        logger.info("GET request access '/task/list' path.");
        Map<String, List<TaskDto>> response = new HashMap<>();
        List<TaskDto> taskData = taskService.getTasks();
        response.put("data", taskData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteTask(@PathVariable String id) {
        logger.info("DELETE request access '/task/delete/:id' path.", id);
        Map<String, String> response = new HashMap<>();
        taskService.deleteTask(id);
        response.put("message", "Task deleted successfully, " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
