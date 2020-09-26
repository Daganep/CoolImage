package com.geekbrains.coolimage.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geekbrains.coolimage.R;
import com.geekbrains.coolimage.databinding.ActivityMainBinding;
import com.geekbrains.coolimage.presenter.MainPresenter;
import com.geekbrains.coolimage.view.recyclerview.RecyclerViewAdapter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private final String TAG = "Request";
    private ActivityMainBinding mainBinding;

    @InjectPresenter
    MainPresenter mainPresenter;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);


        mainPresenter.requestFromServer();

    }

    private void initRecycler(ActivityMainBinding mainBinding){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mainBinding.recyclerView.setLayoutManager(gridLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(mainPresenter.getPhotos());
        mainBinding.recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void onClick(View view){
        updateRecyclerView();
    }

    @Override
    public void updateRecyclerView(){
        initRecycler(mainBinding);
        recyclerViewAdapter.notifyDataSetChanged();

    }
}