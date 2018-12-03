package com.activity.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton actionButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_gioithieudoibong) {
            Intent intent1 = new Intent(HomeActivity.this, GioiThieuDoiBongActivity.class);
            startActivity(intent1);

        } else if (id == R.id.nav_quanlithanhvien) {
            Intent intent2 = new Intent(HomeActivity.this, QuanLiThanhVienActivity.class);
            startActivity(intent2);

        } else if (id == R.id.nav_sodochienthoat) {
            Intent intent3 = new Intent(HomeActivity.this, SoDoChienThuatActivity.class);
            startActivity(intent3);

        } else if (id == R.id.nav_hoatdongtrongthang) {
            Intent intent4 = new Intent(HomeActivity.this, HoatDongTrongThangActivity.class);
            startActivity(intent4);

        } else if (id == R.id.nav_truso) {
            Intent intent4 = new Intent(HomeActivity.this, MapsActivity.class);
            startActivity(intent4);

        } else if (id == R.id.nav_thoat) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
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
        }else if (id == R.id.nav_tintuctrongngay) {
            Intent intent5 = new Intent(HomeActivity.this, TinTucTrongNgayActivity.class);
            startActivity(intent5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
