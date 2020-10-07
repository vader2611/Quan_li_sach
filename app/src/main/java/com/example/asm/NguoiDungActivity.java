package com.example.asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asm.dao.NguoiDungDAO;
import com.example.asm.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    Button btnThemNguoiDung,btnCapNhat;
    NguoiDungDAO nguoiDungDAO;
    EditText edUser, edPass,edRepass,edPhone,edFullName;
    Button btnListNguoiDung;
    Button btnHuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Them Nguoi Dung");
        btnThemNguoiDung= (Button) findViewById(R.id.btnAddUser);
        btnCapNhat= findViewById(R.id.btnUpdate);
        edUser= (EditText) findViewById(R.id.edUserName);
        edPass= (EditText) findViewById(R.id.edPassword);
        edPhone= (EditText) findViewById(R.id.edPhone);
        edFullName= (EditText) findViewById(R.id.edFullName);
        btnListNguoiDung=(Button) findViewById(R.id.btnListNguoiDung);
        btnHuy= (Button)findViewById(R.id.btnListNguoiDung);

        Intent intent= getIntent();
        if (intent!=null){
            Bundle bundle= intent.getBundleExtra("bun");
            edUser.setText(bundle.getString("userName"));
            edPass.setText(bundle.getString("password"));
            edPhone.setText(bundle.getString("phone"));
            edFullName.setText(bundle.getString("hoTen"));
        }


    }

    public void addUser(View view) {
        nguoiDungDAO= new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung= new NguoiDung(edUser.getText().toString(),edPass.getText().toString(),
                edPhone.getText().toString(),edFullName.getText().toString());
        if (nguoiDungDAO.insertNguoiDung(nguoiDung)==1){
            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_LONG).show();

        }

    }

    public void dsNguoidung(View view) {
        Intent intent= new Intent(NguoiDungActivity.this, ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void Huy(View view) {
        Intent intent= new Intent(NguoiDungActivity.this,ListNguoiDungActivity.class);
        startActivity(intent);
    }

    public void updateUser(View view) {
        nguoiDungDAO= new NguoiDungDAO(NguoiDungActivity.this);
        NguoiDung nguoiDung= new NguoiDung(edUser.getText().toString(),edPass.getText().toString(),
                edPhone.getText().toString(),edFullName.getText().toString());
        if (nguoiDungDAO.updateNguoiDung(nguoiDung)==1){
            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Cập nhật thất bại",Toast.LENGTH_LONG).show();

        }
    }
}