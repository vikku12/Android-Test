package com.example.kkushal.alpha.Cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ui.R;

public class AddDeliveryAddress extends ActionBarActivity {
     EditText name, add1,add2,pincode,city,state,ph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_address);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);


        name=(EditText)findViewById(R.id.nameText);
        add1=(EditText)findViewById(R.id.add1_text);
        add2=(EditText)findViewById(R.id.add2_text);
        pincode=(EditText)findViewById(R.id.pin_text);
        city=(EditText)findViewById(R.id.city_text);
        state=(EditText)findViewById(R.id.state_text);
         ph=(EditText)findViewById(R.id.contact_number);

        Button deliver=(Button)findViewById(R.id.deliver_button);
        deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get data
                String Name=name.getText().toString();
                String Add1= add1.getText().toString();
                String Add2=add2.getText().toString();
                String Pincode=pincode.getText().toString();
                String City=city.getText().toString();
                String State=state.getText().toString();
               String Contact=ph.getText().toString();

                Intent intent =new Intent(AddDeliveryAddress.this,Delivery.class);
                intent.putExtra("name",Name);
                intent.putExtra("add1",Add1);
                intent.putExtra("add2",Add2);
                intent.putExtra("pincode",Pincode);
                intent.putExtra("city",City);
                intent.putExtra("state",State);
                intent.putExtra("contact", Contact);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_delivery_address, menu);
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
