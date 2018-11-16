package com.activity.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.activity.myapplication.adapter.ThemListAdapter;
import com.activity.myapplication.sqlite.SQLiteHelper;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ThemListActivity extends AppCompatActivity {

    ListView mListView ;
    ArrayList<Model> mList ;
    ThemListAdapter mAdapter = null ;
    ImageView imageViewIcoi ;
    SQLiteHelper mSqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_list);


        ActionBar actionBar = getSupportActionBar() ;

        mSqliteHelper = new SQLiteHelper(this);

        mListView = findViewById(R.id.ListView) ;
        mList = new ArrayList<>() ;
        mAdapter = new ThemListAdapter(this, R.layout.row, mList) ;
        mListView.setAdapter(mAdapter);



        Cursor cursor = mSqliteHelper.getData("SELECT * FROM RECORD") ;
        mList.clear();

        while (cursor.moveToNext()){
            int id  = cursor.getInt(0) ;
            String hoten = cursor.getString(1) ;
            String tuoi= cursor.getString(2) ;
            String quequan = cursor.getString(3) ;
            String noiohiennay = cursor.getString(4) ;
            String ngaythangnamsinh = cursor.getString(5) ;
            String vitri = cursor.getString(6) ;
            String mucluong = cursor.getString(7) ;
            String ghichu = cursor.getString(8) ;

            byte[] image = cursor.getBlob(9) ;

            mList.add(new Model(id, hoten, tuoi, quequan, noiohiennay, ngaythangnamsinh, vitri, mucluong, ghichu, image)) ;
        }
        mAdapter.notifyDataSetChanged();
        if (mList.size()==0){
            Toast.makeText(this, "không tìm thấy bản ghi", Toast.LENGTH_SHORT).show();
        }
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {

                final CharSequence[] items = {"Sửa", "Xóa"} ;
                AlertDialog.Builder dialog = new AlertDialog.Builder(ThemListActivity.this);

                dialog.setTitle("Hãy chọn ") ;
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i == 0){
                            //update
                            Cursor c = QuanLiThanhVienActivity.mSqliteHelper.getData("SELECT id FROM RECORD") ;
                            ArrayList<Integer> arrID = new ArrayList<Integer>() ;
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0)) ;
                            }
                            showDialogUpdate(ThemListActivity.this, arrID.get(position));
                        }
                        if (i==1){
                            //delete
                            Cursor c = QuanLiThanhVienActivity.mSqliteHelper.getData("SELECT id FROM RECORD") ;
                            ArrayList<Integer> arrID = new ArrayList<Integer>() ;
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0)) ;
                            }
                            showDialogDelete(arrID.get(position)) ;
                        }
                    }
                });
                dialog.show() ;

                return true;
            }
        });
    }

    private void showDialogDelete(final int idRecord) {

        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(ThemListActivity.this) ;
        dialogDelete.setTitle("Cảnh báo!!") ;
        dialogDelete.setMessage("Bạn có chắc chắn muốn xóa?") ;
        dialogDelete.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    QuanLiThanhVienActivity.mSqliteHelper.deleteData(idRecord);
                    Toast.makeText(ThemListActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Log.e("Lỗi", e.getMessage()) ;
                }
                updateRecordList();
            }
        });

        dialogDelete.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogDelete.show() ;
    }

    private void  showDialogUpdate(Activity activity, final int position){
        final Dialog dialog = new Dialog(activity) ;
        dialog.setContentView(R.layout.update_dialog);
        dialog.setTitle("Sửa");

        imageViewIcoi = dialog.findViewById(R.id.imageViewRecord) ;

        final EditText edtHoten = dialog.findViewById(R.id.edtHoten) ;
        final EditText edtTuoi = dialog.findViewById(R.id.edtTuoi) ;
        final EditText edtQuequan = dialog.findViewById(R.id.edtQuequan) ;
        final EditText edtNoio = dialog.findViewById(R.id.edtNoiohiennay) ;
        final EditText edtNgaysinh = dialog.findViewById(R.id.edtNgaythangnamsinh) ;
        final EditText edtVitri = dialog.findViewById(R.id.edtVitrithidau) ;
        final EditText edtMucLuong = dialog.findViewById(R.id.edtMucluong) ;
        final EditText edtGhichu = dialog.findViewById(R.id.edtGhichu) ;

        Button btnSua = dialog.findViewById(R.id.btnSua) ;

        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels*0.95) ;
        int height = (int)(activity.getResources().getDisplayMetrics().heightPixels*0.7) ;
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewIcoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(ThemListActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888);
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    QuanLiThanhVienActivity.mSqliteHelper.updateDate(
                            edtHoten.getText().toString().trim(),
                            edtTuoi.getText().toString().trim(),
                            edtQuequan.getText().toString().trim(),
                            edtNoio.getText().toString().trim(),
                            edtNgaysinh.getText().toString().trim(),
                            edtVitri.getText().toString().trim(),
                            edtMucLuong.getText().toString().trim(),
                            edtGhichu.getText().toString().trim(),
                            QuanLiThanhVienActivity.imageViewToByte(imageViewIcoi) , position );

                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
                catch (Exception error){
                    Log.e("Sửa thất bại", error.getMessage()) ;
                }
                updateRecordList() ;
            }
        });

    }

    private void updateRecordList() {
        Cursor cursor = QuanLiThanhVienActivity.mSqliteHelper.getData("SELECT * FROM RECORD ") ;
        mList.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0) ;
            String hoten = cursor.getString(1) ;
            String tuoi= cursor.getString(2) ;
            String quequan = cursor.getString(3) ;
            String noio = cursor.getString(4) ;
            String ngaysinh = cursor.getString(5) ;
            String vitri= cursor.getString(6) ;
            String mucluong= cursor.getString(7) ;
            String ghichu = cursor.getString(8) ;
            byte[] image = cursor.getBlob(9) ;

            mList.add(new Model(id, hoten, tuoi, quequan, noio, ngaysinh, vitri, mucluong, ghichu, image)) ;
        }
        mAdapter.notifyDataSetChanged();
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
        if (requestCode == 888) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 888);
            } else {
                Toast.makeText(this, "Không được phép truy cập vị trí tệp  ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 888 && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            CropImage.activity(imageUri).setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1, 1)
                    .start(this);
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imageViewIcoi.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Add(View view) {
        Intent intent = new Intent(ThemListActivity.this, QuanLiThanhVienActivity.class) ;
        startActivity(intent);
    }
}

