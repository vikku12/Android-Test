package com.example.kkushal.alpha.Cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ui.R;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {

	Context context;
	ArrayList<Product> productList;

	public ProductListAdapter(Context context, ArrayList<Product> list) {

		this.context = context;
		productList = list;
	}

	@Override
	public int getCount() {

		return productList.size();
	}

	@Override
	public Object getItem(int position) {

		return productList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		Product productListItems = productList.get(position);

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.show_itemlist, null);

		}
		TextView tvSlNo = (TextView) convertView.findViewById(R.id.text_Rs);
		tvSlNo.setText(productListItems.getId());
		TextView tvName = (TextView) convertView.findViewById(R.id.item_name);
		tvName.setText(productListItems.getTitle());
		TextView tvPhone = (TextView) convertView.findViewById(R.id.price);
		tvPhone.setText(productListItems.getPrice());
		ImageView tvimage=(ImageView)convertView.findViewById(R.id.item_img);
		tvimage.setImageBitmap(productListItems.getIcon_id());
		return convertView;
	}

}
