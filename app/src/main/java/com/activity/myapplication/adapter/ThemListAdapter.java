package com.activity.myapplication.adapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.activity.myapplication.Model;
import com.activity.myapplication.R;

import java.util.ArrayList;

public class ThemListAdapter extends BaseAdapter {

    private Context context ;
    private int layout ;
    private ArrayList<Model> recordList ;

    public ThemListAdapter(Context context, int layout, ArrayList<Model> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }


    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int i) {
        return recordList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView imageView ;
        TextView  tvHoten, tvTuoi, tvQuequan, tvNoiohiennay, tvNgaysinh, tvVitrithidau, tvMucluong, tvGhichu ;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = view ;
        ViewHolder holder = new ViewHolder() ;

        if (row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
            row = inflater.inflate(layout, null) ;
            holder.tvHoten= row.findViewById(R.id.tvHoten) ;
            holder.tvTuoi= row.findViewById(R.id.tvTuoi) ;
            holder.tvQuequan = row.findViewById(R.id.tvQuequan) ;
            holder.tvNoiohiennay = row.findViewById(R.id.tvNoio) ;
            holder.tvNgaysinh= row.findViewById(R.id.tvNgaysinh) ;
            holder.tvVitrithidau = row.findViewById(R.id.tvVitrithidau) ;
            holder.tvMucluong= row.findViewById(R.id.tvMucluong) ;
            holder.tvGhichu = row.findViewById(R.id.tvGhichu) ;
            holder.imageView = row.findViewById(R.id.imgIcoi) ;
            row.setTag(holder);
        }else {
            holder = (ViewHolder)row.getTag() ;
        }

        Model model = recordList.get(i) ;


        holder.tvHoten.setText(model.getHoten());
        holder.tvTuoi.setText(model.getTuoi());
        holder.tvQuequan.setText(model.getQuequan());
        holder.tvNoiohiennay.setText(model.getNoiohiennay());
        holder.tvNgaysinh.setText(model.getNgaysinh());
        holder.tvVitrithidau.setText(model.getVitrithidau());
        holder.tvMucluong.setText(model.getMucluong());
        holder.tvGhichu.setText(model.getGhichu());


        byte[] recordImage = model.getImage() ;
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length) ;
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
    }

