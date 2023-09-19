package com.example.librarymanager;

import com.example.librarymanager.Books;

import java.util.ArrayList;

public class Users {
    public String username;
    private String password;
    private Integer balance = 0;
    public ArrayList<Books> books;

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

    public void addBook(Books book){
        if (!this.books.contains(book)){
            this.books.add(book);
        }
    }


}
