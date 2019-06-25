package event.planner.model;

import java.util.ArrayList;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class VotingInvitation {
    private int eventId;
    private  String eventName;
    private ArrayList<String> timeSlotList=new ArrayList<>();

    public VotingInvitation(int eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public ArrayList<String> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(ArrayList<String> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }
    
    
}
