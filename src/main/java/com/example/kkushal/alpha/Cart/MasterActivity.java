package com.example.kkushal.alpha.Cart;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kkushal.alpha.LocalDbClass.OrderHelper;
import com.example.ui.R;

public class MasterActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "MESSAGE";
    private ListView obj;
    OrderHelper mydb;
    int id_To_Update=1;



    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);
           showListView();



        mydb=new OrderHelper(this);
      /*  ArrayList arrayList=mydb.getAllOrders();
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.show_itemlist,null,
                                 new String[]{OrderHelper.ORDER_COLUMN_TITLE,OrderHelper.ORDER_COLUMN_PRICE}, new int[]{R.id.item_name,R.id.price},0);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrayList);
         obj=(ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println(position);
                builder.setMessage(R.string.deleteOrder)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                   mydb.deleteOrdes();
                                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                                   //Intent intent = new Intent(getApplicationContext(), MasterActivity.class);
                                    //startActivity(intent);

                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Are you sure");
                d.show();
            }
        });*/

        Button proceedto_checkout =(Button)findViewById(R.id.proceed_button);
        proceedto_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterActivity.this, AddDeliveryAddress.class);
                startActivity(intent);
            }
        });

    }

    private void showListView() {
  ArrayAdapter<Product> arrayAdapter=new MyListAdapter();
        ListView listView=(ListView)findViewById(R.id.item_list);
        listView.setAdapter(arrayAdapter);
    }
    private class MyListAdapter extends ArrayAdapter<Product>{

        MyListAdapter()
        {
            super(MasterActivity.this, R.layout.show_itemlist);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemview = convertView;
            if (itemview == null) {
                itemview = getLayoutInflater().inflate(R.layout.show_itemlist, parent, false);
            }
            int value = position + 1;
            if (value > 0) {
                Cursor rs = mydb.getData(value);
                id_To_Update = value;
                rs.moveToFirst();
                String title = rs.getString(rs.getColumnIndex(OrderHelper.ORDER_COLUMN_TITLE));
                String rate = rs.getString(rs.getColumnIndex(OrderHelper.ORDER_COLUMN_PRICE));
                System.out.println(title);
                System.out.println(rate);
                if (!rs.isClosed())
                {
                    rs.close();
                }
              // Product currentroduct=myProduct.get(position);
                TextView textView1 = (TextView) findViewById(R.id.item_name);
                textView1.setText(title);

                TextView textView2 = (TextView) findViewById(R.id.price);
                textView2.setText(rate);

                ImageView imageView=(ImageView)findViewById(R.id.item_img);
               // imageView.setImageResource(currentroduct.getIcon_id());
            }
            return  itemview;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_master, menu);
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
