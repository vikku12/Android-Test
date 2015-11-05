package com.example.kkushal.alpha.LocalDbClass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDbHelper extends SQLiteOpenHelper {
	public static String DATABASE_TABLE = "ORDER_INFO1";

	public static final String COLUMN1 = "slno";
	public static final String COLUMN2 = "title";
	public static final String COLUMN3 = "price";
	public static final String COLUMN4=  "pic";
	private  String SCRIPT_CREATE_DATABASE = "create table "
			+ DATABASE_TABLE + " (" + COLUMN1
			+ " integer primary key autoincrement, " + COLUMN2
			+ " text not null, " + COLUMN3 + " text not null, " + COLUMN4 + " blob);";

	public SqlDbHelper(Context context, String name, CursorFactory factory,
					   int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SCRIPT_CREATE_DATABASE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
		onCreate(db);
	}

}
