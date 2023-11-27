package com.example.librarymanager.models;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
//    public String serial;
    public String title;

    @ElementCollection
    public List<String> authors;
    public Integer price;
//    public Integer amount;
    @BooleanFlag
    public Boolean availability;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Book(String title, List<String> authors, Integer price) {
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.availability = true;
    }

    public Book() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return authors;
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
