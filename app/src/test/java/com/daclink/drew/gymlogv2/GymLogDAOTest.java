package com.daclink.drew.gymlogv2;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.daclink.drew.gymlogv2.DB.AppDatabase;
import com.daclink.drew.gymlogv2.DB.GymLogDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import androidx.test.core.app;


import static org.junit.Assert.*;

public class GymLogDAOTest {
    private GymLogDAO gymLogDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        gymLogDao = db.getGymLogDAO();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getGymLogs() {
    }

    @Test
    public void getQuestionWithId() {
    }
}