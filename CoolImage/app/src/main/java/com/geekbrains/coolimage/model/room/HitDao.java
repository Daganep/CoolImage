package com.geekbrains.coolimage.model.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.geekbrains.coolimage.model.entity.Hit;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface HitDao {
    @Query("SELECT * FROM photo_base")
    Single<List<Hit>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insertPhoto(Hit photo);

    /*@Delete
    Single<Integer> deleteExpired(List<Hit> expiredPhotos);*/

    @Query("DELETE FROM photo_base")
    Single<Integer> deleteAll();
}
