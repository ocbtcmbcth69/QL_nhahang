/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class HD1Month {
    private int MaHoaDon,TongTien;
    private Date ngay;

     public HD1Month(){
        this.MaHoaDon = 0;
        this.TongTien = 0;
     }
    
    public HD1Month(int MaHoaDon, int TongTien, Date ngay) {
        this.MaHoaDon = MaHoaDon;
        this.TongTien = TongTien;
        this.ngay = ngay;
    }
    
    public HD1Month(int TongTien, Date ngay) {
        this.TongTien = TongTien;
        this.ngay = ngay;
    }
    
    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    
    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
    
}
