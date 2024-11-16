package com.example.oderfoodapp.recyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oderfoodapp.R;
import com.example.oderfoodapp.object.Category;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryitemViewHoder> {
    List<Category> listCate = new ArrayList<>();
    Context context;
    public CategoryItemAdapter(List<Category> list,Context context){
        listCate = list;
        this.context = context;
    }
    @Override
    public int getItemCount() {
        return listCate.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryitemViewHoder holder, int position) {
        Category cate = listCate.get(position);
        holder.circleImageView.setImageResource(listCate.get(position).getLinkimg());
        holder.txtView.setText(listCate.get(position).getName());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"hello",Toast.LENGTH_LONG).show();
            }
        });
    }

    @NonNull
    @Override
    public CategoryitemViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_category,parent,false);
        return new CategoryitemViewHoder(view);
    }
    public class CategoryitemViewHoder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView txtView;
        CardView cv;
        public CategoryitemViewHoder(@NonNull View itemView) {
            super(itemView);
            this.circleImageView = itemView.findViewById(R.id.image);
            this.txtView = itemView.findViewById(R.id.txtcate);
            this.cv = itemView.findViewById(R.id.itemcate);
        }
    }
}
