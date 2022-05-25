package com.example.test2;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.test2.view.HistoryActivity;

import java.util.ArrayList;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.ViewHolder>{
    private HistoryActivity historyActivity;

    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private ArrayList<String> arrayList;

    public VendorAdapter(ArrayList<String> arrayList){
        this.arrayList = arrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View parent;
        private TextView tvValue;

        /**
         * 新增Code : 垃圾桶按鈕
         */
        private ImageButton ib_del;
        private SwipeRevealLayout swipeRevealLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvValue = itemView.findViewById(R.id.textView);
            parent = itemView;

            /**
             * 新增Code : item往右滑垃圾桶按鈕元件
             */
            ib_del = itemView.findViewById(R.id.ib_del);
            swipeRevealLayout = itemView.findViewById(R.id.swipeLayout);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        viewBinderHelper.setOpenOnlyOne(true);//設置swipe只能有一個item被拉出
        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(position));//綁定Layout
        holder.tvValue.setText(arrayList.get(position));

        /**
         * 新增Code : RecyclerView的item的點擊事件
         */
        holder.tvValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), " " + holder.tvValue.getText(), Toast.LENGTH_SHORT).show();
                /**
                 * 新增Code : item點擊事件加彈窗
                 */
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.tvValue.getContext());
                alertDialog.setTitle(" ");
                alertDialog.setMessage("是否確認修改");
                /**
                 * 新增Code : item彈窗"確定按鈕"點擊事件
                 */
                alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "已修改數量", Toast.LENGTH_SHORT).show();
                    }
                });

                /**
                 * 新增Code : item彈窗"取消按鈕"點擊事件
                 */
                alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "取消修改", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setCancelable(false); // 禁用返回 , false : 點選彈窗以外不會有反應 , true :  點選彈窗以外會取消彈窗
                alertDialog.show(); // 一定要加這行才會出現彈窗 , 寫在該行後面的code 則不會執行 , 因為已經show出彈窗了

            }
        });


        /**
         * 新增Code : RecyclerView的item往右滑出現垃圾桶選項
         */
        holder.ib_del.setOnClickListener((v -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(holder.ib_del.getContext());
            alertDialog.setTitle(" "); // 設置標題
            alertDialog.setMessage("是否確認刪除"); // 設置內容
            /**
             * 新增Code : 點選item跳出彈窗的確定選項(設置最右邊按鈕)
             */
            alertDialog.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    holder.swipeRevealLayout.close(true); // 刪除動畫
                    arrayList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position,arrayList.size());
                    Toast.makeText(v.getContext(), "已刪除", Toast.LENGTH_SHORT).show();
                }
            });
            /**
             * 新增Code : 點選item跳出彈窗的取消選項(設置最左邊按鈕)
             */
            alertDialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    holder.swipeRevealLayout.close(true); // 刪除動畫
                    Toast.makeText(v.getContext(), "已取消", Toast.LENGTH_SHORT).show();
                }
            });
            notifyDataSetChanged();
            alertDialog.setCancelable(false);
            alertDialog.show();

        }));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
