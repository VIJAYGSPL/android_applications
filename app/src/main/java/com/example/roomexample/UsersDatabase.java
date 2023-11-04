package com.example.roomexample;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UserDao dao();

    public static UsersDatabase usersDatabase;

    public static UsersDatabase getDatabase (Context context){
        if(usersDatabase==null){
            usersDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    UsersDatabase.class,"userDB").allowMainThreadQueries().build();
        }
        return usersDatabase;
    }
}

