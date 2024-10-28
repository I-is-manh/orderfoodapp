package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.oderfoodapp.object.Customer;

public class daoCustomer {
    ConnectDataBase db;
    public daoCustomer(Context context){
        db = new ConnectDataBase(context);
    }
    public void insertCustomer(String email,String password,String address,String phonenumber,int linkimg){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email",email);
        values.put("PASSWORD",password);
        values.put("ADDRESS",address);
        values.put("PHONENUMBER",phonenumber);
        values.put("linkimg",linkimg);
        database.insert("tblCustomer",null,values);
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
        while(c.moveToNext()){
            customer = new Customer(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5));
        }
        return customer;
    }

}
