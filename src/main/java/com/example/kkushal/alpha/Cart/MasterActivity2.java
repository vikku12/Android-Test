package com.example.kkushal.alpha.Cart;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.kkushal.alpha.LocalDbClass.SqlHandler;
import com.example.ui.R;

import java.util.ArrayList;

public class MasterActivity2 extends ActionBarActivity{

	SqlHandler sqlHandler;
	ListView lvCustomList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_master);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);
		lvCustomList = (ListView) findViewById(R.id.item_list);
		sqlHandler=new SqlHandler(this);
		showlist();
		lvCustomList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
										   int arg2, long arg3) {

				Product productListItems = (Product) arg0.getItemAtPosition(arg2);
				String slno = productListItems.getId();
				String delQuery = "DELETE FROM ORDER_INFO1 WHERE slno='" + slno + "' ";
				sqlHandler.executeQuery(delQuery);
				showlist();

				return false;
			}
		});

		Button proceedto_checkout =(Button)findViewById(R.id.proceed_button);
		proceedto_checkout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MasterActivity2.this, AddDeliveryAddress.class);
				startActivity(intent);
			}
		});

	}

	private void showlist() {

		ArrayList<Product> contactList = new ArrayList<Product>();
		contactList.clear();
		String query = "SELECT * FROM ORDER_INFO1 ";
		Cursor c1 = sqlHandler.selectQuery(query);
		System.out.println(c1);


		if (c1 != null && c1.getCount() != 0) {
			if (c1.moveToFirst()) {
				do {
					Product contactListItems = new Product();

					contactListItems.setId(c1.getString(c1
							.getColumnIndex("slno")));
					contactListItems.setTitle(c1.getString(c1
							.getColumnIndex("title")));
					contactListItems.setPrice(c1.getString(c1
							.getColumnIndex("price")));
					byte []log=c1.getBlob(c1.getColumnIndex("pic"));

					//problem in (Bitmap bitmap=Utility.getPhoto(log); return null value....
					System.out.println(Utility.getPhoto(log));
					contactListItems.setIcon_id(Utility.getPhoto(c1.getBlob(c1.getColumnIndex("pic"))));
					contactList.add(contactListItems);

				} while (c1.moveToNext());
			}
		}
		c1.close();

		ProductListAdapter productListAdapter = new ProductListAdapter(
				MasterActivity2.this, contactList);
		lvCustomList.setAdapter(productListAdapter);

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
