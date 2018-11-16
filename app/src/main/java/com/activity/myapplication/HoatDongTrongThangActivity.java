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
import com.activity.myapplication.thang.Thang10Activity;
import com.activity.myapplication.thang.Thang11Activity;
import com.activity.myapplication.thang.Thang12Activity;
import com.activity.myapplication.thang.Thang1Activity;
import com.activity.myapplication.thang.Thang2Activity;
import com.activity.myapplication.thang.Thang3Activity;
import com.activity.myapplication.thang.Thang4Activity;
import com.activity.myapplication.thang.Thang5Activity;
import com.activity.myapplication.thang.Thang6Activity;
import com.activity.myapplication.thang.Thang7Activity;
import com.activity.myapplication.thang.Thang8Activity;
import com.activity.myapplication.thang.Thang9Activity;

public class HoatDongTrongThangActivity extends AppCompatActivity {

    SearchView searchView ;
    ListView listView ;
    String[] name={"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6"
            , "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"} ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong_trong_thang);


        listView = findViewById(R.id.lv3) ;
        searchView = (SearchView)findViewById(R.id.searchView3) ;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name) ;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang1Activity.class) ;
                    intent.putExtra("Tháng 1", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang2Activity.class) ;
                    intent.putExtra("Tháng 2", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==2){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang3Activity.class) ;
                    intent.putExtra("Tháng 3", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang4Activity.class) ;
                    intent.putExtra("Tháng 4", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang5Activity.class) ;
                    intent.putExtra("Tháng 5", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang6Activity.class) ;
                    intent.putExtra("Tháng 6", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);

                }else if (position==6){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang7Activity.class) ;
                    intent.putExtra("Tháng 7", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==7){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang8Activity.class) ;
                    intent.putExtra("Tháng 8", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==8){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang9Activity.class) ;
                    intent.putExtra("Tháng 9", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);
                }else if (position==9) {
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang10Activity.class);
                    intent.putExtra("Tháng 10", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                }else if (position==10) {
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang11Activity.class);
                    intent.putExtra("Tháng 11", listView.getItemAtPosition(position).toString());
                    startActivity(intent);
                }else if (position==11){
                    Intent intent = new Intent(HoatDongTrongThangActivity.this, Thang12Activity.class) ;
                    intent.putExtra("Tháng 12", listView.getItemAtPosition(position).toString()) ;
                    startActivity(intent);

            }}
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
