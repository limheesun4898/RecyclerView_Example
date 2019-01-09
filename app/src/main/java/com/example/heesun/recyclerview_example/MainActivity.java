package com.example.heesun.recyclerview_example;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.image0,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
            R.drawable.image6,R.drawable.image7,R.drawable.image8};
    String name[] = {"풍경0","풍경1","풍경2","풍경3","풍경4","풍경5","풍경6","풍경7","풍경8" };
    RecyclerView recyclerView;
    ArrayList<Item> itemList = new ArrayList<>();
    Context context = this;
    RecyclerviewAdapter recyclerviewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setHasFixedSize(false); //리사이클러뷰 내용이 갱신 되면 true, 갱신되지 않고 고정이면 false
        recyclerviewAdapter = new RecyclerviewAdapter(itemList,context);
        // 가로 또는 세로 스크롤 목록 형식
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerviewAdapter);
        Data();

    }
    public void Data(){
        itemList.clear();
       for (int i = 0; i < image.length; i++){
           itemList.add(new Item(name[i],image[i]));
       }
       recyclerviewAdapter.notifyDataSetChanged();

    }
}
