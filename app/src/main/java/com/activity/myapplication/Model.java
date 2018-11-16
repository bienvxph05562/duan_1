package com.activity.myapplication;

public class Model {
    private int id;
    private String  hoten, tuoi, quequan, noiohiennay, ngaysinh, vitrithidau, mucluong, ghichu ;
    private  byte[] image ;

    public Model(int id, String hoten, String tuoi, String quequan, String noiohiennay, String ngaysinh, String vitrithidau, String mucluong, String ghichu, byte[] image) {
        this.id = id;
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.quequan = quequan;
        this.noiohiennay = noiohiennay;
        this.ngaysinh = ngaysinh;
        this.vitrithidau = vitrithidau;
        this.mucluong = mucluong;
        this.ghichu = ghichu;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getNoiohiennay() {
        return noiohiennay;
    }

    public void setNoiohiennay(String noiohiennay) {
        this.noiohiennay = noiohiennay;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getVitrithidau() {
        return vitrithidau;
    }

    public void setVitrithidau(String vitrithidau) {
        this.vitrithidau = vitrithidau;
    }

    public String getMucluong() {
        return mucluong;
    }

    public void setMucluong(String mucluong) {
        this.mucluong = mucluong;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
