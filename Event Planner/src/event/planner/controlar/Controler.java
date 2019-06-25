package event.planner.controlar;

import event.planner.model.Event;
import event.planner.model.EventInvitation;
import event.planner.model.OnVotingEventsSummary;
import event.planner.model.UserProfile;
import event.planner.model.VotingInvitation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class Controler {
    
    private OnVotingEventsSummary eventSummaryModel;
    private ArrayList<Integer> eventIdListForPercitapteEmailList =  new ArrayList<>();
    private int eventId;
    private ArrayList<OnVotingEventsSummary> onVotingIdList = new ArrayList<>();
    

    public Controler() {
    }
    
    public UserProfile login(String email, String passwords){
        int userId;
        String sql = "SELECT `id` FROM `personal_information` WHERE email = '" 
                + email + "' AND " + "passwords = '"
                + passwords + "';";
            
            System.out.println(sql);
        
        try {
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(sql);
            if(rs.next()){
                userId=rs.getInt("id");
                return getUserProfile(userId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean registerNewUser(UserProfile userProfile){
        int newRegisterID = 0;
        final String getMaxUserId="SELECT MAX(id) AS maxUserId FROM `personal_information`";
        String personalInformationSQL ="INSERT INTO `personal_information`(`id`, `name`, `email`, `passwords`, `location`) VALUES (" ;
        String[] registerTimeSlotSQL ={"INSERT INTO `saturday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `sunday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `monday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `tuesday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `wednesday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `thursday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES (",
        "INSERT INTO `friday_schedule`(`id`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`) VALUES ("};
   
        try {
            ResultSet getMaxUserIdResultset = DatabaseConfiguration.statement.executeQuery(getMaxUserId);
            if(getMaxUserIdResultset.next()){
                newRegisterID=getMaxUserIdResultset.getInt("maxUserId")+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        personalInformationSQL+= "'"+newRegisterID+"', '"+userProfile.getUserName()+"', '"+userProfile.getEmail()
                +"', '"+userProfile.getPasswords()+"', '"+userProfile.getLocation()+"')";
        
        //add user id for each timeslot sql
        for(int x=0; x<7; x++){
            registerTimeSlotSQL[x]+=newRegisterID+", ";
        }
        
        for(int a=0; a<7; a++){
            for(int b=0; b<13; b++){
                if(b!=12){
                    registerTimeSlotSQL[a]+= userProfile.getWeekLytimeSlot()[a][b]+", ";
                }else{
                    registerTimeSlotSQL[a]+=userProfile.getWeekLytimeSlot()[a][b]+");";    
                   }
            }
            
        }
        
        try {
            DatabaseConfiguration.statement.executeUpdate(personalInformationSQL);
            
            for(int a=0; a<registerTimeSlotSQL.length; a++){
                System.out.println(registerTimeSlotSQL[a]);
                DatabaseConfiguration.statement.executeUpdate(registerTimeSlotSQL[a]);
                
            }
                  
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
        
        return true;
    }
    
    public UserProfile getUserProfile(int userId){
        UserProfile userProfile = null;
        boolean[][] weeklyTimeSlotList=new boolean[7][13];
        String name, email, passwords, location, personalInformationSQL;
        final String[] dayName={"saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday"};
    
       try {
            personalInformationSQL="SELECT * FROM `personal_information` WHERE id="+userId;
            ResultSet rsProfileInformatoin=DatabaseConfiguration.statement.executeQuery(personalInformationSQL);
            ResultSet[] rsTimeSlot = new ResultSet[7];
            
            //save personal information
            if (rsProfileInformatoin.next()) {
                userProfile=new UserProfile(rsProfileInformatoin.getString("name"),
                        rsProfileInformatoin.getString("email"),
                        rsProfileInformatoin.getString("passwords"),
                        rsProfileInformatoin.getString("location"));     
            }
            userProfile.setUserID(userId);
            
            for(int a=0; a<7; a++){
                String sql="SELECT * FROM `"+dayName[a]+"_schedule` WHERE id="+userId;
                rsTimeSlot[a]=DatabaseConfiguration.statement.executeQuery(sql);
                
                while (rsTimeSlot[a].next()) {
                    
               for(int i=0; i<weeklyTimeSlotList[a].length; i++){
                    if(i<5){
                        weeklyTimeSlotList[a][i]=rsTimeSlot[a].getBoolean(String.valueOf(i+8));
                        
                    }else{
                        weeklyTimeSlotList[a][i]=rsTimeSlot[a].getBoolean(String.valueOf(i+8));

                    }
            
                }
            }
            }
            
            userProfile.setWeekLytimeSlot(weeklyTimeSlotList);
           
        } catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
     return userProfile;
             
    }
    
    public boolean updateUserProfile(UserProfile userProfile){
        String personalInformationSQL ="UPDATE `personal_information` SET " ;
        String[] updateTimeSQL ={"UPDATE `saturday_schedule` SET ", "UPDATE `sunday_schedule` SET ", "UPDATE `monday_schedule` SET ",
             "UPDATE `tuesday_schedule` SET ", "UPDATE `wednesday_schedule` SET ", "UPDATE `thursday_schedule` SET ", "UPDATE `friday_schedule` SET "};
        final String[] columnName={"`8`=", "`9`=", "`10`=", "`11`=","`12`=","`13`=","`14`=","`15`=","`16`=","`17`=","`18`=","`19`=","`20`="};

        personalInformationSQL+="`name`='"+userProfile.getUserName()+"', `passwords`='"+userProfile.getPasswords()
                +"', `location`='"+userProfile.getLocation()+"' WHERE id="+userProfile.getUserID();
        for(int a=0; a<7; a++){
            for(int b=0; b<13; b++){
                if(b!=12){
                        updateTimeSQL[a]+=columnName[b]+ userProfile.getWeekLytimeSlot()[a][b]+", ";
                }else{
                    updateTimeSQL[a]+=columnName[b]+ userProfile.getWeekLytimeSlot()[a][b]+" WHERE id="+userProfile.getUserID();    
                   }
            }
            
        }

        try {
            DatabaseConfiguration.statement.executeUpdate(personalInformationSQL);
            for(int a=0; a<updateTimeSQL.length; a++){
                DatabaseConfiguration.statement.executeUpdate(updateTimeSQL[a]);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
        
        return true;
    }
    
    public boolean createEventAndSendNotification(Event event, int creatorID, ArrayList<String> invitationEmailList){
        //get the last insert id from events table which will be use for invitation to attendees 
            String lastIdFromEventSQL="SELECT MAX(id)  AS last_index FROM events;";
            
            try {
                ResultSet rs = DatabaseConfiguration.statement.executeQuery(lastIdFromEventSQL);
                while (rs.next()) {
                    event.setEventID(rs.getInt("last_index")+1);  
                }
            } catch (SQLException ex) {
                Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //find invitation emailId
            ArrayList<Integer> emailIdList = new ArrayList<>();
            for( int x=0; x<invitationEmailList.size(); x++){
                String getAllUserIDListSQL ="SELECT id FROM `personal_information` WHERE email ='"+invitationEmailList.get(x)+"';";
                
                try {
                ResultSet rs = DatabaseConfiguration.statement.executeQuery(getAllUserIDListSQL);

                if (rs.next()){
                    emailIdList.add(rs.getInt("id"));
                    

                }
                } catch (SQLException ex) {
                    Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            
        //store new event into database
            String createEventsSQL="INSERT INTO `events`(`id`,`events_name`, `location`, `description`, `duration`, `minimum_attendees`,"
                    + " `minimum_threshold`, `total_invitation`, `total_interested_person`, `total_response`, `calculateTimeStatus`, `creator_id`) VALUES ("
                    + event.getEventID()+",'"
                    + event.getName()+ "','"
                    + event.getLocation()+ "','"
                    + event.getDescription()+ "',"
                    + event.getDuration() +","
                    + event.getMinimumAttedees() +","
                    + event.getMinimumThreshold() +","
                    + emailIdList.size()+","
                    + "0, "
                    + "0, "
                    + "0, "
                    + creatorID+");";
            
            
            try {
                //store event data
                DatabaseConfiguration.statement.executeUpdate(createEventsSQL);
                
                //store invitation to invitation table
                String invitaionSQL;
                for(int x=0; x<emailIdList.size(); x++){
                    invitaionSQL="INSERT INTO `invitation`(`id`, `attendees_id`,`response`, `interested`) VALUES ("
                            +event.getEventID()+","+emailIdList.get(x)+", FALSE, FALSE);";
                    System.out.println("Line number 248"+invitaionSQL);

                    DatabaseConfiguration.statement.executeUpdate(invitaionSQL);
                    
                }   
                
            } catch (SQLException ex) {
                Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
          
        
        return true;
    }
    
    public ArrayList<String> getAllUserEmailList(int userId){
        ArrayList<String> emailList = new ArrayList<>();
        String getAllUserListSQL ="SELECT `id`, `email` FROM `personal_information` WHERE id!="+userId;
        
        try {
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(getAllUserListSQL);
            
            while (rs.next()){
                emailList.add(rs.getString("email"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return emailList;
    }
    
    public EventInvitation getIntationEventList(int userID){
        EventInvitation invitation = new EventInvitation();
        ArrayList<Integer> eventIdList= new ArrayList<>();
        
        try {
            String getEventID="SELECT `id` FROM `invitation` WHERE attendees_id="+userID +" AND response=false";
            
            ResultSet rst = DatabaseConfiguration.statement.executeQuery(getEventID);
            while (rst.next()) {
                eventIdList.add(rst.getInt("id"));
                
            }
            
            for(int a=0; a<eventIdList.size(); a++){
                String eventInformationSQL="SELECT events.`events_name`, personal_information.name, personal_information.email, events.`location`, "
                        + "events.`description`, events.`duration`, events.`minimum_attendees`, events.`minimum_threshold`"
                        + " FROM `events` INNER JOIN personal_information ON (events.creator_id=personal_information.id)"
                        + " WHERE events.id= " +eventIdList.get(a);
                ResultSet eventResultSet = DatabaseConfiguration.statement.executeQuery(eventInformationSQL);
                System.out.println("Line number 300 "+eventInformationSQL);
                if(eventResultSet.next()){
                    Event event = new Event();
                    event.setEventID(eventIdList.get(a));
                    event.setName(eventResultSet.getString("events_name"));
                    event.setEventCreatorName(eventResultSet.getString("name")+"  ("+eventResultSet.getString("email"));
                    event.setLocation(eventResultSet.getString("location"));
                    event.setDescription(eventResultSet.getString("description"));
                    event.setDuration(eventResultSet.getInt("duration"));
                    event.setMinimumAttedees(eventResultSet.getInt("minimum_attendees"));
                    event.setMinimumThreshold(eventResultSet.getInt("minimum_threshold"));
                
                    invitation.addEvent(event);
                }   
            }
            
  
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return invitation;
    }
    
    public boolean acceptEventInvitation(int eventId, int userID){
        String getEventDataSQL="SELECT  duration, minimum_attendees, total_invitation, total_interested_person, total_response, "
                + "calculateTimeStatus FROM `events` WHERE id="+eventId+";";
        
        int duration = 0, total_invitation = 0, minimum_attendees=0, totalInterestedPerson = 0, totalResponse = 0;
        boolean calculateTimeStatus = false;
               
        try {
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(getEventDataSQL);
            if(rs.next()){
                duration = rs.getInt("duration");
                minimum_attendees =rs.getInt("minimum_attendees");
                total_invitation = rs.getInt("total_invitation");
                totalInterestedPerson=rs.getInt("total_interested_person");
                totalResponse = rs.getInt("total_response");
                calculateTimeStatus=rs.getBoolean("calculateTimeStatus");
                System.out.println("Line number 76 "+calculateTimeStatus);
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // increement the value of totalInterestedPerson and total_response
        totalInterestedPerson++;
        totalResponse++;
        
        try {
            //now insert new update data into event table
            String updateEventTableSQL ="UPDATE `events` SET `total_interested_person`="+totalInterestedPerson+",`total_response`=" + totalResponse + " WHERE id="+eventId + ";";
            DatabaseConfiguration.statement.executeUpdate(updateEventTableSQL);
                
            
            //now update invaitation table reaspone column so it desapear form notification 
            String updataNotificationTableSQL="UPDATE `invitation` SET `response`=TRUE, `interested`=TRUE WHERE id="+ eventId +" AND attendees_id="+userID+";";
            System.out.println(updataNotificationTableSQL);
            DatabaseConfiguration.statement.executeUpdate(updataNotificationTableSQL);  
            } catch (SQLException ex) {
                Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        if(calculateTimeStatus==false){
            if(totalInterestedPerson>=minimum_attendees || totalResponse==total_invitation){
                
                new calculateCandidateEventTime(duration, eventId);
                try {
                    //now inser new update data into event table
                    String updateEventTableSQL ="UPDATE `events` SET `total_interested_person`="+totalInterestedPerson+",`total_response`=" + totalResponse + " WHERE id="+eventId + ";";
                    DatabaseConfiguration.statement.executeUpdate(updateEventTableSQL);


                    //now update invaitation table reaspone column so it desapear form notification 
                    String updataNotificationTableSQL="UPDATE `invitation` SET `response`=TRUE, `interested`=TRUE WHERE id="+ eventId +" AND attendees_id="+userID+";";
                    System.out.println(updataNotificationTableSQL);
                    DatabaseConfiguration.statement.executeUpdate(updataNotificationTableSQL);  
                } catch (SQLException ex) {
                    Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    //now inser new update data into event table
                    String updateEventTableSQL ="UPDATE `events` SET `total_interested_person`="+totalInterestedPerson+",`total_response`=" + totalResponse + " WHERE id="+eventId + ";";
                    DatabaseConfiguration.statement.executeUpdate(updateEventTableSQL);


                    //now update invaitation table reaspone column so it desapear form notification 
                    String updataNotificationTableSQL="UPDATE `invitation` SET `response`=TRUE, `interested`=TRUE WHERE id="+ eventId +" AND attendees_id="+userID+";";
                    System.out.println(updataNotificationTableSQL);
                    DatabaseConfiguration.statement.executeUpdate(updataNotificationTableSQL);  
                } catch (SQLException ex) {
                    Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            

        }
        else{
            
            System.out.println("Already calculate.");
        }
        
        return true;
    }
    
    public boolean  rejectEventInvitation(int eventId, int userID){
        System.out.println(eventId);
        String getEventDataSQL="SELECT total_response FROM `events` WHERE id="+eventId+";";
        int totalResponse = 0;
               
        try {
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(getEventDataSQL);
            if(rs.next()){
                totalResponse = rs.getInt("total_response"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // increement the value of total_response
        totalResponse++;
        System.out.println(totalResponse);
        
        try {
            //now inser new update data into event table
            String updateEventTableSQL ="UPDATE `events` SET `total_response`=" + totalResponse + " WHERE id="+eventId + ";";
            System.out.println(updateEventTableSQL);
            DatabaseConfiguration.statement.executeUpdate(updateEventTableSQL);
            
            
            //now update invaitation table reaspone column so it desapear form notification 
            String updataNotificationTableSQL="UPDATE `invitation` SET `response`=TRUE, `interested`=false WHERE id="+ eventId +" AND attendees_id="+userID+";";
            System.out.println(updataNotificationTableSQL);
            DatabaseConfiguration.statement.executeUpdate(updataNotificationTableSQL);  
            } catch (SQLException ex) {
                Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
            }
    return true;
    }
    
    public ArrayList<VotingInvitation> getVotingInvitation(int userId){
        ArrayList<VotingInvitation> votingEventList = new ArrayList<>();
        String sql="SELECT voting_notification.events_id, events.events_name FROM voting_notification INNER JOIN events ON "
                + "(voting_notification.events_id=events.id) WHERE attendees_id="+userId+" AND vote_available=True";
        try {
            ResultSet rst = DatabaseConfiguration.statement.executeQuery(sql);
            while (rst.next()) {
                VotingInvitation votingModel = new VotingInvitation(rst.getInt("events_id"), rst.getString("events_name"));
                votingEventList.add(votingModel);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return votingEventList;
    }
    
    public ArrayList<OnVotingEventsSummary> getOnVotinEventSummary(){    
        final String sql ="SELECT voting.*, events_name FROM `voting` INNER JOIN events ON (voting.events_id=events.id)";
        
        try {
            System.out.println(sql); 
            ResultSet rs = DatabaseConfiguration.statement.executeQuery(sql);
            while (rs.next()) {              
               getEventsSummaryObject(rs.getInt("events_id"), rs.getString("events_name"), rs.getString("timeSlot"), rs.getInt("totalVote"));

            }
            
            //there have a one eventSummaryModel which was not add to arraylist as this is a last row
            //so we add it menually
            onVotingIdList.add(eventSummaryModel);
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        for(int i=0; i<eventIdListForPercitapteEmailList.size(); i++){
            getPerticipateEmailList(eventIdListForPercitapteEmailList.get(i), i);
        }
        
        return onVotingIdList;
    }
    
    private void getEventsSummaryObject(int eventId, String name, String timeSlot, int totalvote){
        if(eventId==this.eventId){
            this.eventId=eventId;
            eventSummaryModel.eventName=name;
            eventSummaryModel.TimeSlotList.add(timeSlot);
            eventSummaryModel.voteList.add(totalvote);
        }
        else if(this.eventId==0){
            this.eventId=eventId;
            eventIdListForPercitapteEmailList.add(this.eventId);
            eventSummaryModel = new OnVotingEventsSummary();
            eventSummaryModel.eventName=name;
            eventSummaryModel.TimeSlotList.add(timeSlot);
            eventSummaryModel.voteList.add(totalvote);
        }
        else{
           this.eventId=eventId;
           eventIdListForPercitapteEmailList.add(this.eventId);
           onVotingIdList.add(eventSummaryModel);
           eventSummaryModel = new OnVotingEventsSummary();
           eventSummaryModel.eventName=name;
           eventSummaryModel.TimeSlotList.add(timeSlot);
           eventSummaryModel.voteList.add(totalvote);
           
           
            
        }
    }
    
    private void getPerticipateEmailList(int eventId, int index){
        String perticipateEmailListSQL ="SELECT personal_information.email FROM `voting_notification` INNER JOIN "
                + "personal_information ON (voting_notification.attendees_id=personal_information.id) WHERE "
                + "voting_notification.events_id="+eventId;
        try {
            ResultSet rst= DatabaseConfiguration.statement.executeQuery(perticipateEmailListSQL);
            while (rst.next()) {
                System.out.println(rst.getString("email"));
                //eventSummaryModel.perticipateEmailList.add(rst.getString("email"));
                onVotingIdList.get(index).perticipateEmailList.add(rst.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
