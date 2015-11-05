package com.example.kkushal.alpha.Cart;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ui.R;

public class Delivery extends ActionBarActivity {
TextView bname,bcity,bpincode,bstate,badd1,badd2,bcontact;
    String bstr1,bstr2,bstr3,bstr4,bstr5,bstr6,bstr7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);

        bstr1=getIntent().getStringExtra("name");
        bstr2=getIntent().getStringExtra("add1");
        bstr3=getIntent().getStringExtra("add2");
        bstr4=getIntent().getStringExtra("pincode");
        bstr5=getIntent().getStringExtra("city");
        bstr6=getIntent().getStringExtra("state");
        bstr7=getIntent().getStringExtra("contact");

       bname=(TextView)findViewById(R.id.billing_name);
        bname.setText(bstr1);

        badd1=(TextView)findViewById(R.id.billing_add1);
        badd1.setText(bstr2);


        badd2=(TextView)findViewById(R.id.billing_add2);
        badd2.setText(bstr3);

      bcity=(TextView)findViewById(R.id.billing_city);
        bcity.setText(bstr5);

        bpincode=(TextView)findViewById(R.id.billing_pincode);
        bpincode.setText(bstr4);

        bstate=(TextView)findViewById(R.id.billing_state);
        bstate.setText(bstr6);

        bcontact=(TextView)findViewById(R.id.billing_contact);
        bcontact.setText(bstr7);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delivery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
