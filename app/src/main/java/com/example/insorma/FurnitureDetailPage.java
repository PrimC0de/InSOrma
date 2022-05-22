package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FurnitureDetailPage extends AppCompatActivity {
    ImageView furniturePic;
    TextView furnitureName, furnitureRating, furniturePrice, furnitureDesc;
    EditText quantity;
    Button buy;
    String _furnitureName, _furnitureRating, _furniturePrice, _furnitureDesc;
    Integer _furnitureImage;

    ImageButton home;
    ImageButton transaction;
    ImageButton profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail_page);



        furniturePic = this.findViewById(R.id.ProductPic);
        furnitureName = findViewById(R.id.furnitureName);
        furnitureRating = findViewById(R.id.furnitureRating);
        furniturePrice = findViewById(R.id.furniturePrice);
        furnitureDesc = findViewById(R.id.furnitureDesc);
        quantity = findViewById(R.id.furnitureQuantity);
        buy = findViewById(R.id.buyFurnitureButton);

        Bundle furnitureData = getIntent().getExtras();
        if(furnitureData != null){

            _furnitureImage = furnitureData.getInt("Image");
            _furnitureName= furnitureData.getString("Name");
            _furnitureRating = furnitureData.getString("Rating");
            _furniturePrice = furnitureData.getString("Price");
            _furnitureDesc = furnitureData.getString("Desc");


            furnitureName.setText(_furnitureName);
            furnitureRating.setText(_furnitureRating);
            furniturePrice.setText(_furniturePrice);
            furnitureDesc.setText(_furnitureDesc);
        }

        home = this.findViewById(R.id.Home);
        transaction = this.findViewById(R.id.Transaction);
        profile = this.findViewById(R.id.Profile);
        quantity.setText("0");

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(quantity.getText().toString()) > 0) {
                    Toast.makeText(FurnitureDetailPage.this, "success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(FurnitureDetailPage.this, TransactionPage.class);
                    intent.putExtra("buyName", furnitureName.getText().toString());
                    intent.putExtra("buyQuantity",quantity.getText().toString());
                    intent.putExtra("buyPrice", furniturePrice.getText().toString());
                    Toast.makeText( FurnitureDetailPage.this, furnitureName.getText().toString(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }
                else if(quantity.getText().toString().equals("0")){
                    Toast.makeText(FurnitureDetailPage.this, "failed", Toast.LENGTH_LONG).show();
                }
            }

        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FurnitureDetailPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FurnitureDetailPage.this, TransactionPage.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FurnitureDetailPage.this, ProfilePage.class);
                startActivity(intent);
            }
        });

    }

}