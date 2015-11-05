package com.example.kkushal.alpha;

/**
 * Created by KKushal on 11-Aug-15.
 */


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ui.R;

@SuppressLint("ValidFragment")
public class DeviceListTemplate extends Fragment{

    String data = null;

    @SuppressLint("ValidFragment")
    public DeviceListTemplate(String payload){
        data = payload;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.device_list_template, container,
                false);
        TextView text = (TextView) rootView.findViewById(R.id.textView1);
        text.setText(data);
        return rootView;
    }



}
