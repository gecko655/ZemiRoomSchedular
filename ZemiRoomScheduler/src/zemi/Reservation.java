package zemi;

import java.util.List;

public class Reservation {
	String lab;
	List<Status> attendee;
	LectureTime time;
	public Reservation(String lab, List<Status> attendee){
		this.lab=lab;
		this.attendee=attendee;
	}
	public List<Status> getAttendee() {
		return attendee;
	}
	public String getLaboratory() {
		return lab;
	}
	
	public void setLectureTime(LectureTime time){
		this.time=time;
	}
	@Override
	public String toString() {
		return "Reservation [lab=" + lab + ", attendee=" + attendee + ", time="
				+ time + "]";
	}
	public LectureTime getLectureTime() {
		return time;
	}


}
