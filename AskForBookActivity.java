package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AskForBookActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_askforbook);
        View YesButton = findViewById(R.id.yesButton);
        YesButton.setOnClickListener(this);
        View NoButton = findViewById(R.id.noButton);
        NoButton.setOnClickListener(this);
    }

    public void onClick(View V) {
        if (V.getId() == R.id.yesButton) {
            Intent i = new Intent(this, AddBook.class);
            startActivity(i);
        }
        if (V.getId() == R.id.noButton) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}
