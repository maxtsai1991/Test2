package com.example.test2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.test2.JavaBean;
import com.example.test2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TestActivity extends AppCompatActivity {
    private List<JavaBean> javaBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //假資料
        javaBeanList.add(new JavaBean(123,1));
        javaBeanList.add(new JavaBean(222,2));
        javaBeanList.add(new JavaBean(888,2));
        javaBeanList.add(new JavaBean(222,3));
        javaBeanList.add(new JavaBean(222,5));
        javaBeanList.add(new JavaBean(123,2));
        javaBeanList.add(new JavaBean(888,3));

        Map<Integer, JavaBean> map = new HashMap<>();

        for ( JavaBean javaBean : javaBeanList ){                                                       // 假資料放進javaBean
            if (map.containsKey(javaBean.getNumber())){                                                 // 當map包含javaBean的號碼
                JavaBean oldJavaBean = map.get(javaBean.getNumber());                                   // 取map的javaBean的號碼放入oldJavaBean
                oldJavaBean.setAmount(oldJavaBean.getAmount() + javaBean.getAmount());                  // oldJavaBean設定數量 ( oldJavaBean數量 + javaBean數量 )
            }else{
                map.put(javaBean.getNumber(), new JavaBean(javaBean.getNumber(), javaBean.getAmount())); //map放入 ( javaBean號碼 , 新的JavaBean放入(javaBean號碼,javaBean數量))
            }
        }

        for (JavaBean javaBean : map.values()){
            Log.d("debug", String.format(Locale.getDefault(),"%d, %d", javaBean.getNumber(), javaBean.getAmount()));
            /**
             * debug: 888, 5
             * debug: 123, 3
             * debug: 222, 10
             */
        }

    }



}