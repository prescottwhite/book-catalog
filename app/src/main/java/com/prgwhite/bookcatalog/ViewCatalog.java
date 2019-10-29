package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ViewCatalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_catalog);

        final ListView lv = findViewById(R.id.listView);
        final List<String> books_list = new ArrayList<>();
        BookDatabase db = new BookDatabase(this);
        final ListIterator<Book> iterator = db.getBooks().listIterator();
        showBooks(lv, books_list, iterator);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ViewBook.class);
                intent.putExtra(getString(R.string.intent_int), position);
                startActivity(intent);
            }
        });
    }

    public void showBooks(ListView lv, List<String> books_list, ListIterator<Book> iterator) {
        Book book;
        String title;
        String author;
        String year;

        final ArrayAdapter<String> arrayAdapter;

        while (iterator.hasNext()) {
            book = iterator.next();
            title = book.getTitle();
            author = book.getAuthor();
            year = Integer.toString(book.getYear());

            books_list.add("\"" + title + "\"" + " by " + author + ", published in " + year);
        }

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, books_list);
        lv.setAdapter(arrayAdapter);
    }
}
