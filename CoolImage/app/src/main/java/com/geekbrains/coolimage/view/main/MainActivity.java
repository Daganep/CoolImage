package com.geekbrains.coolimage.view.main;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.geekbrains.coolimage.R;
import com.geekbrains.coolimage.databinding.ActivityMainBinding;
import com.geekbrains.coolimage.presenter.MainPresenter;
import com.geekbrains.coolimage.view.recyclerview.RecyclerViewAdapter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private ActivityMainBinding mainBinding;

    @InjectPresenter
    MainPresenter mainPresenter;

    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        mainPresenter.requestFromServer();
    }

    private void initRecycler(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3); // количество колонок вынесьт в настройки
        mainBinding.recyclerView.setLayoutManager(gridLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(mainPresenter.getPhotos(), mainPresenter);
        mainBinding.recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void updateRecyclerView(){
        initRecycler();
        recyclerViewAdapter.notifyDataSetChanged();
    }
}