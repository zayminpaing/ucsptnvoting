package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class myDbAdapter {


    private DatabaseHandler myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new DatabaseHandler(context);
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {DatabaseHandler.UID, DatabaseHandler.NAME};
        Cursor cursor =db.query(DatabaseHandler.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(DatabaseHandler.UID));
            String name =cursor.getString(cursor.getColumnIndex(DatabaseHandler.NAME));
            buffer.append(cid+ "   " + name  +" \n");
        }
        return buffer.toString();
    }

    public String getData(String qr){
        SQLiteDatabase db=myhelper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+ DatabaseHandler.TABLE_NAME +" where Name=\""+qr+"\"",null);
        StringBuffer buffer= new StringBuffer();//279
        while (cursor.moveToNext())
        {
         //   int cid =cursor.getInt(cursor.getColumnIndex(myhelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(DatabaseHandler.NAME));
            buffer.append( name );
        }
       // flutter-dard
        return buffer.toString();
    }
    public long insertData(String name)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHandler.NAME, name);
        long id = dbb.insert(DatabaseHandler.TABLE_NAME, null , contentValues);
        return id;
    }
    }


