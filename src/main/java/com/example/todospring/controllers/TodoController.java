package com.example.todospring.controllers;

import com.example.todospring.entity.Todo;
import com.example.todospring.service.TodoRepository;
import com.example.todospring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("todos", todoService.findAllToDos());
        return "index";
    }

    @PostMapping(value = "/todo", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createToDo(@ModelAttribute("todo") Todo toDoRequest){
        Todo todo = new Todo();
        todo.setDescription(toDoRequest.getDescription());
        todo.setDueDate(toDoRequest.getDueDate());
        todo.setStatus(toDoRequest.getStatus());
        todo.setOwner(toDoRequest.getOwner());
        todo.setPriority(toDoRequest.getPriority());
        todoService.addToDo(todo);
        return "redirect:/";
    }

//    @GetMapping("/todo")
//    public List<Todo> getAllToDos() {
//        List<Todo> allToDos = todoService.findAllToDos();
//        return allToDos;
//    }


    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getToDo(@PathVariable Long id){
        Optional<Todo> todo = todoService.findSingleToDo(id);

        if (todo.isPresent()) {
            return ResponseEntity.ok(todo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> updateToDo(@PathVariable Long id, @RequestBody Todo toDoRequest){
        Todo updatedToDo = todoService.updateToDo(id, toDoRequest);
        if (updatedToDo != null){
            return ResponseEntity.ok(updatedToDo);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/todo/{id}")
    public void deleteToDo(@PathVariable Long id){
        todoService.deleteToDo(id);
    }

//    public String getTodoPage(Model model) {
//        Todo todo = new Todo();
//        todo.setDescription(todo.getDescription());
//        todo.setDueDate(new LocalDate());
//        todo.setStatus(todo.getStatus());
//        todo.setOwner(todo.getOwner());
//        todo.setPriority(todo.getPriority());
//
//        model.addAttribute("todo", todo);
//
//        return "todo";
//    }
}



