package com.daclink.drew.gymlogv2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.daclink.drew.gymlogv2.DB.AppDatabase;

import java.util.Date;

@Entity(tableName = AppDatabase.GYMLOG_TABLE)
public class GymLog {

    @PrimaryKey(autoGenerate = true)
    private int mLogId;

    private String mExercise;
    private int mWeight;
    private int mReps;

    private Date mDate;

    public GymLog(String exercise, int weight, int reps) {
        mExercise = exercise;
        mWeight = weight;
        mReps = reps;
        mDate = new Date();
    }

    public int getLogId() {
        return mLogId;
    }

    public void setLogId(int logId) {
        mLogId = logId;
    }

    public String getExercise() {
        return mExercise;
    }

    public void setExercise(String exercise) {
        mExercise = exercise;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public int getReps() {
        return mReps;
    }

    public void setReps(int reps) {
        mReps = reps;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    @Override
    public String toString() {
        return  mDate + "\n" +
                mExercise  + "\n" +
                mWeight + "\n" +
                mReps + "\n" +
                "=-=-=-=-=-=-\n";

    }
}


