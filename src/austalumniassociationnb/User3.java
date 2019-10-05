package austalumniassociationnb;
public class User3 {
private int EventID;
private String EventName,Department,EventVenue,EventDate,EventTime,EventMessage;

public User3(int EventID,String EventName,String Department,String EventVenue,String EventDate, String EventTime,String EventMessage)
{
    this.EventID=EventID;
    this.EventName=EventName;
    this.Department=Department;
    this.EventVenue=EventVenue;
    this.EventDate=EventDate;
    this.EventTime=EventTime;
    this.EventMessage=EventMessage;
}
public int getEventID()
{
    return EventID;
}

public String getEventName()
{
    return EventName;
}
public String getDepartment()
{
    return Department;
}
public String getEventVenue()
{
    return EventVenue;
}
public String getEventDate()
{
    return EventDate;
}
public String getEventTime()
{
    return EventTime;
}
public String getEventMessage()
{
    return EventMessage;
}
}
