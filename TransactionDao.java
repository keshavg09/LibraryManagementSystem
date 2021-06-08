package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {

    @Insert
    void addTransaction(Transaction t);

    @Query("select * from transactions")
    List<Transaction> getAllTransactions();

    @Query("select count(*) from transactions")
    int count();

    @Delete
    void delete(Transaction t);
}
