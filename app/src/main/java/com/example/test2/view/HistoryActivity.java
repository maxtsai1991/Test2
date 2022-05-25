package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test2.R;
import com.example.test2.SupportStore;
import com.example.test2.SupportStoreAdapter;
import com.example.test2.VendorAdapter;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private View iv_return_boxing; // 返回到裝箱作業
    private TextView tv_support_store_history2; // 供應商
    private RecyclerView rv_info_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        findViews();
        handleElement();

        // 假資料
        List<SupportStore> supportStoreArrayList = new ArrayList<>();
        SupportStore supportStore = new SupportStore("123456","1");
        SupportStore supportStore2 = new SupportStore("654321","2");
        SupportStore supportStore3 = new SupportStore("678900","3");
        SupportStore supportStore4 = new SupportStore("009876","4");
        SupportStore supportStore5 = new SupportStore("345679","5");
        supportStoreArrayList.add(supportStore);
        supportStoreArrayList.add(supportStore2);
        supportStoreArrayList.add(supportStore3);
        supportStoreArrayList.add(supportStore4);
        supportStoreArrayList.add(supportStore5);
        // 假資料2
        ArrayList<String> arrayList = new ArrayList<>();//做陣列
        for (int i =0;i<3;i++){
            arrayList.add("A"+i);
            arrayList.add("B"+i);
            arrayList.add("C"+i);
            arrayList.add("D"+i);
        }

        // Adapter
//        SupportStoreAdapter supportStoreAdapter = new SupportStoreAdapter(supportStoreArrayList);
//        rv_info_list.setAdapter(supportStoreAdapter);
        VendorAdapter myAdapter = new VendorAdapter(arrayList);
        rv_info_list.setAdapter(myAdapter);


        // RecyclerView
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        rv_info_list.setLayoutManager(layoutManager);

        rv_info_list.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));//為RecyclerView每個item畫底線
        rv_info_list.setLayoutManager(new LinearLayoutManager(this));


    }




    private void findViews() {
        // 返回到裝箱作業
        iv_return_boxing = findViewById(R.id.iv_return_boxing);
        // 供應商
        tv_support_store_history2 = findViewById(R.id.tv_support_store_history2);
        // RecyclerView
        rv_info_list = findViewById(R.id.rv_info_list);
    }

    private void handleElement() {
        // 返回到裝箱作業
        iv_return_boxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, BoxingActivity.class);
                startActivity(intent);
            }
        });


        // 取得上一頁BoxingActivity供應商資料 (bundle)
        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();
        String SupportCompany = bundle.getString("SupportCompany");
        tv_support_store_history2.setText(SupportCompany);
    }


}