package event.planner.controlar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author MD ASHIKUR RAHMAN
 */
class calculateCandidateEventTime {
//    int testEventID=3;
//    int testDuration=
    
    //private String  ="SELECT * FROM `sunday_schedule` WHERE ";
    
    private ArrayList<Integer> checkedInvitationEmailList = new ArrayList<>();
    private ArrayList<String> possibleTimeBlock = new ArrayList<>();
    private HashMap<String, Integer> countAvailableTimeBlock = new HashMap<>();
    private final String[] tableName={"saturday_schedule", "sunday_schedule", "monday_schedule", "tuesday_schedule", "wednesday_schedule", "thursday_schedule", "friday_schedule"};
    private ArrayList<String> mostAppropriateTimeSlotList = new ArrayList<>();
    private int eventID;
    
    

    public calculateCandidateEventTime(int durationHour, int eventID) {
        this.eventID=eventID;
          
        String sqlt="SELECT `attendees_id` FROM `invitation` WHERE `id`="+eventID+";";
        System.out.println("Line number 35 in calculatEventTime"+sqlt);
        
        try {
            ResultSet rst = DatabaseConfiguration.statement.executeQuery(sqlt);
            while (rst.next()) {
                 checkedInvitationEmailList.add(rst.getInt("attendees_id"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(calculateCandidateEventTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createBlock(durationHour);
        findOutBestTimeSlotForEachDay(checkedInvitationEmailList);
        
        storeCandidateAndSendNotificaitonForVoting();
        

        
    }
    
    private void createBlock(int durationHour){
        int increment =durationHour-1;
        for(int i=8; i<=20; i++){
           if((i+increment )<=20){
               String block=String.valueOf(i)+"-"+(i+increment );
               possibleTimeBlock.add(block);
               System.out.println(block);
           }else{
               i=21;
           }  
        }      
    }
    
    
    private void findOutBestTimeSlotForEachDay(ArrayList<Integer> checkedInvitationEmailList) {
        
        for(int x=0; x<7; x++){
            countAvailableTimeBlock.clear();
            retrieveDataFromDatabase(checkedInvitationEmailList, tableName[x]);        
            createMostAttaindeesAvilableTimeSlot(tableName[x], checkedInvitationEmailList.size());
        }           
    }

    
    
    private void retrieveDataFromDatabase(ArrayList<Integer> checkedInvitationEmailList, String tableName) {
        String sql="SELECT * FROM `"+tableName+"` WHERE ";
        for(int x=0; x<checkedInvitationEmailList.size(); x++){
            if(x==checkedInvitationEmailList.size()-1){
                sql+="id="+checkedInvitationEmailList.get(x);
            }else{
                sql+="id="+checkedInvitationEmailList.get(x)+" OR ";
            }
        }
        //System.out.println(sql);
        try {
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(sql);
            
            while (rs.next()) {
                    
                     boolean[] oneAttendeeTimeSlot = new boolean[28];
                     for( int i=8; i<=20; i++){
                         oneAttendeeTimeSlot[i]= rs.getBoolean(String.valueOf(i));
                     }
                     
                     countavailableBlockForAttendees(oneAttendeeTimeSlot);
                     
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(calculateCandidateEventTime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private void countavailableBlockForAttendees(boolean[] bs) {
        for(int i =0; i<possibleTimeBlock.size(); i++){
            String startAndEnd[] = possibleTimeBlock.get(i).split("-");
            int start = Integer.parseInt(startAndEnd[0]);
            int end = Integer.parseInt(startAndEnd[1]);
            
            boolean increment =true;
            
            sdf: for(int j= start; j<=end; j++){
                if(!bs[j]){
                    increment =false;
                break sdf;
                  }
                }
            if (increment ){
                if (countAvailableTimeBlock.get(possibleTimeBlock.get(i)) == null) {
                countAvailableTimeBlock.put(possibleTimeBlock.get(i), 1);
                } else {
                    countAvailableTimeBlock.put(possibleTimeBlock.get(i), countAvailableTimeBlock.get(possibleTimeBlock.get(i)) + 1);
                }  
            }  
        }
    }
    
    private void createMostAttaindeesAvilableTimeSlot(String name, int totalInvaitationNumber){
        int bestOneIndex=-1;
        int tmp=0;
        for(int i =0; i<possibleTimeBlock.size(); i++){           
            if(countAvailableTimeBlock.get(possibleTimeBlock.get(i))!=null && countAvailableTimeBlock.get(possibleTimeBlock.get(i))>tmp){                
                tmp=countAvailableTimeBlock.get(possibleTimeBlock.get(i));
                bestOneIndex=i;
                //System.out.println(i);
            }
        }
        
        
        if(bestOneIndex>=0){
            double percentage=(countAvailableTimeBlock.get(possibleTimeBlock.get(bestOneIndex))*100)/totalInvaitationNumber;
            System.out.println("percentage :"+percentage);
            
            
            if(percentage<=22){
            String weeklyDate=name.substring(0, name.indexOf("_"));
            System.out.println("There are no appropriate available time slot on "+ weeklyDate +" according to your event durationa.");
            }else{
                String weeklyDate=name.substring(0, name.indexOf("_"));
                String startAndEnd[] = possibleTimeBlock.get(bestOneIndex).split("-");
                int start = Integer.parseInt(startAndEnd[0]);
                int end = Integer.parseInt(startAndEnd[1]);
                //String ts="The most appropriate Time is " + weeklyDate + " at " +start + ":00 To " + end +":59";
                String ts = weeklyDate + " at " +start + ":00 To " + end +":59";
                System.out.println(ts);
                mostAppropriateTimeSlotList.add(ts);
            }
        }
        
    }
    
    
    private void storeCandidateAndSendNotificaitonForVoting() {
        if(mostAppropriateTimeSlotList.size()>0){
            for(int a=0; a<mostAppropriateTimeSlotList.size(); a++){
                String sql="INSERT INTO `voting`(`events_id`, `timeSlot`, `totalVote`) VALUES ("
                        +eventID+",'"+mostAppropriateTimeSlotList.get(a)+"',0);";
                
                
                try {
                    DatabaseConfiguration.statement.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(calculateCandidateEventTime.class.getName()).log(Level.SEVERE, null, ex);
                }        
            
            }
            
            //now send get interested attendees id and send notification to voting appropriate date 
            //and set calculateTimeStatus as true so that it never calculate again.
            String updateCalculateTimeStatusSQL="UPDATE `events` SET `calculateTimeStatus`=true WHERE id="+eventID;
            String getInterestedPersonSQL="SELECT `attendees_id` FROM `invitation` WHERE `id`="+eventID+" AND `interested`=TRUE";
            
            try {
                ResultSet rs=DatabaseConfiguration.statement.executeQuery(getInterestedPersonSQL);
                ArrayList<String> interestedAttendeesListSQL=new ArrayList<>();
                while (rs.next()) {
                   String votingNotificationSQL="INSERT INTO `voting_notification`(`events_id`, `attendees_id`, `vote_available`) VALUES ("
                           +eventID+","+rs.getInt("attendees_id")+", TRUE);";
                    interestedAttendeesListSQL.add(votingNotificationSQL); 
                    
                }
                for(int a=0; a<interestedAttendeesListSQL.size(); a++){
                    DatabaseConfiguration.statement.executeUpdate(interestedAttendeesListSQL.get(a));
                }
                
                //now update updateCalculateTimeStatusSQL so that it never calculate again
                DatabaseConfiguration.statement.executeUpdate(updateCalculateTimeStatusSQL);
                System.out.println("Line number 202  "+updateCalculateTimeStatusSQL);
            } catch (SQLException ex) {
                Logger.getLogger(calculateCandidateEventTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
   
    
}
