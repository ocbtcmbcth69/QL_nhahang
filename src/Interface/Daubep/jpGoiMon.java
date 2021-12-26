/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Daubep;

import Interface.BanHang.*;
import Interface.Run;
import Models.Ban;
import Models.DsOrder;
import Models.HoaDon;
import Models.ThucDon;
import Mysql.ConnectMySql;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author ASUS
 */
public class jpGoiMon extends javax.swing.JPanel {

    String TenBan;
    int MaBan;
    int MaHD, tienmon = 0, tongtien = 0;
    ConnectMySql cn = new ConnectMySql();
    HoaDon arrhd;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    ArrayList<DsOrder> order;
    public static jpGoiMon gm;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
    
    
    /**
     * Creates new form jGoiMon
     * @param trangthai
     * @param tenban
     * @param maban
     */
    public jpGoiMon(String trangthai, String tenban, int maban) {
        initComponents();
        gm = this;
        MaBan = maban;
        TenBan = tenban;
        
        jDSMon.setVisible(false);
        jpThongTinThanhToan.setVisible(false);
        jScrollPane1.setVisible(false);
        
        arrhd = cn.GetHDbyMaBan(maban);
        if(arrhd != null){
            order = cn.GetDsOrder(arrhd.GetMaHD());
            fillDsMon(0);
            MaHD = arrhd.GetMaHD();
            lblGioDen.setText(df.format(arrhd.GetGioDen()));  
        }
        lblTenBan.setText(tenban);
        lblTrangThai.setText(trangthai);

        if(lblTrangThai.getText().equals("Trống")){
            btn_DatCho.setText("Đặt chỗ");
            return;
            
        }if(lblTrangThai.getText().equals("Đã đặt trước")){
            btn_DatCho.setText("Hủy đặt");
            return;
        }if(lblTrangThai.getText().equals("Đang phục vụ")){
            btn_DatCho.setVisible(false);
            btn_Back.setVisible(false);
            jpThucDon thucdon = new jpThucDon();
            thucdon.tenban = TenBan;
            thucdon.maban = maban;
            jpThucDon.removeAll();
            jpThucDon.add(thucdon);
            jpThucDon.updateUI();
        }         
    }

