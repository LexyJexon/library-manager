package com.example.librarymanager.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public String username;
    private String password;
    private Integer balance = 0;

    @ElementCollection
    public HashMap<String, Long> books;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void changePassword(String oldPassword,String newPassword){
        if (oldPassword.equals(this.password)){
            this.setPassword(newPassword);
        }
    }

    public Integer getBalance(){
        return this.balance;
    }

    public void topUpBalance(Integer topUpSum){
        this.balance += topUpSum;
    }

    public void writeOffBalance(Integer writeOffSum){
        this.balance -= writeOffSum;
    }

    public void addBook(Book book){
        if (!this.books.containsKey(book.title)){
            this.books.put(book.title, book.getId());
            book.availability = false;
        }
    }

    public User() {
    }
}
