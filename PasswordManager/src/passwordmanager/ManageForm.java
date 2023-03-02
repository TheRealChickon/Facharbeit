package passwordmanager;

import database.db;

import java.awt.Color;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageForm extends javax.swing.JFrame {

    int userNameUpdateId;
    Connection conn;
    Statement st;
    String user;

    public ManageForm() {
        initComponents();
        conn = db.conn();
        st = null;

        URL image = getClass().getResource("/source/ic.png");
        ImageIcon img = new ImageIcon(image);

        this.setIconImage(img.getImage());

        Color col = new Color(35, 35, 35);

        getContentPane().setBackground(col);

    }

    public void getUser(String user) {
        this.user = user;
        greetinglabel.setText("Welcome back, " + user + "!");
        getTableDetails();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        greetinglabel = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtUpdate = new javax.swing.JButton();
        chckVis = new javax.swing.JCheckBox();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 14));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add details of a new password ");

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password Manager");

        greetinglabel.setFont(new java.awt.Font("Courier New", 0, 13));
        greetinglabel.setForeground(new java.awt.Color(255, 255, 255));
        greetinglabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtUserName.setFont(new java.awt.Font("Courier New", 0, 12));

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 12));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tbl.setBackground(new java.awt.Color(31, 31, 31));
        tbl.setFont(new java.awt.Font("Courier New", 0, 14));
        tbl.setForeground(new java.awt.Color(255, 255, 255));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "No.", "Description", "User Name", "Password"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbl.setGridColor(new java.awt.Color(31, 31, 31));
        tbl.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl.getTableHeader().setResizingAllowed(false);
        tbl.getTableHeader().setReorderingAllowed(false);
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setResizable(false);
            tbl.getColumnModel().getColumn(1).setResizable(false);
            tbl.getColumnModel().getColumn(2).setResizable(false);
            tbl.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtUpdate.setText("Update");
        txtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    txtUpdateActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        chckVis.setBackground(new java.awt.Color(38, 38, 38));
        chckVis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chckVisMouseClicked(evt);
            }
        });

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Search");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        txtdes.setFont(new java.awt.Font("Courier New", 0, 12));

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 12));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(greetinglabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jButton2)
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(jButton3)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                                                                        .addGap(18, 18, 18)
                                                                                        .addComponent(txtUpdate))
                                                                                .addComponent(txtdes, javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(chckVis))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(151, 151, 151)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greetinglabel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(chckVis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAdd)
                                        .addComponent(jButton3)
                                        .addComponent(txtUpdate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void getTableDetails() {

        try {
            String query = "select * from userdata where user = '" + user + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("userName");
                String pass = rs.getString("enPass");
                String des = (rs.getString("des"));
                String id = Integer.toString(rs.getInt("uid"));

                String tbData[] = {id, des, name, pass};
                DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();

                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String des = txtdes.getText();

        String encryptedpassword = null;

        try {

            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update(password.getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encryptedpassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {

            String query = "insert into userdata(userName, password, enPass, des, user) values('" + userName + "','" + AESencryption.encrypt(password) + "','" + encryptedpassword + "','" + des + "','" + user + "')";
            st = conn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Password details added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            txtPassword.setText("");
            txtUserName.setText("");
            txtdes.setText("");

            DefaultTableModel tModel = (DefaultTableModel) tbl.getModel();
            tModel.setRowCount(0);

            getTableDetails();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }
    }

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tbl.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        String idString = model.getValueAt(row, 0).toString();
        int id = Integer.parseInt(idString);

        try {
            String query = "select * from userdata where uid = " + id;
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                txtPassword.setText(AESencryption.decrypt(rs.getString("password")));
                txtUserName.setText(rs.getString("userName"));
                txtdes.setText(rs.getString("des"));
                userNameUpdateId = id;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "WARNING", "Something went wrong", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Login obj = new Login();
        obj.show();
        this.dispose();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        int confirm = JOptionPane.showConfirmDialog(this, "Do you want to delete this?", "Warining", JOptionPane.WARNING_MESSAGE);

        String userName = txtUserName.getText();

        if (confirm == 0) {
            txtPassword.setText("");
            txtUserName.setText("");
            txtdes.setText("");
            try {
                String query = "delete from userdata where userName = '" + userName + "'";
                st = conn.createStatement();
                st.executeUpdate(query);

                DefaultTableModel tModel = (DefaultTableModel) tbl.getModel();
                tModel.setRowCount(0);

                JOptionPane.showMessageDialog(this, "Deletion is successfully!");
                getTableDetails();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }

    }

    private void txtUpdateActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        String userName = txtUserName.getText();
        String pass = AESencryption.encrypt(txtPassword.getText());
        String des = txtdes.getText();
        System.out.println(userNameUpdateId);
        try {

            String query = "update userdata set userName = '" + userName + "', password = '" + pass + "', des = '" + des + "' where uid = " + userNameUpdateId;
            st = conn.createStatement();
            st.executeUpdate(query);

            txtPassword.setText("");
            txtUserName.setText("");
            txtdes.setText("");

            DefaultTableModel tModel = (DefaultTableModel) tbl.getModel();
            tModel.setRowCount(0);

            getTableDetails();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Something went wrong!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            System.out.println(e);
        }
    }

    private void chckVisMouseClicked(java.awt.event.MouseEvent evt) {
        if (chckVis.isSelected()) {

            txtPassword.setEchoChar((char) 0);
        } else {

            txtPassword.setEchoChar('\u25cf');
        }
    }

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        String search = txtSearch.getText();

        DefaultTableModel tModel = (DefaultTableModel) tbl.getModel();
        tModel.setRowCount(0);

        try {
            String query = "select * from userdata where (userName LIKE '%" + search + "%' OR password LIKE '%" + search + "%' OR des LIKE '%" + search + "%') AND user = '" + user + "'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("userName");
                String pass = rs.getString("enPass");
                String des = (rs.getString("des"));
                String id = Integer.toString(rs.getInt("uid"));

                String tbData[] = {id, des, name, pass};
                DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();

                tblModel.addRow(tbData);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println(e);
        }

    }

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAdd;
    private javax.swing.JCheckBox chckVis;
    private javax.swing.JLabel greetinglabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton txtUpdate;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtdes;
}