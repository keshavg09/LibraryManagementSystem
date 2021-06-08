package com.example.project2part3;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Account.class, Book.class, Transaction.class}, version = 6, exportSchema = false)
public abstract class Librarydb extends RoomDatabase{

    private static Librarydb sInstance;
    public abstract AccountDao account();
    public abstract BookDao book();
    public abstract TransactionDao transaction();

    public static synchronized Librarydb getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    Librarydb.class,
                    "Library.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData(){
        if(account().count() == 0){
            runInTransaction(new Runnable(){
                @Override
                public void run() {
                    account().addAccount(new Account("anton", "t3nn1sch@mp2021"));
                    account().addAccount(new Account("bernie", "k3ralaf@n"));
                    account().addAccount(new Account("shirleybee", "carmel2chicago"));
                    account().addAccount(new Account("!admin2", "!admin2"));
                }
            });
        }
        if(book().count() == 0){
            runInTransaction(new Runnable(){
                @Override
                public void run() {
                    book().addBook(new Book("Kitchen Confidential", "Anthony Bourdain", "Memoir"));
                    book().addBook(new Book("The IDA Pro Book", "Chris Eagle", "Computer Science"));
                    book().addBook(new Book("Frankenstein", "Mary Shelley", "Fiction"));
                }
            });
        }
    }

}
