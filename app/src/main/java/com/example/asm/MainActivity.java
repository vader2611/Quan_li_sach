package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewThongKe(View view) {
    }



    public void viewHoaDon(View view) {
    }



    public void viewTheLoai(View view) {
        Intent intent= new Intent(MainActivity.this,ListTheLoaiActivity.class);
        startActivity(intent);
    }

    public void viewNguoiDung(View view) {
        Intent intent= new Intent(MainActivity.this, ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void viewBook(View view) {
    }

    public void viewBanChay(View view) {
    }

    public void dangXuat(View view) {
        Intent intent= new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}