package br.com.etecia.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.etecia.epictask.model.Task;
import br.com.etecia.epictask.repository.TaskRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    
    //private List<Task> repository= new ArrayList<>();

    @Autowired
    private TaskRepository repository;

    @GetMapping
    public String listTasks(Model model,@AuthenticationPrincipal OAuth2User user){
        model.addAttribute("tasks", repository.findAll());
        model.addAttribute("user", user);
        
        return "tasks";
    }

    @GetMapping("/form")
    public String showForm(Task task){
        return "form";
    }

    @SuppressWarnings("null")
    @PostMapping("/form")
    public String create(@Valid Task task, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors())return "form";
        System.out.println("Cadastrando Procedimento..." + task);
        repository.save(task);
        redirect.addFlashAttribute("message", "Tarefa Cadastrada com Sucesso");
        return "redirect:/tasks";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        System.out.println("Deletando Tarefa" + id);
        repository.deleteById(id);
        redirect.addFlashAttribute("message", "Tarefa Deletada com Sucesso");
        return "redirect:/tasks";
    }

}
