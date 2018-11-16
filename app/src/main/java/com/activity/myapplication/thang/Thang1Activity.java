package com.activity.myapplication.thang;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.activity.myapplication.R;
import com.activity.myapplication.model.ListDetails;
import com.activity.myapplication.model.Model;

import java.util.ArrayList;

public class Thang1Activity extends AppCompatActivity {

    private ListView listView ;
    private ArrayList<Model> models ;
    private ListAdapter listAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thang1);

        listView = findViewById(R.id.list_view) ;
        models = ListDetails.getList() ;
        listAdapter = new com.activity.myapplication.adapter.ListAdapter(Thang1Activity.this, models);
        listView.setAdapter(listAdapter);


    }
}
