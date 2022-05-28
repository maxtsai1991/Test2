package com.example.test2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Vendor implements Parcelable {
    private String barcodenum; // 條碼
    private String quantity; // 數量

    public Vendor(String barcodenum, String quantity) {
        this.barcodenum = barcodenum;
        this.quantity = quantity;
    }

    public Vendor() {
    }

    public Vendor(String barcodenum) {
        this.barcodenum = barcodenum;
    }


    protected Vendor(Parcel in) {
        barcodenum = in.readString();
        quantity = in.readString();
    }

    public static final Creator<Vendor> CREATOR = new Creator<Vendor>() {
        @Override
        public Vendor createFromParcel(Parcel in) {
            return new Vendor(in);
        }

        @Override
        public Vendor[] newArray(int size) {
            return new Vendor[size];
        }
    };

    public String getBarcodenum() {
        return barcodenum;
    }

    public void setBarcodenum(String barcodenum) {
        this.barcodenum = barcodenum;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(barcodenum);
        dest.writeString(quantity);
    }
}
