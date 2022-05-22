package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.insorma.LoginPage.key;

public class ProfilePage extends AppCompatActivity {

    int position;
    String _userUserName, _userEmail, _userPhoneNumber, _userPassword;
    TextView userEmail, userUsername, userPhoneNumber;
    EditText newUserUsername;
    Button editButton, saveChanges, deleteButton, logOut;
    ImageButton home;
    ImageButton transaction;
    ImageButton profile;
    public static final String key = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        userEmail = findViewById(R.id.userEmail);
        userUsername = findViewById(R.id.userUsername);
        userPhoneNumber = findViewById(R.id.userPhoneNumber);
        newUserUsername = findViewById(R.id.newUserUsername);
        editButton = findViewById(R.id.editButton);
        saveChanges = findViewById(R.id.saveChanges);
        deleteButton = findViewById(R.id.deleteButton);
        logOut = findViewById(R.id.logOut);

        home = this.findViewById(R.id.Home);
        transaction = this.findViewById(R.id.Transaction);
        profile = this.findViewById(R.id.Profile);

        //setPreferences blm ada
        SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);
        _userUserName = prefs.getString("UserName", "No username");
        String NEWUSERNAME = prefs.getString("UserName", "No username");
        userUsername.setText("Username: "+_userUserName);

        _userEmail = prefs.getString("Email", "No Email");
        userEmail.setText("Email: "+_userEmail);

        _userPhoneNumber = prefs.getString("PhoneNumber", "No Phonenumber");
        userPhoneNumber.setText("Phone Number: "+_userPhoneNumber);

        position = prefs.getInt("poisition",position);
        _userPassword = prefs.getString("password", "");

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editButton.setVisibility(View.INVISIBLE);
                saveChanges.setVisibility(View.VISIBLE);
                deleteButton.setVisibility(View.VISIBLE);
                userUsername.setVisibility(View.INVISIBLE);
                newUserUsername.setVisibility(View.VISIBLE);


            }
        });

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!newUserUsername.getText().toString().equals(NEWUSERNAME)){
                    userUsername.setText(newUserUsername.getText().toString());
                    editButton.setVisibility(View.VISIBLE);
                    newUserUsername.setVisibility(View.INVISIBLE);
                    saveChanges.setVisibility(View.INVISIBLE);
                    deleteButton.setVisibility(View.INVISIBLE);
                    userUsername.setVisibility(View.VISIBLE);

                    SharedPreferences.Editor pass = getSharedPreferences(key, MODE_PRIVATE).edit();
                    pass.putString("UserName",newUserUsername.getText().toString());

                    pass.commit();
                }else{
                    Toast.makeText(ProfilePage.this,"failed: same username", Toast.LENGTH_LONG).show();
                }

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, LoginPage.class);
                _userUserName = "";
                _userEmail = "";
                _userPhoneNumber = "";
                _userPassword = "";


                startActivity(intent);

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, LoginPage.class);
                intent.putExtra("Email",prefs.getString("Email",""));
                intent.putExtra("Password",prefs.getString("Password",""));
                intent.putExtra("UserName",prefs.getString("UserName",""));
                intent.putExtra("PhoneNumber",prefs.getString("PhoneNumber",""));

                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, MainPage.class);
                startActivity(intent);
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, TransactionPage.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }
}