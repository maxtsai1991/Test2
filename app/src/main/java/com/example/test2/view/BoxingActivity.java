package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.test2.R;

public class BoxingActivity extends AppCompatActivity {
    private ImageView iv_back_main, iv_to_history;
    private EditText et_num, et_quantity;
    private CheckBox cb_no_auto;
    private Button bt_print;
    // test commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boxing);


        findViews();
        handleElement();
    }

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
        cb_no_auto = findViewById(R.id.cb_no_auto);
        // 列印
        bt_print = findViewById(R.id.bt_print);
    }

    private void handleElement() {
        // 跳轉到歷程記錄
        iv_to_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoxingActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });





    }

}