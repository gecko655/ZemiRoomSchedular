package zemi;

import java.util.ArrayList;
import java.util.List;

public class StudentSchedule extends Schedule {
	List<Integer> lectures;

	public StudentSchedule(String lab,Status status){
		this.status=status;
		this.laboratory=lab;
		lectures=new ArrayList<Integer>();
	}
	public StudentSchedule(String lab,Status status,List<Integer> lectures){
		this.status=status;
		this.laboratory=lab;
		this.lectures=lectures;
	}

	@Override
	List<LectureTime> getSchedule() {
		LectureTimetable table = LectureTimetable.getInstance();
		List<LectureTime> times = new ArrayList<LectureTime>();
		for(Integer lecture: lectures){
            LectureTime time = table.getLectureTime(lecture);
            if(time!=null){
            	times.add(time);
            }
		}
		return times;
	}

	@Override
	public String toString() {
		return "StudentSchedule [lectures=" + lectures + ", status=" + status
				+ ", laboratory=" + laboratory + "]";
	}
	

}
