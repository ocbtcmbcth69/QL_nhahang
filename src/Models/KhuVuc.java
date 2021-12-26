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
public class KhuVuc {
    private int MaKhuVuc;
    private String TenKhuVuc;

    public KhuVuc() {
        this.MaKhuVuc = 0;
        this.TenKhuVuc = "";
    }
    
    public KhuVuc(int MaKhuVuc, String TenKhuVuc) {
        this.MaKhuVuc = MaKhuVuc;
        this.TenKhuVuc = TenKhuVuc;
    }
    public KhuVuc(int MaKhuVuc) {
        this.MaKhuVuc = MaKhuVuc;
     
    }

    public int getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(int MaKhuVuc) {
        this.MaKhuVuc = MaKhuVuc;
    }

    public String getTenKhuVuc() {
        return TenKhuVuc;
    }

    public void setTenKhuVuc(String TenKhuVuc) {
        this.TenKhuVuc = TenKhuVuc;
    }
    
    @Override
    public String toString(){
        return this.TenKhuVuc;
    }
}
