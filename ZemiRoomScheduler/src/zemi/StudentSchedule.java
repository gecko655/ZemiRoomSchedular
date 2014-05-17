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
		// TODO Auto-generated method stub
		return null;
	}

}
