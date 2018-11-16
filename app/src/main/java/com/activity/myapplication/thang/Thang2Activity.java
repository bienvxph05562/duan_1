package com.activity.myapplication.thang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.activity.myapplication.R;
import com.activity.myapplication.adapter.ListAdapter2;
import com.activity.myapplication.model.ListDetails;
import com.activity.myapplication.model.ListDetails2;
import com.activity.myapplication.model.Model;

import java.util.ArrayList;

public class Thang2Activity extends AppCompatActivity {

    private ListView listView2 ;
    private ArrayList<Model> models2 ;
    private ListAdapter2 listAdapter2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thang2);

        listView2 = findViewById(R.id.list_view2) ;
        models2 = ListDetails2.getList() ;
        listAdapter2 = new com.activity.myapplication.adapter.ListAdapter2(Thang2Activity.this, models2);
        listView2.setAdapter(listAdapter2);
    }
}
