package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

//import com.regalscan.regalutilitylib.DBHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static android.os.Environment.DIRECTORY_DOWNLOADS;


public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MainActivity";
//    DBHelper dbHelper;
//    private final String DB_NAME = "Testdb.db";
//    private String TABLE_NAME = "ASSETS";
//    private String PROJECTION = " ";
//    Button bt_add,bt_del,bt_change,bt_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViews();
//        buttonFunction();
//
//        dbHelper = new DBHelper(getContentResolver(),"/storage/emulated/0/Download",DB_NAME);

    }

//    private void findViews() {
//        bt_add = findViewById(R.id.bt_add);
//        bt_del = findViewById(R.id.bt_del);
//        bt_change = findViewById(R.id.bt_change);
//        bt_select = findViewById(R.id.bt_select);
//    }
//
//    private void buttonFunction() {
//        // 增
//        bt_add.setOnClickListener(v -> {
//            insert();
//        });
//        // 刪
//        bt_del.setOnClickListener(v -> {
//            del();
//        });
//        // 改
//        bt_change.setOnClickListener(v -> {
//            update();
//        });
//        // 查
//        bt_select.setOnClickListener(v -> {
//            select();
//        });
//    }
//
//    /**
//     * Insert : 增
//     */
//    public void insert(){
//        try {
//            ContentValues values = new ContentValues();
//            values.put("ID", 7);
//            values.put("Device", "Pen");
//            values.put("TypeID", 1);
//            values.put("CreateDate", "2020-12-12");
//            values.put("Price", 300);
//            Boolean insertboolean = dbHelper.insert(TABLE_NAME,values);
//            Log.d(TAG, "insertboolean: " + insertboolean);
//            dbHelper.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Delete : 刪
//     */
//    public void del(){
//        try {
//            int delquantity = dbHelper.delete("DELETE FROM ASSETS WHERE ID = 6");
//            dbHelper.close();
//            Log.d(TAG, "delquantity: " + delquantity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Update : 改
//     */
//    public void update(){
//        try {
//            int updatequantity =  dbHelper.update("UPDATE ASSETS SET Price = 60000 WHERE ID = 4");
//            dbHelper.close();
//            Log.d(TAG, "updatequantity: " + updatequantity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Select : 查
//     */
//    public void select(){
//        try {
//            Cursor cursor1 = dbHelper.query("SELECT * FROM ASSETS");
//            if (cursor1 != null && cursor1.getCount() >= 0) {
//                while (cursor1.moveToNext()) {
//                    String ID = cursor1.getString(cursor1.getColumnIndexOrThrow("ID"));
//                    String Device = cursor1.getString(cursor1.getColumnIndexOrThrow("Device"));
//                    String TypeID = cursor1.getString(cursor1.getColumnIndexOrThrow("TypeID"));
//                    String CreateDate = cursor1.getString(cursor1.getColumnIndexOrThrow("CreateDate"));
//                    String Price = cursor1.getString(cursor1.getColumnIndexOrThrow("Price"));
//
//                    Log.d(TAG, "ID: " + ID +
//                            " ,Device: " + Device +
//                            " ,TypeID: " + TypeID +
//                            " ,CreateDate: " + CreateDate +
//                            " ,Price: " + Price
//                    );
//                    String s = "ID=" + ID + "\r\n" + "Device=" + Device + "\r\n" + "TypeID=" + TypeID + "\r\n" + "CreateDate=" + CreateDate + "\r\n" + "Price=" + Price;
//                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//                    dbHelper.close();
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}