package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ManageSystemActivity  extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managesystem);
        View CreateAccountButton = findViewById(R.id.SubmitButton2);
        CreateAccountButton.setOnClickListener(this);
    }

    public void onClick(View V) {
        EditText uinput;
        String userin;
        EditText pinput;
        String passin;
        TextView result;

        if (V.getId() == R.id.SubmitButton2) {
            uinput = findViewById(R.id.usernametext2);
            userin = uinput.getText().toString();
            pinput = findViewById(R.id.passwordtext2);
            passin = pinput.getText().toString();
            result = findViewById(R.id.view3);

            if(userin.matches("")||passin.matches("")){
                result.setText("Please do not leave any fields blank.");
            }
            else if(userin.matches("!admin2") && passin.matches("!admin2")){
                Intent i = new Intent(this, TransactionActivity.class);
                startActivity(i);
            }
            else{
                result.setText("This sign-in is only for admin accounts.");
            }

        }
    }
}