package br.com.etecia.epictask.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecia.epictask.model.Task;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    
    @GetMapping

    public String listTasks(){
        
        
        var tasks = List.of(
            new Task(1L, "Castração", "Castração Pitoco", 50, 0), 
            new Task(1L, "Vacinação", "Vacinação Pitoco", 50, 0), 
            new Task(1L, "Exame de Sangue", "Exame Pitoco", 50, 0)
            );
        
        return "tasks";

    }

}
