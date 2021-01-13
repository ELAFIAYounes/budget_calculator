package com.fstt.banque;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fstt.banque.adapter.CustomListView;
import com.fstt.banque.models.Transaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText prix,date;
    TextView somme;
    Button ajouter;
    ListView listView;
    CustomListView customListView;
    ArrayList<Transaction> trans = new ArrayList<>();
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prix = findViewById(R.id.prix);
        date = findViewById(R.id.date);
        ajouter = findViewById(R.id.ajouter);
        listView = findViewById(R.id.listView);
        somme = findViewById(R.id.somme);
        customListView = new CustomListView(trans);
        listView.setAdapter(customListView);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String prix_ = prix.getText().toString().trim();
                String date_ = date.getText().toString().trim();

                if( prix_.equals("")){

                    prix.setError("Invalid champs");
                    return;
                }
                if( date_.equals("")){

                    date.setError("Invalid champs");
                    return;
                }
                // Check If u have enough money
                if(Double.parseDouble(prix_) < 0){

                    if(getSomme() - Math.abs(Double.parseDouble(prix_)) < 0 ){
                        Toast.makeText(getApplicationContext(),"solde insuffisant",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                // Ajouter nouvelle transaction
                try {
                    DateFormat DFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Date dateFormat = DFormat.parse(date_);
                    counter++;
                    Transaction transaction = new Transaction(counter,Double.parseDouble(prix_),dateFormat);
                    trans.add(transaction);
                    customListView.notifyDataSetChanged();
                    somme.setText("Somme : "+ getSomme());
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                date.setText("");
                prix.setText("");

            }
        });
    }
    private double getSomme(){
        double som = 0;
        for(Transaction transaction :trans){

            som += transaction.getPrix();
        }
        return som;
    }
}