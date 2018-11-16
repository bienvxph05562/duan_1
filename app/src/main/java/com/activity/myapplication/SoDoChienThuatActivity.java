package com.activity.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activity.myapplication.sodochienthuat.SoDo235Activity;
import com.activity.myapplication.sodochienthuat.SoDo352Activity;
import com.activity.myapplication.sodochienthuat.SoDo4222Activity;
import com.activity.myapplication.sodochienthuat.SoDo422Activity;
import com.activity.myapplication.sodochienthuat.SoDo4231Activity;
import com.activity.myapplication.sodochienthuat.SoDo4321Activity;
import com.activity.myapplication.sodochienthuat.SoDo433Activity;
import com.activity.myapplication.sodochienthuat.SoDo451Activity;
import com.activity.myapplication.sodochienthuat.SoDo532Activity;

public class SoDoChienThuatActivity extends AppCompatActivity {

    SearchView searchView ;
    ListView listView ;
    String[] name={"Sơ đồ 4-3-2-1", "Sơ đồ 5-3-2", "Sơ đồ 4-3-3", "Sơ đồ 4-2-3-1", "Sơ đồ 2-3-5", "Sơ đồ 4-2-2-2"
            , "Sơ đồ 4-4-2", "Sơ đồ 4-5-1", "Sơ đồ 3-5-2"} ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_do_chien_thuat);

        listView = findViewById(R.id.lv2) ;
        searchView = (SearchView)findViewById(R.id.searchView2) ;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo4321Activity.class) ;
                    intent.putExtra("Sơ đồ 4-3-2-1", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo532Activity.class) ;
                    intent.putExtra("Sơ đồ 5-3-2", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo433Activity.class) ;
                    intent.putExtra("Sơ đồ 4-3-3", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo4231Activity.class) ;
                    intent.putExtra("Sơ đồ 4-2-3-1", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo235Activity.class) ;
                    intent.putExtra("Sơ đồ 2-3-5", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo4222Activity.class) ;
                    intent.putExtra("Sơ đồ 4-2-2-2", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);

                }else if (position==6){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo422Activity.class) ;
                    intent.putExtra("Sơ đồ 4-4-2", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==7){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo451Activity.class) ;
                    intent.putExtra("Sơ đồ 4-5-1", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==8){
                    Intent intent = new Intent(SoDoChienThuatActivity.this, SoDo352Activity.class) ;
                    intent.putExtra("Sơ đồ 3-5-2", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }



            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
