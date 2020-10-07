package com.example.asm.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asm.dao.NguoiDungDAO;
import com.example.asm.dao.TheLoaiDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME="dbBookManager";
    public static final int VERSION=1;
    public DatabaseHelper( Context context ) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NguoiDungDAO.SQL_NGUOI_DUNG);
        db.execSQL(TheLoaiDAO.SQL_THE_LOAI);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NguoiDungDAO.TABLE_NAME);
        db.execSQL(TheLoaiDAO.TABLE_NAME);

    }
}
