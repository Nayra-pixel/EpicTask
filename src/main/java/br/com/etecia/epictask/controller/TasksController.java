package br.com.etecia.epictask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.etecia.epictask.model.Task;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    
    private List<Task> repository= new ArrayList<>();

    @GetMapping

    public String listTasks(Model model){
        
            model.addAttribute("tasks", repository);

        return "tasks";

    }

    @GetMapping("/form")
    public String showForm(){
        return "form";

    }

    @PostMapping("/form")
    public String create(Task task, RedirectAttributes redirect){
        System.out.println("Cadastrando Procedimento..." + task);
        repository.add(task);
        redirect.addFlashAttribute("message", "Procedimento Cadastrado com Sucesso");
        return "redirect:/tasks";
    }

}
