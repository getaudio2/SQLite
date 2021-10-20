package com.example.sqlite.DB;

import android.provider.BaseColumns;

public class ContactsContract  {
    private ContactsContract(){}
    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME ="contacts";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
    }
}