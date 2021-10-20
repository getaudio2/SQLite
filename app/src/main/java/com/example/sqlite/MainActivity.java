package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite.DB.ContactsDBHelper;
import com.example.sqlite.Model.Contact;

public class MainActivity extends AppCompatActivity {

    //Create the instance of dbHelper
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new ContactsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        final Button btnAfegir = findViewById(R.id.btnAfegir);
        btnAfegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText txtNom = findViewById(R.id.txtNom);

                Contact c = new Contact(txtNom.getText().toString());
                dbHelper.insertContact(db, c);

            }
        });

        final Button btnLlistar = findViewById(R.id.btnLlistar);
        btnLlistar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbHelper.showContact(db);

            }
        });
    }

    //Close the db when the activity onDestroy
    @Override
    protected void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}