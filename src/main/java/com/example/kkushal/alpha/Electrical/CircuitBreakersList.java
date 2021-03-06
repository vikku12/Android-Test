package com.example.kkushal.alpha.Electrical;

/**
 * Created by KKushal on 05-Sep-15.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.kkushal.alpha.Cart.FlowActivity;
import com.example.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CircuitBreakersList extends ListFragment {



    private static final String ARG_SECTION_NUMBER = "section_number";


    public static final String TAG =CircuitBreakersList.class
            .getSimpleName();
    // Array of strings storing product names
    String[] CBtitle_name1 = new String[]{"ABB | 10 kA, Double Pole","GreatWhite MCB DP C Series, 20446 ","Havells D Series SP MCB",
            "Havells DP RCCB A Type","Havells D"};

      //Array of String storing product price
    String[]CBitem_price1 =new String[]{"900","600","500","3000","2500","1000"};

    //Array of String storing product icon
    int[]CBicon_img1=new int[]{ R.drawable.cb1,R.drawable.cb2,R.drawable.cb3,R.drawable.cb4,R.drawable.cb5 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        // Each row in the list
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
      //putting value in hashmap
        for(int i=0;i<5;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("item_name1", CBtitle_name1[i]);
            hm.put("item_img1", Integer.toString(CBicon_img1[i]));
            hm.put("price",CBitem_price1[i]);
            aList.add(hm);
        }
        // Keys used in Hashmap
        String[] from = { "item_name1","item_img1","price"};

        // Ids of views in listview_layout
        int[] to = { R.id.item_name,R.id.item_img,R.id.price};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.show_itemlist, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //declare varible to passing data
        String t1=CBtitle_name1[position];
        String p1= CBitem_price1[position];
        int i1=CBicon_img1[position];
        // passing data through bundle &Intent
        Bundle bundle = new Bundle();
        bundle.putString("title1", t1);
        bundle.putString("price1",p1);
        bundle.putInt("image1",i1);
        //going to next activity
        Intent in=new Intent(getActivity(),FlowActivity.class);
        in.putExtra("xy", bundle);
        startActivity(in);
    }

}