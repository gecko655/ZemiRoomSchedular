package zemi;

public class TeacherTime {
	String day;
	String startTime;
	String endTime;
	
	public TeacherTime(String day, String startTime,String endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public TeacherTime() {
		// TODO Auto-generated constructor stub
	}

	public String getDay() {
		return day;
	}

	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}

	@Override
	public String toString() {
		return "TeacherTime [day=" + day + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

}
