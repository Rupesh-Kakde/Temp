package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // 1. Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(
            taskService.getAllTasks()
        );
    }

    // 2. Get task by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(
            @PathVariable int id) {

        Task task = taskService.getTaskById(id);

        if (task != null) {
            return ResponseEntity.ok(task);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Task not found");
    }

    // 3. Add new task
    @PostMapping
    public ResponseEntity<Task> addTask(
            @RequestBody Task task) {

        Task newTask = taskService.addTask(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newTask);
    }

    // 4. Update task
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(
            @PathVariable int id,
            @RequestBody Task task) {

        Task updatedTask =
                taskService.updateTask(id, task);

        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Task not found");
    }

    // 5. Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable int id) {

        boolean deleted =
                taskService.deleteTask(id);

        if (deleted) {
            return ResponseEntity.ok(
                "Task deleted successfully"
            );
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Task not found");
    }

    // 6. Get tasks by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Task>> getTasksByCategory(
            @PathVariable String category) {

        return ResponseEntity.ok(
            taskService.getTasksByCategory(category)
        );
    }
}