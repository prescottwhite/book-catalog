package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class AddBook extends AppCompatActivity {

    private static String KEY_AUTHOR = "author";

    private String titleSt;
    private String authorSt;
    private String yearSt;
    private int yearInt;
    private String descSt;
    private String isbnSt;
    private String ebookSt;

    private EditText mTitleText;
    private EditText mAuthorText;
    private EditText mYearText;
    private EditText mDescText;
    private EditText mISBNText;
    private Switch mEbookSwitch;

    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        mSaveButton = findViewById(R.id.save_btn);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });
    }

    public boolean validYear() {
        mYearText = findViewById(R.id.year_text);
        int yearInt;

        try {
            yearInt = Integer.parseInt(mYearText.getText().toString());
        } catch (Exception e) {
            return false;
        }

        if (yearInt <= Calendar.getInstance().get(Calendar.YEAR)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void saveEntry() {
        mTitleText = findViewById(R.id.title_text);
        titleSt = mTitleText.getText().toString().trim();

        mAuthorText = findViewById(R.id.author_text);
        authorSt = mAuthorText.getText().toString().trim();

        mYearText = findViewById(R.id.year_text);
        yearSt = mYearText.getText().toString().trim();
        if (!yearSt.isEmpty()) {
            yearInt = Integer.parseInt(yearSt);
        }

        mDescText = findViewById(R.id.desc_text);
        descSt = mDescText.getText().toString().trim();

        mISBNText = findViewById(R.id.isbn_text);
        isbnSt = mISBNText.getText().toString().trim();

        mEbookSwitch = findViewById(R.id.ebook_switch);
        if (mEbookSwitch.isChecked()) {
            ebookSt = "Yes";
        }
        else {
            ebookSt = "No";
        }

        if (!titleSt.isEmpty() && !authorSt.isEmpty()&& validYear() && !descSt.isEmpty() && !isbnSt.isEmpty()) {
            BookDatabase db = new BookDatabase(this);
            db.addBook(titleSt, authorSt, yearInt, descSt, isbnSt, ebookSt);
            finish();
        }

        else {
            Toast toast = Toast.makeText(this, R.string.toast_error, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
