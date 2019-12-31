package com.app.aungpyaephyo.ucs_patheinvoting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHandler extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "QRDB";    // Database Name
    public static final String TABLE_NAME = "qrTable";   // Table Name
    private static final int DATABASE_Version = 1;   // Database Version
    public static final String UID="_id";     // Column I (Primary Key)
    public static final String NAME = "Name";    //Column II

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) );";

    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);

            Toast.makeText(context, "Table created", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(context, "can not create table"+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context,"OnUpgrade",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e) {
            Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();

        }
    }

}