    public void fillDsMon(int mahd){
        if(mahd != 0){
            order = cn.GetDsOrder(mahd);
            arrhd = cn.GetHDbyMaBan(MaBan);
            tienmon = 0;
        }
        mahd = MaHD;
        if(order != null){
            jDSMon.setVisible(true);
            jpThongTinThanhToan.setVisible(true);
            jScrollPane1.setVisible(true);
            btn_GoiMon.setText("Done");
                     
            JPanel[] pn = new JPanel[order.size()];
            jDSMon.removeAll();
            jDSMon.setLayout(new BoxLayout(jDSMon, BoxLayout.Y_AXIS));
            for(int i=0;i<order.size();i++){
                tienmon += order.get(i).GetGia() * order.get(i).GetSoLuong();
                pn[i] = new JPanel();
                pn[i].setName(order.get(i).GetMaMon());
                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                pn[i].setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
                pn[i].setBackground(Color.decode("#9AF1FF"));
                pn[i].setLayout(new GridLayout());
                pn[i].setPreferredSize(new Dimension(335, 50));
                pn[i].setMaximumSize(new Dimension(335, 50));
                pn[i].setMinimumSize(new Dimension(335, 50));
                pn[i].add(new JLabel(order.get(i).GetTenMon(),JLabel.CENTER)).setForeground(Color.decode("#001a66"));
                pn[i].add(new JLabel(String.valueOf(chuyentien.format(order.get(i).GetGia()))+" VNĐ",JLabel.CENTER)).setForeground(Color.decode("#ff0000"));
                pn[i].add(new JLabel(String.valueOf(order.get(i).GetSoLuong())+" "+ order.get(i).GetDVT(),JLabel.RIGHT)).setForeground(Color.decode("#008000"));
//                Icon ic = new ImageIcon("/Images/DeleteRed.png");
//                JLabel lbl = new JLabel("", ic,JLabel.CENTER);                
                JLabel lbl = new JLabel("           X");

                lbl.setForeground(Color.decode("#030303"));
                lbl.setName(order.get(i).GetMaMon());
                pn[i].add(lbl).addMouseListener(new MouseAdapter() {
                  @Override
                    public void mouseClicked(MouseEvent e){
                        int qs;
                        ArrayList<ThucDon> td = cn.GetThucDonByMa(e.getComponent().getName());
                        
                        qs = JOptionPane.showConfirmDialog(null, "Hủy món: "+td.get(0).GetTenMon()+" ?", "Hủy món", JOptionPane.YES_NO_OPTION);
                        if (qs == JOptionPane.YES_OPTION) {
                            int xoa = cn.DeleteMon(e.getComponent().getName(),MaHD, MaBan);
                            if(xoa == 1){
                                fillDsMon(MaHD);
                            }
                            if(xoa == 2){
                                fillDsMon(MaHD);
                                HuyHD();
                            }
                        }
                    }
                });
                pn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e){
                        DLSoLuong sl = new DLSoLuong(Run.menuBan, true, e.getComponent().getName(), TenBan, MaBan);
                        sl.setVisible(true);
                    }
                });
                jDSMon.add(pn[i]);
                jDSMon.updateUI();
                
            }

            fillThongTin();
        }        
    }
    
    public void fillThongTin(){
        arrhd = cn.GetHDbyMaBan(MaBan);
        MaHD = arrhd.GetMaHD();
        int ck = cn.CheckDsMon(MaHD, MaBan);
        btn_GoiMon.setVisible(true);
        if(ck == 0){
            HuyHD();
            btn_GoiMon.setVisible(false);
        }
        
        if(arrhd.GetGiamGia() > 100){
            lblGiamGia.setText(chuyentien.format(arrhd.GetGiamGia())+" VNĐ");
            if(tienmon - arrhd.GetGiamGia() <= 0){
                tongtien = 0;
                lblThanhTien.setText("0 VNĐ");
            }else{
                tongtien = tienmon - arrhd.GetGiamGia();
                lblThanhTien.setText(String.valueOf(chuyentien.format(tongtien))+" VNĐ");
            }
        }
        if(arrhd.GetGiamGia() <= 100){
            tongtien = tienmon - (tienmon * arrhd.GetGiamGia() / 100);
            lblThanhTien.setText(String.valueOf(chuyentien.format(tongtien))+" VNĐ");
            lblGiamGia.setText(String.valueOf(arrhd.GetGiamGia())+" %");
        }
        lblTienMon.setText(String.valueOf(chuyentien.format(tienmon))+" VNĐ");        
    }
    
    private void HuyHD(){
        
        JButton btnhuy = new JButton("Hủy bàn");
        btnhuy.setPreferredSize(new Dimension(100, 40));
        btnhuy.setBounds(100, 50, 100, 40);
        btnhuy.setBackground(Color.decode("#0033CC"));
        btnhuy.setForeground(Color.white);
        jDSMon.setLayout(null);
        btn_Back.setVisible(false);
        jpThongTinThanhToan.setVisible(false);
        btnhuy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Ban b = new Ban();
                b.SetTrangThai("Trống");
                b.SetMaBan(MaBan);
                cn.UpDateTrangThaiBan(b);

                Daubep_UI.bh.loadKhuVuc();
                jpGoiMon.gm.removeAll();
                Daubep_UI.bh.fillLb();

                HoaDon hd = new HoaDon();
                hd.SetMaHD(MaHD);
                cn.HuyHD(hd);
            }
        });
        jDSMon.add(btnhuy);
        jDSMon.updateUI();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTtinBan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDSMon = new javax.swing.JPanel();
        jpThongTinThanhToan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTienMon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_GoiMon = new javax.swing.JButton();
        btn_DatCho = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTenBan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGioDen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        jpThucDon = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(833, 641));

        jTtinBan.setBackground(new java.awt.Color(255, 255, 255));
        jTtinBan.setPreferredSize(new java.awt.Dimension(360, 631));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(342, 246));

        jDSMon.setBackground(new java.awt.Color(255, 255, 255));
        jDSMon.setMaximumSize(new java.awt.Dimension(342, 246));
        jDSMon.setPreferredSize(new java.awt.Dimension(344, 300));
        jDSMon.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(jDSMon);

        jpThongTinThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        jpThongTinThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpThongTinThanhToanMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Tiền món : ");

        lblTienMon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblTienMon.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setText("Giảm giá : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Thành tiền : ");

        lblGiamGia.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblGiamGia.setText("0");

        lblThanhTien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        lblThanhTien.setForeground(new java.awt.Color(255, 0, 0));
        lblThanhTien.setText("0");

        javax.swing.GroupLayout jpThongTinThanhToanLayout = new javax.swing.GroupLayout(jpThongTinThanhToan);
        jpThongTinThanhToan.setLayout(jpThongTinThanhToanLayout);
        jpThongTinThanhToanLayout.setHorizontalGroup(
            jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(lblThanhTien))
                    .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                        .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTienMon)
                            .addComponent(lblGiamGia))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jpThongTinThanhToanLayout.setVerticalGroup(
            jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpThongTinThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTienMon))
                .addGap(10, 10, 10)
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGiamGia)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jpThongTinThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblThanhTien))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 15));

        btn_GoiMon.setBackground(new java.awt.Color(0, 51, 204));
        btn_GoiMon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btn_GoiMon.setForeground(new java.awt.Color(255, 255, 255));
        btn_GoiMon.setText("Gọi món");
        btn_GoiMon.setMinimumSize(new java.awt.Dimension(1, 34));
        btn_GoiMon.setPreferredSize(new java.awt.Dimension(120, 50));
        btn_GoiMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GoiMonMouseClicked(evt);
            }
        });
        btn_GoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GoiMonActionPerformed(evt);
            }
        });
        jPanel1.add(btn_GoiMon);

        btn_DatCho.setBackground(new java.awt.Color(0, 51, 204));
        btn_DatCho.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        btn_DatCho.setForeground(new java.awt.Color(255, 255, 255));
        btn_DatCho.setText("Đặt chỗ");
        btn_DatCho.setPreferredSize(new java.awt.Dimension(120, 50));
        btn_DatCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_DatChoMouseClicked(evt);
            }
        });
        jPanel1.add(btn_DatCho);

        btn_Back.setBackground(new java.awt.Color(0, 51, 204));
        btn_Back.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btn_Back.setForeground(new java.awt.Color(255, 255, 255));
        btn_Back.setText("Trở lại");
        btn_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BackMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Back);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        lblTenBan.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        lblTenBan.setText("Bàn");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel2.setText("Giờ đến : ");

        lblGioDen.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        lblGioDen.setForeground(new java.awt.Color(0, 153, 0));
        lblGioDen.setText("...");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setText("Trạng thái :");

        lblTrangThai.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        lblTrangThai.setForeground(new java.awt.Color(255, 0, 0));
        lblTrangThai.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblTenBan)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrangThai))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(lblGioDen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTenBan)))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGioDen)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTrangThai)
                    .addComponent(jLabel3)))
        );

        javax.swing.GroupLayout jTtinBanLayout = new javax.swing.GroupLayout(jTtinBan);
        jTtinBan.setLayout(jTtinBanLayout);
        jTtinBanLayout.setHorizontalGroup(
            jTtinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTtinBanLayout.createSequentialGroup()
                .addGroup(jTtinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jTtinBanLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jTtinBanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jTtinBanLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jpThongTinThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jTtinBanLayout.setVerticalGroup(
            jTtinBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTtinBanLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpThongTinThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpThucDon.setBackground(new java.awt.Color(255, 255, 255));
        jpThucDon.setLayout(new java.awt.BorderLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgMenu.png"))); // NOI18N
        jpThucDon.add(jLabel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTtinBan, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTtinBan, javax.swing.GroupLayout.PREFERRED_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jpThucDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTtinBan.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GoiMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GoiMonMouseClicked
        if(btn_GoiMon.getText().equals("Hủy bàn")){

            jpThucDon.removeAll();
            jpThucDon.add(jLabel1);
            jpThucDon.updateUI();
            jpThongTinThanhToan.setVisible(false);
            btn_Back.setVisible(true);
            lblGioDen.setText("......");
            lblTrangThai.setText("Trống");
            String TrangThai = "Trống";
            Ban b = new Ban(MaBan, lblTenBan.getText(), TrangThai);
            int Update = cn.UpdateBan(b);
            Daubep_UI.bh.loadKhuVuc();
            btn_GoiMon.setText("Gọi món");
            btn_DatCho.setVisible(true);
            btn_DatCho.setText("Đặt bàn");
            return;

        }if(btn_GoiMon.getText().equals("Thanh toán")){
            DLThanhToan thanhtoan = new DLThanhToan(Run.QlCafe, true, tongtien, TenBan, MaBan, MaHD);//tongtien trang thai ban ten ban
            thanhtoan.setVisible(true);
            return;
        }
        if(btn_GoiMon.getText().equals("Gọi món")){
            jpThucDon.setVisible(true);
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lblGioDen.setText(df.format(date));
            lblTrangThai.setText("Đang phục vụ");
            btn_DatCho.setVisible(false);
            btn_Back.setVisible(false);
            btn_GoiMon.setText("Hủy bàn");

            jpThucDon thucdon;
            thucdon = new jpThucDon();
            thucdon.maban = MaBan;
            thucdon.tenban = TenBan;

            thucdon.gioden = sf.format(date);
            jpThucDon.removeAll();
            jpThucDon.add(thucdon);
            jpThucDon.revalidate();
        }
    }//GEN-LAST:event_btn_GoiMonMouseClicked

    private void btn_DatChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_DatChoMouseClicked
        if(lblTrangThai.getText().equals("Đã đặt trước")){
            lblTrangThai.setText("Trống");
            btn_DatCho.setText("Đặt chỗ");           
            String TrangThai = "Trống";
            Ban b = new Ban(MaBan, TenBan, TrangThai);
            int Update = cn.UpdateBan(b);
            Daubep_UI.bh.loadKhuVuc();
//            Daubep_UI.bh.updateUI();
        }else{
            lblTrangThai.setText("Đã đặt trước");
            btn_DatCho.setText("Hủy đặt");
            String TrangThai = "Đã đặt trước";
            Ban b = new Ban(MaBan, TenBan, TrangThai);
            int Update = cn.UpdateBan(b);
            Daubep_UI.bh.loadKhuVuc();
//            jpBanHang.bh.updateUI();
//            Run.QlCafe.reloadPanel(1, MaBan);            
        }
    }//GEN-LAST:event_btn_DatChoMouseClicked

    private void jpThongTinThanhToanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongTinThanhToanMousePressed
        DLGiamGia giam = new DLGiamGia(Run.QlCafe, true, MaHD, TenBan, tienmon);
        giam.setVisible(true);
    }//GEN-LAST:event_jpThongTinThanhToanMousePressed

    private void btn_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BackMouseClicked
        Daubep_UI.bh.fillLb();
    }//GEN-LAST:event_btn_BackMouseClicked

    private void btn_GoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GoiMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GoiMonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_DatCho;
    private javax.swing.JButton btn_GoiMon;
    private javax.swing.JPanel jDSMon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jTtinBan;
    private javax.swing.JPanel jpThongTinThanhToan;
    private javax.swing.JPanel jpThucDon;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblGioDen;
    private javax.swing.JLabel lblTenBan;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTienMon;
    private javax.swing.JLabel lblTrangThai;
    // End of variables declaration//GEN-END:variables
}
