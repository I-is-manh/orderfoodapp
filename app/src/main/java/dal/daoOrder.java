package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class daoOrder {
    ConnectDataBase db;
    public daoOrder(Context context){
        db = new ConnectDataBase(context);
    }
//    public long insertOrder(int customerID,long createDate,String address){
//        SQLiteDatabase database = db.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("customerID",customerID);
//        values.put("createDate",createDate);
//        values.put("address",address);
//    }
}
