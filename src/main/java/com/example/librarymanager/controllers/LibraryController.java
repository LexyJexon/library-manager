package com.example.librarymanager.controllers;

import com.example.librarymanager.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.librarymanager.repo.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class LibraryController {

    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/library")
    public String library(Model model){
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "library";

    }

    @GetMapping("/library/add")
    public String addBook(Model model){
        return "add-book";
    }

    @PostMapping("/library/add")
    public String addBookPost(@RequestParam String title, @RequestParam String author, @RequestParam int price, Model model){
        List<String> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book(title, authors, price);
        bookRepository.save(book);
        return "redirect:/library";
    }
}
