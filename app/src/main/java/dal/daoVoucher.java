package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class daoVoucher {
    ConnectDataBase db;
    public daoVoucher(Context context){
        db = new ConnectDataBase(context);
    }
    public long insertVoucher(String code,String desc,String discount_type,double discount_value, double min_ordervalue,double max_discount,long start_date,long end_date,boolean status){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("code",code);
        values.put("description",desc);
        values.put("discount_type",discount_type);
        values.put("discount_value",discount_value);
        values.put("min_order_value",min_ordervalue);
        values.put("max_discount",max_discount);
        values.put("start_date",start_date);
        values.put("end_date",end_date);
        values.put("statusvoucher",status);
        return database.insert("tblVoucher",null,values);
    }
}
