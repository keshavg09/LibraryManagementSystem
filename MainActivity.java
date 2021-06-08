package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Librarydb ldb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View CreateAccountButton = findViewById(R.id.button);
        CreateAccountButton.setOnClickListener(this);
        View PlaceHoldButton = findViewById(R.id.button2);
        PlaceHoldButton.setOnClickListener(this);
        View ManageSystemButton = findViewById(R.id.button3);
        ManageSystemButton.setOnClickListener(this);
        ldb = Librarydb.getInstance(this);
        ldb.populateInitialData();
    }

    public void onClick(View V){
        if(V.getId() == R.id.button){
            Intent i = new Intent(this, CreateAccountActivity.class);
            startActivity(i);
        }
        if(V.getId() == R.id.button2){
            Intent i = new Intent(this, PlaceHoldActivity.class);
            startActivity(i);
        }
        if(V.getId() == R.id.button3){
            Intent i = new Intent(this, ManageSystemActivity.class);
            startActivity(i);
        }
    }
}