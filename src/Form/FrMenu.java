package Form;

import Tool.KoneksiDB;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class FrMenu extends javax.swing.JFrame {
    
    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;
    
    public FrMenu() {
        initComponents();
        Image image = new ImageIcon(getClass().getResource("/Image/Admin-Schoolar.png")).getImage();
       setIconImage(image);
        this.setExtendedState(this.getExtendedState() | FrMenu.MAXIMIZED_BOTH);
        
        disableMenu();
        txtIdUser.requestFocus(true);
    }
    
    private void disableMenu(){
        menuSistem(false);
        menuMaster(false);
        menuAkademik(false);
        menuMahasiswa(false);
        menuPegawai(false);
        menuUKT(false);
        
    }
    
    private void enableMenu(){
       
    }
    
    private void aksiLogin(){
        vid_user = txtIdUser.getText().replaceAll("'", "");
        vpass = txtPass.getText().replaceAll("'", "");
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from tbuser where id_user='"+vid_user+"' " 
                + " and pass ='"+vpass+"' ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            if ( res.first()){
                vnama_user = res.getString("nama_user");
                vlev_user = res.getString("lev_user");
                lbKeterangan.setText("ID.User : "+vid_user+" - "+vnama_user+
                        " || Lev User : "+vlev_user);
                panelLogin.setVisible(false);
                if(vlev_user.equals("Administrator")){
                    userAdmin();
                }else if(vlev_user.equals("Staf Akademik")){
                    userAkademik();
                }else if(vlev_user.equals("Staf Kepegawaian")){
                    userKepegawaian();
                }else if(vlev_user.equals("Staf Kemahasiswaan")){
                    userKemahasiswaan();
                }else if(vlev_user.equals("Staf Bag. Pembayaran UKT")){
                    userPembayaranUKT();
                }
            }else{
                JOptionPane.showMessageDialog(this, "ID.User dan Password Salah",
                        "Informasi",JOptionPane.INFORMATION_MESSAGE);
                
            }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error Method aksiLogin : "+ex);
        }
    }
    
    void menuSistem(Boolean sta){
        mnSistem.setVisible(sta);
    }
    
    void menuMaster(Boolean sta){
        mnMaster.setVisible(sta);
    }
    
    void menuAkademik(Boolean sta){
        mnAkademik.setVisible(sta);
    }
    
    void menuMahasiswa(Boolean sta){
        mnMahasiswa.setVisible(sta);
    }
    
    void menuPegawai(Boolean sta){
        mnPegawai.setVisible(sta);
    }
    
    void menuUKT(Boolean sta){
        mnUKT.setVisible(sta);
    }
    
    void userAdmin(){
        menuSistem(true);
        menuMaster(true);
        menuAkademik(true);
        menuMahasiswa(true);
        menuPegawai(true);
        menuUKT(true);
    }
    
    void userAkademik(){
        menuSistem(true);
        mnUser.setText("Ubah Password");
        mnUser.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Image/key.png")));
        menuMaster(true);
        menuAkademik(true);
        menuMahasiswa(false);
        menuPegawai(false);
        menuUKT(false);
    }
    
    void userKemahasiswaan(){
        menuSistem(true);
        mnUser.setText("Ubah Password");
        mnUser.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Image/key.png")));
        menuMaster(false);
        menuAkademik(false);
        menuMahasiswa(true);
        menuPegawai(false);
        menuUKT(false);
    }
    
    void userKepegawaian(){
        menuSistem(true);
        mnUser.setText("Ubah Password");
        mnUser.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Image/key.png")));
        menuMaster(false);
        menuAkademik(false);
        menuMahasiswa(false);
        menuPegawai(true);
        menuUKT(false);
    }
    
    void userPembayaranUKT(){
        menuSistem(true);
        mnUser.setText("Ubah Password");
        mnUser.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/Image/key.png")));
        menuMaster(false);
        menuAkademik(false);
        menuMahasiswa(false);
        menuPegawai(false);
        menuUKT(true);
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
        lbKeterangan = new javax.swing.JLabel();
        jpMenu = new javax.swing.JDesktopPane();
        panelLogin = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtIdUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSistem = new javax.swing.JMenu();
        mnUser = new javax.swing.JMenuItem();
        mnKeluar = new javax.swing.JMenuItem();
        mnMaster = new javax.swing.JMenu();
        mnTA = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnJurusan = new javax.swing.JMenuItem();
        mnProdi = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnAkademik = new javax.swing.JMenu();
        mnSetThAkademik = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mnKelompokMk = new javax.swing.JMenuItem();
        mnMasterMk = new javax.swing.JMenuItem();
        mnMkSemesterAktif = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        mnJadwalMk = new javax.swing.JMenuItem();
        mnPegawai = new javax.swing.JMenu();
        mnDataPegawai = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        mnPegawaiMutasi = new javax.swing.JMenuItem();
        mnPegawaiKeluar = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        mnTransJabatan = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        mnLapDataPegawai = new javax.swing.JMenuItem();
        mnMahasiswa = new javax.swing.JMenu();
        mnDataMahasiswa = new javax.swing.JMenuItem();
        mnDataNilaiMhs = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnDataMahasiswaCuti = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnMhsKeluar = new javax.swing.JMenu();
        mnDataMahasiswaDO = new javax.swing.JMenuItem();
        mnDataMahasiswaMD = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnDataMahasiswaAlumni = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnLapMahasiswa = new javax.swing.JMenuItem();
        mnUKT = new javax.swing.JMenu();
        mnMasterUKT = new javax.swing.JMenuItem();
        mnUKTMhs = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnTransUKT = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        mnLapTransUKT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIAKAD v.1.0.1");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbKeterangan.setText("ID.User : ...... || Lev User : ........");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbKeterangan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        txtIdUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "ID.User :"));
        txtIdUser.setOpaque(false);

        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Password :"));
        txtPass.setOpaque(false);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/login-blue.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/small_logout.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login SIAKAD v.1.0.1");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("-{ Sistem Informasi Akademik Oemah Codinger }-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdUser))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIdUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelLogin.addTab("Login User", new javax.swing.ImageIcon(getClass().getResource("/Image/Admin-Schoolar-Icon.png")), jPanel2); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon-login.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel5.setText("SISTEM INFORMASI AKADEMIK");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("SEKOLAH TINGGI OEMAH CODINGER ( STOC )");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel7.setText("OemahCodinger.com");

        jpMenu.setLayer(panelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jpMenu.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpMenuLayout.createSequentialGroup()
                        .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        mnSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1 - Sistem.png"))); // NOI18N
        mnSistem.setText("Sistem");

        mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1 - user.png"))); // NOI18N
        mnUser.setText("User");
        mnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserActionPerformed(evt);
            }
        });
        mnSistem.add(mnUser);

        mnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/small_logout.png"))); // NOI18N
        mnKeluar.setText("Keluar");
        mnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKeluarActionPerformed(evt);
            }
        });
        mnSistem.add(mnKeluar);

        jMenuBar1.add(mnSistem);

        mnMaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - Master.png"))); // NOI18N
        mnMaster.setText("Master");

        mnTA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnTA.setText("Tahun Angkatan");
        mnTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTAActionPerformed(evt);
            }
        });
        mnMaster.add(mnTA);
        mnMaster.add(jSeparator1);

        mnJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnJurusan.setText("Jurusan");
        mnJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJurusanActionPerformed(evt);
            }
        });
        mnMaster.add(mnJurusan);

        mnProdi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        mnProdi.setText("Program Studi");
        mnProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdiActionPerformed(evt);
            }
        });
        mnMaster.add(mnProdi);
        mnMaster.add(jSeparator11);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2 - master small.png"))); // NOI18N
        jMenuItem10.setText("Jabatan Pegawai");
        mnMaster.add(jMenuItem10);

        jMenuBar1.add(mnMaster);

        mnAkademik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - Akademik.png"))); // NOI18N
        mnAkademik.setText("Akademik");

        mnSetThAkademik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/1 - tahun akademik.png"))); // NOI18N
        mnSetThAkademik.setText("Set Tahun Akademik");
        mnAkademik.add(mnSetThAkademik);
        mnAkademik.add(jSeparator7);

        mnKelompokMk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnKelompokMk.setText("Data Kelompok Matakuliah");
        mnAkademik.add(mnKelompokMk);

        mnMasterMk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnMasterMk.setText("Data Master Matakuliah");
        mnAkademik.add(mnMasterMk);

        mnMkSemesterAktif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnMkSemesterAktif.setText("Data Matakuliah Semester Aktif");
        mnAkademik.add(mnMkSemesterAktif);
        mnAkademik.add(jSeparator9);

        mnJadwalMk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/5 - akademik-small.png"))); // NOI18N
        mnJadwalMk.setText("Data Jadwal Matakuliah");
        mnAkademik.add(mnJadwalMk);

        jMenuBar1.add(mnAkademik);

        mnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - Pegawai.png"))); // NOI18N
        mnPegawai.setText("Pegawai");

        mnDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnDataPegawai.setText("Data Pegawai");
        mnPegawai.add(mnDataPegawai);
        mnPegawai.add(jSeparator8);

        mnPegawaiMutasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnPegawaiMutasi.setText("Data Pegawai Mutasi");
        mnPegawai.add(mnPegawaiMutasi);

        mnPegawaiKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnPegawaiKeluar.setText("Data Pegawai Keluar");
        mnPegawai.add(mnPegawaiKeluar);
        mnPegawai.add(jSeparator10);

        mnTransJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/4 - pegawai-small.png"))); // NOI18N
        mnTransJabatan.setText("Data Transaksi Jabatan");
        mnPegawai.add(mnTransJabatan);
        mnPegawai.add(jSeparator14);

        mnLapDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapDataPegawai.setText("Laporan Data Pegawai");
        mnPegawai.add(mnLapDataPegawai);

        jMenuBar1.add(mnPegawai);

        mnMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - Mahasiswa.png"))); // NOI18N
        mnMahasiswa.setText("Mahasiswa");

        mnDataMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMahasiswa.setText("Data Mahasiswa");
        mnDataMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMahasiswaActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMahasiswa);

        mnDataNilaiMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nilai-mahasiswa-small.png"))); // NOI18N
        mnDataNilaiMhs.setText("Data Nilai Mahasiswa");
        mnMahasiswa.add(mnDataNilaiMhs);
        mnMahasiswa.add(jSeparator4);

        mnDataMahasiswaCuti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMahasiswaCuti.setText("Data Mahasiswa Cuti");
        mnDataMahasiswaCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMahasiswaCutiActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMahasiswaCuti);
        mnMahasiswa.add(jSeparator5);

        mnMhsKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnMhsKeluar.setText("Data Mahasiswa Keluar");

        mnDataMahasiswaDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMahasiswaDO.setText("Drop Out (DO)");
        mnDataMahasiswaDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMahasiswaDOActionPerformed(evt);
            }
        });
        mnMhsKeluar.add(mnDataMahasiswaDO);

        mnDataMahasiswaMD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMahasiswaMD.setText("Mengundurkan Diri");
        mnDataMahasiswaMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMahasiswaMDActionPerformed(evt);
            }
        });
        mnMhsKeluar.add(mnDataMahasiswaMD);

        mnMahasiswa.add(mnMhsKeluar);
        mnMahasiswa.add(jSeparator2);

        mnDataMahasiswaAlumni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3 - mahasiswa small.png"))); // NOI18N
        mnDataMahasiswaAlumni.setText("Data Mahasiswa Alumni");
        mnDataMahasiswaAlumni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataMahasiswaAlumniActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnDataMahasiswaAlumni);
        mnMahasiswa.add(jSeparator6);

        mnLapMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapMahasiswa.setText("Laporan Data Mahasiswa");
        mnLapMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLapMahasiswaActionPerformed(evt);
            }
        });
        mnMahasiswa.add(mnLapMahasiswa);

        jMenuBar1.add(mnMahasiswa);

        mnUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - UKT.png"))); // NOI18N
        mnUKT.setText("Uang Kuliah");

        mnMasterUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - master-ukt.png"))); // NOI18N
        mnMasterUKT.setText("Master Uang kuliah");
        mnUKT.add(mnMasterUKT);

        mnUKTMhs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/6 - ukt-mahasiswa-small.png"))); // NOI18N
        mnUKTMhs.setText("Data UKT Mahasiswa");
        mnUKT.add(mnUKTMhs);
        mnUKT.add(jSeparator12);

        mnTransUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pembayaran-small.png"))); // NOI18N
        mnTransUKT.setText("Data Transaksi UKT");
        mnUKT.add(mnTransUKT);
        mnUKT.add(jSeparator13);

        mnLapTransUKT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/report-small2.png"))); // NOI18N
        mnLapTransUKT.setText("Laporan Transaksi UKT");
        mnUKT.add(mnLapTransUKT);

        jMenuBar1.add(mnUKT);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMenu)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnJurusanActionPerformed
       IfrJurusan fr = new IfrJurusan();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnJurusanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        txtIdUser.setText("");
        txtPass.setText("");
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       if(txtIdUser.getText().equals("") || txtPass.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Silahkan Lengakapi Data!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
       }else{
           aksiLogin();
       }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        if(txtIdUser.getText().equals("") || txtPass.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Silahkan Lengakapi Data!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
       }else{
           aksiLogin();
       }
    }//GEN-LAST:event_txtPassActionPerformed

    private void mnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserActionPerformed
        if(mnUser.getText().equals("Ubah Password")){
            jdUbahPassword fr = new jdUbahPassword(this, true, vid_user);
            fr.setVisible(true);
        }else{
            IfrUser fr = new IfrUser();
            jpMenu.add(fr);
            fr.setVisible(true);
        }
    }//GEN-LAST:event_mnUserActionPerformed

    private void mnTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTAActionPerformed
        IfrTahunAngkatan fr = new IfrTahunAngkatan();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnTAActionPerformed

    private void mnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKeluarActionPerformed
       int jawab = JOptionPane.showConfirmDialog(this, "Yakin Ingin Keluar?", "Informasi",
               JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnKeluarActionPerformed

    private void mnProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdiActionPerformed
        IfrProdi fr = new IfrProdi();
        jpMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnProdiActionPerformed

    private void mnDataMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMahasiswaActionPerformed
       IfrMahasiswa fr = new IfrMahasiswa();
       jpMenu.add(fr);
       fr.setVisible(true);
    }//GEN-LAST:event_mnDataMahasiswaActionPerformed

    private void mnLapMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLapMahasiswaActionPerformed
       ifrLapMahasiswa fr = new ifrLapMahasiswa();
       jpMenu.add(fr);
       fr.setVisible(true);
    }//GEN-LAST:event_mnLapMahasiswaActionPerformed

    private void mnDataMahasiswaCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMahasiswaCutiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMahasiswaCutiActionPerformed

    private void mnDataMahasiswaDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMahasiswaDOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMahasiswaDOActionPerformed

    private void mnDataMahasiswaMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMahasiswaMDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMahasiswaMDActionPerformed

    private void mnDataMahasiswaAlumniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataMahasiswaAlumniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataMahasiswaAlumniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) throws UnsupportedLookAndFeelException,
            IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        try{
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme("Default","java Swing", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
           SwingUtilities.updateComponentTreeUI(new FrMenu());
        }finally{
            new FrMenu().setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JDesktopPane jpMenu;
    private javax.swing.JLabel lbKeterangan;
    private javax.swing.JMenu mnAkademik;
    private javax.swing.JMenuItem mnDataMahasiswa;
    private javax.swing.JMenuItem mnDataMahasiswaAlumni;
    private javax.swing.JMenuItem mnDataMahasiswaCuti;
    private javax.swing.JMenuItem mnDataMahasiswaDO;
    private javax.swing.JMenuItem mnDataMahasiswaMD;
    private javax.swing.JMenuItem mnDataNilaiMhs;
    private javax.swing.JMenuItem mnDataPegawai;
    private javax.swing.JMenuItem mnJadwalMk;
    private javax.swing.JMenuItem mnJurusan;
    private javax.swing.JMenuItem mnKelompokMk;
    private javax.swing.JMenuItem mnKeluar;
    private javax.swing.JMenuItem mnLapDataPegawai;
    private javax.swing.JMenuItem mnLapMahasiswa;
    private javax.swing.JMenuItem mnLapTransUKT;
    private javax.swing.JMenu mnMahasiswa;
    private javax.swing.JMenu mnMaster;
    private javax.swing.JMenuItem mnMasterMk;
    private javax.swing.JMenuItem mnMasterUKT;
    private javax.swing.JMenu mnMhsKeluar;
    private javax.swing.JMenuItem mnMkSemesterAktif;
    private javax.swing.JMenu mnPegawai;
    private javax.swing.JMenuItem mnPegawaiKeluar;
    private javax.swing.JMenuItem mnPegawaiMutasi;
    private javax.swing.JMenuItem mnProdi;
    private javax.swing.JMenuItem mnSetThAkademik;
    private javax.swing.JMenu mnSistem;
    private javax.swing.JMenuItem mnTA;
    private javax.swing.JMenuItem mnTransJabatan;
    private javax.swing.JMenuItem mnTransUKT;
    private javax.swing.JMenu mnUKT;
    private javax.swing.JMenuItem mnUKTMhs;
    private javax.swing.JMenuItem mnUser;
    private javax.swing.JTabbedPane panelLogin;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}

// Keterangan

/*
    1. Deklarasikan terlebih dahulu variabel-variabel name pada form login dan menu
    2. Import class library yang dibutuhkan
    3. Deklarasikan objek koneksi database dan class Connection
    4. Deklarasikan variabel-variabel yang dibutuhkan unutk oparasi login
    5. Buat method DisableMenu() dan UnableMenu()
    6. Buat method aksi login
    7. Tambahkan beberapa sintak pada method contructor
    8. Ubah sintak method main
    9. Tambahkan data untuk tbuser
    10. Tambahkan sintak untuk tombol login dan batal

*/