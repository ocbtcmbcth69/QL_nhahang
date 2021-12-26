/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QuanLy;

import Interface.Run;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class QuanLy_UI extends javax.swing.JFrame {
    /**
     * Creates new form QuanLy_UI
     */
    public QuanLy_UI() {
        initComponents();
        LoadPanel(2);
        //Set tên NV
        String text = "Xin chào,"+Run.tk.getTenNV();
        lblQTV.setText(text);
        
        //Set thời gian
        Clock clock= new Clock(); 
        clock.start();
    }
    QL_Ban ban;
    QL_ThucDon td;
    QL_NhomMon nm;
    QL_TaiKhoan nv;
    QL_PhieuNhap pn;
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    public class Clock extends Thread{ 
    public Clock(){    } 
    @Override
    public void run(){ 
        while(true){ 
            Calendar calendar = Calendar.getInstance();                
            String str;  
            str= sdf.format(calendar.getTime()); 
            lblTime.setText(str); 
        try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
      } 
    }
    }
    public void LoadPanel(int i){
        jContent.removeAll();
        switch (i){ 
            case 1:
                if(ban == null){
                    ban = new QL_Ban();
                }
                jContent.add(ban);
                break;  
            case 2:
                if(td == null){
                    td = new QL_ThucDon();
                }
                jContent.add(td);                
                break;
            case 3:
                if(nm == null){
                    nm = new QL_NhomMon();
                }
                jContent.add(nm);                
                break; 
            case 4:
                if(nv == null){
                    nv = new QL_TaiKhoan();
                }
                jContent.add(nv);
                break;
            case 5:
                if(pn == null){
                    pn = new QL_PhieuNhap();
                }
                jContent.add(pn);
            default:
                break;
                
        }
        jContent.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPmenu = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblQTV = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jMenuTab = new javax.swing.JPanel();
        menuChose = new javax.swing.JPanel();
        btn_QLNhomMon = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btn_QLThucDon = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btn_QLNV = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btn_QLBan = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_QLThucDon1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1237, 736));

        jPmenu.setBackground(new java.awt.Color(0, 153, 153));

        btn_home.setBackground(new java.awt.Color(0, 153, 153));
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_home_page_38px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trang chủ");

        javax.swing.GroupLayout btn_homeLayout = new javax.swing.GroupLayout(btn_home);
        btn_home.setLayout(btn_homeLayout);
        btn_homeLayout.setHorizontalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_homeLayout.setVerticalGroup(
            btn_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(btn_homeLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Quản lý");

        lblQTV.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        lblQTV.setForeground(new java.awt.Color(255, 255, 255));
        lblQTV.setText("Xin chào");

        lblTime.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("jLabel5");

        javax.swing.GroupLayout jPmenuLayout = new javax.swing.GroupLayout(jPmenu);
        jPmenu.setLayout(jPmenuLayout);
        jPmenuLayout.setHorizontalGroup(
            jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                .addGroup(jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQTV)
                    .addComponent(lblTime))
                .addGap(213, 213, 213))
        );
        jPmenuLayout.setVerticalGroup(
            jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPmenuLayout.createSequentialGroup()
                        .addComponent(lblQTV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1341, 659));

        jMenuTab.setBackground(new java.awt.Color(0, 153, 153));
        jMenuTab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuChose.setBackground(new java.awt.Color(0, 153, 153));

        btn_QLNhomMon.setBackground(new java.awt.Color(0, 153, 153));
        btn_QLNhomMon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QLNhomMonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_QLNhomMonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_QLNhomMonMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_test_passed_25px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Quản lý nhóm món");

        javax.swing.GroupLayout btn_QLNhomMonLayout = new javax.swing.GroupLayout(btn_QLNhomMon);
        btn_QLNhomMon.setLayout(btn_QLNhomMonLayout);
        btn_QLNhomMonLayout.setHorizontalGroup(
            btn_QLNhomMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLNhomMonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(btn_QLNhomMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_QLNhomMonLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_QLNhomMonLayout.setVerticalGroup(
            btn_QLNhomMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLNhomMonLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(btn_QLNhomMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_QLThucDon.setBackground(new java.awt.Color(0, 153, 153));
        btn_QLThucDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QLThucDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_QLThucDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_QLThucDonMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_food_25px.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quản lý thực đơn");

        javax.swing.GroupLayout btn_QLThucDonLayout = new javax.swing.GroupLayout(btn_QLThucDon);
        btn_QLThucDon.setLayout(btn_QLThucDonLayout);
        btn_QLThucDonLayout.setHorizontalGroup(
            btn_QLThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLThucDonLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(btn_QLThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_QLThucDonLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_QLThucDonLayout.setVerticalGroup(
            btn_QLThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLThucDonLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(btn_QLThucDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_QLNV.setBackground(new java.awt.Color(0, 153, 153));
        btn_QLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QLNVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_QLNVMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_QLNVMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_folder_25px.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quản lý nhân viên");

        javax.swing.GroupLayout btn_QLNVLayout = new javax.swing.GroupLayout(btn_QLNV);
        btn_QLNV.setLayout(btn_QLNVLayout);
        btn_QLNVLayout.setHorizontalGroup(
            btn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLNVLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(btn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_QLNVLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_QLNVLayout.setVerticalGroup(
            btn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLNVLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(btn_QLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_QLBan.setBackground(new java.awt.Color(0, 153, 153));
        btn_QLBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QLBanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_QLBanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_QLBanMouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_restaurant_table_25px.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quản lý bàn,khu vực");
        jLabel11.setMaximumSize(new java.awt.Dimension(0, 27));
        jLabel11.setMinimumSize(new java.awt.Dimension(0, 27));

        javax.swing.GroupLayout btn_QLBanLayout = new javax.swing.GroupLayout(btn_QLBan);
        btn_QLBan.setLayout(btn_QLBanLayout);
        btn_QLBanLayout.setHorizontalGroup(
            btn_QLBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLBanLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(btn_QLBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_QLBanLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_QLBanLayout.setVerticalGroup(
            btn_QLBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLBanLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(btn_QLBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_QLBanLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_QLThucDon1.setBackground(new java.awt.Color(0, 153, 153));
        btn_QLThucDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_QLThucDon1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_QLThucDon1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_QLThucDon1MouseExited(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-document-25.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Quản lý phiếu nhập");

        javax.swing.GroupLayout btn_QLThucDon1Layout = new javax.swing.GroupLayout(btn_QLThucDon1);
        btn_QLThucDon1.setLayout(btn_QLThucDon1Layout);
        btn_QLThucDon1Layout.setHorizontalGroup(
            btn_QLThucDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLThucDon1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(btn_QLThucDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btn_QLThucDon1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_QLThucDon1Layout.setVerticalGroup(
            btn_QLThucDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_QLThucDon1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(btn_QLThucDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout menuChoseLayout = new javax.swing.GroupLayout(menuChose);
        menuChose.setLayout(menuChoseLayout);
        menuChoseLayout.setHorizontalGroup(
            menuChoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuChoseLayout.createSequentialGroup()
                .addGroup(menuChoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_QLNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_QLThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_QLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_QLBan, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_QLThucDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        menuChoseLayout.setVerticalGroup(
            menuChoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuChoseLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btn_QLBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_QLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_QLNhomMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_QLThucDon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_QLThucDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );

        jMenuTab.add(menuChose, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 230, 720));

        jContent.setBackground(new java.awt.Color(255, 255, 255));
        jContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jMenuTab, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(225, Short.MAX_VALUE)
                    .addComponent(jContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMenuTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jContent, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1237, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 821, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1237, 821));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        setColorMenu(btn_home);
        this.setVisible(false);
        Run.QLCF();
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        setColorMenu(btn_home);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        resetColorMenu(btn_home);
    }//GEN-LAST:event_btn_homeMouseExited
    
    private void btn_QLNhomMonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNhomMonMouseClicked
        setColorMenu(btn_QLNhomMon);
        if(nm == null){
            nm = new QL_NhomMon();
        }
        jContent.removeAll();
        jContent.add(nm);
        jContent.updateUI();
    }//GEN-LAST:event_btn_QLNhomMonMouseClicked

    private void btn_QLNhomMonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNhomMonMouseEntered
        setColorMenu(btn_QLNhomMon);
    }//GEN-LAST:event_btn_QLNhomMonMouseEntered

    private void btn_QLNhomMonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNhomMonMouseExited
        resetColorMenu(btn_QLNhomMon);
    }//GEN-LAST:event_btn_QLNhomMonMouseExited

    private void btn_QLThucDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDonMouseClicked
        setColorMenu(btn_QLThucDon);
        if(td == null){
            td = new QL_ThucDon();
        }
        jContent.removeAll();
        jContent.add(td);
        jContent.updateUI();
    }//GEN-LAST:event_btn_QLThucDonMouseClicked

    private void btn_QLThucDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDonMouseEntered
        setColorMenu(btn_QLThucDon);
    }//GEN-LAST:event_btn_QLThucDonMouseEntered

    private void btn_QLThucDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDonMouseExited
        resetColorMenu(btn_QLThucDon);
    }//GEN-LAST:event_btn_QLThucDonMouseExited

    private void btn_QLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNVMouseClicked
        setColorMenu(btn_QLNV);
        if(nv == null){
            nv = new QL_TaiKhoan();
        }
        jContent.removeAll();
        jContent.add(nv);
        jContent.updateUI();
    }//GEN-LAST:event_btn_QLNVMouseClicked

    private void btn_QLNVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNVMouseEntered
        setColorMenu(btn_QLNV);
    }//GEN-LAST:event_btn_QLNVMouseEntered

    private void btn_QLNVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLNVMouseExited
        resetColorMenu(btn_QLNV);
    }//GEN-LAST:event_btn_QLNVMouseExited

    private void btn_QLBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLBanMouseClicked
        setColorMenu(btn_QLBan);
        if(ban == null){
            ban = new QL_Ban();
        }
        jContent.removeAll();
        jContent.add(ban);
        jContent.updateUI();
    }//GEN-LAST:event_btn_QLBanMouseClicked

    private void btn_QLBanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLBanMouseEntered
        setColorMenu(btn_QLBan);
    }//GEN-LAST:event_btn_QLBanMouseEntered

    private void btn_QLBanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLBanMouseExited
        resetColorMenu(btn_QLBan);
    }//GEN-LAST:event_btn_QLBanMouseExited

    private void btn_QLThucDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDon1MouseClicked
        setColorMenu(btn_QLThucDon1);
        if(pn == null){
            pn = new QL_PhieuNhap();
        }
        jContent.removeAll();
        jContent.add(pn);
        jContent.updateUI();
    }//GEN-LAST:event_btn_QLThucDon1MouseClicked

    private void btn_QLThucDon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDon1MouseEntered
        setColorMenu(btn_QLThucDon1);
    }//GEN-LAST:event_btn_QLThucDon1MouseEntered

    private void btn_QLThucDon1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_QLThucDon1MouseExited
        resetColorMenu(btn_QLThucDon1);
    }//GEN-LAST:event_btn_QLThucDon1MouseExited
    
    public void setColorMenu(JPanel panel){
        panel.setBackground(new Color(73, 190, 183));
    }
    
    public void resetColorMenu(JPanel panel){
        panel.setBackground(new Color(0,153,153));
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_QLBan;
    private javax.swing.JPanel btn_QLNV;
    private javax.swing.JPanel btn_QLNhomMon;
    private javax.swing.JPanel btn_QLThucDon;
    private javax.swing.JPanel btn_QLThucDon1;
    private javax.swing.JPanel btn_home;
    private javax.swing.JPanel jContent;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jMenuTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPmenu;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblQTV;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel menuChose;
    // End of variables declaration//GEN-END:variables
}
