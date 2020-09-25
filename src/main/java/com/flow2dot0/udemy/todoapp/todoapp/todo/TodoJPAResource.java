package com.flow2dot0.udemy.todoapp.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * User: flow2dot0-osx
 * Date: 16/09/2020
 * Time: 13:07
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {

    @Autowired
    private TodoHardcodedService todoService;

    @Autowired
    private TodoJPARepository todoJPARepository;

    @GetMapping("jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJPARepository.findByUsername(username);
//        return todoService.findAll();
    }

    @GetMapping("jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoJPARepository.findById(id).get();
//        return todoService.findById(id);
    }

    @PutMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo todoUpated = todoJPARepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo createdTodo = todoJPARepository.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        todoJPARepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
