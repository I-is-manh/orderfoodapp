package dal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.oderfoodapp.object.Customer;

public class daoCustomer {
    ConnectDataBase db;
    public daoCustomer(Context context){
        db = new ConnectDataBase(context);
    }
    public long insertCustomer(String email,String password,String address,String phonenumber,int linkimg){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        values.put("ADDRESS",address);
        values.put("PHONENUMBER",phonenumber);
        values.put("LINKAVT",linkimg);
        return database.insert("tblCustomer",null,values);
    }
    public long SignUpCustomer(String email,String password){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        return database.insert("tblCustomer",null,values);
    }
    public boolean checkEmailExist(String email){
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblCustomer",null,"EMAIL = ?", new String[]{email},null,null,null);

        if(c != null && c.getCount()  == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public void updateCustomer(int id,String email,String password,String address,String phonenumber,int linkimg){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",email);
        values.put("PASSWORD",password);
        values.put("ADDRESS",address);
        values.put("PHONENUMBER",phonenumber);
        values.put("linkimg",linkimg);
        database.update("tblCustomer",values,"customerID = ?", new String[]{String.valueOf(id)});
    }
    public Customer getCustomer(int id){
        Customer customer = new Customer();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblCustomer",null,"customerID = ?", new String[]{String.valueOf(id)},null,null,null);
        if(c == null || c.getCount() == 0) return null;
        while(c.moveToNext()){
            customer = new Customer(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5));
        }
        return customer;
    }
    public boolean checkDn(String email,String password){
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblCustomer",null,"EMAIL = ? and PASSWORD = ?", new String[]{email,password},null,null,null);

        if(c != null && c.getCount()  == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
