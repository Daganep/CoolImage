package com.geekbrains.coolimage.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geekbrains.coolimage.R;
import com.geekbrains.coolimage.databinding.ActivityMainBinding;
import com.geekbrains.coolimage.view.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);

        init();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mainBinding.recyclerView.setLayoutManager(gridLayoutManager);
        mainBinding.recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void init(){
        recyclerViewAdapter = new RecyclerViewAdapter();
    }
}