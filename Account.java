package com.example.project2part3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "username")
    private String musername;

    @ColumnInfo(name = "password")
    private String mpassword;

    public Account(String musername, String mpassword){
        this.musername = musername;
        this.mpassword = mpassword;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMusername(){
        return musername;
    }

    public void setMusername(String user){
        musername = user;
    }

    public String getMpassword(){
        return mpassword;
    }

    public void setMpassword(String pass){
        mpassword = pass;
    }
}
