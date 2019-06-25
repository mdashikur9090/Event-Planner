package event.planner.view;

import event.planner.controlar.Controler;
import event.planner.controlar.DatabaseConfiguration;
import event.planner.controlar.VoteTimeSlot;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import event.planner.model.Event;
import event.planner.model.EventInvitation;
import event.planner.model.OnVotingEventsSummary;
import event.planner.model.UserProfile;
import event.planner.model.VotingInvitation;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class MainFrame extends javax.swing.JFrame implements ActionListener{
    Controler controler = new Controler();
    private JCheckBox[][] checkBoxList = new JCheckBox[7][13];
    private final String[] dayName={"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"};
    private ArrayList<String> emailList = new ArrayList<String>();
    private JCheckBox[] invationCheckBoxList;
    private ArrayList<JButton>invitationButtonList= new ArrayList<>();
    private int selectedNotificationButton;
    private EventInvitation  invitationNotifications;
    private ArrayList<VotingInvitation> votingInvitationList;
    private ArrayList<JButton> votingJbuttonList=new ArrayList<>();
    
    
    
    UserProfile userProfile;

    /**
     * Creates new form NewJFrame
     */
    public MainFrame(UserProfile userProfile) {
        this.userProfile=userProfile;
        DatabaseConfiguration db = new DatabaseConfiguration();
        initComponents();
        this.setTitle("Main Frame");
        this.setLocationRelativeTo(null);
        
        //set Layout
        jpOnvotingEvent.setLayout(new BoxLayout(jpOnvotingEvent, BoxLayout.Y_AXIS));
        jpDashboardTimeSlot.setLayout(new BoxLayout(jpDashboardTimeSlot, BoxLayout.Y_AXIS));
        jpDashboardAudienceEmailList.setLayout(new BoxLayout(jpDashboardAudienceEmailList, BoxLayout.Y_AXIS));
        jpTimeSlot.setLayout(new GridLayout(13, 7));
        jpInvitationEmailList.setLayout(new BoxLayout(jpInvitationEmailList, BoxLayout.Y_AXIS));
        jpInvitation.setLayout(new BoxLayout(jpInvitation, BoxLayout.Y_AXIS));
        jpVotingNotification.setLayout(new BoxLayout(jpVotingNotification, BoxLayout.Y_AXIS));
        
        //add actiontion listner for accept and reject button 
        btnAccept.addActionListener(this);
        btnReject.addActionListener(this);

        //ViewProfileInformation viewProfileInformation = new ViewProfileInformation();
        //getUerProfile
        jtfName.setText(userProfile.getUserName());
        lblUserName.setText(lblUserName.getText() + userProfile.getUserName());
        jtfEmail.setText(userProfile.getEmail());
        jtfEmail.setEditable(false);
        jtfPasswords.setText(userProfile.getPasswords());
        jtfLocation.setText(userProfile.getLocation());
        //checkBoxList=viewProfileInformation.getCheckBoxList();
                
        

        //add time slot as checkbox
        for(int a =0; a<7; a++){
            for(int b=0; b<13; b++){
                if(b<5){
                    JCheckBox jCheckBox = new JCheckBox(String.valueOf(b+8)+ "  AM");
                    if(userProfile.getWeekLytimeSlot()[a][b]){
                        jCheckBox.setSelected(true);
                    }
                  checkBoxList[a][b]= jCheckBox;    
                 }else{
                    JCheckBox jCheckBox = new JCheckBox(String.valueOf(b-4)+ "  PM");
                    if(userProfile.getWeekLytimeSlot()[a][b]){
                        jCheckBox.setSelected(true);
                    }
                    checkBoxList[a][b]= jCheckBox;
                        
                 }
            }  
        }
        //now add into panel
        for(int a =0; a<13; a++){
            for(int b=0; b<7; b++){
                jpTimeSlot.add(checkBoxList[b][a]);
            }  
        }
        
        
        dashboardInformation();
        
        createEvent();
        
        showInvitationNotifications();
        
        showVotingNotification();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jlpDashboard = new javax.swing.JLayeredPane();
        lblOnVoting = new javax.swing.JLabel();
        jpDashboardTimeSlot = new javax.swing.JPanel();
        lblDashboardTimeSlot = new javax.swing.JLabel();
        lblPerticipate = new javax.swing.JLabel();
        jspOnvotingEvent = new javax.swing.JScrollPane();
        jpOnvotingEvent = new javax.swing.JPanel();
        jspDashboardAudienceEmailList = new javax.swing.JScrollPane();
        jpDashboardAudienceEmailList = new javax.swing.JPanel();
        jlpEditProfile = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        lblMonday = new javax.swing.JLabel();
        lblTuesday = new javax.swing.JLabel();
        lblWednesday = new javax.swing.JLabel();
        lblThursday = new javax.swing.JLabel();
        lblFriday = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPasswords = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfLocation = new javax.swing.JTextField();
        lblLocation = new javax.swing.JLabel();
        jtfPasswords = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        lblSaturday = new javax.swing.JLabel();
        lblSunday = new javax.swing.JLabel();
        jpTimeSlot = new javax.swing.JPanel();
        jlpCreateEvents = new javax.swing.JLayeredPane();
        lblEventName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEventLocation = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        lblEventDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblEventMattendees = new javax.swing.JLabel();
        lblEventDuration = new javax.swing.JLabel();
        cmbDuration = new javax.swing.JComboBox<>();
        cmbMinimumAttendees = new javax.swing.JComboBox<>();
        lblEventMthreshold = new javax.swing.JLabel();
        cmbMinimumThreshold = new javax.swing.JComboBox<>();
        lblEventInvitation = new javax.swing.JLabel();
        btnCreateEvent = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpInvitationEmailList = new javax.swing.JPanel();
        jlpInvitations = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpInvitation = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblInvationEventName = new javax.swing.JLabel();
        lblInvationEventLocation = new javax.swing.JLabel();
        lblInvationEventDescription = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEventDescription = new javax.swing.JTextArea();
        txtEventLocation = new javax.swing.JTextField();
        txtEventName = new javax.swing.JTextField();
        lblMinAttendees = new javax.swing.JLabel();
        lblInvitationEventDuration = new javax.swing.JLabel();
        btnReject = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        txtCreatorName = new javax.swing.JTextField();
        lblEventCreator = new javax.swing.JLabel();
        lblInvationName = new javax.swing.JLabel();
        lblDetailsOfInvation = new javax.swing.JLabel();
        jlpVoting = new javax.swing.JLayeredPane();
        jScrollPaneVotingNotification = new javax.swing.JScrollPane();
        jpVotingNotification = new javax.swing.JPanel();
        jpVote = new javax.swing.JPanel();
        lblVotingTimeSlotName = new javax.swing.JLabel();
        lblVotingTotalPresentVote = new javax.swing.JLabel();
        lblVotingNotificationName = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOnVoting.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOnVoting.setText("On voting Event");

        javax.swing.GroupLayout jpDashboardTimeSlotLayout = new javax.swing.GroupLayout(jpDashboardTimeSlot);
        jpDashboardTimeSlot.setLayout(jpDashboardTimeSlotLayout);
        jpDashboardTimeSlotLayout.setHorizontalGroup(
            jpDashboardTimeSlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpDashboardTimeSlotLayout.setVerticalGroup(
            jpDashboardTimeSlotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDashboardTimeSlot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDashboardTimeSlot.setText("Timeslot and Vote");

        lblPerticipate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPerticipate.setText("Perticipaters");

        jspOnvotingEvent.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jpOnvotingEventLayout = new javax.swing.GroupLayout(jpOnvotingEvent);
        jpOnvotingEvent.setLayout(jpOnvotingEventLayout);
        jpOnvotingEventLayout.setHorizontalGroup(
            jpOnvotingEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );
        jpOnvotingEventLayout.setVerticalGroup(
            jpOnvotingEventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        jspOnvotingEvent.setViewportView(jpOnvotingEvent);

        jspDashboardAudienceEmailList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jpDashboardAudienceEmailListLayout = new javax.swing.GroupLayout(jpDashboardAudienceEmailList);
        jpDashboardAudienceEmailList.setLayout(jpDashboardAudienceEmailListLayout);
        jpDashboardAudienceEmailListLayout.setHorizontalGroup(
            jpDashboardAudienceEmailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
        jpDashboardAudienceEmailListLayout.setVerticalGroup(
            jpDashboardAudienceEmailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        jspDashboardAudienceEmailList.setViewportView(jpDashboardAudienceEmailList);

        jlpDashboard.setLayer(lblOnVoting, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpDashboard.setLayer(jpDashboardTimeSlot, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpDashboard.setLayer(lblDashboardTimeSlot, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpDashboard.setLayer(lblPerticipate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpDashboard.setLayer(jspOnvotingEvent, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpDashboard.setLayer(jspDashboardAudienceEmailList, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpDashboardLayout = new javax.swing.GroupLayout(jlpDashboard);
        jlpDashboard.setLayout(jlpDashboardLayout);
        jlpDashboardLayout.setHorizontalGroup(
            jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlpDashboardLayout.createSequentialGroup()
                .addGroup(jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jlpDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jspOnvotingEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpDashboardTimeSlot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jlpDashboardLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(lblOnVoting)
                        .addGap(150, 150, 150)
                        .addComponent(lblDashboardTimeSlot)
                        .addGap(0, 87, Short.MAX_VALUE)))
                .addGroup(jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlpDashboardLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblPerticipate))
                    .addGroup(jlpDashboardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jspDashboardAudienceEmailList, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jlpDashboardLayout.setVerticalGroup(
            jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpDashboardLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOnVoting)
                    .addComponent(lblDashboardTimeSlot)
                    .addComponent(lblPerticipate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jlpDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspOnvotingEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpDashboardTimeSlot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspDashboardAudienceEmailList))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dashboard", jlpDashboard);

        jPanel4.setBackground(javax.swing.UIManager.getDefaults().getColor("EditorPane.selectionBackground"));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

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

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setActionCommand("");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSaturday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSaturday.setText("Saturday");

        lblSunday.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSunday.setText("Sunday");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                        .addGap(18, 18, 18)
                        .addComponent(lblFriday))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jpTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFriday)
                            .addComponent(lblThursday)
                            .addComponent(lblWednesday)
                            .addComponent(lblTuesday)
                            .addComponent(lblMonday)
                            .addComponent(lblSaturday)
                            .addComponent(lblSunday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpTimeSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(357, 357, 357))
        );

        jlpEditProfile.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpEditProfileLayout = new javax.swing.GroupLayout(jlpEditProfile);
        jlpEditProfile.setLayout(jlpEditProfileLayout);
        jlpEditProfileLayout.setHorizontalGroup(
            jlpEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlpEditProfileLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jlpEditProfileLayout.setVerticalGroup(
            jlpEditProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Edit Profile", jlpEditProfile);

        lblEventName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventName.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblEventLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventLocation.setText("Location");

        txtLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblEventDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventDescription.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        lblEventMattendees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventMattendees.setText("Minimum attendees");

        lblEventDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventDuration.setText("Duration");

        cmbDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmbMinimumAttendees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblEventMthreshold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventMthreshold.setText("Minimum threshold");

        cmbMinimumThreshold.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblEventInvitation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEventInvitation.setText("Invaitaion");

        btnCreateEvent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateEvent.setText("Create Event");
        btnCreateEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInvitationEmailListLayout = new javax.swing.GroupLayout(jpInvitationEmailList);
        jpInvitationEmailList.setLayout(jpInvitationEmailListLayout);
        jpInvitationEmailListLayout.setHorizontalGroup(
            jpInvitationEmailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jpInvitationEmailListLayout.setVerticalGroup(
            jpInvitationEmailListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jpInvitationEmailList);

        jlpCreateEvents.setLayer(lblEventName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(txtName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventLocation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(txtLocation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventDescription, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventMattendees, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventDuration, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(cmbDuration, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(cmbMinimumAttendees, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventMthreshold, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(cmbMinimumThreshold, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(lblEventInvitation, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(btnCreateEvent, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpCreateEvents.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpCreateEventsLayout = new javax.swing.GroupLayout(jlpCreateEvents);
        jlpCreateEvents.setLayout(jlpCreateEventsLayout);
        jlpCreateEventsLayout.setHorizontalGroup(
            jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventMthreshold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMinimumThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventMattendees)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMinimumAttendees, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventDuration)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventName)
                        .addGap(63, 63, 63)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpCreateEventsLayout.createSequentialGroup()
                        .addComponent(lblEventInvitation)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpCreateEventsLayout.createSequentialGroup()
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCreateEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(38, 38, 38))))
        );
        jlpCreateEventsLayout.setVerticalGroup(
            jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEventName))
                        .addGap(26, 26, 26)
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEventLocation)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEventDescription)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEventDuration)
                            .addComponent(cmbDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEventMattendees)
                            .addComponent(cmbMinimumAttendees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jlpCreateEventsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEventInvitation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jlpCreateEventsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEventMthreshold)
                    .addComponent(cmbMinimumThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateEvent))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Create Events", jlpCreateEvents);

        jlpInvitations.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jpInvitationLayout = new javax.swing.GroupLayout(jpInvitation);
        jpInvitation.setLayout(jpInvitationLayout);
        jpInvitationLayout.setHorizontalGroup(
            jpInvitationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );
        jpInvitationLayout.setVerticalGroup(
            jpInvitationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jpInvitation);

        lblInvationEventName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvationEventName.setText("Event Name");

        lblInvationEventLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvationEventLocation.setText("Location");

        lblInvationEventDescription.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvationEventDescription.setText("Description");

        txtEventDescription.setEditable(false);
        txtEventDescription.setColumns(20);
        txtEventDescription.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtEventDescription.setRows(5);
        jScrollPane7.setViewportView(txtEventDescription);

        txtEventLocation.setEditable(false);
        txtEventLocation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEventLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEventLocationActionPerformed(evt);
            }
        });

        txtEventName.setEditable(false);
        txtEventName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblMinAttendees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMinAttendees.setText("Minimum attendees:  ");

        lblInvitationEventDuration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvitationEventDuration.setText("Duration:  ");

        btnReject.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReject.setText("Reject");
        btnReject.setEnabled(false);

        btnAccept.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAccept.setText("Accept");
        btnAccept.setEnabled(false);

        txtCreatorName.setEditable(false);
        txtCreatorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblEventCreator.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEventCreator.setText("Creator Name");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInvationEventName)
                            .addComponent(lblInvationEventLocation)
                            .addComponent(lblInvationEventDescription)
                            .addComponent(lblEventCreator))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCreatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEventLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAccept, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(lblInvitationEventDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMinAttendees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvationEventName)
                    .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCreatorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEventCreator, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEventLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInvationEventLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInvationEventDescription)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMinAttendees)
                    .addComponent(lblInvitationEventDuration))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblInvationName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvationName.setText("Invitation Name");

        lblDetailsOfInvation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDetailsOfInvation.setText("Details of Invitation");

        jlpInvitations.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpInvitations.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpInvitations.setLayer(lblInvationName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpInvitations.setLayer(lblDetailsOfInvation, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpInvitationsLayout = new javax.swing.GroupLayout(jlpInvitations);
        jlpInvitations.setLayout(jlpInvitationsLayout);
        jlpInvitationsLayout.setHorizontalGroup(
            jlpInvitationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlpInvitationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jlpInvitationsLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblInvationName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(lblDetailsOfInvation)
                .addGap(199, 199, 199))
        );
        jlpInvitationsLayout.setVerticalGroup(
            jlpInvitationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpInvitationsLayout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jlpInvitationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvationName)
                    .addComponent(lblDetailsOfInvation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jlpInvitationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jlpInvitationsLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Invitations", jlpInvitations);

        jScrollPaneVotingNotification.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jpVotingNotificationLayout = new javax.swing.GroupLayout(jpVotingNotification);
        jpVotingNotification.setLayout(jpVotingNotificationLayout);
        jpVotingNotificationLayout.setHorizontalGroup(
            jpVotingNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jpVotingNotificationLayout.setVerticalGroup(
            jpVotingNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jScrollPaneVotingNotification.setViewportView(jpVotingNotification);

        javax.swing.GroupLayout jpVoteLayout = new javax.swing.GroupLayout(jpVote);
        jpVote.setLayout(jpVoteLayout);
        jpVoteLayout.setHorizontalGroup(
            jpVoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        jpVoteLayout.setVerticalGroup(
            jpVoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        lblVotingTimeSlotName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVotingTimeSlotName.setText("Time Slot Name");

        lblVotingTotalPresentVote.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVotingTotalPresentVote.setText("Total present vote");

        lblVotingNotificationName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVotingNotificationName.setText("Notification Name");

        jlpVoting.setLayer(jScrollPaneVotingNotification, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpVoting.setLayer(jpVote, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpVoting.setLayer(lblVotingTimeSlotName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpVoting.setLayer(lblVotingTotalPresentVote, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jlpVoting.setLayer(lblVotingNotificationName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jlpVotingLayout = new javax.swing.GroupLayout(jlpVoting);
        jlpVoting.setLayout(jlpVotingLayout);
        jlpVotingLayout.setHorizontalGroup(
            jlpVotingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpVotingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneVotingNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jpVote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpVotingLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblVotingNotificationName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVotingTimeSlotName)
                .addGap(123, 123, 123)
                .addComponent(lblVotingTotalPresentVote)
                .addGap(20, 20, 20))
        );
        jlpVotingLayout.setVerticalGroup(
            jlpVotingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jlpVotingLayout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jlpVotingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVotingTimeSlotName)
                    .addComponent(lblVotingTotalPresentVote)
                    .addComponent(lblVotingNotificationName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jlpVotingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpVote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneVotingNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("voting", jlpVoting);

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserName.setText("Log as:    ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblUserName))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogOut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
                boolean[][] updateDataList = new boolean[7][13];
                String name, email, passwords, location;
                name=jtfName.getText();
                passwords=jtfPasswords.getText();
                location=jtfLocation.getText();
        
                if(name.equals("") || passwords.equals("") || location.equals("")){
                        System.out.println("You must fill all fields.");
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
                        
                        userProfile.setUserName(name);
                        userProfile.setPasswords(passwords);
                        userProfile.getLocation();
                        userProfile.setWeekLytimeSlot(updateDataList);
                        
                        if(controler.updateUserProfile(userProfile)){
                            JOptionPane.showMessageDialog (null, "Profile information has been create successfully", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
                        } else{
                            JOptionPane.showMessageDialog (null, "Profile information update unsuccessfully so try again", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        
                    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void btnCreateEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEventActionPerformed
        // TODO add your handling code here:
        
        String name=txtName.getText();
        String location=txtLocation.getText();
        String description=txtDescription.getText();
        if(name.equals("") || location.equals("") || description.equals("")){
            System.out.println("You must fill all fields.");
            
        }else{
            ArrayList<String> candidateInvitaionIdList = new ArrayList<>();
            
            for(int a=0; a<emailList.size(); a++){
                if(invationCheckBoxList[a].isSelected()){
                    candidateInvitaionIdList.add(emailList.get(a));
                }
            }

            Event newEvent = new Event();
            newEvent.setName(name);
            newEvent.setLocation(location);
            newEvent.setDescription(description);
            newEvent.setDuration(cmbDuration.getSelectedIndex()+1);
            newEvent.setMinimumAttedees(cmbMinimumAttendees.getSelectedIndex()+1);
            newEvent.setMinimumThreshold(cmbMinimumThreshold.getSelectedIndex()+1);
            
            if(controler.createEventAndSendNotification(newEvent, userProfile.getUserID(), candidateInvitaionIdList)){
                JOptionPane.showMessageDialog (null, "Event has been created successfully", "Event Create", JOptionPane.INFORMATION_MESSAGE);
            }
            
           
           
           //as this is not a realtime database so dipose this fram and run again for new update.
           this.dispose();
           new MainFrame(userProfile).setVisible(true);
           
        }
           
    }//GEN-LAST:event_btnCreateEventActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void txtEventLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEventLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEventLocationActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCreateEvent;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDuration;
    private javax.swing.JComboBox<String> cmbMinimumAttendees;
    private javax.swing.JComboBox<String> cmbMinimumThreshold;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneVotingNotification;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLayeredPane jlpCreateEvents;
    private javax.swing.JLayeredPane jlpDashboard;
    private javax.swing.JLayeredPane jlpEditProfile;
    private javax.swing.JLayeredPane jlpInvitations;
    private javax.swing.JLayeredPane jlpVoting;
    private javax.swing.JPanel jpDashboardAudienceEmailList;
    private javax.swing.JPanel jpDashboardTimeSlot;
    private javax.swing.JPanel jpInvitation;
    private javax.swing.JPanel jpInvitationEmailList;
    private javax.swing.JPanel jpOnvotingEvent;
    private javax.swing.JPanel jpTimeSlot;
    private javax.swing.JPanel jpVote;
    private javax.swing.JPanel jpVotingNotification;
    private javax.swing.JScrollPane jspDashboardAudienceEmailList;
    private javax.swing.JScrollPane jspOnvotingEvent;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLocation;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPasswords;
    private javax.swing.JLabel lblDashboardTimeSlot;
    private javax.swing.JLabel lblDetailsOfInvation;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEventCreator;
    private javax.swing.JLabel lblEventDescription;
    private javax.swing.JLabel lblEventDuration;
    private javax.swing.JLabel lblEventInvitation;
    private javax.swing.JLabel lblEventLocation;
    private javax.swing.JLabel lblEventMattendees;
    private javax.swing.JLabel lblEventMthreshold;
    private javax.swing.JLabel lblEventName;
    private javax.swing.JLabel lblFriday;
    private javax.swing.JLabel lblInvationEventDescription;
    private javax.swing.JLabel lblInvationEventLocation;
    private javax.swing.JLabel lblInvationEventName;
    private javax.swing.JLabel lblInvationName;
    private javax.swing.JLabel lblInvitationEventDuration;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblMinAttendees;
    private javax.swing.JLabel lblMonday;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOnVoting;
    private javax.swing.JLabel lblPasswords;
    private javax.swing.JLabel lblPerticipate;
    private javax.swing.JLabel lblSaturday;
    private javax.swing.JLabel lblSunday;
    private javax.swing.JLabel lblThursday;
    private javax.swing.JLabel lblTuesday;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblVotingNotificationName;
    private javax.swing.JLabel lblVotingTimeSlotName;
    private javax.swing.JLabel lblVotingTotalPresentVote;
    private javax.swing.JLabel lblWednesday;
    private javax.swing.JTextField txtCreatorName;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtEventDescription;
    private javax.swing.JTextField txtEventLocation;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    
private void showInvitationNotifications() {
        jpInvitation.setPreferredSize(new Dimension(230, 385));
        invitationNotifications=controler.getIntationEventList(userProfile.getUserID());
        
        if(invitationNotifications.getInvitationEventList()!=null){
            for(int a=0; a<invitationNotifications.getInvitationEventList().size(); a++){
                JButton jb = new JButton(invitationNotifications.getInvitationEventList().get(a).getName());
                jb.setAlignmentX(Component.LEFT_ALIGNMENT);
                jb.setPreferredSize(new Dimension(200, 50));
                jb.setMaximumSize(new Dimension(200, 50)); 
                jb.addActionListener(this);
                invitationButtonList.add(jb);
                jpInvitation.add(jb);
                
            } 
            
        }
    }

private void showVotingNotification() {
        jpVotingNotification.setPreferredSize(new Dimension(240, 372));
    
        votingInvitationList = controler.getVotingInvitation(userProfile.getUserID());


    try {
        for (VotingInvitation eachVM : votingInvitationList){
            JButton jb = new JButton(eachVM.getEventName());
            jb.setAlignmentX(Component.LEFT_ALIGNMENT);
            jb.setPreferredSize(new Dimension(225, 50));
            jb.setMaximumSize(new Dimension(225, 50)); 
            jb.addActionListener(this);
            votingJbuttonList.add(jb);
            jpVotingNotification.add(jb);
        } 
        
    } catch (NullPointerException e) {
        System.out.println(e.getMessage());
    }
  
    }

private void createEvent() {
        //add cmbMinimumThreshold item as a percentage
        for(int x=1; x<=100; x++){
            cmbMinimumThreshold.addItem(String.valueOf(x)+"%");         
        }

         emailList = controler.getAllUserEmailList(userProfile.getUserID());
         invationCheckBoxList= new JCheckBox[emailList.size()];
         
         for(int a=0; a<emailList.size(); a++){
             JCheckBox jcb = new JCheckBox(emailList.get(a));
             invationCheckBoxList[a]=jcb;
             jpInvitationEmailList.add(invationCheckBoxList[a]);
             cmbMinimumAttendees.addItem(String.valueOf(a+1));
         }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        if(object==btnAccept){
            if(controler.acceptEventInvitation(invitationNotifications.getInvitationEventList().get(selectedNotificationButton).getEventID(),userProfile.getUserID())){
                jpInvitation.remove(invitationButtonList.get(selectedNotificationButton));
                JOptionPane.showMessageDialog (null, "Response has been received successfully", "Vote", JOptionPane.INFORMATION_MESSAGE);
                btnAccept.setEnabled(false);
                btnReject.setEnabled(false);
                txtEventName.setText("");
                txtCreatorName.setText("");
                txtEventLocation.setText("");
                txtEventDescription.setText("");
                lblInvitationEventDuration.setText("");
                lblMinAttendees.setText("");
                jpInvitation.revalidate();
                jpInvitation.repaint();

            }   
            
        }
        else if(object==btnReject){
            if(controler.rejectEventInvitation(invitationNotifications.getInvitationEventList().get(selectedNotificationButton).getEventID(),userProfile.getUserID())){
               jpInvitation.remove(invitationButtonList.get(selectedNotificationButton));
                JOptionPane.showMessageDialog (null, "Response has been received successfully", "Vote", JOptionPane.INFORMATION_MESSAGE);
                btnAccept.setEnabled(false);
                btnReject.setEnabled(false);
                txtEventName.setText("");
                txtCreatorName.setText("");
                txtEventLocation.setText("");
                txtEventDescription.setText("");
                lblInvitationEventDuration.setText("");
                lblMinAttendees.setText("");
                jpInvitation.revalidate();
                jpInvitation.repaint(); 
            }
            
        }
        else{
            for(int a=0; a<invitationButtonList.size(); a++){
                if(object==invitationButtonList.get(a)){
                    selectedNotificationButton=a;
                    btnAccept.setEnabled(true);
                    btnReject.setEnabled(true);
                    txtEventName.setText(invitationNotifications.getInvitationEventList().get(a).getName());
                    txtCreatorName.setText(invitationNotifications.getInvitationEventList().get(a).getEventCreatorName());
                    txtEventLocation.setText(invitationNotifications.getInvitationEventList().get(a).getLocation());
                    txtEventDescription.setText(invitationNotifications.getInvitationEventList().get(a).getDescription());
                    lblInvitationEventDuration.setText("Duration:  "+invitationNotifications.getInvitationEventList().get(a).getDuration());
                    lblMinAttendees.setText("Minimum attendees:  "+invitationNotifications.getInvitationEventList().get(a).getMinimumAttedees());
                }
            }
            
            
            //now check all the voting notificatin buttonlist
            for(int b=0; b<votingJbuttonList.size(); b++){
                if(object==votingJbuttonList.get(b)){
                    jpVote.removeAll();
                    jpVote.add(new VoteTimeSlot(votingInvitationList.get(b).getEventId(), userProfile.getUserID(), jpVotingNotification, votingJbuttonList.get(b), jpVote));
                    jpVote.revalidate();
                    jpVote.repaint();
                }
            }
            
        }
    }

    private void dashboardInformation() {
        jpOnvotingEvent.setPreferredSize(new Dimension(200, 385));
        jpDashboardTimeSlot.setPreferredSize(new Dimension(300, 385));
        jpDashboardAudienceEmailList.setPreferredSize(new Dimension(210, 385));
        
        ArrayList<OnVotingEventsSummary> eventSummaryList=controler.getOnVotinEventSummary();
            
        try {
            for(OnVotingEventsSummary esm: eventSummaryList){
                System.out.println("line n " +esm.eventName);
                JButton jb = new JButton(esm.eventName);
                jb.setAlignmentX(Component.LEFT_ALIGNMENT);
                jb.setPreferredSize(new Dimension(200, 50));
                jb.setMaximumSize(new Dimension(200, 50)); 
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jpDashboardTimeSlot.removeAll();
                        jpDashboardAudienceEmailList.removeAll();
                        
                        for(int a=0; a<esm.TimeSlotList.size(); a++){
                            JLabel lblTimeslot = new JLabel(esm.TimeSlotList.get(a), SwingConstants.CENTER);
                            JLabel lblTotalVote = new JLabel(String.valueOf(esm.voteList.get(a)), SwingConstants.CENTER);

                            //set size and font
                            lblTimeslot.setPreferredSize(new Dimension(220, 50));
                            lblTimeslot.setMaximumSize(new Dimension(220, 50));
                            lblTimeslot.setFont(new Font("Tahoma", Font.BOLD, 12));
                            lblTotalVote.setPreferredSize(new Dimension(80, 50));
                            lblTotalVote.setMaximumSize(new Dimension(80, 50));
                            lblTotalVote.setFont(new Font("Tahoma", Font.BOLD, 12));

                            JPanel jp1=new JPanel();
                            jp1.setSize(200, 50);
                            jp1.setLayout(new BoxLayout(jp1, BoxLayout.X_AXIS));
                            jp1.add(lblTimeslot);
                            jp1.add(lblTotalVote);

                            jpDashboardTimeSlot.add(jp1);
                        }
                        
                        for(String email: esm.perticipateEmailList){
                            System.out.println(email);
                            JLabel lblEmail = new JLabel(email, SwingConstants.LEFT);
                            
                            //set size and font
                            lblEmail.setPreferredSize(new Dimension(220, 30));
                            lblEmail.setMaximumSize(new Dimension(220, 30));
                            lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
                            jpDashboardAudienceEmailList.add(lblEmail);
                        }
                        
                        
                        jpDashboardTimeSlot.validate();
                        jpDashboardAudienceEmailList.validate();
                        jpDashboardTimeSlot.repaint();
                        jpDashboardAudienceEmailList.repaint();
                    }
                });
                jpOnvotingEvent.add(jb);
            }
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
            
    }


}
