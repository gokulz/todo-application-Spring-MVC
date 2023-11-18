package com.gokulcodes.todoappmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gokulcodes.todoappmvc.dao.TodoRepositoryDAO;
import com.gokulcodes.todoappmvc.entity.TodoApp;

@Service
public class TodoServiceImpl implements TodoService {

    //define the field
    private TodoRepositoryDAO todoRepositoryDAO;

    //constructor injection 

    public TodoServiceImpl(TodoRepositoryDAO todoRepositoryDAO) {
        this.todoRepositoryDAO = todoRepositoryDAO;
    }

    @Override
    public List<TodoApp> findTaskAll() {
   
        return todoRepositoryDAO.findAll();
    }

    @Override
    public TodoApp saveTheTask(TodoApp theTodoApp) {
   
        return todoRepositoryDAO.save(theTodoApp);
    }

    @Override
    public void deleteTaskById(long id) {
        todoRepositoryDAO.deleteById(id);
        
 }

    @Override
    public TodoApp findTaskById(long id) {
        // define the find by id 

        Optional<TodoApp> theTaskResult = todoRepositoryDAO.findById(id);

        //assing the todo class local variable null
         TodoApp theTodoApp = null;

         if(theTaskResult.isPresent()){
            theTodoApp = theTaskResult.get();
         } else{
              throw new RuntimeException("The task of the Id not found " + id);
         }
      
        //return the result
      
        return theTodoApp;

        


    
    }


    


    
}
