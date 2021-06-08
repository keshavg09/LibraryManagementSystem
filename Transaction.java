package com.example.project2part3;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactions")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "TransactionType")
    private String transactionType;

    @ColumnInfo(name = "username")
    private String user;

    @ColumnInfo(name = "reservationNum")
    private int reservationNum;

    public Transaction(String transactionType, String user, int reservationNum){
        this.transactionType = transactionType;
        this.user = user;
        this.reservationNum = reservationNum;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTransactionType(){
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getUser(){
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    @Override
    public String toString(){
        String out = "Transaction Type: "+ transactionType + "\nUsername: " + user + "\nReservation Number: " + reservationNum;
        return(out);
    }
}
