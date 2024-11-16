package com.example.oderfoodapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oderfoodapp.R;
import com.example.oderfoodapp.object.Category;
import com.example.oderfoodapp.recyclerViewAdapter.CategoryItemAdapter;

import java.util.ArrayList;
import java.util.List;

import dal.daoCategory;
import de.hdodenhof.circleimageview.CircleImageView;

public class TrangChuFrag extends Fragment {

    public TrangChuFrag(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            RecyclerView recyclerView = view.findViewById(R.id.listcategory);
            // khai báo class daoCategory để làm việc với cơ sở dữ liệu category
            daoCategory dCate = new daoCategory(getContext());

            List<Category> listCate = new ArrayList<>();
            // lấy danh sách category
            listCate = dCate.getListCategory();
            List<Category> listCateAdapter = new ArrayList<>();
            // do trong bảng tblCategory tôi không có ảnh nên tôi phải thêm ảnh cho từng danh mục bằng tay ae nên
            // xem phần contructor của class Category để hiểu hơn
            listCateAdapter.add(new Category(listCate.get(0),R.drawable.pizzarau));
            listCateAdapter.add(new Category(listCate.get(1),R.drawable.myyhaisan));
            listCateAdapter.add(new Category(listCate.get(2),R.drawable.sushitom));
            listCateAdapter.add(new Category(listCate.get(3),R.drawable.camep));
            listCateAdapter.add(new Category(listCate.get(4),R.drawable.kemdau));
            listCateAdapter.add(new Category(listCate.get(5),R.drawable.comchien));
            listCateAdapter.add(new Category(listCate.get(6),R.drawable.saladga));
            listCateAdapter.add(new Category(listCate.get(7),R.drawable.garena1));
            listCateAdapter.add(new Category(listCate.get(8),R.drawable.bachtuoc));
            listCateAdapter.add(new Category(listCate.get(9),R.drawable.banhmythapcam));
            // Khai báo và khởi tạo Adapter cho RecycleView
        CategoryItemAdapter cia = new CategoryItemAdapter(listCateAdapter,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(cia);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trang_chu_frag,container,false);
    }
}
