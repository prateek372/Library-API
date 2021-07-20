package com.training.demolibrary.controller;

import com.training.demolibrary.model.Book;
import com.training.demolibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all")
    public List<Book> getAllItems(){
        return this.bookService.getAllBooks();
    }

    @PostMapping(value = "/add")
    public String addBook(@RequestBody Book book){
        return this.bookService.addNewBook(book);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable String id){
        return this.bookService.deleteBook(id);
    }

    @PutMapping(value = "update/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book){
        this.bookService.updateBook(id, book);
    }

    @GetMapping(value = "all/{id}")
    public Book getSingleBook(@PathVariable String id){
        return this.bookService.getBookById(id);
    }

}
