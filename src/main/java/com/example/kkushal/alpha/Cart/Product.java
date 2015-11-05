package com.example.kkushal.alpha.Cart;

import android.graphics.Bitmap;

/**
 * Created by KKushal on 12-Sep-15.
 */
public class Product {

// varible name for product
   private String title;
   private String price;
   private Bitmap icon_id;
    private String id;
    public boolean selected;
public Product()
{

}
    //Constructor
  public  Product(String title,Bitmap icon_id,String price,String id)
    {
        this.title=title;
        this.icon_id=icon_id;
        this.price=price;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Bitmap getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(Bitmap icon_id) {
        this.icon_id = icon_id;
    }
}
