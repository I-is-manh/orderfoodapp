package dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.oderfoodapp.object.Food;

import java.util.ArrayList;
import java.util.List;

public class daoFood {
    ConnectDataBase db;
    public daoFood(Context context){
        db = new ConnectDataBase(context);
    }
    public List<Food> getFoodByCategoryId(int categoryId){
        List<Food> list = new ArrayList<>();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblFood",null,"categoryID = ?",new String[]{String.valueOf(categoryId)},null,null,null);
        while(c.moveToNext()){
            Food f = new Food(c.getInt(0),c.getInt(1),c.getString(2),c.getInt(3),c.getString(4),c.getFloat(5),c.getFloat(6),c.getFloat(7));
            list.add(f);
        }
        return list;
    }
    public Food getFood(int foodID){
        Food f = new Food();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.query("tblFood",null,"foodId = ?",new String[]{String.valueOf(foodID)},null,null,null);
        while(c.moveToNext()){
            f = new Food(c.getInt(0),c.getInt(1),c.getString(2),c.getInt(3),c.getString(4),c.getFloat(5),c.getFloat(6),c.getFloat(7));
        }
        return f;
    }
}
