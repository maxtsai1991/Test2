package com.example.test2;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.ArrayList;

//public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder>{
//    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
//    private ArrayList<Vendor> arrayList; // 假資料
//
//    public VendorAdapter(ArrayList<Vendor> arrayList){
//        this.arrayList = arrayList;
//    }
//
//    /**
//     * ViewHolder
//     */
//    public class ViewHolder extends RecyclerView.ViewHolder {
////        private View parent;
//        TextView barcodeNum;    // 號碼
//        TextView vendorquantity;// 數量
//        private ImageButton ib_del; // 垃圾桶
//        private SwipeRevealLayout swipeRevealLayout; // Item滑動Layout
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
////            parent = itemView;
//            barcodeNum = itemView.findViewById(R.id.tv_barcode_num);
//            vendorquantity = itemView.findViewById(R.id.tv_vendor_quantity);
//            ib_del = itemView.findViewById(R.id.ib_del);
//            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);
//        }
//    }
//
//    /**
//     * onCreateViewHolder
//     */
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 取得item的lavout
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vendor_history_info,parent,false);
//        return new ViewHolder(view);
//    }
//
//    /**
//     * onBindViewHolder : item顯示要做的事情
//     */
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        viewBinderHelper.setOpenOnlyOne(true);              // 設置swipe只能有一個item被拉出
//        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(position)); //   綁定滑動Layout
//        Vendor vendor = arrayList.get(position);            // 取得假資料List Item位置
//        holder.barcodeNum.setText(vendor.getBarcodenum());  // 綁定號碼
//        holder.vendorquantity.setText(vendor.getQuantity());// 綁定數量
//
//        /**
//         * RecyclerView的item的點擊事件
//         */
//        holder.barcodeNum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(), " " + holder.barcodeNum.getText(), Toast.LENGTH_SHORT).show();
//                /**
//                 * item點擊事件加彈窗
//                 */
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.barcodeNum.getContext());
//                alertDialog.setTitle(" ");
//                alertDialog.setMessage(" 是否確認修改 " + arrayList.get(position).getBarcodenum() + " ?? ");
//                /**
//                 * item彈窗"確定按鈕"點擊事件
//                 */
//                alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(v.getContext(), "已修改數量", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                /**
//                 * item彈窗"取消按鈕"點擊事件
//                 */
//                alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(v.getContext(), "取消修改", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                alertDialog.setCancelable(false); // 禁用返回 , false : 點選彈窗以外不會有反應 , true :  點選彈窗以外會取消彈窗
//                alertDialog.show(); // 一定要加這行才會出現彈窗 , 寫在該行後面的code 則不會執行 , 因為已經show出彈窗了
//            }
//        });
//
//
//        /**
//         * RecyclerView的item往右滑出現垃圾桶選項
//         */
//        holder.ib_del.setOnClickListener((v -> {
//            AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.ib_del.getContext());
//            alertDialog.setTitle(" "); // 設置標題
//            alertDialog.setMessage("是否確認刪除"); // 設置內容
//
//            /**
//             * 點選item跳出彈窗的確定選項(設置最右邊按鈕)
//             */
//            alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    holder.swipeRevealLayout.close(true); // 刪除動畫
//                    arrayList.remove(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position,arrayList.size());
//                    Toast.makeText(v.getContext(), "已刪除", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            /**
//             * 點選item跳出彈窗的取消選項(設置最左邊按鈕)
//             */
//            alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(v.getContext(), "已取消", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            notifyDataSetChanged();
//            alertDialog.setCancelable(false);
//            alertDialog.show();
//        }));
//    }
//
//    /**
//     * getItemCount
//     */
//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//
//}
