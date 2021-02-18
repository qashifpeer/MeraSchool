package com.kashifpeer.meraschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private Button btnAttendance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAttendance=findViewById(R.id.btn_attendence);
        btnAttendance.setOnClickListener(this::gotoAttendance);













    }

    private void gotoAttendance(View view) {
        startActivity(new Intent(getApplicationContext(),AttendenceActivity.class));


    }
}
