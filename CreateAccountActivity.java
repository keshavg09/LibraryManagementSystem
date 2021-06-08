package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private Librarydb ldb;
    private List<Account> AccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
        View SubmitButton = findViewById(R.id.SubmitButton);
        SubmitButton.setOnClickListener(this);
        ldb = Librarydb.getInstance(this);
        //ldb.populateInitialData();
        AccountList = ldb.account().getAllAccounts();
    }

    public void onClick(View V) {
        EditText uinput;
        String userin;
        EditText pinput;
        String passin;
        TextView result;

        if (V.getId() == R.id.SubmitButton) {
            uinput = findViewById(R.id.usernametext);
            userin = uinput.getText().toString();
            pinput = findViewById(R.id.passwordtext);
            passin = pinput.getText().toString();
            result = findViewById(R.id.response);
            boolean duplicate = false;
            for(int i = 0; i < AccountList.size(); i++){
                if(AccountList.get(i).getMusername().matches(userin)){
                    duplicate = true;
                }
            }
            if(userin.matches("")|| passin.matches("")){
                result.setText("Please do not leave either field blank.");
            }else if(duplicate == true){
                Toast.makeText(this, "Username already exists", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }else{
                ldb.account().addAccount(new Account(userin, passin));
                ldb.transaction().addTransaction(new Transaction("new account", userin, 0));
                Toast.makeText(this, "Account created", Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }

        }
    }
}
