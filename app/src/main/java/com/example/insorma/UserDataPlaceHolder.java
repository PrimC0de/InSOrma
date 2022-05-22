package com.example.insorma;

import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;


public class UserDataPlaceHolder extends AppCompatActivity {

    String ID, Email, Password, Username, PhoneNumber;

    //constructor
    public UserDataPlaceHolder(String ID, String email, String password, String username, String phoneNumber) {
        this.ID = ID;
        Email = email;
        Password = password;
        Username = username;
        PhoneNumber = phoneNumber;
    }

    //getter & setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
