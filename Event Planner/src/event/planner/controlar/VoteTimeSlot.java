package event.planner.controlar;




import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class VoteTimeSlot extends JPanel implements ActionListener{
    private JPanel jpVotingNotification, jpVote;
    private JButton removeButton;
    private int eventId; 
    private HashMap<String, Integer> totalVoteList = new HashMap<>();
    private int attendeesID;

    public VoteTimeSlot(int eventId, int attendeesID, JPanel jpVotingNotification, JButton jbVotingNotification,  JPanel jpVote) {
        this.eventId=eventId;
        this.attendeesID=attendeesID;
        this.jpVotingNotification=jpVotingNotification;
        this.removeButton=jbVotingNotification;
        this.jpVote=jpVote;
        
        this.setSize(490, 370);
        
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        String sql ="SELECT  `timeSlot`, `totalVote` FROM `voting` WHERE `events_id`="+this.eventId;
        
        try {
            ResultSet rs= DatabaseConfiguration.statement.executeQuery(sql);
            while (rs.next()) {
                String slotName = rs.getString("timeSlot");
                totalVoteList.put(slotName, rs.getInt("totalVote"));
                JButton jButton = new JButton(slotName);
                jButton.addActionListener(this);
                JLabel lblTotalvote = new JLabel(String.valueOf(rs.getInt("totalVote")), SwingConstants.CENTER);
                
                //set size
                jButton.setPreferredSize(new Dimension(350, 50));
                jButton.setMaximumSize(new Dimension(350, 50));
                lblTotalvote.setPreferredSize(new Dimension(135, 50));
                lblTotalvote.setMaximumSize(new Dimension(135, 50));
                lblTotalvote.setFont(new Font("Tahoma", Font.BOLD, 14));
                
                JPanel jp1=new JPanel();
                jp1.setSize(470, 50);
                jp1.setLayout(new BoxLayout(jp1, BoxLayout.X_AXIS));
                jp1.add(jButton);
                jp1.add(lblTotalvote);
                
                this.add(jp1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoteTimeSlot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sql = "UPDATE `voting` SET `totalVote`=" + (totalVoteList.get(e.getActionCommand())+1) 
                +" WHERE `events_id`="+this.eventId + " AND `timeSlot`= '"+e.getActionCommand()+"';";
        String closeVotingNotificatioSQL="UPDATE `voting_notification` SET `vote_available`=FALSE WHERE `events_id`="
                +this.eventId + " AND `attendees_id`="+attendeesID;
        try {
            DatabaseConfiguration.statement.executeUpdate(sql);
            DatabaseConfiguration.statement.executeUpdate(closeVotingNotificatioSQL);
        } catch (SQLException ex) {
            Logger.getLogger(VoteTimeSlot.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jpVote.removeAll();
        jpVotingNotification.remove(removeButton);
        jpVotingNotification.revalidate();
        this.jpVote.revalidate();
        jpVotingNotification.repaint();
        this.jpVote.repaint();
        
       JOptionPane.showMessageDialog (null, "Vote has been counted successfully", "Vote", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
