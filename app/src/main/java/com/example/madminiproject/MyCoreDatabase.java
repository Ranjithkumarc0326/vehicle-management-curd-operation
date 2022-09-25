package com.example.madminiproject;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyCoreDatabase extends SQLiteOpenHelper {

    static final private String DB_NAME="Vehicle database";
    static final private String DB_TABLE="Vehicle";
    static final private int DB_VER=1;

    Context ctx;
    SQLiteDatabase myDb;

    public MyCoreDatabase(Context ct){
        super(ct,DB_NAME,null,DB_VER);
        ctx=ct;


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement,vname text,rno text,pno text);");
        Log.i("Database","table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DB_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void insertData(DemoClass obj) {
        String s1 = obj.vname;
        String s2 = obj.rno;
        String s3 = obj.pno;
        try {
            myDb = getWritableDatabase();
            myDb.execSQL("insert into " + DB_TABLE + " (vname,rno,pno) values('" + s1 + "','" + s2 + "','" + s3 + "');");
            Toast.makeText(ctx, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchData(DemoClass obj) {
        String s0 = obj.pno;
        try {
            myDb = getReadableDatabase();
            Cursor cr = myDb.rawQuery("Select * from " + DB_TABLE + " where pno='" + s0 + "';", null);
            StringBuilder str = new StringBuilder();
            while (cr.moveToNext()) {
                String s1 = cr.getString(1);
                String s2 = cr.getString(2);
                String s3 = cr.getString(3);
                str.append(s1 + "   " + s2 + "   " + s3 + "\n");
            }
            Toast.makeText(ctx, str.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteData(DemoClass obj) {
        String s0 = obj.pno;
        try {
            myDb = getWritableDatabase();
            myDb.delete(DB_TABLE, "pno = ?", new String[]{s0});
            Toast.makeText(ctx, "Deleted successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(DemoClass obj1,DemoClass obj2) {
        String s0 = obj1.pno;
        String s1 = null, s2 = null;
        if (obj2.pno != null)
            s1 = "pno";
        else if (obj2.rno != null)
            s1 = "rno";
        else if (obj2.vname!=null)
            s1 = "vname";
        if (obj2.pno != null)
            s2 = obj2.pno;
        else if (obj2.rno != null)
            s2 = obj2.rno;
        else if (obj2.vname!=null)
            s2 = obj2.vname;
        try {
            myDb = getWritableDatabase();
            String query = "update " + DB_TABLE + " set " + s1 + "='" + s2 + "' where pno='" + s0 + "';";
            myDb.execSQL(query);
            Toast.makeText(ctx, "Updated successfully", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cursor getData() {
        myDb = getReadableDatabase();
        Cursor c = myDb.rawQuery("Select * from "+DB_TABLE,null);
        return c;
    }
}
