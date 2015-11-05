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


public class FansList extends ListFragment {


    // Array of strings storing country names
    String[] Ftitle_name1 = new String[]{ "Excelair 200 MM Box Type Exhaust Fan","Havells, Grey, 42 W, Axial Fan","Sibass, Black, 220 V, Square Shape","Trinity Touch Tribox Enclosures"
            ,"Axial Fan"};


    String[]Fitem_price1 =new String[]{"900","600","500","3000","2500","1000"};



    int[]Ficon_img1=new int[]{ R.drawable.f1,R.drawable.f2,R.drawable.f3,R.drawable.f4,R.drawable.f5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<5;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            //for first column
            hm.put("item_name1", Ftitle_name1[i]);
            hm.put("item_img1", Integer.toString(Ficon_img1[i]));
            hm.put("price",Fitem_price1[i]);
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


        String t1=Ftitle_name1[position];

        String p1= Fitem_price1[position];
        int i1=Ficon_img1[position];
        // Starting new detail
        Bundle bundle = new Bundle();
        bundle.putString("title1", t1);
        bundle.putString("price1",p1);
        bundle.putInt("image1",i1);
        Intent in=new Intent(getActivity(),FlowActivity.class);
        in.putExtra("xy", bundle);
        startActivity(in);

    }

}
