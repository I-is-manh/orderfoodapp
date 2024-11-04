package com.example.oderfoodapp.object;

public class Voucher {
    private int voucherID;
    private String code;
    private String description;
    private String discount_type;
    private double discount_value;
    private double min_ordervalue;
    private double max_discount;
    private int start_date; // Unix timestamp
    private int end_date;   // Unix timestamp
    private boolean status;

    // Constructor không tham số
    public Voucher() {
    }

    // Constructor có tham số
    public Voucher(int voucherID, String code, String description, String discount_type,
                   double discount_value, double min_ordervalue, double max_discount,
                   int start_date, int end_date, boolean status) {
        this.voucherID = voucherID;
        this.code = code;
        this.description = description;
        this.discount_type = discount_type;
        this.discount_value = discount_value;
        this.min_ordervalue = min_ordervalue;
        this.max_discount = max_discount;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }

    // Getter và Setter
    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public double getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(double discount_value) {
        this.discount_value = discount_value;
    }

    public double getMin_ordervalue() {
        return min_ordervalue;
    }

    public void setMin_ordervalue(double min_ordervalue) {
        this.min_ordervalue = min_ordervalue;
    }

    public double getMax_discount() {
        return max_discount;
    }

    public void setMax_discount(double max_discount) {
        this.max_discount = max_discount;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "Voucher{" +
                "voucherID=" + voucherID +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", discount_type='" + discount_type + '\'' +
                ", discount_value=" + discount_value +
                ", min_ordervalue=" + min_ordervalue +
                ", max_discount=" + max_discount +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", status=" + status +
                '}';
    }
}
