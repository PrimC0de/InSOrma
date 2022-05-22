package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RegisterPage extends AppCompatActivity {

    EditText userEmail, userPassword,userUserName, userPhoneNumber;
    Button registerButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        userEmail = (EditText)findViewById(R.id.UserEmail);
        userPassword = (EditText)findViewById(R.id.UserPassword);
        userUserName = (EditText) findViewById(R.id.UserUsername);
        userPhoneNumber = (EditText)findViewById(R.id.UserPhoneNumber);
        registerButton = (Button)findViewById(R.id.RegisterButton);
        loginButton = (Button)findViewById(R.id.LoginButton);

        userEmail.setText("asd.com");
        userPassword.setText("dada123");
        userUserName.setText("adsd123");
        userPhoneNumber.setText("08123");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkValue(userEmail, userPassword, userUserName, userPhoneNumber) == 1){
                    Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                    intent.putExtra("Email",userEmail.getText().toString());
                    intent.putExtra("Password",userPassword.getText().toString());
                    intent.putExtra("UserName",userUserName.getText().toString());
                    intent.putExtra("PhoneNumber",userPhoneNumber.getText().toString());
                    startActivity(intent);

                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

    }

    public Integer checkValue(EditText userEmail, EditText userPassword, EditText userUserName, EditText userPhoneNumber){
        String regEx = "([A-Za-z]+[0-9]+|[0-9]+[A-Za-z])";
        if(userEmail.getText().toString().isEmpty() ||
                userUserName.getText().toString().isEmpty() ||
                userPhoneNumber.getText().toString().isEmpty() ||
                userPassword.getText().toString().isEmpty() ) {
            Log.i("Warning", "field empty");
            return 0;
        }
        if(!userEmail.getText().toString().endsWith(".com")) {
            userEmail.setError("Email Error");
            userEmail.requestFocus();
            return 0;
        }

        if(!(userUserName.getText().toString().length() <21) && !(userUserName.getText().toString().length() >2)) {
            userUserName.setError("Username Error");
            userUserName.requestFocus();
            return 0;
        }

        String asd;
        asd = userPassword.getText().toString();
        if(!asd.matches(regEx)){
            Toast.makeText(this, userPassword.getText(), Toast.LENGTH_SHORT).show();
            userPassword.setError("Password Error");
            userPassword.requestFocus();
            return 0;
        }

        return 1;
    }
}