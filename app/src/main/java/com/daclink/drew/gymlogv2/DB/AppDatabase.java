package com.daclink.drew.gymlogv2.DB;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;

import com.daclink.drew.gymlogv2.DB.TypeConverter.DateTypeConverter;
import com.daclink.drew.gymlogv2.GymLog;

@Database(entities = {GymLog.class}, version =1)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public static final String dbName="db-gymlog";
    public static final String GYMLOG_TABLE="gymlog";
    public static final String USER_TABLE="user";
    public abstract GymLogDAO getGymLogDAO();
}

