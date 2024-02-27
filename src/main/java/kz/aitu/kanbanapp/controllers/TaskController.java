package kz.aitu.kanbanapp.controllers;

import kz.aitu.kanbanapp.models.Task;
import kz.aitu.kanbanapp.services.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskManager taskManager;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        taskManager.addTask(task);
        return task;
    }

    @GetMapping
    public List<Task> viewTasksByStatus(@RequestParam String status) {
        return taskManager.getTasksByStatus(status);
    }

    @PutMapping("/{taskId}")
    public void updateTaskStatus(@PathVariable int taskId, @RequestParam String status) {
        taskManager.updateTaskStatus(taskId, status);
    }
}
