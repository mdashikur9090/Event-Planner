package event.planner.model;

import java.util.ArrayList;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class OnVotingEventsSummary {
    public ArrayList<String> TimeSlotList = new ArrayList<>();
    public ArrayList<String> perticipateEmailList = new ArrayList<>();
    public ArrayList<Integer> voteList = new ArrayList<>();
    public String eventName;
    
    public OnVotingEventsSummary() {
        
    }

    public ArrayList<String> getTimeSlotList() {
        return TimeSlotList;
    }

    public void setTimeSlotList(ArrayList<String> TimeSlotList) {
        this.TimeSlotList = TimeSlotList;
    }

    public ArrayList<String> getPerticipateEmailList() {
        return perticipateEmailList;
    }

    public void setPerticipateEmailList(ArrayList<String> perticipateEmailList) {
        this.perticipateEmailList = perticipateEmailList;
    }

    public ArrayList<Integer> getVoteList() {
        return voteList;
    }

    public void setVoteList(ArrayList<Integer> voteList) {
        this.voteList = voteList;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
       
}
