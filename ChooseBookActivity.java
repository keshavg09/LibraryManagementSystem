package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ChooseBookActivity extends AppCompatActivity implements View.OnClickListener {

    private Librarydb ldb;
    private List<Book> BookList;
    private List<String> bookTitles = new ArrayList<String>();
    private String titles[];
    private Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosebook);
        ldb = Librarydb.getInstance(this);
        //ldb.populateInitialData();
        BookList = ldb.book().getAllBooks();

        String passed = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            passed = extras.getString("passedGenre");
        }

        int count = 0;
        for(int i = 0; i < BookList.size(); i++){
            if(BookList.get(i).getMgenre().matches(passed)){
                bookTitles.add(BookList.get(i).getMtitle());
            }
        }
        titles = new String[bookTitles.size()];
        titles = bookTitles.toArray(titles);
        if(bookTitles.size() == 0){
            Intent i = new Intent(this, MainActivity.class);
            Toast.makeText(this, "No books left for this genre", Toast.LENGTH_LONG).show();
            startActivity(i);
        }
        dropdown = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, titles);
        dropdown.setAdapter(adapter);

        View CreateAccountButton = findViewById(R.id.selectButton);
        CreateAccountButton.setOnClickListener(this);
    }

    public void onClick(View V) {
        if (V.getId() == R.id.selectButton) {
            String selected = (String) dropdown.getSelectedItem();
            if (selected != null) {
                Intent i = new Intent(ChooseBookActivity.this, SignInConfirm.class);
                Bundle extraInfo = new Bundle();
                extraInfo.putString("selected", selected);
                i.putExtras(extraInfo);
                startActivity(i);
            }
        }
    }
}
