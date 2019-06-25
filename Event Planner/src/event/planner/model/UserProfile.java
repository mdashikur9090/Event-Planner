package event.planner.model;


/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class UserProfile {
   private String userName, email, passwords, location;
   private int userID;
   private boolean [][] weekLytimeSlot=new boolean[7][13];

    public UserProfile(String userName, String email, String passwords, String location) {
        this.userName = userName;
        this.email = email;
        this.passwords = passwords;
        this.location = location;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean[][] getWeekLytimeSlot() {
        return weekLytimeSlot;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    

    public void setWeekLytimeSlot(boolean[][] weekLytimeSlot) {
        this.weekLytimeSlot = weekLytimeSlot;
    }
   
    
   
   
   
    
}
