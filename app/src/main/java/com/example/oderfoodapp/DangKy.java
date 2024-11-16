package com.example.oderfoodapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.oderfoodapp.SharePreferencesClass.ManagerSessionUser;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dal.daoCustomer;

public class DangKy extends AppCompatActivity {
    // Khai báo các view ở trên đầu
    private LinearLayout linearDangKy;
    TextView dangNhap;
    Button btnDangKy;
    TextInputEditText email;
    TextInputEditText pass;
    TextInputEditText repass;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    TextInputLayout repassLayout;
    daoCustomer dCustomer = new daoCustomer(DangKy.this);
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // khai báo một sharepreferences để lưu dữ liệu cho toàn bộ ứng dụng
        ManagerSessionUser sessionUser = new ManagerSessionUser(DangKy.this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.dang_ky);

        // Ánh xạ các view ở đây
        btnDangKy = findViewById(R.id.btn_DangKy);
        dangNhap = findViewById(R.id.tv_DangNhap);
        email = findViewById(R.id.edt_email_phone);
        pass = findViewById(R.id.edt_MK);
        repass = findViewById(R.id.edt_NhapLaiMK);
        emailLayout = findViewById(R.id.emaildklayout);
        passLayout = findViewById(R.id.mkdkLayout);
        repassLayout = findViewById(R.id.repassdklayout);

        // xử lý khi click vào textview đăng nhập
        dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhap.setTextColor(Color.BLACK);
                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(DangKy.this, DangNhap.class);
                startActivity(intent);
            }
        });

        // xử lý khi click vaào btn Đăng ký
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = email.getText().toString();
                String passText = pass.getText().toString();
                String repassText = repass.getText().toString();
                boolean checkDK = true;
                if(emailText.isEmpty()){
                    emailLayout.setError("Không được bỏ trống");
                    checkDK = false;
                }
                else{
                    emailLayout.setError(null);
                }
                if(!isValidEmail(emailText)){
                    emailLayout.setError("Email không hợp lệ");
                    checkDK = false;
                }
                else{
                    emailLayout.setError(null);
                }
                if(passText.isEmpty()){
                    passLayout.setError("Không được bỏ trống");
                    checkDK = false;
                }
                else{
                    passLayout.setError(null);
                }
                if(repassText.isEmpty()){
                    repassLayout.setError("Không được bỏ trống");
                    checkDK = false;
                }
                else{
                    repassLayout.setError(null);
                }
                if(!passText.equals(repassText)){
                    passLayout.setError("Mật khẩu không trùng khớp");
                    repassLayout.setError("Mật khẩu không trùng khớp");
                    checkDK = false;
                }
                if(checkDK){
                    if(!dCustomer.checkEmailExist(emailText)){
                        if(dCustomer.SignUpCustomer(emailText,passText) != 0){
                            sessionUser.createLoginSession(emailText,passText);
                            sessionUser.checkLogin();
                            Toast.makeText(DangKy.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            Intent intent = new Intent(DangKy.this, TrangChung.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else{
                        emailLayout.setError("Email này đã tồn tại");
                    }


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
