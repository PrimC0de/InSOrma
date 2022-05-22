package com.example.insorma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter {
    ArrayList<TransactionPlaceholder> transactionPlaceholder = new ArrayList<>();

    public TransactionAdapter(Activity activity, int resource, ArrayList<TransactionPlaceholder> objects) {
        super(activity, resource, objects);
        transactionPlaceholder = objects;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        LayoutInflater LIF = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = LIF.inflate(R.layout.transaction_page_list,null);


        TextView Name = view.findViewById(R.id.furnitureName);
        TextView ID = view.findViewById(R.id.furnitureID);



        Name.setText(transactionPlaceholder.get(position).getFurnitureName());
        ID.setText(transactionPlaceholder.get(position).getTransactionID());

        return view;
    }
}
