package isetB.projetworldcap;


import android.content.ContentValues;
import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="worldcap_db";

    public static final String TABLE_WORLDCAP ="user";
    public static final String COL_ID ="_id";
    public static final String COL_NAME ="name";
    public static final String COL_EMAIL ="email";
    public static final String COL_PASSWORD ="password";

    public static  final String CREATE_WORLDCAP_TABLE = "CREATE TABLE " + TABLE_WORLDCAP + "("
            +COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_NAME +" TEXT NOT NULL, "
            +COL_EMAIL +" TEXT ,"
            +COL_PASSWORD +" TEXT) ";

    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB","Table Create SQL: "+ CREATE_WORLDCAP_TABLE);
        db.execSQL( CREATE_WORLDCAP_TABLE );
        Log.d("DB","DB create!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORLDCAP);
        onCreate(db);
    }
    public SQLiteDatabase open(){
        db=this.getWritableDatabase();
        return db;
    }


    public void addUser(user s){
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_EMAIL,s.getEmail());
        values.put(COL_ID,s.getId());
        values.put(COL_PASSWORD,s.getPassword());
        db.insert(TABLE_WORLDCAP,null,values);
    }

    public void updateUser(user s, int id){
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,s.getName());
        values.put(COL_EMAIL,s.getEmail());
        db.update(TABLE_WORLDCAP,values,COL_ID+"=?",new String[]{String.valueOf(id)});
    }
    public void removeUser(int id){
        open();
        db.delete(TABLE_WORLDCAP,COL_ID+"=?",new String[]{String.valueOf(id)});
    }

    public ArrayList<user> getAllStudent(){
        db=this.getReadableDatabase();
        ArrayList<user>list=new ArrayList<user>();
        Cursor c =db.query(TABLE_WORLDCAP,new String[]{COL_ID,COL_NAME,COL_EMAIL},null,null,null,null,null);
        c.moveToFirst();
        do{
            user s=new user(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            list.add(s);
        }
        while (c.moveToNext());
        return list;
    }
    public int getStudentCount(){
        db=this.getReadableDatabase();
        Cursor c =db.query(TABLE_WORLDCAP,null,null,null,null,null,null,null);
        return c.getCount();
    }
}
