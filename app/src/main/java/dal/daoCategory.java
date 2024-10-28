package dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.oderfoodapp.object.Category;

import java.util.ArrayList;
import java.util.List;

public class daoCategory {
    ConnectDataBase db;
    public daoCategory(Context context){
        db = new ConnectDataBase(context);
    }
    public void insertCategory(String name) {
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        database.insert("tblCategory", null, values);
    }
    public List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblCategory",null,null,null,null,null,null);
        while(c.moveToNext()){
            Category cate = new Category(c.getInt(0),c.getString(1));
            list.add(cate);
        }
        return list;
    }

}
