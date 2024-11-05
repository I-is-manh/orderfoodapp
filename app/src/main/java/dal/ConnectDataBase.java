package dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectDataBase extends SQLiteOpenHelper {
    // khai báo tên các baảng;
    private static String dbName = "appFood.db";
    private static int version = 1;
//    private static String Customer = "tblCustomer";
//    private static String CustomerVoucher = "tblCustomerVoucher";
//    private static String Order = "tblOrder";
//    private static String OrderDetail = "tblOrderDetail";
//    private static String Voucher = "tblVoucher";
//    private static String Food = "tblFood";
//    private static String Category = "tblCategory";
//    private static String ShoppingCart = "tblShoppingCart";
//    private static String ShoppingCartDetail = "tblShoppingCartDetail";
//    private static String FeedBack = "tblFeedBack";
    public ConnectDataBase(@Nullable Context context) {
        super(context, dbName, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // tạo bảng Customer;
        String tblCustomer = "create table tblCustomer (" +
                "customerID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EMAIL TEXT," +
                "PASSWORD TEXT," +
                "ADDRESS TEXT," +
                "PHONENUMBER CHAR(10)," +
                "LINKAVT INTEGER" +
                ")";
        db.execSQL(tblCustomer);
        String tblCategory = "create table tblCategory (" +
                "categoryID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT" +
                ")";
        db.execSQL(tblCategory);
        String tblFood = "create table tblFood(" +
                "foodId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "categoryID INTEGER references tblCategory(categoryID)," +
                "NAME TEXT," +
                "LINKIMG INTEGER," +
                "DESCRIPTION TEXT," +
                "PRICE FLOAT," +
                "DISCOUTN_PERCENT FLOAT," +
                "MARK FLOAT" +
                ")";
        db.execSQL(tblFood);
        String tblOrder = "create table tblOrder(" +
                "orderID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "customerID INTEGER references tblCustomer(customerID)," +
                "createDate integer," +
                "address text" +
                ")";
        db.execSQL(tblOrder);
        String tblOrderDetail = "create table tblOrderDetail(" +
                "orderID  integer references tblOrder(orderID)," +
                "foodID integer references tblFood(foodId)," +
                "quantity integer," +
                "primary key(orderID,foodID)" +
                ")";
        db.execSQL(tblOrderDetail);
        String tblFeedBack = "create table tblFeedBack(" +
                "feedbackId integer primary key autoincrement," +
                "customerID int references tblCustomer(customerID)," +
                "foodId int references tblFood(foodId)," +
                "feedbackDetail text," +
                "mark float" +
                ")";
        db.execSQL(tblFeedBack);
        String tblVoucher = "create table tblVoucher(" +
                "voucherId integer primary key autoincrement," +
                "code text," +
                "description text," +
                "discount_type text," +
                "discount_value float," +
                "min_order_value float," +
                "max_discount float," +
                "start_date integer," +
                "end_date integer," +
                "statusvoucher integer" +
                ")";
        db.execSQL(tblVoucher);
        String tblCustomerVoucher = "create table tblCustomerVoucher(" +
                "customerID int references tblCustomer(customerID)," +
                "voucherId int references tblVoucher(voucherId)," +
                "primary key(customerID,voucherId)" +
                ")";
        db.execSQL(tblCustomerVoucher);
        String tblShoppingCart = "create table tblShoppingCart(" +
                "ShoppingCartId integer primary key autoincrement," +
                "customerID int references tblCustomer(customerID)" +
                ")";
        db.execSQL(tblShoppingCart);
        String tblShoppingCartDetail = "create table tblShoppingCartDetail(" +
                "ShoppingCartId integer references tblShoppingCart(ShoppingCartId)," +
                "foodId int references tblFood(foodId)," +
                "quantity integer," +
                "primary key(ShoppingCartId,foodId)" +
                ")";
        db.execSQL(tblShoppingCartDetail);
        String tblVoucher4Order = "create table tblVoucher4Order (" +
                "orderID  integer references tblOrder(orderID)," +
                "voucherId integer references tblVoucher(voucherId)," +
                "primary key(orderID,voucherId)" +
                ")";
        db.execSQL(tblVoucher4Order);
    }
    public void open(){
        SQLiteDatabase db = this.getReadableDatabase();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
