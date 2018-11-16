package com.activity.myapplication.model;

import com.activity.myapplication.R;

import java.util.ArrayList;

public class ListDetails5 {
    public static ArrayList<Model> getList(){
        ArrayList<Model> list = new ArrayList<>() ;




        list.add(new Model(R.mipmap.vnu, " Giao hữu bóng đá với ĐH QUỐC GIA HÀ NỘI", " Ngày 3-5 chúng ta có trận giao hữu bóng đá với đội bóng của ĐH Quốc gia Hà Nội tại sân bóng PVF. "));
        list.add(new Model(R.mipmap.dn, " Giao hữu bóng đá với ĐH Sư Phạm Hà Nội", " Ngày 12-5 chúng ta có trận giao hữu bóng đá với đội bóng của ĐH Quốc gia Sư Phạm Hà Nội tại sân bóng của trường. "));
        list.add(new Model(R.mipmap.thptfpt, " Giao lưu với các bạn THPT FPT", " Ngày 15-5 chúng ta có buổi giao lưu trò chuyện cùng các bạn của trường THPT FPT. "));
        list.add(new Model(R.mipmap.ok, " Giao lưu với các bạn tại trung tâm bảo trợ trẻ em", " Ngày 21-5 chúng ta có buổi giao lưu, văn nghệ, trò chuyện cùng các bạn nhỏ tại trung tâm bảo trợ Nam Từ Liêm-Hà Nội. "));
        list.add(new Model(R.mipmap.n, " Tổng kết tháng 5", " Ngày 30-5 chúng ta có buổi giao liên hoan tổng kết tháng 1 tại Nam Tửu quán trước KTX Mỹ Đình. "));

        return list ;
    }
}
