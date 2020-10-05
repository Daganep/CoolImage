package com.geekbrains.coolimage.model.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geekbrains.coolimage.model.entity.Hit;

@Database(entities = {Hit.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HitDao hitDao();
}
