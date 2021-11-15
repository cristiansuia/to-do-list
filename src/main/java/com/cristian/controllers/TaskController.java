package com.cristian.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cristian.model.Task;
import com.cristian.services.TaskService;
import com.cristian.servicesimpl.TaskServiceImpl;

@Controller
@SessionAttributes("username")
public class TaskController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
    TaskService taskService;

	@GetMapping(value="/tasks")
    public ModelMap findAll(ModelMap model){
        String username = (String) model.get("username");
        model.addAttribute("tasks", taskService.findAllByUsername(username));
        return model;
    }
    
    @GetMapping("/addTask")
    public String addTaskView(Model model) {
        model.addAttribute("task", new Task());
        return "new-task";
    }
    
    @PostMapping("/addTask")
    public RedirectView addTask(ModelMap model, @ModelAttribute("task") Task task, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/tasks", true);
        task = taskService.addTask((String) model.get("username"), task);
        redirectAttributes.addFlashAttribute("savedTask", task);
        redirectAttributes.addFlashAttribute("addTaskSuccess", true);
        return redirectView;
    }
    
    @PostMapping("/delete")
    public RedirectView deleteTask(ModelMap model, @ModelAttribute("task") Task task, RedirectAttributes redirectAttributes) {
    	LOGGER.info("Delete task called for task with id: "+task.getId());
        final RedirectView redirectView = new RedirectView("/tasks", true);
        this.taskService.removeTask((String) model.get("username"), task);
        return redirectView;
    }

}
