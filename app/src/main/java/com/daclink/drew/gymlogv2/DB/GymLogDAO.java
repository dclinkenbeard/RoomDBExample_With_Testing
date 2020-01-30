package com.daclink.drew.gymlogv2.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.daclink.drew.gymlogv2.GymLog;

import java.util.List;

@Dao
public interface GymLogDAO {
    @Insert
    void insert(GymLog... gymlogs);

    @Update
    void update(GymLog... gymlogs);

    @Delete
    void delete(GymLog gymLog);

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE)
    List<GymLog> getGymLogs();

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE mLogId = :logID")
    GymLog getQuestionWithId(int logID);
}

