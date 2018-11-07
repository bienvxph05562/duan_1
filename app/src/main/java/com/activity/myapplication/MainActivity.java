package com.activity.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtTaikhoan;
    private EditText edtMatkhau;
    private CheckBox showmatkhau;
    private Button btnDangnhap, btnThoat ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTaikhoan = (EditText) findViewById(R.id.edtTaikhoan);
        edtMatkhau = (EditText) findViewById(R.id.edtMatkhau);
        showmatkhau = (CheckBox) findViewById(R.id.showmatkhau);
        btnDangnhap = (Button) findViewById(R.id.btnDangnhap) ;
        btnThoat = (Button) findViewById(R.id.btnThoat) ;

        showmatkhau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    edtMatkhau.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    edtMatkhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });


        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtTaikhoan.getText().toString().equals("admin") &&
                        edtMatkhau.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
}

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_thoat, null);
        Button btnDongy = (Button) view.findViewById(R.id.btnDongy);
        Button btnKhong = (Button) view.findViewById(R.id.btnKhong);

        builder.setView(view) ;
        final Dialog dialog2 = builder.create();
        dialog2.setTitle("Thoát ứng dụng");
        dialog2.show();

        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
    }
}
