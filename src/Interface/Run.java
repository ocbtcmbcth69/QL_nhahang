/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Interface.BanHang.Banhang_UI;
import Interface.Daubep.Daubep_UI;
import Interface.QuanLy.QuanLy_UI;
import Interface.TaiKhoan.TaiKhoan_UI;
import Interface.ThongKe.ThongKe_UI;
import Interface.CaiDat.ThongTin_UI;
import Models.TaiKhoan;
/**
 *
 * @author ASUS
 */
public class Run {
    public static Home_UI QlCafe;
    public static Login_UI frmlg;
    public static TaiKhoan tk;    
    public static Banhang_UI menuBan;
    public static Daubep_UI menuBep;
    public static TaiKhoan_UI menuTK;    
    public static QuanLy_UI menuQL;
    public static ThongKe_UI menuTHK;
    public static ThongTin_UI menuTT;
    public static boolean chotCa;    
    public static String gioLam; 
 


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lg();
    }
    public static void lg(){
        frmlg = new Login_UI();
        frmlg.setVisible(true);       
    }  
    public static void QLCF(){
        QlCafe = new Home_UI();
        QlCafe.setVisible(true);       
    }
    
    public static void menuBan(){
        menuBan = new Banhang_UI();
        menuBan.setVisible(true);       
    }
    
    public static void menuBep(){
        menuBep = new Daubep_UI();
        menuBep.setVisible(true);       
    }
    
    public static void menuTK(){
        menuTK = new TaiKhoan_UI();
        menuTK.setVisible(true);       
    }
    
    public static void menuQL(){
        menuQL = new QuanLy_UI();
        menuQL.setVisible(true);       
    }
    
    public static void menuTHK(){
        menuTHK = new ThongKe_UI();
        menuTHK.setVisible(true);       
    }
    
    public static void menuTT(){
        menuTT = new ThongTin_UI();
        menuTT.setVisible(true);       
    }
}
