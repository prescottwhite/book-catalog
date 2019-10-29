package com.prgwhite.bookcatalog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BookDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "books.db";
    private static final int VERSION = 1;

    public BookDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final class BookTable {
        private static final String TABLE = "books";
        private static final String COL_TITLE = "title";
        private static final String COL_AUTHOR = "author";
        private static final String COL_YEAR = "year";
        private static final String COL_DESC = "description";
        private static final String COL_ISBN = "isbn";
        private static final String COL_EBOOK = "ebook";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + BookTable.TABLE + " (" +
                BookTable.COL_TITLE + " text, " +
                BookTable.COL_AUTHOR + " text, " +
                BookTable.COL_YEAR + " int, " +
                BookTable.COL_DESC + " text, " +
                BookTable.COL_ISBN + " text, " +
                BookTable.COL_EBOOK + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("drop table if exists " + BookTable.TABLE);
        onCreate(db);
    }

    public long addBook(String title, String auth, int year, String desc, String isbn, String ebook) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BookTable.COL_TITLE, title);
        values.put(BookTable.COL_AUTHOR, auth);
        values.put(BookTable.COL_YEAR, year);
        values.put(BookTable.COL_DESC, desc);
        values.put(BookTable.COL_ISBN, isbn);
        values.put(BookTable.COL_EBOOK, ebook);

        long id = db.insert(BookTable.TABLE, null, values);
        return id;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "select * from " + BookTable.TABLE;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setTitle(cursor.getString(0));
                book.setAuthor(cursor.getString(1));
                book.setYear(cursor.getInt(2));
                book.setDesc(cursor.getString(3));
                book.setISBN(cursor.getString(4));
                book.setEbook(cursor.getString(5));
                books.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return books;
    }
}