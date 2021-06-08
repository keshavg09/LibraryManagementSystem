package com.example.project2part3;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class SignInConfirm extends AppCompatActivity implements View.OnClickListener {
    private String passed = "";
    private Librarydb ldb;
    private List<Account> AccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ldb = Librarydb.getInstance(this);
        //ldb.populateInitialData();
        AccountList = ldb.account().getAllAccounts();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            passed = extras.getString("selected");
        }
        View CreateAccountButton = findViewById(R.id.SubmitButton1);
        CreateAccountButton.setOnClickListener(this);
    }

    public void onClick(View V) {
        EditText uinput;
        String userin;
        EditText pinput;
        String passin;
        TextView result;


        if (V.getId() == R.id.SubmitButton1) {
            uinput = findViewById(R.id.usernametext1);
            userin = uinput.getText().toString();
            pinput = findViewById(R.id.passwordtext1);
            passin = pinput.getText().toString();
            result = findViewById(R.id.view2);
            boolean exists = false;

            for(int i = 0; i < AccountList.size();i++){
                if(AccountList.get(i).getMusername().matches(userin) && AccountList.get(i).getMpassword().matches(passin) ){
                    exists = true;
                    break;
                }
            }

            if(userin.matches("") || passin.matches("")){
                result.setText("Please fill in all fields");
            }
            else if(exists){
                Intent i = new Intent(this, ConfirmActivity.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("selectedTitle", passed);
                extraInfo.putString("selectedUser", userin);
                i.putExtras(extraInfo);
                startActivity(i);
            }
            else{
                result.setText("Information not found");
            }
        }
    }
}
