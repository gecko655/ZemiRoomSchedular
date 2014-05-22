package zemi;

import java.util.ArrayList;
import java.util.List;

public class LectureTime {
	String day;
	String koma;
	final static int[][] defaultTime = {{900,1030},{1045,1215},{1320,1450},{1505,1635},{1650,1820}};

	public LectureTime(String day, String koma) {
		this.day = day;
		this.koma = koma;
	}

	public String getDay() {
		return day;
	}

	public String getKoma() {
		return koma;
	}
	
	static List<LectureTime> convert(TeacherTime tTime){
		List<LectureTime> lTime = new ArrayList<LectureTime>();
		int start = Integer.parseInt(tTime.getStartTime());
		int end = Integer.parseInt(tTime.getEndTime());
		for(int i=0;i<defaultTime.length;i++){
			if(start<defaultTime[i][1]&&defaultTime[i][0]<end){
				lTime.add(new LectureTime(tTime.getDay(), String.valueOf(i)));
			}
		}
		return lTime;
		
	}
}
