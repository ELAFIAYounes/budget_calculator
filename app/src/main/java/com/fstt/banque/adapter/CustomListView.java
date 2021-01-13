package com.fstt.banque.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fstt.banque.R;
import com.fstt.banque.models.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomListView extends BaseAdapter {
    ArrayList<Transaction> trans;
    public CustomListView(ArrayList<Transaction> transaction) {
        trans = transaction;
    }

    @Override
    public int getCount() {
        return trans.size();
    }

    @Override
    public Transaction getItem(int position) {
        return trans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list,parent,false);
        }
        TextView id = convertView.findViewById(R.id.custom_id);
        TextView prix = convertView.findViewById(R.id.custom_prix);
        TextView date = convertView.findViewById(R.id.custom_dateT);
        id.setText(String.valueOf(getItem(position).getId()));
        prix.setText(String.valueOf(getItem(position).getPrix()));
        date.setText(new SimpleDateFormat("dd-MM-yyyy").format(getItem(position).getDateTransaction()));

        return convertView;
    }
}
