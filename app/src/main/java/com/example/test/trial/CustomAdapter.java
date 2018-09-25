package com.example.test.trial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<SpinnerItem> {

    CustomAdapter(Context context, ArrayList<SpinnerItem> items){
        super(context,0,items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position,View convertView,ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_row,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textView=convertView.findViewById(R.id.textView);

        SpinnerItem spinnerItem=getItem(position);

        if(spinnerItem!=null) {
            imageView.setImageResource(spinnerItem.getImageId());
            textView.setText(spinnerItem.getName());
        }

        return  convertView;
    }
}
