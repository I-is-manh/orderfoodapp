package com.example.oderfoodapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import dal.ConnectDataBase;
import dal.daoCategory;
import dal.daoCustomer;
import dal.daoFeedBack;
import dal.daoFood;
import dal.daoVoucher;

public class DangNhap extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dang_nhap);
        // code nhưng dưới đây là để mở sqlite trên máy mn ae chỉ cần chạy một lần để có thể thêm vào trong app

        ConnectDataBase conn = new ConnectDataBase(DangNhap.this);
        //thêm các bảng vào ứng dụng trong một lần chạy
        //Insert dữ liệu cho bảng category
//        daoCategory category = new daoCategory(DangNhap.this);
//        category.insertCategory("Pizza");
//        category.insertCategory("Mỳ ý");
//        category.insertCategory("Sushi");
//        category.insertCategory("Đồ uống");
//        category.insertCategory("Tráng miệng");
//        category.insertCategory("Cơm");
//        category.insertCategory("Salad");
//        category.insertCategory("Gà rán");
//        category.insertCategory("Hải sản");
//        category.insertCategory("Bánh mỳ");
        //Insert dữ liệu cho bảng tblCustomer
//        daoCustomer customer = new daoCustomer(DangNhap.this);
//        customer.insertCustomer("daVasst@gmail.com","password123","123 Cầu Giấy,Quận Cầu Giấy Hà Nội","0942549465",R.drawable.davasst);
//        customer.insertCustomer("giang@gmail.com","mypassword","456 Trần Duy Hưng Quận Cầu Giấy Hà Nội","0983726152",R.drawable.anh_dai_dien);
//        customer.insertCustomer("hungviet@gmail.com","alicepass","789 Kim Mã, Quận Ba Đình,Cầu giấy,Hà Nội","0983726152",R.drawable.my_avatar);
        //Insert dữ liệu cho bảng tblFood
//        daoFood food = new daoFood(DangNhap.this);
//        food.inserFood(1,"Pizza Margherita",R.drawable.pizzamaraghita,"Pizza truyền thống với phô mai",180000,10,4.5);
//        food.inserFood(1,"Pizza Pepperoni",R.drawable.peperonies,"Pizza với xúc xích pepperoni",120000,5,4.8);
//        food.inserFood(1,"Pizza Hải sản",R.drawable.pizahaisan,"Pizza với hải sản tươi ngon",130000,15,4.6);
//        food.inserFood(1,"Pizza Thập cẩm",R.drawable.pizzathapcam,"Pizza với nhiều loại nhân",140000,10,4.6);
//        food.inserFood(1,"Pizza Vegetarian",R.drawable.pizzarau,"Pizza chay với rau củ",110000,0,4.6);
//        food.inserFood(1,"Pizza BBQ",R.drawable.pizzabbq,"Pizza với sốt BBQ",150000,0,3.9);
//        food.inserFood(2,"Spaghetti Carbonara",R.drawable.spagetycarbornara,"Mì Ý sốt kem béo",80000,0,3.9);
//        food.inserFood(2,"Fettuccine Alfredo",R.drawable.getalfredo,"Mì Ý với sốt Alfredo",90000,0,4.2);
//        food.inserFood(2,"Spaghetti Bolognese",R.drawable.bolognese,"Mì Ý với sốt thịt bò",95000,0,4.2);
//        food.inserFood(2,"Mì Ý sốt pesto",R.drawable.pesto,"Mì Ý với sốt pesto thơm ngon",120000,5,4.2);
//        food.inserFood(2,"Mì Ý hải sản",R.drawable.myyhaisan,"Mì Ý với hải sản tươi",150000,5,4.2);
//        food.inserFood(3,"Sushi cá hồi",R.drawable.sushicahoi,"Sushi với cá hồi tươi",150000,15,4.2);
//        food.inserFood(3,"Sushi tôm",R.drawable.sushitom,"Sushi với tôm tươi",130000,10,4.2);
//        food.inserFood(3,"Sushi bạch tuộc",R.drawable.bachtuoc,"Sushi với bạch tuộc tươi ngon",140000,5,4.2);
//        food.inserFood(3,"Sushi rau củ",R.drawable.shushiraucu,"Sushi chay với rau củ",120000,15,4.4);
//        food.inserFood(3,"Sushi cuộn California",R.drawable.shushicalifornia,"Sushi cuộn với cá và rau",160000,0,4.0);
//        food.inserFood(3,"Sushi cuộn Philadelphia",R.drawable.sushiphiladep,"Sushi cuộn với cá và rau",160000,0,4.0);
//        food.inserFood(4,"Trá sữa trân châu",R.drawable.trasua,"Trà sữa với trân châu",40000,0,4.4);
//        food.inserFood(4,"Nước ép cam",R.drawable.camep,"Nước ép cam tươi",20000,0,4.4);
//        food.inserFood(4,"Trá sữa matcha",R.drawable.camep,"Trá sữa matcha thơm ngon",20000,0,4.4);
//        food.inserFood(4,"Nước chanh dây",R.drawable.chanhday,"Nước chanh dây tươi mát",30000,0,4.4);
//        food.inserFood(4,"Sinh tố bơ",R.drawable.sinhtobo,"Sinh tố bơ ngọt ngào",45000,5,4.1);
//        food.inserFood(4,"Sinh tố dưa hấu",R.drawable.duahau,"Sinh tố dưa hấu mát lạnh",40000,0,4.1);
//        food.inserFood(5,"Bánh ngọt Chocolate",R.drawable.chocolate,"Bánh ngọt với socola",50000,0,4.1);
//        food.inserFood(5,"Kem dâu tây",R.drawable.kemdau,"Kem với dâu tây tươi",30000,0,4.9);
//        food.inserFood(6,"Cơm gà xối mỡ",R.drawable.comga,"Cơm gà giòn tan",50000,0,4.9);
//        food.inserFood(6,"Cơm sườn nướng",R.drawable.comsuon,"Cơm với sườn nướng thơm ngon",75000,0,4.9);
//        food.inserFood(6,"Cơm thịt kho",R.drawable.comthitkho,"Cơm với thịt kho trứng",35000,0,4.9);
//        food.inserFood(6,"Cơm chiên dương châu",R.drawable.comchien,"Cơm chiên với tôm và trứng",55000,0,4.9);
//        food.inserFood(6,"Cơm gà nướng",R.drawable.comganuong,"Cơm với gà nướng thơm ngon",55000,0,4.9);
//        food.inserFood(7,"Salad trộn dầu giấm",R.drawable.saladtron,"Salad rau củ với dầu giấm",40000,5,4.2);
//        food.inserFood(7,"Salad Caesar",R.drawable.saladcasear,"Salad với sốt Caesar",45000,5,4.5);
//        food.inserFood(7,"Salad tôm",R.drawable.saladtom,"Salad với tôm tươi",55000,5,4.5);
//        food.inserFood(7,"Salad rau quả",R.drawable.saladraucu,"Salad với nhiều loại rau củ",35000,5,4.5);
//        food.inserFood(7,"Salad gà",R.drawable.saladga,"Salad với gà nướng",55000,0,4.1);
//        food.inserFood(10,"Bánh mỳ heo quay",R.drawable.heoquay,"Bánh mỳ ăn với thịt heo quay",25000,0,4.8);
//        food.inserFood(10,"Bánh mỳ thập cẩm",R.drawable.banhmythapcam,"Bánh mỳ với nhiều loại nhân",25000,0,4.8);
//        food.inserFood(10,"Bánh mỳ xá xíu",R.drawable.xaxiu,"Bánh mỳ với thịt xá xíu",27000,0,4.8);
//        food.inserFood(10,"Bánh mỳ pate",R.drawable.banhmpate,"Bánh mỳ ăn với pate ngon béo ngậy tuyệt đối",20000,0,5.0);
//        food.inserFood(9,"Ốc hương xào bơ tỏi",R.drawable.ochuong,"Ốc hương được xào với bơ tỏi thơm ngon",80000,0,3.9);
//        food.inserFood(9,"Càng ghẹ rang muối",R.drawable.cangghe,"Càng ghẹ rang muối thơm ngon mời bạn ăn nha",110000,0,3.9);
//        food.inserFood(9,"Càng ghẹ rang muối",R.drawable.cangghe,"Càng ghẹ rang muối thơm ngon mời bạn ăn nha",110000,0,3.9);
//        food.inserFood(8,"Gà rán",R.drawable.garena,"Đùi gà thơm ngon giòn rụn ngon khó cững",30000,0,4.7);
//        food.inserFood(8,"Gà sốt cay",R.drawable.gacay,"Gà sốt cay phong cách hàn xẻng cay suýt xoa",50000,0,4.8);
//        food.inserFood(8,"Gà cay phô mai",R.drawable.gaphomai,"Gà sốt cay ăn cùng phô mai béo ngậy tuyệt đối",73000,0,4.8);
          //Insert dữ liệu vào bảng tblVoucher
