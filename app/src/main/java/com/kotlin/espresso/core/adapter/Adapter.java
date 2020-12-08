package com.kotlin.espresso.core.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kotlin.espresso.R;
import com.kotlin.espresso.core.data.Course;
import com.kotlin.espresso.core.helper.ImageHandler;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private static LayoutInflater inflater;
    private ArrayList<Course> data;

    public Adapter(Context context, ArrayList<Course> data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        //Not necessary
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Not necessary
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view =  inflater.inflate(R.layout.item_list, null);
        ImageView imageCourses = (ImageView) view.findViewById(R.id.image_course);
        TextView titleCourse= (TextView) view.findViewById(R.id.title_course);
        titleCourse.setText(data.get(position).getName());
        imageCourses.setImageBitmap(ImageHandler.getImageFromUrl(data.get(position).getImage()));
        return view;
    }

}
