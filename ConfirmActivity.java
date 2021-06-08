package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private TextView user;
    private TextView num;
    private String passedTitle;
    private Librarydb ldb;
    private List<Book> BookList;
    private List<Transaction> TransactionList;
    private String passedUser;
    private int num1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        View ConfirmButton = findViewById(R.id.ConfirmButton);
        ldb = Librarydb.getInstance(this);
        //ldb.populateInitialData();
        BookList = ldb.book().getAllBooks();
        TransactionList = ldb.transaction().getAllTransactions();
        ConfirmButton.setOnClickListener(this);
        title = findViewById(R.id.viewbooktitle);
        user = findViewById(R.id.viewname);
        num = findViewById((R.id.viewconfirmnum));
        passedTitle = "";
        passedUser = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            passedTitle = extras.getString("selectedTitle");
            passedUser = extras.getString("selectedUser");
        }
        title.setText(passedTitle);
        user.setText(passedUser);

        Random rand = new Random();
        num1 = rand.nextInt(1000)+1;
        for(int i = 0; i < TransactionList.size(); i++){
            if(TransactionList.get(i).getReservationNum() == num1){
                num1 = rand.nextInt(1000)+1;
            }
        }
        String confirmationNum =  "Confirmation Number: " + String.valueOf(num1);
        num.setText(confirmationNum);
    }

    public void onClick(View V) {
        if (V.getId() == R.id.ConfirmButton) {
            Intent i = new Intent(this, MainActivity.class);
            for(int j = 0; j < BookList.size(); j++){
                if(BookList.get(j).getMtitle().matches(passedTitle)){
                    ldb.book().delete(BookList.get(j));
                    break;
                }
            }
            Toast.makeText(this, "Order Confirmed!", Toast.LENGTH_LONG).show();
            ldb.transaction().addTransaction(new Transaction("place hold", passedUser, num1));
            startActivity(i);
        }
    }

}
