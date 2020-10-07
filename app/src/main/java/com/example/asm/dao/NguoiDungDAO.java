package com.example.asm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.asm.database.DatabaseHelper;
import com.example.asm.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    public DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    public static final String SQL_NGUOI_DUNG = "CREATE TABLE NguoiDung (" +
            " userName text primary key, " +
            " password text, " +
            " phone text, " +
            " hoTen text" +
            ");";
    public static final String TABLE_NAME = "NguoiDung";

    public NguoiDungDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public int insertNguoiDung(NguoiDung nguoiDung) {
        ContentValues values = new ContentValues();
        values.put("userName", nguoiDung.getUserName());
        values.put("password", nguoiDung.getPassword());
        values.put("phone", nguoiDung.getPhone());
        values.put("hoTen", nguoiDung.getHoTen());
        try {
            if (db.insert(TABLE_NAME, null, values) < 0) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e("NguoiDungDAO", ex.getMessage());
        }


        return 1;
    }

    public List<NguoiDung> getAllNguoiDung()
    {
        List<NguoiDung> ls = new ArrayList<NguoiDung>();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            NguoiDung nguoiDung = new NguoiDung();
            nguoiDung.setUserName(cursor.getString(0));
            nguoiDung.setPassword(cursor.getString(1));
            nguoiDung.setPhone(cursor.getString(2));
            nguoiDung.setHoTen(cursor.getString(3));
            ls.add(nguoiDung);
            cursor.moveToNext();

        }
        cursor.close();
        return ls;
    }

    //delete
    public int deleteNguoiDungByID(String username){
        int result = db.delete(TABLE_NAME,"username=?",new String[]{username});
        if (result == 0)
            return -1;
        return 1;
    }
    //update
    public int updateNguoiDung(NguoiDung nguoiDung){
        ContentValues values = new ContentValues();
        values.put("password",nguoiDung.getPassword());
        values.put("phone",nguoiDung.getPhone());
        values.put("hoTen",nguoiDung.getHoTen());
        try {
            if ( db.update(TABLE_NAME,values,"username=?", new String[]{nguoiDung.getUserName()})<0 ){
                return -1;
            };

        }catch (Exception ex){
            Log.e("NguoiDungDao", ex.getMessage());


        }
        return 1;
    }



}
