package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm.dao.TheLoaiDAO;
import com.example.asm.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {

    EditText edmatheloai, edtentheloai, edvitri, edmota;
    Button btnthem, btnshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);

        edmatheloai = findViewById(R.id.edMaTheLoai);
        edtentheloai = findViewById(R.id.edTenTheLoai);
        edvitri = findViewById(R.id.edViTri);
        edmota = findViewById(R.id.edmota);

    }

    public void ThemTheLoai(View view) {
    }

    public void startThemNguoiDung(View view) {
    }

    public void Themtheloai1(View view) {
        TheLoaiDAO theLoaiDAO = new TheLoaiDAO(TheLoaiActivity.this);
        TheLoai theLoai  = new TheLoai(edmatheloai.getText().toString(),edtentheloai.getText().toString(),
                edmota.getText().toString(),Integer.parseInt(edvitri.getText().toString()));
        if (theLoaiDAO.inserTheLoai(theLoai)<0){
            Toast.makeText(TheLoaiActivity.this,"Insert thất bại",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(TheLoaiActivity.this,"Insert thành công",Toast.LENGTH_LONG).show();
        }
    }
    }
