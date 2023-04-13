package com.ahmed.test2sqldatabase;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddNewStudent extends AppCompatActivity {
    EditText nameET, phoneET, addressET, rateEt;
    Button addBtn, pick;
    MyDbHelper DB;
    Integer image;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);
        nameET=findViewById(R.id.studentName);
        phoneET=findViewById(R.id.studentPhone);
        addressET=findViewById(R.id.studentAddress);
        rateEt=findViewById(R.id.rate);
        addBtn=findViewById(R.id.addStudent);
        pick= findViewById(R.id.pickImage);
        DB=new MyDbHelper(this);
        i=findViewById(R.id.myImage);

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), RESULT_OK);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname= nameET.getText().toString();
                String Saddress= addressET.getText().toString();
                String Sphone= phoneET.getText().toString();
              //  String Simage= .getText().toString();
                float Srate= Float.parseFloat(rateEt.getText().toString());
                DB.addStudent(new student(Sname, Saddress, Sphone, Srate,R.drawable.student));
                finish();
            }
        });



    }

    //@Override
   /* protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== RESULT_OK){
            try {
                final Uri selectedImage  = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                ImageView imageView = (ImageView) findViewById(R.id.myImage);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(AddNewStudent.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(AddNewStudent.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
        }*/
    }
