package com.afs.todolist.controller;

import com.afs.todolist.controller.mapper.TodoMapper;
import com.afs.todolist.entity.Todo;
import com.afs.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodos(@PathVariable String id) {
        todoService.deleteTodo(id);
        return true;
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable String id,@RequestBody Todo todo) {

        System.out.println(todo);
        todoService.updateTodo(id,todo);
        return todo;
    }
    @PostMapping()
    public Todo postTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return todo;
    }
}
