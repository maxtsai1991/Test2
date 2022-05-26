package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.test2.R;
import com.example.test2.Vendor;
import com.example.test2.VendorAdapter;
import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {
    private View iv_return_boxing; // 返回到裝箱作業
    private TextView tv_vendor_name_history; // 供應商
    private RecyclerView rv_info_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        findViews();
        handleElement(); // 元件處理

        /**
         * 假資料
         */
        ArrayList<Vendor> vendorArrayList = new ArrayList<>();
        for (int i =111123456 ; i < 111123465 ; i++){
            Vendor vendor = new Vendor("AA" + i + "6","1");
            Vendor vendor2 = new Vendor("BB" + i + "5","2");
            Vendor vendor3 = new Vendor("CC" + i + "4","3");
            Vendor vendor4 = new Vendor("DD" + i + "3","4");
            Vendor vendor5 = new Vendor("EE" + i + "2","5");
            Vendor vendor6 = new Vendor("FF" + i + "1","6");
            vendorArrayList.add(vendor);
            vendorArrayList.add(vendor2);
            vendorArrayList.add(vendor3);
            vendorArrayList.add(vendor4);
            vendorArrayList.add(vendor5);
            vendorArrayList.add(vendor6);
        }

        /**
         * Adapter
         */
        VendorAdapter myAdapter = new VendorAdapter(vendorArrayList);
        rv_info_list.setAdapter(myAdapter);

        /**
         * RecyclerView
         */
        rv_info_list.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL)); // 為RecyclerView每個item畫底線
        rv_info_list.setLayoutManager(new LinearLayoutManager(this));
    }

        /**
         * findView
         */
    private void findViews() {
        // 返回到裝箱作業
        iv_return_boxing = findViewById(R.id.iv_return_boxing);
        // 供應商
        tv_vendor_name_history = findViewById(R.id.tv_vendor_name_history);
        // RecyclerView
        rv_info_list = findViewById(R.id.rv_info_list);
    }

        /**
         * 元件處理
         */
    private void handleElement() {
        // 返回到裝箱作業
        iv_return_boxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, BoxingActivity.class);
                startActivity(intent);
            }
        });

        /**
         * 取得上一頁BoxingActivity供應商資料 (bundle) , 設置供應商名稱
         */
        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();
        String vendorname = bundle.getString("vendorname");
        tv_vendor_name_history.setText(vendorname);
    }

}