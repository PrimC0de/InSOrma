package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    EditText userEmail ;
    EditText userPassword ;
    Button loginButton ;
    Button registerButton ;
    ArrayList<UserDataPlaceHolder> Account;
    Integer counter, size;
    public static final String key = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        userEmail = (EditText)findViewById(R.id.UserEmail);
        userPassword = (EditText)findViewById(R.id.UserPassword);
        loginButton = (Button)findViewById(R.id.LoginButton);
        registerButton = (Button)findViewById(R.id.RegisterButton);


        Account = new ArrayList<>();
        //dummy data
        Account.add(new UserDataPlaceHolder("100", "100@gmail.com", "100", "100A", "100100"));
        Account.add(new UserDataPlaceHolder("101", "101@gmail.com", "101", "101A", "101101"));

        String _userID, _userEmail, _userPassword, _userUserName, _userPhoneNumber;

        Bundle userData = getIntent().getExtras();
        if(userData != null){

            _userEmail = userData.getString("Email");
            _userPassword = userData.getString("Password");
            _userUserName = userData.getString("UserName");
            _userPhoneNumber = userData.getString("PhoneNumber");

            size = Account.size();
            counter = Integer.parseInt(Account.get(size-1).getID());
//            _UserID = String.valueOf(counter);
            _userID = counter.toString();
            Account.add(new UserDataPlaceHolder(_userID, _userEmail, _userPassword, _userUserName, _userPhoneNumber));
        }

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                for(int i = 0;i<Account.size();i++){
                    if(Account.get(i).getEmail().equals(userEmail.getText().toString()) &&
                        Account.get(i).getPassword().equals(userPassword.getText().toString())){
                        //intent ke main page
                        Intent intent = new Intent(LoginPage.this, MainPage.class);

                        SharedPreferences.Editor pass = getSharedPreferences(key, MODE_PRIVATE).edit();
                        pass.putString("Email",Account.get(i).getEmail());
                        pass.putString("Password",Account.get(i).getPassword());
                        pass.putString("UserName",Account.get(i).getUsername());
                        pass.putString("PhoneNumber",Account.get(i).getPhoneNumber());
                        pass.putInt("position", i);
                        pass.commit();

                        startActivity(intent);

                        Log.i("Warning", "Mantap");
                        break;
                    }else if(!Account.get(i).getEmail().equals(userEmail.getText().toString()) &&
                            !Account.get(i).getPassword().equals(userPassword.getText().toString())){
                            if(i+1 == Account.size()) Toast.makeText(LoginPage.this,"No account or Wrong credential", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);

            }
        });

    }

}