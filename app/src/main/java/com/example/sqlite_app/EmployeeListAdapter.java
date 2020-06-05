package com.example.sqlite_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

class EmployeeListAdapter extends ArrayAdapter<Employees> {

    private Context mcontext;
    int mResource;

    public EmployeeListAdapter(@NonNull Context context, int resource, @NonNull List<Employees> objects) {
        super(context, resource, objects);
        mcontext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();
        String age = getItem(position).getAge();

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView name_row = (TextView)convertView.findViewById(R.id.name_row);
        TextView age_row = (TextView)convertView.findViewById(R.id.age_row);

        name_row.setText(name);
        age_row.setText(age);

        return convertView;


    }
}
