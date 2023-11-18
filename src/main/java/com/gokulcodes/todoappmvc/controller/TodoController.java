package com.gokulcodes.todoappmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gokulcodes.todoappmvc.entity.TodoApp;
import com.gokulcodes.todoappmvc.service.TodoService;

@Controller
@RequestMapping("/todoApps")
public class TodoController {

    //define the field
     private TodoService theTodoService;

    //constructor injection 


    public TodoController(TodoService theTodoService) {
        this.theTodoService = theTodoService;
    }


    @GetMapping("list")
    public String showAllTasks(Model theModel){
        // get all from database
        List<TodoApp> theTodoApp = theTodoService.findTaskAll();

        //add to the model attribute
        theModel.addAttribute("todoApps", theTodoApp);


        //return the html form 
        return "todo/todo-list";

    }
    @GetMapping("/showFormForAddTask")
    public String showFormForAddTask(Model theModel){
        // create a new obejct and bind the data into the model attribute
        TodoApp theTodoApp = new TodoApp();

        // bind the data to the attribute model
        theModel.addAttribute("todoApp", theTodoApp);
     
       // return the todo-list form
       return "todo/todo-form";
    }
    @GetMapping("/showFormForEdit")
    public String showFormForEdit(@RequestParam("todoId") long id, Model theModel){

      //get the id 
      TodoApp theTodoApp = theTodoService.findTaskById(id);

      // add to model attribute
      theModel.addAttribute("todoApp", theTodoApp);

      //return the form
      return "todo/todo-form";

    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("todoApp") TodoApp theTodoApp){
        theTodoService.saveTheTask(theTodoApp);

        return "redirect:/todoApps/list";
    }

    @GetMapping("/deleteTask")
    public String delete(@RequestParam("todoId") long id){
        theTodoService.deleteTaskById(id);

        return "redirect:/todoApps/list";
    }
    
}
