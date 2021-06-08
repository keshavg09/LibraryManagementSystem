package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);

    @Query("select * from books")
    List<Book> getAllBooks();

    @Query("select count(*) from books")
    int count();

    @Delete
    void delete(Book book);
}
