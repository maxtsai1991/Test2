package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test2.R;

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
        handleCheckBoxes();
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

    }

    private void handleCheckBoxes() {
    }
}