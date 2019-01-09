package com.example.heesun.recyclerview_example;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    ArrayList<Item> itemList;
    Context context;
    RecyclerviewAdapter(ArrayList<Item> itemList, Context context){
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewAdapter.ViewHolder viewHolder, int position) {
        Item item = itemList.get(position);

        viewHolder.item_text.setText(item.getName());
        Glide.with(context).load(item.getImage()).into(viewHolder.item_image);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_text;
        ImageView item_image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_text = itemView.findViewById(R.id.item_text);
            item_image = itemView.findViewById(R.id.item_image);

        }
    }
}
