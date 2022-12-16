package com.afs.todolist.service;

import com.afs.todolist.entity.Todo;
import com.afs.todolist.exception.InvalidIdException;
import com.afs.todolist.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void updateTodo(String id,Todo todo) {
        validateObjectId(id);
        todoRepository.save(todo);
    }

    private void validateObjectId(String id){
        if(!ObjectId.isValid(id)){
            throw new InvalidIdException(id);
        }
    }
}
