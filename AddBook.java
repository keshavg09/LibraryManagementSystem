package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddBook extends AppCompatActivity implements View.OnClickListener {

    private EditText titlein;
    private EditText authorin;
    private EditText genrein;
    private String titleS;
    private String authorS;
    private String genreS;
    private Librarydb ldb;
    private List<Book> BookList;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        View CreateAccountButton = findViewById(R.id.submitButton3);
        CreateAccountButton.setOnClickListener(this);
        ldb = Librarydb.getInstance(this);
        BookList = ldb.book().getAllBooks();
        result = findViewById(R.id.view4);
    }

    public void onClick(View V) {
        if (V.getId() == R.id.submitButton3) {
            titlein = findViewById(R.id.title1);
            titleS = titlein.getText().toString();

            authorin = findViewById(R.id.author1);
            authorS = authorin.getText().toString();

            genrein = findViewById(R.id.genre1);
            genreS = genrein.getText().toString();

            boolean duplicate = false;
            for(int i = 0; i < BookList.size(); i++){
                if(BookList.get(i).getMtitle().matches(titleS) && BookList.get(i).getMauthor().matches(authorS)){
                    duplicate = true;
                }
            }


            if(titleS.matches("") || authorS.matches("") || genreS.matches("")){
                result.setText("Please do not leave any of the fields blank");
            }
            else if(duplicate){
                result.setText("Book Entered Already Exists");
            }
            else{
                Intent i = new Intent(this, MainActivity.class);
                ldb.book().addBook(new Book(titleS, authorS, genreS));
                Toast.makeText(this, "Book Added", Toast.LENGTH_LONG).show();
                startActivity(i);
            }

        }
    }
}
