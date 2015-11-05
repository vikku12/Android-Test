package com.example.kkushal.alpha.Cart;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kkushal.alpha.LocalDbClass.OrderHelper;
import com.example.kkushal.alpha.LocalDbClass.SqlHandler;
import com.example.ui.R;


public class FlowActivity extends ActionBarActivity{
TextView infoview1,priceview1;
    SqlHandler sqlHandler;
    private SQLiteDatabase db=null;
    ListView lvCustomList;
    ImageView first_image;
    Bitmap bitmap;
    //for Db
    int from_Where_I_Am_Coming = 0;
    private OrderHelper mydb;
    byte[]logic;

    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemshow);
        Bundle bundle = getIntent().getBundleExtra("xy");
        //for first column
        String str1 = bundle.getString("title1");
        String str2= bundle.getString("price1");
        int icon1=bundle.getInt("image1");
        Toast toast=new Toast(this);
        LayoutInflater inflater=this.getLayoutInflater();
        View toastView=inflater.inflate(R.layout.cart_message_display, (ViewGroup)findViewById(R.id.toastView));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ssback);
        sqlHandler=new SqlHandler(this);

        mydb = new OrderHelper(this);

        //for image

       ImageView first_image=(ImageView)findViewById(R.id.first_imgView);
        first_image.setImageResource(icon1);
        //for information
        infoview1=(TextView)findViewById(R.id.first_infoView);
        infoview1.setText(str1);
        //infoview2=(TextView)findViewById(R.id.first_infoView);
       //infoview2.setText(str3);
        //for price
        priceview1=(TextView)findViewById(R.id.first_priceView);
        priceview1.setText("Rs."+str2+"/-");

  //  bitmap =((BitmapDrawable)first_image.getDrawable()).getBitmap();
     bitmap=(BitmapFactory.decodeResource(
             getResources(), R.drawable.logic));
        System.out.println(bitmap);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // MenuInflater inflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_flow, menu);
        MenuItem menuItem = menu.findItem(R.id.action_cart);
        menuItem.setIcon(buildCounterDrawable(count, R.drawable.empty_shopping_cart));

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
                Intent intent=new Intent(FlowActivity.this, MasterActivity2.class);
                startActivity(intent);
                break;

        }
        //   Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
        return true;
    }
    public void showDialog(View v)
    {
        Toast toast=new Toast(getApplicationContext());
        LayoutInflater inflater=this.getLayoutInflater();
        View toastView=inflater.inflate(R.layout.cart_message_display, (ViewGroup)findViewById(R.id.toastView));
        toast.setGravity(Gravity.TOP, 14, 14);
        toast.setView(toastView);
        toast.show();
       // System.out.println(logic);
        doIncrease();
        goToCart();
    }
     public void goToCart(){

         String title = infoview1.getText().toString();
         String rate = priceview1.getText().toString();
         logic=Utility.getBytes(bitmap);

         String query = "INSERT INTO ORDER_INFO1(title,price,pic) values ('"
                 + title + "','" + rate + "','"+logic+"')";
         sqlHandler.executeQuery(query);
        // showlist();
        /* if(mydb.insertOrder(infoview1.getText().toString(), priceview1.getText().toString())){
                 }

                 else{
                     Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                 }*/

                 Intent intent = new Intent(FlowActivity.this,MasterActivity2.class);
                 startActivity(intent);
         }
/*
         Bundle bundle = getIntent().getBundleExtra("xy");
         //for first column
         String str1 = bundle.getString("title1");
         String str2= bundle.getString("price1");
         int icon1=bundle.getInt("image1");

         Intent intent1 = new Intent(FlowActivity.this,ProductDetailsActivity1.class);
         intent1.putExtra("name",str1);
         intent1.putExtra("img", icon1);
         intent1.putExtra("price",str2);
         startActivity(intent1);*/

    private Drawable buildCounterDrawable(int count, int backgroundImageId) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.counter_menuitem_layout, null);
        view.setBackgroundResource(backgroundImageId);

        if (count == 0) {
            View counterTextPanel = view.findViewById(R.id.counterValuePanel);
            counterTextPanel.setVisibility(View.GONE);
        } else {
            TextView textView = (TextView) view.findViewById(R.id.count);
            textView.setText("" + count);
        }

        view.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        return new BitmapDrawable(getResources(), bitmap);
    }

    private void doIncrease() {
        count++;
        invalidateOptionsMenu();
    }
}
