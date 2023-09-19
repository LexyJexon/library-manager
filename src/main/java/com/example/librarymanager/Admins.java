package com.example.librarymanager;

public class Admins {
    public String username;
    private String password;
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
}
