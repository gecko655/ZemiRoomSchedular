package zemi;

import java.util.ArrayList;
import java.util.List;

public class TeacherSchedule extends Schedule {
	TeacherTime teacherTime;
	
	public TeacherSchedule(String lab,Status status){
		this.status=status;
		this.laboratory=lab;
		teacherTime=new TeacherTime();
	}
	public TeacherSchedule(String lab,Status status,TeacherTime time){
		this.status=status;
		this.laboratory=lab;
		this.teacherTime=time;
	}


	@Override
	List<LectureTime> getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

}
