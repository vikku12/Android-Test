package com.example.kkushal.alpha.Hardwear;

/**
 * Created by KKushal on 05-Sep-15.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kkushal.alpha.Cart.MasterActivity2;
import com.example.ui.R;

public class HardwearActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_electrical, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                break;
            case R.id.action_cart:
                Intent intent=new Intent(HardwearActivity.this, MasterActivity2.class);
                startActivity(intent);
                break;

            case R.id.action_search:
                Toast.makeText(getBaseContext(), "You selected search", Toast.LENGTH_SHORT).show();
                break;
        }
        //   Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
        return true;
    }



}