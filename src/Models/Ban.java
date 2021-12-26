/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ASUS
 */
public class Ban {
   private String  TenBan, TrangThai;
    private int MaBan,MaKhuVuc;
    
    public Ban(){
        this.MaBan =0;
        this.TenBan ="";
        this.TrangThai ="";
        this.MaKhuVuc = 0;
    }
    public Ban(int ma, String ten, String trangthai){
        this.MaBan =ma;        
//        this.MaKhuVuc =makv;
        this.TenBan =ten;
        this.TrangThai =trangthai;
    }
    
    public Ban(int ma, int makv,String ten, String trangthai){
        this.MaBan =ma;        
        this.MaKhuVuc =makv;
        this.TenBan =ten;
        this.TrangThai =trangthai;
    }
    
    public void SetMaBan(int ma){
        this.MaBan = ma;
    }
    public int GetMaBan(){
        return this.MaBan;
    }
    public void SetTenBan(String ten){
        this.TenBan = ten;
    }
    public String GetTenBan(){
        return this.TenBan;
    }
    public void SetTrangThai(String trangthai){
        this.TrangThai = trangthai;
    }
    public String GetTrangThai(){
        return this.TrangThai;
    }

    public int getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(int MaKhuVuc) {
        this.MaKhuVuc = MaKhuVuc;
    }
    
    @Override
    public String toString(){
        return this.TenBan;
    } 
}
