package com.example.springdata.web.controller;


import com.example.springdata.SpringDataApplication;
import com.example.springdata.dao.IBookDAO;
import com.example.springdata.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Value("${me}")
    private String me;
    @Autowired
    private IBookDAO dao;

    @GetMapping(value="/Cestqui")
    public String getName(){
        return me;
    }
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return dao.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getAllBooks(@PathVariable int id){
        return dao.findById(id);
    }

    @GetMapping("/books/title/{title}")
    public Book getBook(@PathVariable String title){
        return dao.findByTitle(title);
    }
    @GetMapping("/books/author/{author}")
    public List<Book> getAuthorBooks(@PathVariable String author){
        return dao.findAllByAuthor(author);
    }

    @PostMapping("books")
    public Book addBook(@RequestBody Book book){

        if(dao.findById(book.getId()).isPresent()){
            dao.save(book);
            return dao.findByTitle(book.getTitle());
        }
        return null;
    }

    @PutMapping(value = "/books", produces="text/plain")
    public int replaceBook(@RequestBody Book book){
        //Book b =new Book(book.getTitle(),book.getAuthor(),book.getText());
        dao.save(book);
        return book.getId();
    }

    @DeleteMapping(value = "/books/{id}")
    public void supprimerBook(@PathVariable int id){
        dao.deleteById(id);
    }
}
