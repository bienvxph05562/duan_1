package com.activity.myapplication.thang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.activity.myapplication.R;
import com.activity.myapplication.adapter.ListAdapter2;
import com.activity.myapplication.model.ListDetails2;
import com.activity.myapplication.model.ListDetails3;
import com.activity.myapplication.model.Model;

import java.util.ArrayList;

public class Thang3Activity extends AppCompatActivity {

    private ListView listView2 ;
    private ArrayList<Model> models2 ;
    private ListAdapter2 listAdapter2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thang3);

        listView2 = findViewById(R.id.list_view3) ;
        models2 = ListDetails3.getList() ;
        listAdapter2 = new com.activity.myapplication.adapter.ListAdapter2(Thang3Activity.this, models2);
        listView2.setAdapter(listAdapter2);
    }
}
