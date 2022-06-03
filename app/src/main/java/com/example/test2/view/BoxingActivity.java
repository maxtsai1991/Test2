package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test2.R;
import com.example.test2.Vendor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BoxingActivity extends AppCompatActivity {
    /**
     * 返回主選單 , 進入裝箱作業-工作歷程(歷程記錄)
     */
    private ImageView iv_back_main, iv_to_history;
    /**
     * 供應商名稱
     */
    private TextView tv_vendor_boxing;
    /**
     * 條碼資訊(號碼) , 數量
     */
    private EditText et_num, et_quantity;
    /**
     * CheckBox(手動/自動)
     */
    private CheckBox cb_no_auto;
    /**
     * 列印
     */
    private Button bt_print;
    private String vendorName = "帝商";

    private ArrayList<Vendor> vendorList;
    private Vendor vendor ;
    /**
     * EditText輸入[號碼]轉字串
     */
    private String inputNumStr;
    /**
     * EditText輸入[數量]轉字串
     */
    private String inputQTYStr;


    public BoxingActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing);
        findViews();
        handleElement();

        /**
         * ArrayList & Vendor (JavaBean) 初始化
         */
        vendorList = new ArrayList<>();
        vendor = new Vendor();

    }

    /**
     * findViews
     */
    private void findViews() {
        // 返回主選單
        iv_back_main = findViewById(R.id.iv_back_main);
        // 進入裝箱作業-工作歷程(歷程記錄)
        iv_to_history = findViewById(R.id.iv_to_history);
        // 條碼資訊(號碼)
        et_num = findViewById(R.id.et_num);
        // 數量
        et_quantity = findViewById(R.id.et_quantity);
        // 手動
        cb_no_auto = (CheckBox) findViewById(R.id.cb_no_auto);
        // 列印
        bt_print = findViewById(R.id.bt_print);
        // 供應商
        tv_vendor_boxing = findViewById(R.id.tv_vendor_boxing);
    }

    /**
     * 元件處理
     */
    private void handleElement() {

        /**
         * 跳轉下一頁(歷程記錄)
         */
        iv_to_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoxingActivity.this, HistoryActivity.class);
                /**
                 * Bundle 將資料帶到下一頁 歷程記錄
                 */
                Bundle bundle = new Bundle();
                bundle.putString("vendorname", vendorName);
                bundle.putParcelableArrayList("vendorList",vendorList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        /**
         * 列印 : 暫時先取得三種資料 : 供應商 號碼 數量
         */
        bt_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BoxingActivity.this, "供應商 : " + vendorName + "\n"
                        + " 條碼號碼 : " + et_num.getEditableText().toString()  + "\n"
                        + " 數量 : " + et_quantity.getEditableText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 供應商設定文字
         */
        tv_vendor_boxing.setText(vendorName);

        /**
         *  et_num EditText【號碼】監聽事件
         */
        et_num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                    et_num.setHint("輸入英文&數字");                   // 設定提示訊息
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    inputNumStr = et_num.getText().toString().trim();       // EditText輸入[號碼]轉字串
                    Log.d("debug", "輸入的號碼 : " + inputNumStr);
                    return true;
                }
                return false; //回傳 false 表示到這邊結束，回傳 true 則會繼續原本 onKey 定義的動作。
            }
        });

        /**
         *  et_quantity EditText【數量】監聽事件
         */
        et_quantity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                    et_quantity.setHint("輸入整數");                         // 設定提示訊息
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    inputQTYStr = et_quantity.getText().toString().trim();            // EditText輸入[數量]轉字串
                    Log.d("debug", "輸入的數量 : " + inputQTYStr);

                    /**
                     * 判斷是否同號碼
                     */
                    judgeNum(inputNumStr, inputQTYStr);

                    /**
                     * 隱藏鍵盤
                     */
                    InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    if(inputMethodManager.isActive()){
                        inputMethodManager.hideSoftInputFromWindow(BoxingActivity.this.getCurrentFocus().getWindowToken(),0);
                    }
                    return true;
                }
                return false; //回傳 false 表示到這邊結束，回傳 true 則會繼續原本 onKey 定義的動作。
            }
        });

        /**
         * Checkbox(手動/自動) 預設為自動(isChecked = false)
         */
        cb_no_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 判斷兩欄位是否為空值
                if (TextUtils.isEmpty(inputNumStr) && TextUtils.isEmpty(inputQTYStr)){
                    Toast.makeText(BoxingActivity.this, " 號碼及數量不能為空,請輸入號碼及數量 ", Toast.LENGTH_SHORT).show();
                }else {
                    if (isChecked){
                        Toast.makeText(BoxingActivity.this, " 【手動】 ", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(BoxingActivity.this, " 【自動】 ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    /**
     * 判斷是否同號碼
     */
    public ArrayList<Vendor> judgeNum(String inputNumStr, String inputQTY){
        /**
         * 初始化Vendor
         */
        vendor = new Vendor();
        /**
         * 設定[號碼] 到vendor
         */
        vendor.setBarcodenum(inputNumStr);
        Log.d("debug",  " 取vendor號碼 : " + vendor.getBarcodenum() );
        /**
         * 設定[數量] 到vendor
         */
        vendor.setQuantity(inputQTY);
        Log.d("debug",  " 取vendor數量 : " + vendor.getQuantity() );
        /**
         * vendor 放進 ArrayList<Vendor>
         */
        vendorList.add(vendor);

        /**
         * HashMap初始化 , Key放String , Value放vendor的號碼及數量
         */
        Map<String, Vendor> map = new HashMap<>();
        /**
         * 遍歷vendorList
         */
        for(Vendor vendor : vendorList){
            /**
             * if判斷 : 取vendor的號碼 並和 map 比對
             */
            if(map.containsKey(vendor.getBarcodenum())){
                /**
                 * 取map裡面的vendor號碼 , 放進oldVendor(型態Vendor)
                 */
                Vendor oldVendor = map.get(vendor.getBarcodenum());
                /**
                 * oldVendor號碼 相加 vendor的數量 並轉型成int 放入sumQTY
                 */
                int sumQTY = Integer.parseInt(oldVendor.getQuantity()) + Integer.parseInt(vendor.getQuantity());
                /**
                 * int的sumQTY 轉回 String
                 */
                String sumQTYStr = String.valueOf(sumQTY);
                /**
                 * 將sumQTYStr設定給oldVendor的數量
                 */
                oldVendor.setQuantity(sumQTYStr);
                /**
                 * oldVendor放回vendorList
                 */
                vendorList.add(oldVendor);
            }else {
                /**
                 * map放入 ( vendor號碼 , 新的Vendor(vendor號碼,vendor數量) )
                 */
                map.put(vendor.getBarcodenum(), new Vendor(vendor.getBarcodenum(),vendor.getQuantity()));
            }
        }
        return vendorList;
    }

}