/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DsCaLam {
    private int SoTien;
    private String TenNV;
    private Time GioBD,GioKT;
    private Date NgayLam;

    public DsCaLam(int SoTien, String TenNV, Time GioBD, Time GioKT, Date NgayLam) {
        this.SoTien = SoTien;        
        this.TenNV = TenNV;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.NgayLam = NgayLam;
    }

//    public int getMaCLV() {
//        return MaCLV;
//    }
//
//    public void setMaCLV(int MaCLV) {
//        this.MaCLV = MaCLV;
//    }

    public int getSoTien() {
        return SoTien;
    }


    public String getTenNV() {
        return TenNV;
    }

    public Time getGioBD() {
        return GioBD;
    }

    public Time getGioKT() {
        return GioKT;
    }

    public Date getNgayLam() {
        return NgayLam;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }
    
    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setGioBD(Time GioBD) {
        this.GioBD = GioBD;
    }

    public void setGioKT(Time GioKT) {
        this.GioKT = GioKT;
    }

    public void setNgayLam(Date NgayLam) {
        this.NgayLam = NgayLam;
    }
    
    
}
