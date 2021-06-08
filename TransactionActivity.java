package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TransactionActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView transactionListView;
    private Librarydb ldb;
    private List<Transaction> TransactionList;
    private ArrayAdapter<Transaction> transactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        transactionListView = findViewById(R.id.list_transactions);
        ldb = Librarydb.getInstance(this);
        TransactionList = ldb.transaction().getAllTransactions();
        transactionAdapter = new ArrayAdapter<>(this, R.layout.transactionlistview, R.id.log, TransactionList);
        transactionListView.setAdapter(transactionAdapter);
        View OkButton = findViewById(R.id.okButton);
        OkButton.setOnClickListener(this);
    }

    public void onClick(View V){
        if(V.getId() == R.id.okButton){
            Intent i = new Intent(this, AskForBookActivity.class);
            startActivity(i);
        }
    }
}
