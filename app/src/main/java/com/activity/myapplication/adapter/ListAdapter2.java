package com.activity.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.activity.myapplication.R;
import com.activity.myapplication.model.Model;

import java.util.ArrayList;

public class ListAdapter2 extends BaseAdapter {

    private Context context ;
    private ArrayList<Model> models ;

    public ListAdapter2(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = View.inflate(context, R.layout.list_items, null) ;
        }
        ImageView images = (ImageView) convertView.findViewById(R.id.imageView);
        TextView name = (TextView) convertView.findViewById(R.id.tv_name) ;
        TextView nd = (TextView) convertView.findViewById(R.id.tv_nd) ;

        Model model = models.get(position) ;
        images.setImageResource(model.getImage());
        name.setText(model.getTvName());
        nd.setText(model.getTvNd());

        return convertView;
    }
}
