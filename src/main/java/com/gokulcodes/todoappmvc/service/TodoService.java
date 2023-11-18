package com.gokulcodes.todoappmvc.service;

import java.util.List;

import com.gokulcodes.todoappmvc.entity.TodoApp;


public interface TodoService {

    List<TodoApp>findTaskAll(); //to view all

    TodoApp saveTheTask(TodoApp theTodoApp); //to edit and create

    TodoApp findTaskById(long id); // find task by id 
    
    void deleteTaskById(long id);
}
