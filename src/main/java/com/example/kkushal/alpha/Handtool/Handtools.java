package com.example.kkushal.alpha.Handtool;

/**
 * Created by KKushal on 11-Aug-15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Handtools extends ListFragment {

    // Array of strings storing country names
    String[] title = new String[] {
            "",
            "SCREWDRIVERS AND NUTDRIVERS",
            "SPANNERS & WRENCHES"
    };

    //array for tag_name of horizontal view layout
    String []HI= new String[]{"image1","image2","image3","image4"};
    // Array of integers points to images stored in /res/drawable/
    int[][] icon_img = new int[][]{
            { R.drawable.sw6,R.drawable.sw7,R.drawable.sn6,R.drawable.sn7},
            { R.drawable.sn1,R.drawable.sn2,R.drawable.sn3,R.drawable.sn4},
            { R.drawable.sw1,R.drawable.sw2,R.drawable.sw3,R.drawable.sw4},

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<3;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("title_view", title[i]);
            for (int j=0;j<4;j++) {
                hm.put(HI[j], Integer.toString(icon_img[i][j]));
            }
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "title_view","image1","image2","image3","image4"};

        // Ids of views in listview_layout
        int[] to = { R.id.title_view,R.id.image1,R.id.image2,R.id.image3,R.id.image4};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.image_horizontalview, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    void showDetails(int index) {

        getListView().setItemChecked(index, true);
        Intent in = new Intent(getActivity(), HandtoolsActivity.class);
        startActivity(in);

    }
}
