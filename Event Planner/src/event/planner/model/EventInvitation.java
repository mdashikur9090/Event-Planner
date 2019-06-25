package event.planner.model;

import java.util.ArrayList;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class EventInvitation {
    private ArrayList<Event> invitationEventList = new ArrayList<>();

    public EventInvitation() {
    }
    
    public void addEvent(Event event){
        invitationEventList.add(event);
    }


    public ArrayList<Event> getInvitationEventList() {
        return invitationEventList;
    }

    public void setInvitationEventList(ArrayList<Event> invitationEventList) {
        this.invitationEventList = invitationEventList;
    }
            
}
