package zemi;

import java.util.Map;

public class LectureTimetable {
	Map<Integer,LectureTime> lectureTimetable;
	public LectureTimetable(){
		
	}
	
	public void setLectureTime(int lectureNum, LectureTime lectureTime){
		lectureTimetable.put(new Integer(lectureNum), lectureTime);
	}

	public LectureTime getLectureTime(int lectureNum){
		return lectureTimetable.get(lectureTimetable);
	}
}
