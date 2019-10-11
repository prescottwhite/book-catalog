package com.prgwhite.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddBook extends AppCompatActivity {

    private static String KEY_AUTHOR = "author";

    private String authorString;

    private EditText mAuthorText;
    private EditText mYearText;

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
        if (validYear() == true) {

        }
        else {
            Toast toast = Toast.makeText(this, R.string.toast_error, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
