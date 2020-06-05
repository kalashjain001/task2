package com.example.sqlite_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class output_data extends AppCompatActivity {

    private ListView listView;
    DBHelper dbHelper;
    ArrayList<Employees> employeesArrayList = new ArrayList<>();
    Employees employee;
    TextView no_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_data);

        listView = (ListView) findViewById(R.id.list_view);
        no_record = (TextView)findViewById(R.id.no_record);


        dbHelper = new DBHelper(this);
        Cursor cursor = dbHelper.getAllData();

        if(cursor.getCount()==0) {

            no_record.setText("NO RECORDS FOUND");
            return ;
        }

        employee = new Employees("NAME","AGE");
        employeesArrayList.add(employee);

        // To add the data to Employee List Array

        while(cursor.moveToNext()) {

            employee = new Employees(cursor.getString(0),cursor.getString(1));
            employeesArrayList.add(employee);

        }

        // To add the EmployeeList Array to the listView

        EmployeeListAdapter adapter = new EmployeeListAdapter(this, R.layout.custom_layout, employeesArrayList);
        listView.setAdapter(adapter);
    }


    // To move back to the Main Activity using Back Button.
    public void home_page(View view){

        Intent main_act = new Intent(this,MainActivity.class);
        startActivity(main_act);
    }

}
