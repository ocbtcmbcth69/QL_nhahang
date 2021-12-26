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
public class CaLamViec {
    private int MaCLV,SoTien;
    private String MaNV;
    private Time GioBD,GioKT;
    private Date NgayLam;

    public CaLamViec(int MaCLV, int SoTien, String MaNV, Time GioBD, Time GioKT, Date NgayLam) {
        this.MaCLV = MaCLV;
        this.SoTien = SoTien;
        this.MaNV = MaNV;
        this.GioBD = GioBD;
        this.GioKT = GioKT;
        this.NgayLam = NgayLam;
    }

    public String getMaNV() {
        return MaNV;
    }

    public Date getNgayLam() {
        return NgayLam;
    }

    public void setNgayLam(Date NgayLam) {
        this.NgayLam = NgayLam;
    }

    
    
    public int getMaCLV() {
        return MaCLV;
    }

    public int getSoTien() {
        return SoTien;
    }


    public void setMaCLV(int MaCLV) {
        this.MaCLV = MaCLV;
    }

    public void setSoTien(int SoTien) {
        this.SoTien = SoTien;
    }

    public Time getGioBD() {
        return GioBD;
    }

    public void setGioBD(Time GioBD) {
        this.GioBD = GioBD;
    }

    public Time getGioKT() {
        return GioKT;
    }

    public void setGioKT(Time GioKT) {
        this.GioKT = GioKT;
    }

    

   

    
    
}
