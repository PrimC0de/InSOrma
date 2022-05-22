package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.insorma.LoginPage.key;

public class TransactionDetailPage extends AppCompatActivity {

    TextView furnitureID, furnitureName, furnitureQuantity, furniturePrice, furnitureDate;
    ImageButton home, transaction, profile;
    public static final String key = "key";
    String _transactionID, _furnitureName, _transactionDate;
    Integer _boughtQuantity, _totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail_page);

        furnitureID = findViewById(R.id.furnitureID);
        furnitureName = findViewById(R.id.furnitureName);
        furnitureQuantity = findViewById(R.id.furnitureQuantity);
        furniturePrice = findViewById(R.id.furniturePrice);
        furnitureDate = findViewById(R.id.furnitureDate);

        home = this.findViewById(R.id.Home);
        transaction = this.findViewById(R.id.Transaction);
        profile = this.findViewById(R.id.Profile);

        SharedPreferences prefs = getSharedPreferences(key, MODE_PRIVATE);
        _transactionID = prefs.getString("transactionID", "asdasd");
        furnitureID.setText(_transactionID);

        _furnitureName = prefs.getString("furnitureName", "");
        furnitureName.setText(_furnitureName);

        _transactionDate = prefs.getString("transactionDate", "");
        furnitureDate.setText(_transactionDate);

        _boughtQuantity = prefs.getInt("boughtQuantity", 0);
        furnitureQuantity.setText(String.valueOf(_boughtQuantity));

        _totalPrice = prefs.getInt("furniturePrice", 0);
        furniturePrice.setText(String.valueOf(_totalPrice));



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionDetailPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionDetailPage.this, TransactionPage.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionDetailPage.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }
}