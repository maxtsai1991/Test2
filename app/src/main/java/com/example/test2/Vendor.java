package com.example.test2;

public class Vendor {
    private String barcodenum; // 條碼
    private String quantity; // 數量

    public Vendor(String barcodenum, String quantity) {
        this.barcodenum = barcodenum;
        this.quantity = quantity;
    }

    public Vendor() {
    }

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
}
