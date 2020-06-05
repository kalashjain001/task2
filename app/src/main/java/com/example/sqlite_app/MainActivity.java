package com.example.sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // To move to the Input Activity.
    public void inputAct(View view){

        Intent input = new Intent(this,input_data.class);
        startActivity(input);
    }

    // To move to the Output Activity.
    public void outputData(View view){

        Intent output = new Intent(this,output_data.class);
        startActivity(output);
    }

}
