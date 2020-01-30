package com.daclink.drew.gymlogv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.daclink.drew.gymlogv2.DB.AppDatabase;
import com.daclink.drew.gymlogv2.DB.GymLogDAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mMainDisplay;

    EditText mExercise;
    EditText mWeight;
    EditText mReps;

    Button mSubmit;

    GymLogDAO mGymLogDAO;

    List<GymLog> mGymLogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainDisplay = findViewById(R.id.mainGymLogDisplay);

        mMainDisplay.setMovementMethod(new ScrollingMovementMethod());

        mExercise = findViewById(R.id.mainExerciseEditText);
        mWeight = findViewById(R.id.mainWeightEditText);
        mReps = findViewById(R.id.mainRepsEditText);

        mSubmit = findViewById(R.id.mainSubmitButton);

        mGymLogDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .build()
                .getGymLogDAO();

        refreshDisplay();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitGymlog();
                refreshDisplay();
            }
        });
    }

    private void submitGymlog(){
        // I like it this way because it makes debugging easier.
        // also the interpreter cleans it up...
        String exercise = mExercise.getText().toString();
        int weight = Integer.parseInt(mWeight.getText().toString());
        int reps = Integer.parseInt(mReps.getText().toString());

        mGymLogDAO.insert(new GymLog(exercise, weight, reps));
    }

    private void refreshDisplay(){
        mGymLogs = mGymLogDAO.getGymLogs();
        if(! mGymLogs.isEmpty()){
            mMainDisplay.setText("");
            for(GymLog log : mGymLogs){
                String temp = mMainDisplay.getText().toString();
                mMainDisplay.setText(log.toString());
                mMainDisplay.append(temp);
            }
        }else{
            mMainDisplay.setText("No logs yet, time to hit the gym!");
        }
    }

}
