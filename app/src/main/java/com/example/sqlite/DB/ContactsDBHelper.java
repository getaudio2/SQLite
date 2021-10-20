package com.example.sqlite.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlite.DB.ContactsContract.*;
import com.example.sqlite.Model.Contact;

public class ContactsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ContactsEntry.TABLE_NAME + "(" + ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ContactsEntry.COLUMN_NAME_TITLE + " TEXT)";

    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertContact(SQLiteDatabase db, Contact c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(ContactsEntry.COLUMN_NAME_TITLE, c.getNom());

            db.insert(ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public void showContact(SQLiteDatabase db) {
        if (db.isOpen()){
            String sql = "select * from " + ContactsEntry.TABLE_NAME;
            db.execSQL(sql);
        }else{
            Log.i("sql","Database is closed");
        }
    }
}
