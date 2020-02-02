package com.daclink.drew.gymlogv2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.drew.gymlogv2.DB.AppDatabase;

import java.util.Date;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    int userid;

    String username;
    Date dateCreated;
    boolean active;

    public User(String username) {
        this.username = username;
        this.dateCreated = new Date();
        this.active = true;
    }

    public User(int userid, String username, Date dateCreated, boolean active) {
        this.userid = userid;
        this.username = username;
        this.dateCreated = dateCreated;
        this.active = active;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
