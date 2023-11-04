package com.example.roomdbex5;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={User.class},version=1)      //entities means table
public abstract class MyAppDatabase extends RoomDatabase
{
    public abstract MyDao myDao();
}

