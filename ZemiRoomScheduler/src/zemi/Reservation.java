package zemi;

import java.util.List;

public class Reservation {
	String lab;
	List<Status> attendee;
	public Reservation(String lab, List<Status> attendee){
		this.lab=lab;
		this.attendee=attendee;
	}

}
