package com.example.sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.EOFException;

public class input_data extends AppCompatActivity {

    EditText input_name;
    EditText input_age;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        input_name = (EditText)findViewById(R.id.inputName);
        input_age = (EditText)findViewById(R.id.inputAge);
        dbHelper = new DBHelper(this);

    }

    public void saveData(View view){

        String n = input_name.getText().toString();

        // To check if the name input is Empty.
        if(n.equals("")){

            Toast.makeText(input_data.this, "Enter both Name and Age", Toast.LENGTH_LONG).show();
            input_name.setText("");
            input_age.setText("");
            return;
        }

        // To check if the value entered as age is an Integer or not.
        try{

            int i = Integer.valueOf(input_age.getText().toString());
        }
        catch(Exception age){

            Toast.makeText(input_data.this,"Enter a Number as Age",Toast.LENGTH_LONG).show();
            input_name.setText("");
            input_age.setText("");
            return;
        }

        // To add the input data to the database

        boolean result = dbHelper.insertData(input_name.getText().toString(), Integer.valueOf(input_age.getText().toString()));
        if (result == true) {
            Toast.makeText(input_data.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }

        input_name.setText("");
        input_age.setText("");

    }
    // To move back to the Main Activity using Back Button.
    public void home_page(View view){

        Intent main_act = new Intent(this,MainActivity.class);
        startActivity(main_act);
    }

}
