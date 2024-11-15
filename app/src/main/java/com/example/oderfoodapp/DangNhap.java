package com.example.oderfoodapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

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
    // Hãy khai báo các Element(View) trong file.xml ngay trên đầu
    TextView dangKi;
    TextView quenMK;
    TextInputEditText emailDn;
    TextInputEditText password;
    Button btnDangNhap;
    // khai báo biến của class daoCustomer thao tác với bảng tblCustomer
    daoCustomer dcustomer = new daoCustomer(DangNhap.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dang_nhap);
      //Hãy ánh xạ các Element(View) trong file.xml ở đây cho d
        quenMK = findViewById(R.id.tv_QuenMK);
        quenMK.setOnClickListener(v -> quenMK.setTextColor(Color.BLACK));
        emailDn = findViewById(R.id.edt_email_phone);
        password = findViewById(R.id.edt_MK);
        dangKi = findViewById(R.id.tv_DangKy);
        btnDangNhap = findViewById(R.id.btn_DangNhap);
        // xử lý nút đăng ký
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
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Lay ra gia tri cua 2 o email va dang nhap
                String emailText = emailDn.getText().toString();
                String passwordText = password.getText().toString();
                if(dcustomer.checkDn(emailText,passwordText) == true){
                    Intent intent = new Intent(DangNhap.this, TrangChung.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    //emailDn.setBackground(ContextCompat.getDrawable(DangNhap.this,R.drawable.inputerror));
                    TextInputLayout emaillayout = findViewById(R.id.emailLayout);
                    emaillayout.setError("Sai tài khoản hoặc mật khẩu");
                    TextInputLayout mklayout = findViewById(R.id.mkLayout);
                    mklayout.setError("Sai tài khoản hoặc mật khẩu");
                }
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
