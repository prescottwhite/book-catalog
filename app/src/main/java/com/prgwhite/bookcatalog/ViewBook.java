package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);

        TextView mTitle = findViewById(R.id.view_title);
        TextView mAuthor = findViewById(R.id.view_author);
        TextView mYear = findViewById(R.id.view_year);
        TextView mDesc = findViewById(R.id.view_desc);
        TextView mISBN = findViewById(R.id.view_isbn);
        TextView mEbook = findViewById(R.id.view_ebook);

        BookDatabase db = new BookDatabase(this);
        Book book;

        Intent intent = getIntent();
        int pos = intent.getIntExtra(getString(R.string.intent_int), 0);
        book = db.getBooks().listIterator(pos).next();

        mTitle.setText(book.getTitle());
        mAuthor.setText(book.getAuthor());
        mYear.setText(Integer.toString(book.getYear()));
        mDesc.setText(book.getDesc());
        mISBN.setText(book.getISBN());
        mEbook.setText(book.getEbook());
    }
}
