package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test2.R;

public class BoxingActivity extends AppCompatActivity {
    private ImageView iv_back_main, iv_to_history; // 返回主選單 , 進入裝箱作業-工作歷程(歷程記錄)
    private TextView tv_support_company; // 供應商
    private EditText et_num, et_quantity; // 條碼資訊(號碼) , 數量
    private CheckBox cb_no_auto; // 手動
    private Button bt_print; // 列印
    private String SupportCompany = "帝商科技2022";

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
        cb_no_auto = (CheckBox) findViewById(R.id.cb_no_auto);
        // 列印
        bt_print = findViewById(R.id.bt_print);
        // 供應商
        tv_support_company = findViewById(R.id.tv_support_company);
    }

    private void handleElement() {

        // 跳轉到歷程記錄
        iv_to_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoxingActivity.this, HistoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("SupportCompany",SupportCompany);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        // Checkbox(手/自) 預設為手動(isChecked = true)
        cb_no_auto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(BoxingActivity.this, " 已開啟手動 ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(BoxingActivity.this, " 已開啟自動 ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 供應商
        tv_support_company.setText(SupportCompany);
        // 條碼
        String num1 = et_num.getEditableText().toString();
        // 數量
        String quantity = et_quantity.getEditableText().toString();

        // 列印
        bt_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BoxingActivity.this, "條碼號碼 : " + et_num.getEditableText().toString() +" , " + " 數量 : " + et_quantity.getEditableText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}