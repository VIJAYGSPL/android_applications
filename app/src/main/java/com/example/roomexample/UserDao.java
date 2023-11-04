package com.example.roomexample;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity user);

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM UserEntity")
    List<UserEntity> getAll();

    @Update
    public void update(UserEntity user);

}
