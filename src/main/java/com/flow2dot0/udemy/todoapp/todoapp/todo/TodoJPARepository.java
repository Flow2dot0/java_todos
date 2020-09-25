package com.flow2dot0.udemy.todoapp.todoapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
