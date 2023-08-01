package com.example.new_one;

import java.util.List;

public class Model {
    public String username;
    public String pass;
    public String email;

    public Model(String username, String pass, String email) {
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    public Model() {

    }

    @Override
    public String toString() {
        return "Model{" +
                "username='" + username + '\'' +
                ", pass=" + pass +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



