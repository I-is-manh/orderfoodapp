package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class daoFeedBack {
    ConnectDataBase db;
    public daoFeedBack(Context context){
        db = new ConnectDataBase(context);
    }
    public long insertFeedBack(int customerID,int foodId,String feedback,double mark){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("customerID",customerID);
        values.put("foodId",foodId);
        values.put("feedbackDetail",feedback);
        values.put("mark",mark);
        return database.insert("tblFeedBack",null,values);
    }
}
