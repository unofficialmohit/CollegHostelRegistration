package com.mg.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FinalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String className = intent.getStringExtra("class");
        String dept = intent.getStringExtra("dept");
        String rank = intent.getStringExtra("rank");
        String address = intent.getStringExtra("address");
        String hostelNumber = intent.getStringExtra("hostel");
        String gender = intent.getStringExtra("gender");
        String course = intent.getStringExtra("course");
        String referenceId = intent.getStringExtra("ref");

        // Displaying the values in TextViews or any other UI components
        TextView nameTextView = findViewById(R.id.nameTextView);
        nameTextView.setText("Name: " + name);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView classNameTextView = findViewById(R.id.classNameTextView);
        classNameTextView.setText("Class: " + className);

        TextView deptTextView = findViewById(R.id.deptTextView);
        deptTextView.setText("Department: " + dept);

        TextView rankTextView = findViewById(R.id.rankTextView);
        rankTextView.setText("Merit Rank: " + rank);

        TextView addressTextView = findViewById(R.id.addressTextView);
        addressTextView.setText("Address: " + address);

        TextView hostelTextView = findViewById(R.id.hostelTextView);
        hostelTextView.setText("Hostel: " + hostelNumber);

        TextView genderTextView = findViewById(R.id.genderTextView);
        genderTextView.setText("Gender: " + gender);

        TextView courseTextView = findViewById(R.id.courseTextView);
        courseTextView.setText("Course: " + course);

        TextView refIdTextView = findViewById(R.id.refIdTextView);
        refIdTextView.setText("Reference ID: " + referenceId);
    }
}
