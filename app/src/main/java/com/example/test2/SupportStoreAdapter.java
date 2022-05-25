package com.example.test2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.view.HistoryActivity;

import java.util.List;


public class SupportStoreAdapter extends RecyclerView.Adapter<SupportStoreAdapter.SupportStoreViewHolder> {
    private HistoryActivity historyActivity;
    private List<SupportStore> supportStoreList;

    public SupportStoreAdapter(List<SupportStore> supportStoreList) {
        this.supportStoreList = supportStoreList;
    }

    @NonNull
    @Override
    public SupportStoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 取得item的lavout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_supportstore_info,parent,false);
        SupportStoreViewHolder supportStoreViewHolder = new SupportStoreViewHolder(view);
        return supportStoreViewHolder;
    }

    // item顯示要做的事情
    @Override
    public void onBindViewHolder(@NonNull SupportStoreViewHolder holder, int position) {
        SupportStore supportStore = supportStoreList.get(position); // 拿到list位置後
        holder.barcodeNum.setText(supportStore.getBarcodenum()); // 設置TextView
        holder.quantity.setText(supportStore.getQuantity());
    }

    @Override
    public int getItemCount() {
        return supportStoreList.size();
    }

    class SupportStoreViewHolder extends RecyclerView.ViewHolder {
        TextView barcodeNum;
        TextView quantity;

        public SupportStoreViewHolder(View itemView) {
            super(itemView);
            this.barcodeNum = itemView.findViewById(R.id.tv_barcode_num);
            this.quantity = itemView.findViewById(R.id.tv_supportstore_quantity);
        }
    }
}
