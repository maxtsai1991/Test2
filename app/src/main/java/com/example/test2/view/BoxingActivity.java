package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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

    private ArrayList<Vendor> vendorArrayList;
    private Vendor vendor;

    private String editableNumStr;
    private String editableQuantityStr;

    public BoxingActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing);
        findViews();
        handleElement();

        vendorArrayList = new ArrayList<>();
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
         * 跳轉下一頁(歷程記錄) , Bundle供應商名稱
         */
        iv_to_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoxingActivity.this, HistoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("vendorname", vendorName);
                bundle.putParcelableArrayList("vendorArrayList",vendorArrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        /**
         * Checkbox(手動/自動) 預設為自動(isChecked = false)
         */
        cb_no_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(BoxingActivity.this, " 【手動】 ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(BoxingActivity.this, " 【自動】 ", Toast.LENGTH_SHORT).show();
                }
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
         *  et_num EditText號碼監聽事件
         */
        et_num.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    editableNumStr = et_num.getText().toString();
//                    vendor = new Vendor();
//                    vendor.setBarcodenum(editableNumStr);
//                    vendorArrayList.add(vendor);
                    return true;
                }
                return false;
            }
        });

        /**
         *  et_quantity EditText數量監聽事件
         */
        et_quantity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    editableQuantityStr = et_quantity.getText().toString();
                    vendor = new Vendor();
                    vendor.setBarcodenum(editableNumStr);
                    vendor.setQuantity(editableQuantityStr);
                    vendorArrayList.add(vendor);
                    return true;
                }
                return false;
            }
        });
    }

}