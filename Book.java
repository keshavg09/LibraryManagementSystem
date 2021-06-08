package com.example.project2part3;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String mtitle;

    @ColumnInfo(name = "author")
    private String mauthor;

    @ColumnInfo(name = "genre")
    private String mgenre;

    public Book(String mtitle, String mauthor, String mgenre){
        this.mtitle = mtitle;
        this.mauthor = mauthor;
        this.mgenre = mgenre;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMtitle(){
        return mtitle;
    }

    public void setMtitle(String mtitle){
        this.mtitle = mtitle;
    }

    public String getMauthor(){
        return mauthor;
    }

    public void setMauthor(String mauthor) {
        this.mauthor = mauthor;
    }

    public String getMgenre(){
        return mgenre;
    }

    public void setMgenre(String mgenre){
        this.mgenre = mgenre;
    }
}
