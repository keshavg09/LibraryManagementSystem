package com.example.project2part3;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AccountDao {
    @Insert
    void addAccount(Account account);

    @Query("select * from accounts")
    List<Account> getAllAccounts();

    @Query("select count(*) from accounts")
    int count();

    @Delete
    void delete(Account account);
}
