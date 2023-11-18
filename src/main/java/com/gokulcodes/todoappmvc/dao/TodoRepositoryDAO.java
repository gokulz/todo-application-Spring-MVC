package com.gokulcodes.todoappmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gokulcodes.todoappmvc.entity.TodoApp;

@Repository
public interface TodoRepositoryDAO extends JpaRepository<TodoApp, Long>{
    
}
