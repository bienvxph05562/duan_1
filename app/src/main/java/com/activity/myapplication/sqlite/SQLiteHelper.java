package com.activity.myapplication.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

private static final String DATABASE_NAME = "QUAN_LY_THANH_VIEN" ;
private static final String TABLE_THANHVIEN = "THANHVIEN";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase() ;
        database.execSQL(sql);
    }

    public void insertData(String ten, String tuoi, String quequan,
                           String noiohiennay, String ngaythangnamsinh, String vitrithidau,
                           String mucluong, String ghichu, byte[] image){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql = "INSERT INTO RECORD VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
        SQLiteStatement statement = database.compileStatement(sql) ;
        statement.clearBindings();


        statement.bindString(1,ten);
        statement.bindString(2, tuoi);
        statement.bindString(3, quequan);
        statement.bindString(4, noiohiennay);
        statement.bindString(5, ngaythangnamsinh);
        statement.bindString(6, vitrithidau);
        statement.bindString(7, mucluong);
        statement.bindString(8, ghichu);

        statement.bindBlob(9, image);

        statement.executeInsert() ;
    }

    public void updateDate(String ten, String tuoi, String quequan,
                           String noiohiennay, String ngaythangnamsinh, String vitrithidau,
                           String mucluong, String ghichu, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql = "UPDATE RECORD SET ten=?, tuoi=?, quequan=?, noiohiennay=?,  ngaythangnamsinh=?, vitrithidau=?, mucluong=?, ghichu=?,  image=? WHERE id=?" ;
        SQLiteStatement statement = database.compileStatement(sql) ;

        statement.bindString(1, ten);
        statement.bindString(2, tuoi);
        statement.bindString(3, quequan);
        statement.bindString(4, noiohiennay);
        statement.bindString(5, ngaythangnamsinh);
        statement.bindString(6, vitrithidau);
        statement.bindString(7, mucluong);
        statement.bindString(8, ghichu);

        statement.bindBlob(9, image);
        statement.bindDouble(10, id);

        statement.execute();
        database.close();
    }

    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase() ;
        String sql ="DELETE FROM RECORD WHERE id=?" ;
        SQLiteStatement statement = database.compileStatement(sql) ;
        statement.clearBindings();
        statement.bindDouble(1, (double) id);

        statement.execute();
        database.close();

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase() ;
        return database.rawQuery(sql, null) ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_THANHVIEN);
        onCreate(db);
    }
}
