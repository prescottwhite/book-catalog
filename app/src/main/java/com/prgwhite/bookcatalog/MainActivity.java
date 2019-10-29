package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mLaunchAddActivityBtn;
    private Button mViewCatActivityBtn;
    private Button mExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLaunchAddActivityBtn = findViewById(R.id.add_book_btn);
        mViewCatActivityBtn = findViewById(R.id.view_cat_btn);
        mExitBtn = findViewById(R.id.exit_btn);

        mLaunchAddActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startAddActivity();
            }
        });

        mViewCatActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startViewCatActivity();
            }
        });

        mExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void startAddActivity() {
        Intent intent = new Intent(this, AddBook.class);
        startActivity(intent);
    }

    public void startViewCatActivity() {
        Intent intent = new Intent(this, ViewCatalog.class);
        startActivity(intent);
    }
}
