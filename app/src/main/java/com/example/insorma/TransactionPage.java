package com.example.insorma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.insorma.LoginPage.key;

public class TransactionPage extends AppCompatActivity {

    ArrayList<TransactionPlaceholder> transactionPlaceholder = new ArrayList<>();
    ListView listView;
    ImageButton home;
    ImageButton transaction;
    ImageButton profile;

    String _transactionID, _furnitureName, _transactionDate, _boughtQuantity, _totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_page);

        listView = findViewById(R.id.TransactionPageLV);
        home = this.findViewById(R.id.Home);
        transaction = this.findViewById(R.id.Transaction);
        profile = this.findViewById(R.id.Profile);


        transactionPlaceholder.add(new TransactionPlaceholder("F111", "Destiny", "31-01-2002", 1, 100));
        transactionPlaceholder.add(new TransactionPlaceholder("F222", "Destiny", "31-02-2002", 2, 200));
        transactionPlaceholder.add(new TransactionPlaceholder("F333", "Destiny", "31-03-2002", 3, 300));

        Bundle furnitureData = getIntent().getExtras();
        if(furnitureData != null){


            _furnitureName = furnitureData.getString("buyName");
            _totalPrice = furnitureData.getString("buyPrice");
            _boughtQuantity = furnitureData.getString("buyQuantity");

            transactionPlaceholder.add(new TransactionPlaceholder("F444", _furnitureName, "31-03-2002", Integer.parseInt(_boughtQuantity), Integer.parseInt(_totalPrice)*Integer.parseInt(_boughtQuantity)));

        }

        TransactionAdapter transactionAdapter = new TransactionAdapter(TransactionPage.this, R.layout.main_page_list, transactionPlaceholder);
        listView.setAdapter(transactionAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(TransactionPage.this, TransactionDetailPage.class);
                SharedPreferences.Editor pass = getSharedPreferences(key, MODE_PRIVATE).edit();
                pass.putString("transactionID",transactionPlaceholder.get(i).getTransactionID());
                pass.putString("furnitureName",transactionPlaceholder.get(i).getFurnitureName());
                pass.putString("transactionDate",transactionPlaceholder.get(i).getTransactionDate());
                pass.putInt("boughtQuantity",transactionPlaceholder.get(i).getBoughtQuantity());
                pass.putInt("furniturePrice",transactionPlaceholder.get(i).getTotalPrice());
                pass.putInt("position", i);
                pass.commit();
                startActivity(intent);
            }
        });




        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionPage.this, MainPage.class);
                startActivity(intent);
            }
        });

        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionPage.this, TransactionPage.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TransactionPage.this, ProfilePage.class);
                startActivity(intent);
            }
        });



    }
}