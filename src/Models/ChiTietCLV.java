/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class ChiTietCLV {
    private int MaCLV,TienChotCa,MaCTCLV;
    private Date GioKTThucTe,NgayLam;
    private Calendar GioBDThucTe;
    private String MaNV;

    public ChiTietCLV() {
        this.MaCTCLV = 0;
        this.MaCLV = 1; //Có vấn đề
        this.TienChotCa = 0;
        this.GioBDThucTe = null;
        this.GioKTThucTe = null;
        this.NgayLam = null;
        this.MaNV = "NV1";
    }
    
    public ChiTietCLV(int MaCLV,int MaCTCLV, int TienChotCa, Calendar GioBDThucTe, Date GioKTThucTe,Date Ngaylam,String MaNV) {
        this.MaCLV = MaCLV;
        this.MaCTCLV = MaCTCLV;
        this.TienChotCa = TienChotCa;
        this.GioBDThucTe = GioBDThucTe;
        this.GioKTThucTe = GioKTThucTe;
        this.MaNV = MaNV;
        this.NgayLam = Ngaylam;
    }

    public int getMaCLV() {
        return MaCLV;
    }

    public int getTienChotCa() {
        return TienChotCa;
    }

    public Calendar getGioBDThucTe() {
        return GioBDThucTe;
    }

    public Date getGioKTThucTe() {
        return GioKTThucTe;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaCLV(int MaCLV) {
        this.MaCLV = MaCLV;
    }

    public void setTienChotCa(int TienChotCa) {
        this.TienChotCa = TienChotCa;
    }

    public void setGioBDThucTe(Calendar GioBDThucTe) {
        this.GioBDThucTe = GioBDThucTe;
    }

    public void setGioKTThucTe(Date GioKTThucTe) {
        this.GioKTThucTe = GioKTThucTe;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayLam() {
        return NgayLam;
    }

    public void setNgayLam(Date NgayLam) {
        this.NgayLam = NgayLam;
    }

    public int getMaCTCLV() {
        return MaCTCLV;
    }

    public void setMaCTCLV(int MaCTCLV) {
        this.MaCTCLV = MaCTCLV;
    }
    
    
    
}
