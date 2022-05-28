package com.example.test2.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.test2.R;
import com.example.test2.Vendor;
import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {
    /**
     * 返回到裝箱作業
     */
    private View iv_return_boxing;
    /**
     * 供應商
     */
    private TextView tv_vendor_name_history;
    /**
     * Recyclerview id
     */
    private RecyclerView rv_info_list;

    /**
     * 供應商 上一頁Bundle來的資料
     *
     */
    private String vendorName;
    /**
     * 號碼 上一頁Bundle來的資料
     */
    private String editableNumStr;
    /**
     * 數量 上一頁Bundle來的資料
     */
    private String editableQuantityStr;
    private ArrayList<Vendor> vendorArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        findViews();
        /**
         * 元件處理
         */
        handleElement();

        /**
         * Bundle來的資料
         */
//        vendorArrayList = new ArrayList<>();
//        Vendor vendor = new Vendor();
//        vendor.setBarcodenum(editableNumStr);
//        vendor.setQuantity(editableQuantityStr);
//        vendorArrayList.add(vendor);

//        ArrayList<Vendor> vendorArrayList = new ArrayList<>();
//        for (int i =111123456 ; i < 111123465 ; i++){
//            Vendor vendor = new Vendor("AA" + i + "6","1");
//            Vendor vendor2 = new Vendor("BB" + i + "5","2");
//            Vendor vendor3 = new Vendor("CC" + i + "4","3");
//            Vendor vendor4 = new Vendor("DD" + i + "3","4");
//            Vendor vendor5 = new Vendor("EE" + i + "2","5");
//            Vendor vendor6 = new Vendor("FF" + i + "1","6");
//            vendorArrayList.add(vendor);
//            vendorArrayList.add(vendor2);
//            vendorArrayList.add(vendor3);
//            vendorArrayList.add(vendor4);
//            vendorArrayList.add(vendor5);
//            vendorArrayList.add(vendor6);
//    }

        /**
         * Adapter
         */
        VendorAdapter vendorAdapter = new VendorAdapter(vendorArrayList);
        rv_info_list.setAdapter(vendorAdapter);

        /**
         * RecyclerView
         */
        rv_info_list.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL)); // 為RecyclerView每個item畫底線
        rv_info_list.setLayoutManager(new LinearLayoutManager(this));
    }

    private void findViews() {
        iv_return_boxing = findViewById(R.id.iv_return_boxing);
        tv_vendor_name_history = findViewById(R.id.tv_vendor_name_history);
        rv_info_list = findViewById(R.id.rv_info_list);
    }

    private void handleElement() {
        /**
         * 返回到裝箱作業
         */
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

        ArrayList arrayList = bundle.getParcelableArrayList("vendorArrayList");
        vendorArrayList = (ArrayList<Vendor>) arrayList;

        vendorName = bundle.getString("vendorname");
        tv_vendor_name_history.setText(vendorName);
    }

    /**
     * VendorAdapter
     */
    public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder>{
        private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
        private ArrayList<Vendor> vendorArrayList; // 假資料

        public VendorAdapter(ArrayList<Vendor> vendorArrayList){
            this.vendorArrayList = vendorArrayList;
        }

        /**
         * ViewHolder
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            private View parent;
            /**
             * 垃圾桶icon
             */
            private ImageButton ib_del;
            /**
             * RecyclerView Item滑動Layout
             */
            private SwipeRevealLayout swipeRevealLayout;
            /**
             * 號碼TV
             */
            TextView barcodeNum;
            /**
             * 數量TV
             */
            TextView vendorquantity;
            /**
             * ItemLayout
             */
            private ConstraintLayout cl_itemView;

            /**
             * ViewHolder建構子, 放FVB
             */
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
//                parent = itemView;
                barcodeNum = itemView.findViewById(R.id.tv_barcode_num);
                vendorquantity = itemView.findViewById(R.id.tv_vendor_quantity);
                ib_del = itemView.findViewById(R.id.ib_del);
                swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);
                cl_itemView = itemView.findViewById(R.id.cl_itemView);
            }
        }

        /**
         * onCreateViewHolder
         */
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 取得item的lavout
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vendor_history_info,parent,false);
            return new ViewHolder(view);
        }

        /**
         * onBindViewHolder : item顯示要做的事情
         */
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            /**
             * 設置swipe只能有一個item被拉出
             */
            viewBinderHelper.setOpenOnlyOne(true);
            /**
             * 綁定滑動 SwipeLayout
             */
            viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(position));

            /**
             * 取得資料List Item位置
             */
            Vendor vendor = vendorArrayList.get(position);
            /**
             * 綁定號碼
             */
            holder.barcodeNum.setText(vendor.getBarcodenum());
            /**
             * 綁定數量
             */
            holder.vendorquantity.setText(vendor.getQuantity());

            /**
             * RecyclerView的item的點擊事件
             */
            holder.cl_itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), " " + holder.barcodeNum.getText(), Toast.LENGTH_SHORT).show();
                    /**
                     * AlertDialog
                     */
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.barcodeNum.getContext());
                    alertDialog.setTitle(" ");
                    alertDialog.setMessage(" 是否確認修改 " + vendorArrayList.get(position).getBarcodenum() + " ?? ");
                    /**
                     * AlertDialog "確定"按鈕 點擊事件
                     */
                    alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(v.getContext(), "已修改數量", Toast.LENGTH_SHORT).show();
                        }
                    });

                    /**
                     * AlertDialog"取消"按鈕 點擊事件
                     */
                    alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(v.getContext(), "取消修改", Toast.LENGTH_SHORT).show();
                        }
                    });

                    /**
                     * 禁用返回 , false : 點選彈窗以外不會有反應 , true :  點選彈窗以外會取消彈窗
                     */
                    alertDialog.setCancelable(false);
                    /**
                     * 一定要加這行才會出現彈窗 , 寫在該行後面的code 則不會執行 , 因為已經show出彈窗了
                     */
                    alertDialog.show();
                }
            });


            /**
             * RecyclerView的item往右滑出現垃圾桶選項
             */
            holder.ib_del.setOnClickListener((v -> {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.ib_del.getContext());
                alertDialog.setTitle(" "); // 設置標題
                alertDialog.setMessage("是否確認刪除"); // 設置內容

                /**
                 * 點選item跳出彈窗的確定選項(設置最右邊按鈕)
                 */
                alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.swipeRevealLayout.close(true); // 刪除動畫
                        vendorArrayList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position,vendorArrayList.size());
                        Toast.makeText(v.getContext(), "已刪除", Toast.LENGTH_SHORT).show();
                    }
                });

                /**
                 * 點選item跳出彈窗的取消選項(設置最左邊按鈕)
                 */
                alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "已取消", Toast.LENGTH_SHORT).show();
                    }
                });

                notifyDataSetChanged();
                alertDialog.setCancelable(false);
                alertDialog.show();
            }));
        }

        /**
         * getItemCount
         */
        @Override
        public int getItemCount() {
            return vendorArrayList.size();
        }
    }

}