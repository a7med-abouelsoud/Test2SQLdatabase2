package com.ahmed.test2sqldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecyclerACT;
    Button addStudentBtn;
    MyDbHelper Db;
    ArrayList <student> myArrayLis= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerACT= findViewById(R.id.studentRecycler);
        addStudentBtn=findViewById(R.id.addStudent);
        Db= new MyDbHelper(this);
        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddNewStudent.class);
                startActivity(i);
            }
        });



    }


    @Override
    protected void onResume() {
        super.onResume();
        myArrayLis= Db.getAllStuednts();
        studentAdapter adapter= new studentAdapter(this, myArrayLis);
        myRecyclerACT.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerACT.setAdapter(adapter);

    }
}