//        daoVoucher voucher = new daoVoucher(DangNhap.this);
//        try {
//            voucher.insertVoucher("DISCOUNT10","Giảm 10% cho đơn hàng từ 100k","percentage",10,100000,50000,new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2024-05-12").getTime() / 1000,new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2024-05-25").getTime()/1000,true);
//            voucher.insertVoucher("FREESHIP","Miễn phí vận chuyển cho đơn từ 200k","fixed_amount",30000,200000,30000,new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2024-05-12").getTime() / 1000,new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2025-05-25").getTime()/1000,true);
//
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        // sửa lại bảng tblFeedback bảng này thiếu vài cột
//        SQLiteDatabase database = conn.getWritableDatabase();
//        database.execSQL("alter table tblFeedBack add feedbackDetail text");
//        database.execSQL("alter table tblFeedBack add mark float");
        //Insert dữ liệu cho bảng feedback
//        daoFeedBack feedBack = new daoFeedBack(DangNhap.this);
//         feedBack.insertFeedBack(1,1,"Món ăn rất ngon",4.5);
//         feedBack.insertFeedBack(1,2,"Hơi ngán một tý",2.5);
//         feedBack.insertFeedBack(2,1,"ôi món ăn tuyệt vời",4.9);
//         feedBack.insertFeedBack(1,36,"bánh mỳ heo quay đối với tôi là chân ái",5.0);


        // end


        TextView quenMK = findViewById(R.id.tv_QuenMK);
        quenMK.setOnClickListener(v -> quenMK.setTextColor(Color.BLACK));

        TextView dangKi = findViewById(R.id.tv_DangKy);
        dangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đổi màu văn bản khi nhấn vào TextView
                dangKi.setTextColor(Color.BLACK);
                // Chuyển đến màn hình đăng ký
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });

        // Xử lý nút đăng nhập
        Button btnDangNhap = findViewById(R.id.btn_DangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang TrangChu
                Intent intent = new Intent(DangNhap.this, TrangChung.class);
                startActivity(intent);
                finish(); // Đóng trang đăng nhập để không quay lại được trang đăng nhập khi nhấn nút back
            }
        });

        // Tạo OnBackPressedCallback để xử lý sự kiện khi nhấn nút Back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finishAffinity();
            }
        };

        // Đăng ký callback
        getOnBackPressedDispatcher().addCallback(this, callback);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dangKy), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
