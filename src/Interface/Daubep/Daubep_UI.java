/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Daubep;

import Interface.Daubep.*;
import Interface.Daubep.jpGoiMon;
import Interface.Run;
import Models.Ban;
import Models.KhuVuc;
import Mysql.ConnectMySql;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author ASUS
 */
public class Daubep_UI extends javax.swing.JFrame {
    ConnectMySql cn = new ConnectMySql();
    ArrayList<KhuVuc> arrKV;
    ArrayList<Ban> arrBanRieng;    
    ArrayList<Ban> arrBanAll;
    ArrayList<Ban> ban;
    public static Daubep_UI bh;
    /**
     * Creates new form Home_UI
     */
    public Daubep_UI() {
        initComponents();
        bh = this;
        //Set tên NV
        String text = "Xin chào,"+Run.tk.getTenNV();
        lblQTV.setText(text);
        
        //Set thời gian
        Clock clock= new Clock(); 
        clock.start();
        
        //Load khu vực và bàn
        loadKhuVuc();
        
    }

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
    
    public void loadKhuVuc(){
        arrKV = cn.GetAllKhuVuc();
        jTabbedKV.removeAll();
        jTabbedKV.setFont(new java.awt.Font("Segoe UI Light", Font.PLAIN, 16));
        
        //Tab Tat ca
        JPanel jPanelAllBan = new JPanel();
        
        jPanelAllBan.setLayout(new FlowLayout(LEFT));        
        jPanelAllBan.setName("Tất cả");
//        JScrollPane scJp = new JScrollPane(jPanelAllBan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
//        jTabbedKV.add(scJp);
        jTabbedKV.add(jPanelAllBan);
        
        jPanelAllBan.removeAll();
        arrBanAll = cn.GetAllBan();
        JButton[] btn = new JButton[arrBanAll.size()];
        for (int i = 0; i < arrBanAll.size(); i++) {
            btn[i] = new JButton();
                btn[i].setName(String.valueOf(arrBanAll.get(i).GetMaBan()));
                String[] mb = arrBanAll.get(i).GetTenBan().split(" ");
                btn[i].setText(mb[1]);
                btn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_table_60px.png")));
                Border thickBorder = new LineBorder(Color.WHITE,6);
                btn[i].setBorder(thickBorder);
                btn[i].setBackground(Color.decode("#1AFF66"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                if(arrBanAll.get(i).GetTrangThai().equals("Đang phục vụ")){
                    btn[i].setBackground(Color.decode("#FF34BB"));
                }
                if(arrBanAll.get(i).GetTrangThai().equals("Đã đặt trước")){
                    btn[i].setBackground(Color.decode("#FFFF00"));
                }
                btn[i].setPreferredSize(new Dimension(93, 70));
                btn[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            jpGoiMon goimon;
                            ban = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                            if(ban != null){                            
                                goimon = new jpGoiMon(ban.get(0).GetTrangThai(),ban.get(0).GetTenBan(),ban.get(0).GetMaBan());
                                jAdd.removeAll();
                                jAdd.add(goimon);
                                jAdd.updateUI();
                            }
                        }                    
                });
                jPanelAllBan.add(btn[i]);
                jPanelAllBan.updateUI();
        }
        
        //Tab tung khu vuc
        JPanel[] pn = new JPanel[arrKV.size()];
        for (int i = 0; i < arrKV.size(); i++) {
            pn[i] = new JPanel();
            pn[i].setLayout(new FlowLayout(FlowLayout.LEFT));
            pn[i].setName(String.valueOf(arrKV.get(i).getTenKhuVuc()));
            jTabbedKV.add(pn[i]);
            
            arrBanRieng = cn.GetBanTheoKV(arrKV.get(i).getMaKhuVuc());
            JButton[] btnRieng = new JButton[arrBanRieng.size()];
            for (int j = 0; j < arrBanRieng.size(); j++) {
            btnRieng[j] = new JButton();
                btnRieng[j].setName(String.valueOf(arrBanRieng.get(j).GetMaBan()));
                String[] mb = arrBanRieng.get(j).GetTenBan().split(" ");
                btnRieng[j].setText(mb[1]);
                btnRieng[j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_table_60px.png")));
                Border thickBorder = new LineBorder(Color.WHITE,6);
                btnRieng[j].setBorder(thickBorder);
                btnRieng[j].setBackground(Color.decode("#1AFF66"));
                btnRieng[j].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                btnRieng[j].setForeground(new java.awt.Color(51, 51, 51));
                if(arrBanRieng.get(j).GetTrangThai().equals("Đang phục vụ")){
                    btnRieng[j].setBackground(Color.decode("#FF34BB"));
                }
                if(arrBanRieng.get(j).GetTrangThai().equals("Đã đặt trước")){
                    btnRieng[j].setBackground(Color.decode("#FFFF00"));
                }                
                btnRieng[j].setPreferredSize(new Dimension(93, 70));
                btnRieng[j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mousePressed(MouseEvent e) {
                            jpGoiMon goimon2;
                            ban = cn.GetBan(Integer.parseInt(e.getComponent().getName()));
                            if(ban != null){                            
                                goimon2 = new jpGoiMon(ban.get(0).GetTrangThai(),ban.get(0).GetTenBan(),ban.get(0).GetMaBan());
                                jAdd.removeAll();
                                jAdd.add(goimon2);
                                jAdd.updateUI();
                            }
                        }                    
                });
                pn[i].add(btnRieng[j]);
                pn[i].updateUI();
            }
        }
    }
    
