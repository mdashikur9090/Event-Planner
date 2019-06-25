package event.planner.model;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class Event {
    private String name, eventCreatorName, location, description;
    private int duration, minimumAttedees, minimumThreshold, eventID;

    
    public Event() {
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventCreatorName() {
        return eventCreatorName;
    }

    public void setEventCreatorName(String eventCreatorName) {
        this.eventCreatorName = eventCreatorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinimumAttedees() {
        return minimumAttedees;
    }

    public void setMinimumAttedees(int minimumAttedees) {
        this.minimumAttedees = minimumAttedees;
    }

    public int getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(int minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }
    
    
  
}
