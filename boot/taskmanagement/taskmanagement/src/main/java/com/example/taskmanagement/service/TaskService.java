package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public TaskService() {

        tasks.add(
            new Task(
                1,
                "Complete Java Practical",
                "Programming",
                "2026-09-21",
                false
            )
        );

        tasks.add(
            new Task(
                2,
                "Study Spring Boot",
                "Study",
                "2026-09-22",
                false
            )
        );
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task updateTask(int id, Task updatedTask) {

        Task existingTask = getTaskById(id);

        if (existingTask != null) {

            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCategory(updatedTask.getCategory());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setCompleted(updatedTask.isCompleted());

            return existingTask;
        }

        return null;
    }

    public boolean deleteTask(int id) {

        return tasks.removeIf(
            task -> task.getId() == id
        );
    }

    public List<Task> getTasksByCategory(String category) {

        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {

            if (task.getCategory()
                   .equalsIgnoreCase(category)) {

                result.add(task);
            }
        }

        return result;
    }
}