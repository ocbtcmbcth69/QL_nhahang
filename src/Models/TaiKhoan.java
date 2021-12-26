/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class TaiKhoan {

    private int lv,SDT,GioiTinh;
    private String MaNV, Password, TenNV, ChucVu, DiaChi;
    private Date NgayVaoLam;

    public TaiKhoan(){}
    
    public TaiKhoan( String MaNV,String TenNV, int GioiTinh,  String ChucVu, Date NgayVaoLam, String DiaChi, int SDT, int lv,  String Password) {
        this.lv = lv;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.MaNV = MaNV;
        this.Password = Password;
        this.TenNV = TenNV;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.NgayVaoLam = NgayVaoLam;
    }
    public TaiKhoan( String MaNV,String TenNV, int GioiTinh,  String ChucVu, Date NgayVaoLam, String DiaChi, int SDT) {
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.ChucVu = ChucVu;
        this.DiaChi = DiaChi;
        this.NgayVaoLam = NgayVaoLam;
    }
    
    public TaiKhoan( String MaNV) {
        this.MaNV = MaNV;
    }

    public void SetLv(int lv) {
        this.lv = lv;
    }

    public int GetLv() {
        return this.lv;
    }

    public void SetMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String GetMaNV() {
        return this.MaNV;
    }

    public void SetPassword(String Password) {
        this.Password = Password;
    }

    public String GetPassword() {
        return this.Password;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(Date NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }
    
    
}
