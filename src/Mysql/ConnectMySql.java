/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Models.Ban;
import Models.CaLamViec;
import Models.ChiTietCLV;
import Models.ChiTietHD;
import Models.DsOrder;
import Models.HD1Month;
import Models.HoaDon;
import Models.KhuVuc;
import Models.Loai; 
import Models.PhieuNhap;
import Models.TaiKhoan;
import Models.ThucDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ConnectMySql {
    public static Connection cn = null;
//    public static Connection conn;
    public ConnectMySql(){
        try{
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectMySql.class.getName()).log(Level.SEVERE, null, ex);
            }
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnhahang?useUnicode=true&characterEncoding=utf8", "root", "");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kết nối thất bại !");
        }        
    }
    
    //Check Login
    public String CheckLogin(String ma)
    {
        String check = "";
        String sql;
            sql = "Select MatKhau From nhanvien Where MaNV = '"+ma+"' ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                check = rs.getString(0);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi đăng nhập !");
        }
        return check; 
    }
    
    public int LVTK(TaiKhoan tk)
    {
        int lvtk =0;
        String sql;
            sql = "Select PhanQuyen From nhanvien Where MaNV = '"+tk.GetMaNV()+"' AND MatKhau='"+tk.GetPassword()+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                lvtk = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return lvtk; 
    }   
    
    public TaiKhoan GetTaiKhoan(String ma){
        TaiKhoan td = null;
        String sql;
            sql = "Select * From nhanvien Where MaNV = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new TaiKhoan(rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getDate(5),rs.getString(6),  rs.getInt(7), rs.getInt(8),rs.getString(9));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
    public Vector GetNhomMon(){
        Vector arrloai = null;
        String sql = "Select * From nhommon";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector();
            Loai all = new Loai(null, "Tất cả các món","");
            arrloai.add(all);            
            while(rs.next()){
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai; 
    }
    
    //them moi CTCLV
    public int InsertCLVLogin(ChiTietCLV clv,String gioBD,String ngay){
        int insert = 0;
        String sql = "Insert into chitietcalam (MaNV,MaCLV,GioBDThucTe,GioKTThucTe,NgayLam,TienChotCa) "
                + "values ('"+clv.getMaNV()+"','"+clv.getMaCLV()+"','"+gioBD+"', '"+gioBD+"', '"+ngay+"','"+clv.getTienChotCa()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
           ex.printStackTrace();
        }
        return insert;
    }
    
    //Lay CLV
//    public ArrayList<CaLamViec> GetAllCLV(){
//        ArrayList<CaLamViec> arrCLV = null;
//        String sql;
//            sql = "Select * From calamviec ";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrCLV = new ArrayList<CaLamViec>();
//            while(rs.next()){
//                CaLamViec kv = new CaLamViec(rs.getInt(1),  rs.getInt(5),rs.getString(2), rs.getTime(3), rs.getTime(4));
//                arrCLV.add(kv);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
//        }
//        return arrCLV; 
//    }
    //Lay Khu vuc
    public ArrayList<KhuVuc> GetAllKhuVuc(){
        ArrayList<KhuVuc> arrKV = null;
        String sql;
            sql = "Select * From khuvuc ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrKV = new ArrayList<KhuVuc>();
            while(rs.next()){
                KhuVuc kv = new KhuVuc(rs.getInt(1), rs.getString(2));
                arrKV.add(kv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrKV; 
    }
      
//    public ArrayList<CaLamViec> GetCLV(){
//        ArrayList<CaLamViec> arrloai = null;
//        String sql = "Select * From calamviec";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            arrloai = new ArrayList<CaLamViec>();  
//            while(rs.next()){
//                CaLamViec kv = new CaLamViec(rs.getInt(1),rs.getInt(5), rs.getString(2),rs.getTime(3),rs.getTime(4));
//                arrloai.add(kv);
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
//        }
//        return arrloai; 
//    }
    //Lay Ban
    public ArrayList<Ban> GetAllBan(){
        ArrayList<Ban> arrBan = null;
        String sql;
            sql = "Select * From ban ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban kv = new Ban(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
                arrBan.add(kv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    }
    
    
    public ArrayList<Ban> GetBan(int ma){
       ArrayList<Ban> arrBan = null;
        String sql;
            sql = "Select * From ban where MaBan = '"+ma+"' ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban b = new Ban(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
                arrBan.add(b);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    }
    
    //Hoa don
    
    public HoaDon GetHDbyMaBan(int ma){
        String sql;
        HoaDon arrhd = null;
            sql = "Select * From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrhd = new HoaDon(rs.getInt(1),rs.getString(2) ,rs.getInt(3), rs.getInt(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return arrhd;        
    }  
    
    public ArrayList<DsOrder> GetDsOrder(int ma){
        ArrayList<DsOrder> arrDs = null;
        String sql;
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon Where ct.MaHoaDon = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    } 
    //Tao Hoa don moi
    public int InsertHoaDon(HoaDon hd, String gio){
        int insert = 0;
        String sql = "Insert into hoadon (MaNV,GiamGia,MaBan, GioDen, TrangThai) values ('"+hd.getMaNV()+"','"+hd.GetGiamGia()+"','"+hd.GetMaBan()+"', '"+gio+"', '"+hd.GetTrangThai()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    //Loai mon
    public ArrayList<Loai> GetLoai(){
        ArrayList<Loai> arrloai = null;
        String sql = "Select * From nhommon";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new ArrayList<Loai>();
            while(rs.next()){
                Loai sp = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrloai.add(sp);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai; 
    }
    
    public ArrayList<ThucDon> GetThucDon(String ma){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;
        if(ma == null){
            sql = "Select * From thucdon";
        }else{
            sql = "Select * From thucdon Where MaLoai = '"+ma+"'";
        }
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
    public ArrayList<PhieuNhap> GetPhieuNhap(String ma){
        ArrayList<PhieuNhap> arrPhieuNhap = null;
        String sql;
        if(ma == null){
            sql = "Select * From phieunhap";
        }else{
            sql = "Select * From phieunhap Where MaPhieu = '"+ma+"'";
        }
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrPhieuNhap = new ArrayList<PhieuNhap>();
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                arrPhieuNhap.add(pn);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrPhieuNhap;
    }
    public ChiTietHD GetDsChiTiet(String ma, int maban){
        ChiTietHD arrDs = null;
        String sql;

            sql = "Select SoLuong, Gia, MaChiTietHD From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon Where MaMon = '"+ma+"' AND MaBan = '"+maban+"' AND hd.TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                arrDs = new ChiTietHD();
                arrDs.SetSoLuong(rs.getInt(1));
                arrDs.SetGia(rs.getInt(2));
                arrDs.SetMaChiTietHD(rs.getInt(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách Order !");
        }
        return arrDs;        
    } 
    
    public ArrayList<ThucDon> GetThucDonByMa(String ma){
        ArrayList<ThucDon> arrThucDon = null;
        String sql;

            sql = "Select * From thucdon Where MaMon = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrThucDon = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrThucDon.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return arrThucDon;        
    }
    public ArrayList<PhieuNhap> GetPhieuNhapByMa(String ma){
        ArrayList<PhieuNhap> arrPhieuNhap = null;
        String sql;

            sql = "Select * From phieunhap Where MaPhieu = '"+ma+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrPhieuNhap = new ArrayList<PhieuNhap>();
            while(rs.next()){
                PhieuNhap pn = new PhieuNhap(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                arrPhieuNhap.add(pn);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách phiếu nhập !");
        }
        return arrPhieuNhap;
    }
    
    public int GetMaHD(int ma){
        String sql;
        int mahd = 0;
            sql = "Select MaHoaDon From hoadon Where MaBan = '"+ma+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahd = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;        
    } 
    public int UpdateChiTiet(ChiTietHD ct){
        int update = 0;
        String sql = "UPDATE chitiethd SET SoLuong = '"+ct.GetSoLuong()+"', Gia = '"+ct.GetGia()+"' WHERE MaChiTietHD = '"+ct.GetMaChiTietHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update chi tiết không thành công !");
        }
        return update;        
    }
    
    public int InsertChiTietHD(ChiTietHD cthd){
        int insert = 0;
        String sql = "Insert into chitiethd (MaHoaDon, MaMon, SoLuong, Gia) values ('"+cthd.GetMaHD()+"', '"+cthd.GetMaMon()+"', '"+cthd.GetSoLuong()+"', '"+cthd.GetGia()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn không thành công !"+ex.toString());
        }
        return insert;
    }
    
    public int UpdateBan(Ban b){
        int update = 0;
        String sql = "UPDATE ban SET TenBan = '"+b.GetTenBan()+"', TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update bàn không thành công !");
        }
        return update;
    }  
    
    public int DeleteMon(String mamon, int mahd, int maban){
        int check = 0;
        try{
            String sql;
            sql = "Delete From chitiethd Where MaMon = '"+mamon+"' AND MaHoaDon = '"+mahd+"'";
            Statement st = cn.createStatement();
            st.executeUpdate(sql);
            check = 1;
            if(CheckDsMon(mahd, maban) == 0){
                check = 2;
            }
        }catch(SQLException ex){
            
        }
        return check;
    }
    
    public int CheckDsMon(int mahd, int maban){
        String sql;
        int dem = 0;
            sql = "Select * From hoadon AS hd INNER JOIN chitiethd AS ct ON ct.MaHoaDon = hd.MaHoaDon Where MaBan = '"+maban+"' AND ct.MaHoaDon = '"+mahd+"' AND TrangThai = 0";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dem++;
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
        }
        return dem;        
    }  
    
    public int UpDateTrangThaiBan(Ban b){
         int update = 0;
        String sql = "UPDATE ban SET TrangThai = '"+b.GetTrangThai()+"' WHERE MaBan = '"+b.GetMaBan()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update trạng thái bàn không thành công !");
        }
        return update;        
    }
    
    public int HuyHD(HoaDon hd){
        int update = 0;
        String sql = "Delete From hoadon WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    } 
    
    public int ThanhToan(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET TongTien = '"+hd.GetTongTien()+"', TrangThai = 1 WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Thanh toán không thành công !");
        }
        return update;        
    }
    
    public int UpdateHD(HoaDon hd){
        int update = 0;
        String sql = "UPDATE hoadon SET GiamGia = '"+hd.GetGiamGia()+"' WHERE MaHoaDon = '"+hd.GetMaHD()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Giảm giá không thành công !");
        }
        return update;
    }    
// UpdateTK
    public int UpdateTK(TaiKhoan b){
        int update = 0;
        String sql = "UPDATE nhanvien SET TenNV = '"+b.getTenNV()+"', PhanQuyen = '"+b.GetLv()+"', GioiTinh = '"+b.getGioiTinh()+"', ChucVu ='"+b.getChucVu()+"', DiaChi='"+b.getDiaChi()+"', SDT ='"+b.getSDT()+"'  WHERE MaNV = '"+b.GetMaNV()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }
    
    public int UpdateTK1(TaiKhoan tk) {
        int update = 0;
        String sql = "UPDATE nhanvien SET TenNV = '"+tk.getTenNV()+"', DiaChi='"+tk.getDiaChi()+"', SDT ='"+tk.getSDT()+"'  WHERE MaNV = '"+tk.GetMaNV()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }
    
// insertTK
    public int InserTK(TaiKhoan b,String ngayLam){
        int insert = 0;
        String sql = "Insert into nhanvien (MaNV, tenNV, GioiTinh, ChucVu, NgayVaoLam, DiaChi, SDT, PhanQuyen, MatKhau) values ('"+b.GetMaNV()+"', '"+b.getTenNV()+"', '"+b.getGioiTinh()+"' ,'"+b.getChucVu()+"','"+ngayLam+"','"+b.getDiaChi()+"','"+b.getSDT()+"','"+b.GetLv()+"', '"+b.GetPassword()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
            
        }catch(SQLException ex){
        }
        return insert;
    }
    
 public ArrayList<TaiKhoan> GetTaiKhoan(){
        ArrayList<TaiKhoan> arrtk = null;
        String sql;
            sql = "Select * From nhanvien";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtk = new ArrayList<TaiKhoan>();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getDate(5),rs.getString(6),  rs.getInt(7), rs.getInt(8),rs.getString(9));
                arrtk.add(tk);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getErrorCode());
        }
        return arrtk;
    }
 // Delete TK
 public boolean DeleteTaiKhoan(ArrayList<String> listMaBan){
        boolean check = false;
        try{
            String sql;
            for(String ma : listMaBan){
                sql = "Delete From nhanvien Where MaNV = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
//GetCaLam
//    public CaLamViec GetCaLam(int x) {
//        CaLamViec td = null;
//        String sql;
//            sql = "SELECT * FROM calamviec WHERE MaCLV = '"+x+"'";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//               td  = new CaLamViec(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getTime(4), rs.getTime(5));
//            }
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "lỗi !");
//        }
//        return td;
//    }
//    //Update ca lam viec
//    public int UpdateCL(CaLamViec clv) {
//        int update = 0;
//        String sql = "UPDATE calamviec SET TenCLV = '"+clv.getTenCLV()+"', GioBD = '"+clv.getGioBD()+"', GioKT = '"+clv.getGioKT()+"', SoTien = '"+clv.getSoTien()+"'  WHERE MaCLV = '"+clv.getMaCLV()+"'";
//        try{
//            Statement st = cn.createStatement();
//            update = st.executeUpdate(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "lỗi !");
//        }
//        return update;
//    }
//    //Inset ca lam viec
//    public int InserCL(CaLamViec clv) {
//        int insert = 0;
//        String sql = "Insert into calamviec ( TenCLV, GioBD, GioKT, SoTien) values ('"+clv.getTenCLV()+"', '"+clv.getGioBD()+"' ,'"+clv.getGioKT()+"','"+clv.getSoTien()+"')";
//        try{
//            Statement st = cn.createStatement();
//            insert = st.executeUpdate(sql);
//            
//        }catch(SQLException ex){
//        }
//        return insert;
//    }
//    
//    //Delete ca lam viec
//    public boolean DeleteCaLam(ArrayList<Integer> listMaCLV){
//        boolean check = false;
//        try{
//            String sql;
//            for(int ma : listMaCLV){
//                sql = "Delete From  calamviec Where MaCLV = '"+ma+"'";
//                Statement st = cn.createStatement();
//                st.executeUpdate(sql);
//            } 
//            check = true;
//        }catch(SQLException ex){
//            
//        }
//        return check;
//    }
   //QL_NhomMon
    public String GetMaLoai(String TenLoai){
        String maloai = null;
        String sql = "Select MaLoai From nhommon Where TenLoai = '"+TenLoai+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                maloai = rs.getString(1);
            }
 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được mã loại !");
        }
        return maloai; 
    }
   
    public ArrayList<Loai> SearchLoai(String ten){
        ArrayList<Loai> arrtd = null;
        String sql;
            sql = "SELECT * FROM nhommon WHERE TenLoai LIKE '%"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Loai>();
            while(rs.next()){
                Loai td = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    } 
    public int UpdateLoai(Loai b){
        int update = 0;
        String sql = "UPDATE nhommon SET TenLoai = '"+b.GetTenLoai()+"', MauSac = '"+b.GetMauSac()+"' WHERE MaLoai = '"+b.GetMaLoai()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update Loại không thành công !");
        }
        return update;
    }
    public int InsertLoai(Loai b){
        int insert = 0;
        String sql = "Insert into nhommon (TenLoai, MauSac) values ('"+b.GetTenLoai()+"', '"+b.GetMauSac()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    
    public Loai GetLoaiByMa(String manhom){
        Loai loai = null;
        String sql = "Select * From nhommon Where MaLoai = '"+manhom+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                loai = new Loai(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return loai; 
    }
     public boolean DeleteNhom(ArrayList<String> lismanhom){
        boolean check = false;
        try{
            String sql;
            for(String ma : lismanhom){
                sql = "Delete From nhommon Where MaLoai = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }

    
// QL_Ban
    public int InsertBan(Ban b){
        int insert = 0;
        String sql = "Insert into ban (MaKhuVuc, TenBan, TrangThai) values ('"+b.getMaKhuVuc()+"','"+b.GetTenBan()+"', '"+b.GetTrangThai()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    
    public boolean DeleteBan(ArrayList<Integer> listMaBan){
        boolean check = false;
        try{
            String sql;
            for(int ma : listMaBan){
                sql = "Delete From ban Where MaBan = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    
    public ArrayList<Ban> SearchBan(String ten){
        ArrayList<Ban> arrtd = null;
        String sql;
            sql = "SELECT  b.MaBan, kv.MaKhuVuc, kv.TenKhuVuc, b.TenBan, b.TrangThai From ban b " +
                    "   INNER JOIN khuvuc kv "+
                    "   ON b.MaKhuVuc = kv.MaKhuVuc" +
                   
                     "WHERE TenBan LIKE= '%"+ten+"%'" ;
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<Ban>();
            while(rs.next()){
                Ban td = new Ban(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    
    //QL_ThucDon
      
    public ArrayList<ThucDon> SearchMon(String ten){
        ArrayList<ThucDon> arrtd = null;
        String sql;
            sql = "SELECT * FROM thucdon WHERE TenMon LIKE '%"+ten+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon td = new ThucDon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }  
    public ArrayList<PhieuNhap> SearchPhieu(String ma){
        ArrayList<PhieuNhap> arrtd = null;
        String sql;
            sql = "SELECT * FROM phieunhap WHERE MaPhieu LIKE '%"+ma+"%'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtd = new ArrayList<PhieuNhap>();
            while(rs.next()){
                PhieuNhap td = new PhieuNhap(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4));
                arrtd.add(td);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return arrtd;
    }
    public int InsertThucDon(ThucDon td){
        int insert = 0;
        String sql = "Insert into thucdon (TenMon, MaLoai, DonGia, DVT) values ('"+td.GetTenMon()+"', '"+td.GetMaLoai()+"', '"+td.GetDonGia()+"', '"+td.GetDVT()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public int InsertPhieuNhap(PhieuNhap td){
        int insert = 0;
        String sql = "Insert into phieunhap (MaPhieu, NCC, NgayLam, TongTien) values ('"+td.getMaPhieu()+"', '"+td.getNCC()+"', '"+td.getNgayLam()+"', '"+td.getTongTien()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
    public boolean DeleteThucDon(ArrayList<String> listMamon){
        boolean check = false;
        try{
            String sql;
            for(String ma : listMamon){
                sql = "Delete From thucdon Where MaMon = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    public boolean DeletePhieuNhap(ArrayList<String> listMaphieu){
        boolean check = false;
        try{
            String sql;
            for(String ma : listMaphieu){
                sql = "Delete From phieunhap Where MaPhieu = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    public int UpdateThucDon(ThucDon td){
        int update = 0;
        String sql = "UPDATE thucdon SET TenMon = '"+td.GetTenMon()+"', MaLoai = '"+td.GetMaLoai()+"', DonGia = '"+td.GetDonGia()+"', DVT = '"+td.GetDVT()+"' WHERE MaMon = '"+td.GetMaMon()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update món không thành công !");
        }
        return update;
    }
    public int UpdatePhieuNhap(PhieuNhap pn){
        int update = 0;
        String sql = "UPDATE phieunhap SET NCC = '"+pn.getNCC()+"', NgayTao = '"+pn.getNgayLam()+"', TongTien = '"+pn.getTongTien()+"' WHERE MaPhieu = '"+pn.getMaPhieu()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update phiếu không thành công !");
        }
        return update;
    }
//QL_KhuVuc
    public Vector GetKV(){
        Vector arrloai = null;
        String sql = "Select * From khuvuc";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrloai = new Vector();
            KhuVuc all = new KhuVuc(0, "Tất cả khu vực");
            arrloai.add(all);            
            while(rs.next()){
                KhuVuc kv = new KhuVuc(rs.getInt(1), rs.getString(2));
                arrloai.add(kv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrloai; 
    }
    
    
    
    public int InsertKV(KhuVuc kv){
        int insert = 0;
        String sql = "Insert into khuvuc ( TenKhuVuc) values ('"+kv.getTenKhuVuc()+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
        }
        return insert;
    }
 
    public boolean DeleteKV(ArrayList<Integer> listMaKV){
        boolean check = false;
        try{
            String sql;
            
            for(int ma : listMaKV){
                sql = "Delete From khuvuc Where MaKhuVuc = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    public boolean DeleteBanMaKV(ArrayList<Integer> listMaKV){
        boolean check = false;
        try{
            String sql;
            for(int ma : listMaKV){
                sql = "Delete From ban Where MaKhuVuc = '"+ma+"'";
                Statement st = cn.createStatement();
                st.executeUpdate(sql);
            } 
            check = true;
        }catch(SQLException ex){
            
        }
        return check;
    }
    public ArrayList<KhuVuc> GetKV(int ma){
       ArrayList<KhuVuc> arrKhuVuc = null;
        String sql;
            sql = "Select * From khuvuc where MaKhuVuc = '"+ma+"' ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrKhuVuc = new ArrayList<KhuVuc>();
            while(rs.next()){
                KhuVuc kv = new KhuVuc(rs.getInt(1),rs.getString(2));
                arrKhuVuc.add(kv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrKhuVuc; 
    }
    
    public int UpdateKV(KhuVuc kv){
        int update = 0;
        String sql = "UPDATE khuvuc SET TenKhuVuc = '"+kv.getTenKhuVuc()+"' WHERE MaKhuVuc = '"+kv.getMaKhuVuc()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Update khu vực không thành công !");
        }
        return update;
    }  


public Vector GetbantheoKV(int maban){
        Vector arrKV = null;
        String sql = "Select MaKhuVuc From ban Where MaBan='"+maban+"' ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrKV = new Vector();            
            while(rs.next()){                              
                arrKV.add(rs.getInt(1));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrKV; 
    }
public ArrayList<Ban> GetBanTheoKV(int ma){
       ArrayList<Ban> arrBan = null;
        String sql;
            sql = "Select * From ban where MaKhuVuc = '"+ma+"' ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrBan = new ArrayList<Ban>();
            while(rs.next()){
                Ban kv = new Ban(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
                arrBan.add(kv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
        }
        return arrBan; 
    }

    public int UpdateMK(TaiKhoan tkn) {
         int update = 0;
         String sql = "UPDATE nhanvien SET MatKhau ='"+tkn.GetPassword()+"'  WHERE MaNV = '"+tkn.GetMaNV()+"'";
        try{
            Statement st = cn.createStatement();
            update = st.executeUpdate(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return update;
    }
    
    public ArrayList<ThucDon> GetChiTietMonByMa(){
        ArrayList<ThucDon> arrDs = null;
        String sql;
            sql = "SELECT TenMon, MaMon, DVT FROM thucdon where MaMon in (Select MaMon From chitiethd)";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<ThucDon>();
            while(rs.next()){
                ThucDon order = new ThucDon();
                order.SetTenMon(rs.getString(1));
                order.SetMaMon(rs.getString(2));
                order.SetDVT(rs.getString(3));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }  

    public ArrayList<DsOrder> GetGiaSoLuong(String ma){
        ArrayList<DsOrder> arrDs = null;
        String sql;
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND ct.MaMon = '"+ma+"'";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }
    
    public ArrayList<TaiKhoan> GetMaNV() {
        ArrayList<TaiKhoan> arrtk = null;
        String sql;
            sql = "Select MaNV From nhanvien";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrtk = new ArrayList<TaiKhoan>();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getString(1));
                arrtk.add(tk);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getErrorCode());
        }
        return arrtk;
    }
    
    public ArrayList<HoaDon> GetDSHD1() {
        ArrayList<HoaDon> arrDs = null;
        String sql;
            sql = "Select * From hoadon Where TrangThai =1 ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while(rs.next()){
                HoaDon order = new HoaDon(rs.getString(2));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;         //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<HoaDon> GetHdByDate2(String d1, String d2){
        ArrayList<HoaDon> arrDs = null;
        String sql;
//        if(d1.equals(d2))
//            sql = "Select * From hoadon Where GioDen >= '"+d1+"'";
//            else
            sql = "Select * From hoadon Where GioDen BETWEEN '"+d1+"' AND '"+d2+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while(rs.next()){
                HoaDon order = new HoaDon(rs.getInt(1),rs.getString(2) ,rs.getInt(3), rs.getInt(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
        }
        return arrDs;        
    }   
    
    public ArrayList<DsOrder> GetHdByDate(String d1,String d2, String m){
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if(d1.equals(d2)){
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen >= '"+d1+"' AND ct.MaMon ='"+m+"'";
        }else
            sql = "Select Gia, SoLuong, TenMon, DVT From chitiethd AS ct INNER JOIN hoadon AS hd ON ct.MaHoaDon = hd.MaHoaDon INNER JOIN thucdon AS td ON td.MaMon = ct.MaMon Where hd.TrangThai = 1 AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"' AND ct.MaMon ='"+m+"'";
        try{
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder();
                order.SetGia(rs.getInt(1));
                order.SetSoLuong(rs.getInt(2));
                order.SetTenMon(rs.getString(3));
                order.SetDVT(rs.getString(4));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }
    
    
    
    public ArrayList<HoaDon> GetDSHD(){
        ArrayList<HoaDon> arrDs = null;
        String sql;
            sql = "Select * From hoadon Where TrangThai =1 ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HoaDon>();
            while(rs.next()){
                HoaDon order = new HoaDon(rs.getInt(1),rs.getString(2) ,rs.getInt(3), rs.getInt(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7));
                arrDs.add(order);
            }
        }catch(SQLException ex){
        }
        return arrDs;        
    }
    
    public ArrayList<DsOrder> GetCtHDByDate(int ma, String d1, String d2){
        ArrayList<DsOrder> arrDs = null;
        String sql;
        if(d1.equals(d2))
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen >= '"+d1+"'";
            else
            sql = "Select ct.MaMon, TenMon, DVT, SoLuong, Gia, ct.MaHoaDon From chitiethd AS ct INNER JOIN thucdon AS td ON ct.MaMon = td.MaMon INNER JOIN hoadon AS hd ON hd.MaHoaDon = ct.MaHoaDon Where ct.MaHoaDon = '"+ma+"' AND hd.GioDen BETWEEN '"+d1+"' AND '"+d2+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<DsOrder>();
            while(rs.next()){
                DsOrder order = new DsOrder(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
        }
        return arrDs;        
    }   
    
    public int InsertCaLam(String maNV,String gioLam,String GioKT,String ngay,int soTien){
        int insert = 0;
        String sql = "Insert into calamviec (MaNV,GioBDThucTe,GioKTThucTe,NgayLam,TienChotCa) "
                + "values ('"+maNV+"', '"+gioLam+"', '"+GioKT+"', '"+ngay+"', '"+soTien+"')";
        try{
            Statement st = cn.createStatement();
            insert = st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return insert;
    }
    
    public ArrayList<HD1Month> GetHDThang() {
        ArrayList<HD1Month> arrDs = null;
        String sql;
            sql = "Select MaHoaDon,TongTien,GioDen From hoadon "
                    + "Where TrangThai =1 ";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<HD1Month>();
            while(rs.next()){
                HD1Month i = new HD1Month(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3));
                arrDs.add(i);
            }
        }catch(SQLException ex){
        }
        return arrDs;         //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<CaLamViec> GetCtCaLam(String d1, String d2){
        ArrayList<CaLamViec> arrDs = null;
        String sql;
        if(d1.equals(d2))
            sql = "Select * From calamviec Where NgayLam >= '"+d1+"'";
            else
            sql = "Select * From calamviec Where NgayLam BETWEEN '"+d1+"' AND '"+d2+"'";
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<CaLamViec>();
            while(rs.next()){
                CaLamViec order = new CaLamViec(rs.getInt(1), rs.getInt(6),rs.getString(2), rs.getTime(3), rs.getTime(4), rs.getDate(5));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
        }
        return arrDs;        
    }   
    
    public ArrayList<CaLamViec> GetCtCaLam(){
        ArrayList<CaLamViec> arrDs = null;
        String sql= "Select * From calamviec" ;
 
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            arrDs = new ArrayList<CaLamViec>();
            while(rs.next()){
                CaLamViec order = new CaLamViec(rs.getInt(1), rs.getInt(6),rs.getString(2), rs.getTime(3), rs.getTime(4), rs.getDate(5));
                arrDs.add(order);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách chi tiết hoa đơn !"+ex.toString());
        }
        return arrDs;        
    }   
}


