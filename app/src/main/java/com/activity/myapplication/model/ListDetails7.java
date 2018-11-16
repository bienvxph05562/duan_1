package com.activity.myapplication.model;

import com.activity.myapplication.R;

import java.util.ArrayList;

public class ListDetails7 {
    public static ArrayList<Model> getList(){
        ArrayList<Model> list = new ArrayList<>() ;

        list.add(new Model(R.mipmap.logo, " Giao hữu bóng đá với ĐH Ngọai Thương", " Ngày 10-7 chúng ta có trận giao hữu bóng đá với đội bóng của ĐH Ngoại Thương tại sân bóng FPT. "));
        list.add(new Model(R.mipmap.g, " Tập luyện  ", " Ngày 16-7 chúng ta có buổi tập luyện cùng đội tuyển phủi EOC. "));
        list.add(new Model(R.mipmap.futsal, " Giao lưu bóng đá futsal với trẻ HaNoi Buffalo", " Ngày 22-7 chúng ta có buổi giao bóng đá futsal tập luyện cùng đội trẻ HaNoi Buffalo. "));
        list.add(new Model(R.mipmap.ttt, " Giao hữu cùng fan", " Ngày 27-7 chúng ta có buổi giao lưu cùng người hâm mộ. "));
        list.add(new Model(R.mipmap.n, " Tổng kết tháng 9", " Ngày 30-7 chúng ta có buổi giao liên hoan tổng kết tháng 7 tại  quán nước mía tại KTX Mỹ Đình. "));

        return list ;
    }
}
