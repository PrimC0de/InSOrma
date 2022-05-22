package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.insorma.LoginPage.key;

public class MainPage extends AppCompatActivity {
    String _userEmail, _userPassword, _userUserName, _userPhoneNumber;

    ArrayList<FurniturePlaceholder> furniturePlaceholders = new ArrayList<>();
    ListView listView;
    TextView userName;
    ImageButton home;
    ImageButton transaction;
    ImageButton profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        listView = findViewById(R.id.MainPageLV);
        userName = findViewById(R.id.UserUsername);
        home = this.findViewById(R.id.Home);
        transaction = this.findViewById(R.id.Transaction);
        profile = this.findViewById(R.id.Profile);

        SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);
        _userUserName = prefs.getString("UserName", "No username");
        userName.setText(_userUserName);

        furniturePlaceholders.add(new FurniturePlaceholder("Destiny", "10/10", "1200", "Waifu", R.drawable.destiny_eating));
        furniturePlaceholders.add(new FurniturePlaceholder("Destiny2", "10/10", "1300", "Waifu", R.drawable.destiny_eating));
        furniturePlaceholders.add(new FurniturePlaceholder("Destiny3", "10/10", "1400", "Waifu", R.drawable.destiny_eating));

        FurnitureAdapter furnitureAdapter = new FurnitureAdapter(MainPage.this, R.layout.main_page_list, furniturePlaceholders);
        listView.setAdapter(furnitureAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainPage.this, FurnitureDetailPage.class);


                intent.putExtra("Image", furniturePlaceholders.get(i).getFurnitureImage());
                intent.putExtra("Name", furniturePlaceholders.get(i).getFurnitureName());
                intent.putExtra("Rating", furniturePlaceholders.get(i).getFurnitureRating());
                intent.putExtra("Price", furniturePlaceholders.get(i).getFurniturePrice());
                intent.putExtra("Desc", furniturePlaceholders.get(i).getFurnitureDesc());
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, TransactionPage.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage.this, ProfilePage.class);
                startActivity(intent);
            }
        });



    }


}