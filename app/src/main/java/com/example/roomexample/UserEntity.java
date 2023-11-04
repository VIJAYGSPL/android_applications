package com.example.roomexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.Setter;
import lombok.Getter;
@Setter
@Getter
@Entity
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @ColumnInfo(name = "username")
    public String userName;
    @ColumnInfo(name = "password")
    public String password;
    public UserEntity() {
        this.userName = userName;
        this.password = password;
    }
}
