package com.prgwhite.bookcatalog;

public class Book {

    private String mTitle;
    private String mAuthor;
    private int mYear;
    private String mDesc;
    private String mISBN;
    private String mEbook;

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setYear(int year) {
        this.mYear = year;
    }

    public int getYear() {
        return mYear;
    }

    public void setDesc(String desc) {
        this.mDesc = desc;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setISBN(String isbn) {
        this.mISBN = isbn;
    }

    public String getISBN() {
        return mISBN;
    }

    public void setEbook(String ebook) {
        this.mEbook = ebook;
    }

    public String getEbook() {
        return mEbook;
    }
}
