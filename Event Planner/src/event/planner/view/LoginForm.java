package event.planner.view;

import event.planner.controlar.Controler;
import event.planner.controlar.DatabaseConfiguration;
import event.planner.model.UserProfile;
import javax.swing.JOptionPane;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LoginForm() {
        initComponents();
        this.setSize(500, 400);
        this.setTitle("Login");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        new DatabaseConfiguration();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        lblInforRegister = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lblInforRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInforRegister.setText("If you don't have any account plese register first.");

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPassword.setText("Password");

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEmail.setText("Email");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmail)
                                    .addComponent(lblPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblInforRegister)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lblInforRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegister)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText();
        if(!email.equals("") && !password.equals("")){
            Controler controler = new Controler();
            UserProfile userProfile= controler.login(email, password);
            if(userProfile!=null){
                this.dispose();
                new MainFrame(userProfile).setVisible(true);
            }else{
                JOptionPane.showMessageDialog (null, "Your Email or passwords is wrong.", "Login", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            new JOptionPane().showMessageDialog(this, "You must fiil both email and password field.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new RegisterForm().setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed


    public static void main(String args[]) {
        new LoginForm().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblInforRegister;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
