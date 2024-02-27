package kz.aitu.kanbanapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kanban")
public class TaskController {
    @GetMapping
    public String greeting(){
        return "Welcome to your Personal Kanban!";
    }
}
