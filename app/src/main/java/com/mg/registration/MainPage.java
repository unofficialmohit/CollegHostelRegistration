package com.mg.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
EditText name,dept,address,classname,meritRank;
Spinner hostel;
Button submit;
RadioButton ug,pg,rs;
RadioButton male,female;
public String[] hostels={"Hostel No 1","Hostel No 2","Hostel No 3","Hostel No 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        name=findViewById(R.id.name);
        dept=findViewById(R.id.dept);
        address=findViewById(R.id.address);
        classname=findViewById(R.id.cls);
        meritRank=findViewById(R.id.rank);
        ug=findViewById(R.id.ug);
        pg=findViewById(R.id.pg);
        rs=findViewById(R.id.rs);
        hostel=findViewById(R.id.hostel);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,hostels);
        hostel.setAdapter(myAdapter);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gender = "";
                String hostelNumber = "";

                // Determine gender
                if (male.isChecked()) {
                    gender = "BH";
                } else if (female.isChecked()) {
                    gender = "GH";
                }

                // Determine hostel number
                String selectedHostel = hostel.getSelectedItem().toString();
                if (selectedHostel.equals("Hostel No 1")) {
                    hostelNumber = "1";
                } else if (selectedHostel.equals("Hostel No 2")) {
                    hostelNumber = "2";
                } else if (selectedHostel.equals("Hostel No 3")) {
                    hostelNumber = "3";
                } else if (selectedHostel.equals("Hostel No 4")) {
                    hostelNumber = "4";
                }

                String course = "";
                if (ug.isChecked()) {
                    course = "UG";
                } else if (pg.isChecked()) {
                    course = "PG";
                } else if (rs.isChecked()) {
                    course = "Research";
                }
                if(address.getText().toString().toLowerCase().trim().equals("chandigarh") || address.getText().toString().trim().toLowerCase().equals("mohali"))
                {
                    Toast.makeText(MainPage.this, "Sorry, You cant take Hostel", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!name.getText().toString().isEmpty() && !dept.getText().toString().isEmpty() && !classname.getText().toString().isEmpty() &&
                        !meritRank.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !gender.isEmpty()) {

                    // Generate the reference id
                    String referenceId = gender + "/" + classname.getText() + "/" + dept.getText().toString() + "/" + gender.substring(0, 2) + hostelNumber + "/"+System.currentTimeMillis();

                    // Display the toast message
                    Toast.makeText(MainPage.this, "Reference ID: " + referenceId, Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(MainPage.this,FinalPage.class);
                    intent.putExtra("name",name.getText().toString());
                    intent.putExtra("class",classname.getText().toString());
                    intent.putExtra("dept",dept.getText().toString());
                    intent.putExtra("rank",meritRank.getText().toString());
                    intent.putExtra("address",address.getText().toString());
                    intent.putExtra("hostel",hostelNumber);
                    intent.putExtra("gender",gender);
                    intent.putExtra("course",course);
                    intent.putExtra("ref",referenceId);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainPage.this, "INVALID INPUT", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}