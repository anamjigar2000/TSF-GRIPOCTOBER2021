package com.example.bankingapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String Dbname = "Main_data.db";
    public static final String table_name_1 = "Dummy_data";
    public static final String table_name_2 = "History_data";
    public DatabaseHelper(Context context)
    {
        super(context,Dbname,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create_table_1 = "CREATE TABLE "+table_name_1+" (acno INTEGER PRIMARY KEY, name TEXT, email TEXT, mob_no INTEGER, balance INTEGER)";
        String create_table_2 = "CREATE TABLE "+table_name_2+" (transact_id INTEGER PRIMARY KEY AUTOINCREMENT,from_acc_no INTEGER, from_user TEXT, to_user TEXT, amount INTEGER, time TEXT)";
        db.execSQL(create_table_1);
        db.execSQL(create_table_2);
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(1234567, 'Jigar', 'jigar@gmail.com', 1234567890, 10000)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(1357246, 'Deesha', 'deesha@gmail.com', 2345678901, 7500)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(5599632, 'Paras', 'paras@gmail.com', 3456789012, 8900)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(7800253, 'Aditi', 'aditi@gmail.com', 4567890123, 6700)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(1424210, 'Kush', 'kush@gmail.com', 5678901234, 9650)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(1579029, 'Ashwin', 'ashwin@gmail.com', 6789012345, 6500)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(3996448, 'Tina', 'tina@gmail.com', 7890123456, 5660)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(8059248, 'Jigna', 'jigna@gmail.com', 8901234567, 2145)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(4431262, 'coco', 'coco@gmail.com', 9012345678, 10880)");
        db.execSQL("INSERT INTO " + table_name_1 + " VALUES(5882365, 'Jayshree', 'jayshree@gmail.com', 0123456789, 9900)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + table_name_1);
        onCreate(db);
    }
    public void insert_history(int ac_no, String sender_na, String receiver_na, int amt, String tm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("from_acc_no", ac_no);
        contentValues.put("from_user", sender_na);
        contentValues.put("to_user", receiver_na);
        contentValues.put("amount", amt);
        contentValues.put("time", tm);
        long result = db.insert(table_name_2,null,contentValues);
    }
    public Boolean update_main(int amt, String na)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("balance", amt);
        db.update(table_name_1, contentValues, "name = ?", new String[] {na});
        return true;
    }
}