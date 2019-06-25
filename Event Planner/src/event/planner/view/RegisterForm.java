package event.planner.view;

import event.planner.controlar.Controler;
import event.planner.controlar.DatabaseConfiguration;
import event.planner.model.UserProfile;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class RegisterForm extends javax.swing.JFrame {
    private JCheckBox[][] checkBoxList = new JCheckBox[7][13];
    Controler controler = new Controler();

    public RegisterForm() {
        initComponents();
        this.setSize(800, 420);
        this.setTitle("Register");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        new DatabaseConfiguration();
        
        //set layout
        jpTimeSlot.setLayout(new GridLayout(13, 7));
        
        
        //Create a checkbox list which will be add to timeSlot panel
        for(int a=0; a<7; a++){
            for(int i=0; i<13; i++){
                if(i<5){
                    JCheckBox jCheckBox = new JCheckBox(String.valueOf(i+8)+ "  AM");
                    checkBoxList[a][i]=jCheckBox;
                        
                }else{
                    JCheckBox jCheckBox = new JCheckBox(String.valueOf(i-4)+ "  PM");
                    checkBoxList[a][i]=jCheckBox;
                }         
            }          
        }
        
        //now add all the checkbox into time slot panel
        for(int a =0; a<13; a++){
            for(int b=0; b<7; b++){
               jpTimeSlot.add(checkBoxList[b][a]); 
            }  
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaturday = new javax.swing.JLabel();
        lblSunday = new javax.swing.JLabel();
        lblMonday = new javax.swing.JLabel();
        lblTuesday = new javax.swing.JLabel();
        lblWednesday = new javax.swing.JLabel();
        lblThursday = new javax.swing.JLabel();
        lblFriday = new javax.swing.JLabel();
        jpTimeSlot = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPasswords = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfLocation = new javax.swing.JTextField();
        lblLocation = new javax.swing.JLabel();
        jtfPasswords = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaturday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSaturday.setText("Saturday");

        lblSunday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSunday.setText("Sunday");

        lblMonday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMonday.setText("Monday");

        lblTuesday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTuesday.setText("Tuesday");

        lblWednesday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblWednesday.setText("Wednesday");

        lblThursday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThursday.setText("Thursday");

        lblFriday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFriday.setText("Friday");

        javax.swing.GroupLayout jpTimeSlotLayout = new javax.swing.GroupLayout(jpTimeSlot);
        jpTimeSlot.setLayout(jpTimeSlotLayout);
        jpTimeSlotLayout.setHorizontalGroup(
            jpTimeSlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );
        jpTimeSlotLayout.setVerticalGroup(
            jpTimeSlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        lblName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblName.setText("Name");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmail.setText("Email");

        lblPasswords.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPasswords.setText("Passwords");

        jtfName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jtfEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });

        jtfLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLocation.setText("Location");

        jtfPasswords.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.setActionCommand("");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jtfName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblPasswords)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblLocation)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPasswords, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jtfLocation))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswords)
                    .addComponent(jtfPasswords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLocation)
                    .addComponent(jtfLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblSaturday)
                        .addGap(18, 18, 18)
                        .addComponent(lblSunday)
                        .addGap(18, 18, 18)
                        .addComponent(lblMonday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTuesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWednesday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblThursday)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFriday))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFriday)
                            .addComponent(lblThursday)
                            .addComponent(lblWednesday)
                            .addComponent(lblTuesday)
                            .addComponent(lblMonday)
                            .addComponent(lblSaturday)
                            .addComponent(lblSunday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        boolean[][] updateDataList = new boolean[7][13];
        String name, email, passwords, location;
        name=jtfName.getText();
        email=jtfEmail.getText();
        passwords=jtfPasswords.getText();
        location=jtfLocation.getText();

        if(name.equals("") || email.equals("") || passwords.equals("") || location.equals("")){
            JOptionPane.showMessageDialog (null, "You must fill all fields.", "Validation", JOptionPane.INFORMATION_MESSAGE);
        }else{
            for(int a =0; a<7; a++){
                for(int b=0; b<13; b++){
                    if(checkBoxList[a][b].isSelected()){
                        updateDataList[a][b]=true;
                    }else{
                        updateDataList[a][b]=false;
                    }
                }
            }
            
            
            UserProfile userProfile = new UserProfile(name, email, passwords, location);
            userProfile.setWeekLytimeSlot(updateDataList);
            
            if(controler.registerNewUser(userProfile)){
                JOptionPane.showMessageDialog (null, "Registration complete successfully. Please login now", "Registration", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new LoginForm().setVisible(true);
            }else{
                JOptionPane.showMessageDialog (null, "Registration  unsuccessfully. Try agian", "Registration", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnRegisterActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jpTimeSlot;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLocation;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPasswords;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFriday;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMonday;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPasswords;
    private javax.swing.JLabel lblSaturday;
    private javax.swing.JLabel lblSunday;
    private javax.swing.JLabel lblThursday;
    private javax.swing.JLabel lblTuesday;
    private javax.swing.JLabel lblWednesday;
    // End of variables declaration//GEN-END:variables
}
