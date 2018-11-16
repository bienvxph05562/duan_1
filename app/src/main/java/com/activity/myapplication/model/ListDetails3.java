package com.activity.myapplication.model;

import com.activity.myapplication.R;

import java.util.ArrayList;

public class ListDetails3 {
    public static ArrayList<Model> getList(){
        ArrayList<Model> list = new ArrayList<>() ;

        list.add(new Model(R.mipmap.n, " Nghỉ tết Nguyên Đán", " Nghỉ tết từ ngày 1-3 đến hết ngày 29-3. "));

        return list ;
    }
}
