package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test2.R;

public class HistoryActivity extends AppCompatActivity {
    private View iv_return_boxing;
    private TextView tv_support_store_history2;
    private RecyclerView rv_info_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        findViews();
        handleElement();
    }



    private void findViews() {
        iv_return_boxing = findViewById(R.id.iv_return_boxing);
        tv_support_store_history2 = findViewById(R.id.tv_support_store_history2);
        rv_info_list = findViewById(R.id.rv_info_list);
    }

    private void handleElement() {

    }
}