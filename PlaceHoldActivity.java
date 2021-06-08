package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceHoldActivity extends AppCompatActivity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholds);
        View MemoirButton = findViewById(R.id.memoirButton);
        MemoirButton.setOnClickListener(this);
        View CSButton = findViewById(R.id.csButton);
        CSButton.setOnClickListener(this);
        View FictionButton = findViewById(R.id.fictionButton);
        FictionButton.setOnClickListener(this);
    }

    public void onClick(View V){
        if(V.getId() == R.id.memoirButton){
            Intent i = new Intent(this, ChooseBookActivity.class);
            String passed = "Memoir";
            Bundle extraInfo = new Bundle();
            extraInfo.putString("passedGenre", passed);
            i.putExtras(extraInfo);
            startActivity(i);
        }
        if(V.getId() == R.id.csButton){
            Intent i = new Intent(this, ChooseBookActivity.class);
            String passed = "Computer Science";
            Bundle extraInfo = new Bundle();
            extraInfo.putString("passedGenre", passed);
            i.putExtras(extraInfo);
            startActivity(i);
        }
        if(V.getId() == R.id.fictionButton){
            Intent i = new Intent(this, ChooseBookActivity.class);
            String passed = "Fiction";
            Bundle extraInfo = new Bundle();
            extraInfo.putString("passedGenre", passed);
            i.putExtras(extraInfo);
            startActivity(i);
        }
    }
}

