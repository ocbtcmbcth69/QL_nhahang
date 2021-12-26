package Models;

import java.util.Date;

public class PhieuNhap {
    private String MaPhieu,NCC;
    private Date NgayLam;
    private int TongTien;
    
    public PhieuNhap(){}
     
    public PhieuNhap(String MaPhieu, String NCC, Date NgayLam, int TongTien){
        this.MaPhieu=MaPhieu;
        this.NCC=NCC;
        this.NgayLam=NgayLam;
        this.TongTien=TongTien;
    }

    public String getNCC() {
        return NCC;
    }

    public void setNCC(String NCC) {
        this.NCC = NCC;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public Date getNgayLam() {
        return NgayLam;
    }

    public void setNgayLam(Date NgayLam) {
        this.NgayLam = NgayLam;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
