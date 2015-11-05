package com.example.kkushal.alpha.LocalDbClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KKushal on 15-Sep-15.
 */
public class OrderHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "B2bmonk.db";
    public static final String ORDER_TABLE_NAME = "orders";
    public static final String ORDER_COLUMN_ID = "id";
    public static final String ORDER_COLUMN_TITLE = "title";
    public static final String ORDER_COLUMN_PRICE = "price";
    public static final String ORDER_COLUMN_DESCRIPTION = "description";
    private HashMap hp;

   public  OrderHelper(Context context)
   {
       super(context,DATABASE_NAME,null,1);
   }

    @Override
    public void onCreate(SQLiteDatabase db){
        // TODO Auto-generated method stub
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement, title text,price text)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS order");
        onCreate(db);

    }
    public boolean insertOrder(String title, String price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("price", price);
        //contentValues.put("description", description);
        db.insert("orders", null, contentValues);
        return true;
    }
    public boolean updateOrder (Integer id, String title, String price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("price", price);
        db.update("orders", contentValues, "id = ? ", new String[]{Integer.toString(id)});
        return true;
    }
    public void deleteOrdes()
    {
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(ORDER_TABLE_NAME, null, null);
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from orders where id="+id+"", null );
        return res;
    }

    public ArrayList<String>getAllOrders()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from orders", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(ORDER_COLUMN_TITLE)));
            array_list.add(res.getString(res.getColumnIndex(ORDER_COLUMN_PRICE)));
            //array_list.add(res.getString(res.getColumnIndex(ORDER_COLUMN_DESCRIPTION)));
            res.moveToNext();
        }
        return array_list;
    }


}

