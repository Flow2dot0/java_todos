package com.flow2dot0.udemy.todoapp.todoapp.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: flow2dot0-osx
 * Date: 16/09/2020
 * Time: 13:19
 */
@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "username", "Learn to dance", new Date(), false));
        todos.add(new Todo(++idCounter, "username", "Learn to Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "username", "Learn to Angular", new Date(), false));
    }

    public Todo save(Todo todo){
        if(todo.getId()==-1 || todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if(todo == null) return null;
        if(todos.remove(todo)) return todo;

        return null;
    }

    public Todo findById(long id) {
        for(Todo todo:todos){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

}
