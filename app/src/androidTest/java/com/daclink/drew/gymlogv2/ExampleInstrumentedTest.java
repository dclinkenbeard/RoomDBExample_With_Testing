package com.daclink.drew.gymlogv2;

import android.content.Context;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.daclink.drew.gymlogv2.DB.AppDatabase;
import com.daclink.drew.gymlogv2.DB.GymLogDAO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.daclink.drew.gymlogv2", appContext.getPackageName());
    }

    private GymLogDAO gymLogDao;
    private AppDatabase db;
    @Before
    public void createDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();


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
        GymLog testValue = new GymLog("Squat",285,6);
        gymLogDao.insert(testValue);
        List<GymLog> DBvalue = gymLogDao.getGymLogs();
        //There should only be one entry...
        assertEquals(1,DBvalue.size());

        assertEquals(testValue.getExercise(),DBvalue.get(0).getExercise());
        assertEquals(testValue,DBvalue.get(0));
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
