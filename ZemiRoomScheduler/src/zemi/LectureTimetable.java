package zemi;

import java.util.HashMap;
import java.util.Map;

public class LectureTimetable {
	Map<Integer, LectureTime> lectureTimetable;
	private static LectureTimetable instance;

	private LectureTimetable() {
		lectureTimetable = new HashMap<Integer,LectureTime>();

	}
	static public LectureTimetable getInstance(){
		if(instance==null){
			instance = new LectureTimetable();
		}
		return instance;
	}

	public void setLectureTime(int lectureNum, LectureTime lectureTime) {
		lectureTimetable.put(new Integer(lectureNum), lectureTime);
	}

	public LectureTime getLectureTime(int lectureNum) {
		if(!lectureTimetable.containsKey(lectureNum)){
			return null;
		}
		return lectureTimetable.get(lectureNum);
	}

	@Override
	public String toString() {
		return "LectureTimetable [lectureTimetable=" + lectureTimetable + "]";
	}
}
