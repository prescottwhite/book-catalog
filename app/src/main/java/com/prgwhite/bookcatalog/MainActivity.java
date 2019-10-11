package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button launchAddActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchAddActivityBtn = findViewById(R.id.add_book_btn);

        launchAddActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startAddActivity();
            }
        });
    }

    public void startAddActivity() {
        Intent intent = new Intent(this, AddBook.class);
        startActivity(intent);
    }
}
