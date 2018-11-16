package com.activity.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.activity.myapplication.sqlite.SQLiteHelper;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;

public class QuanLiThanhVienActivity extends AppCompatActivity {
    Button btnThem, btnXemThanhVien ;
    EditText ed_id, ed_hoten, ed_tuoi, ed_quequan, ed_noiohiennay, ed_ngaythangnamsinh, ed_vitrithidau, ed_mucluong, ed_ghichu;

    ImageView mImageView;
    final int REQUEST_CODE_GALLERY = 999;
    public static SQLiteHelper mSqliteHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_thanh_vien);


        btnThem = findViewById(R.id.btnThem);
        btnXemThanhVien = findViewById(R.id.btnXemdanhsach) ;

        ActionBar actionBar = getSupportActionBar() ;


        mImageView = findViewById(R.id.imageView);
        ed_hoten = findViewById(R.id.edtHoten);
        ed_tuoi = findViewById(R.id.edtTuoi);
        ed_quequan = findViewById(R.id.edtQuequan);
        ed_noiohiennay = findViewById(R.id.edtNoiohiennay);
        ed_ngaythangnamsinh = findViewById(R.id.edtNgaythangnamsinh) ;
        ed_vitrithidau = findViewById(R.id.edtVitrithidau) ;
        ed_mucluong = findViewById(R.id.edtMucluong) ;
        ed_ghichu = findViewById(R.id.edtGhichu) ;

        mSqliteHelper = new SQLiteHelper(this);

        mSqliteHelper.queryData("CREATE TABLE IF NOT EXISTS RECORD(id INTEGER PRIMARY KEY AUTOINCREMENT, ten VARCHAR, tuoi VARCHAR, quequan VARCHAR, noiohiennay VARCHAR, ngaythangnamsinh VARCHAR, vitrithidau VARCHAR, mucluong VARCHAR, ghichu VARCHAR,    image BLOB)");

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityCompat.requestPermissions(QuanLiThanhVienActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY);

            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String hoten = ed_hoten.getText().toString();
                    String tuoi = ed_tuoi.getText().toString();
                    String quequan = ed_quequan.getText().toString();
                    String noiohiennay= ed_noiohiennay.getText().toString();
                    String namsinh = ed_ngaythangnamsinh.getText().toString();
                    String vitrithidau = ed_vitrithidau.getText().toString();
                    String mucluong = ed_mucluong.getText().toString();
                    String ghichu = ed_ghichu.getText().toString();


                    if (resultUri == null){
                        Toast.makeText(QuanLiThanhVienActivity.this, "Bạn cần điền đầy đủ thông tin, và ảnh", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (hoten.isEmpty() && tuoi.isEmpty() && quequan.isEmpty() &&
                            noiohiennay.isEmpty() && namsinh.isEmpty() &&
                            vitrithidau.isEmpty() && mucluong.isEmpty() && ghichu.isEmpty() ){
                          Toast.makeText(QuanLiThanhVienActivity.this, "Bạn cần điền đầy đủ thông tin, và ảnh", Toast.LENGTH_SHORT).show();
                    }else {

                        mSqliteHelper.insertData(
                                ed_hoten.getText().toString().trim(),
                                ed_tuoi.getText().toString().trim(),
                                ed_quequan.getText().toString().trim(),
                                ed_noiohiennay.getText().toString().trim(),
                                ed_ngaythangnamsinh.getText().toString().trim(),
                                ed_vitrithidau.getText().toString().trim(),
                                ed_mucluong.getText().toString().trim(),
                                ed_ghichu.getText().toString().trim(),
                                imageViewToByte(mImageView)
                        );

                        Toast.makeText(QuanLiThanhVienActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        ed_hoten.setText("");
                        ed_tuoi.setText("");
                        ed_quequan.setText("");
                        ed_noiohiennay.setText("");
                        ed_ngaythangnamsinh.setText("");
                        ed_vitrithidau.setText("");
                        ed_mucluong.setText("");
                        ed_ghichu.setText("");


                        mImageView.setImageResource(R.drawable.ic_account_circle_black_24dp);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btnXemThanhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuanLiThanhVienActivity.this, ThemListActivity.class));
            }
        });

    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(this, " Không được phép truy cập vị trí tệp  ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private  Uri resultUri;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1).start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                resultUri = result.getUri();
                mImageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }



}