    public void fillLb(){
        jAdd.removeAll();
        jAdd.add(jLabel10);
        jAdd.updateUI();        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jPmenu = new javax.swing.JPanel();
        btn_home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblQTV = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLayout = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTabbedKV = new javax.swing.JTabbedPane();
        jAdd = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPmenu.setBackground(new java.awt.Color(174, 124, 90));

        btn_home.setBackground(new java.awt.Color(174, 124, 90));
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

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bán hàng");

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
                .addGap(360, 360, 360)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 403, Short.MAX_VALUE)
                .addGroup(jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQTV)
                    .addComponent(lblTime))
                .addGap(152, 152, 152))
        );
        jPmenuLayout.setVerticalGroup(
            jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPmenuLayout.createSequentialGroup()
                .addGroup(jPmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPmenuLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1))
                    .addGroup(jPmenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQTV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTime)))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(btn_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayout.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(26, 255, 102));
        jLabel2.setText("           ");
        jLabel2.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel5.setText("Bàn trống");

        jLabel6.setBackground(new java.awt.Color(255, 52, 187));
        jLabel6.setText("           ");
        jLabel6.setOpaque(true);

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setText("Đang phục vụ");

        jLabel8.setBackground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("           ");
        jLabel8.setOpaque(true);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel9.setText("Đã đặt trước");

        jTabbedKV.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedKV, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedKV, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(55, 55, 55))
        );

        jAdd.setBackground(new java.awt.Color(255, 255, 255));
        jAdd.setLayout(new java.awt.BorderLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgTable.jpg"))); // NOI18N
        jAdd.add(jLabel10, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jLayoutLayout = new javax.swing.GroupLayout(jLayout);
        jLayout.setLayout(jLayoutLayout);
        jLayoutLayout.setHorizontalGroup(
            jLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayoutLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 87, Short.MAX_VALUE))
        );
        jLayoutLayout.setVerticalGroup(
            jLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayoutLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1251, 704));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        resetColorMenu(btn_home);
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        setColorMenu(btn_home);
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        setColorMenu(btn_home);
        this.setVisible(false);
        Run.QLCF();
    }//GEN-LAST:event_btn_homeMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void setColorMenu(JPanel panel){
        panel.setBackground(new Color(168, 69, 0));
    }
    
    public void resetColorMenu(JPanel panel){
        panel.setBackground(new Color(174,124,90));
    }
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Daubep_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Daubep_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Daubep_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Daubep_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Daubep_UI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_home;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jLayout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPmenu;
    private javax.swing.JTabbedPane jTabbedKV;
    private javax.swing.JLabel lblQTV;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
