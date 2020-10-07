package com.example.asm.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.asm.NguoiDungActivity;
import com.example.asm.R;
import com.example.asm.dao.NguoiDungDAO;
import com.example.asm.model.NguoiDung;

import java.util.List;

public class NguoiDungRecyclerAdapter extends RecyclerView.Adapter<NguoiDungRecyclerAdapter.RecyclerHolderView> {
    private Context context;
    private List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;
    private NguoiDungDAO nguoiDungDAO;
    public NguoiDungRecyclerAdapter(Context context, List<NguoiDung> arrNguoiDung)
    {

        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoiDungDAO(context);
    }

    @Override
    public int getItemCount() {
        return arrNguoiDung.size();
    }

    //gan du lieu
    @Override
    public void onBindViewHolder(RecyclerHolderView recyclerHolderView, final int position) {
        NguoiDung nguoiDung = arrNguoiDung.get(position);
        recyclerHolderView.tvName.setText(nguoiDung.getUserName());
        recyclerHolderView.tvPhone.setText(nguoiDung.getPhone());
        recyclerHolderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nguoiDung1= arrNguoiDung.get(position);
                Intent intent = new Intent(context, NguoiDungActivity.class);
                Bundle bundle= new Bundle();
                bundle.putString("userName",nguoiDung1.getUserName());
                bundle.putString("password",nguoiDung1.getPassword());
                bundle.putString("phone",nguoiDung1.getPhone());
                bundle.putString("hoTen",nguoiDung1.getHoTen());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
               // Toast.makeText(context,"Sửa đây",Toast.LENGTH_LONG).show();
            }
        });


    }
    //tao view
    @Override
    public RecyclerHolderView onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = inflater.inflate(R.layout.item_nguoi_dung,null);
        RecyclerHolderView  view1 = new RecyclerHolderView(view);
        view1.ivIcon = (ImageView)view.findViewById(R.id.ivIcon);
        view1.tvName = (TextView)view.findViewById(R.id.tvName);
        view1.tvPhone = (TextView)view.findViewById(R.id.tvPhone);
        view1.ivDelete = (ImageView)view.findViewById(R.id.ivDelete);
        view1.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nguoiDungDAO.deleteNguoiDungByID(arrNguoiDung.get(i).getUserName());

                //Intent intent = new Intent(context, NguoiDungActivity.class);
                NguoiDung nguoiDung = arrNguoiDung.get(i);
                arrNguoiDung.remove(nguoiDung);
                notifyDataSetChanged();

            }
        });


        return view1;
    }



    public class RecyclerHolderView extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        TextView tvName;
        TextView tvPhone;
        ImageView ivDelete;

        public RecyclerHolderView(View itemView) {
            super(itemView);
            this.ivIcon = ivIcon;
            this.tvName = tvName;
            this.tvPhone = tvPhone;
            this.ivDelete = ivDelete;
        }
    }
}

