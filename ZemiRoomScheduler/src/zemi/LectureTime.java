package zemi;

import java.util.ArrayList;
import java.util.List;

public class LectureTime {
	String day;
	String koma;
	final static int[][] defaultTime = {{900,1030},{1045,1215},{1320,1450},{1505,1635},{1650,1820}};
	final static String[] days ={"Mon","Tue","Wed","Thu","Fri"};
	final static String[] komas ={"1","2","3","4","5"};

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
				lTime.add(new LectureTime(tTime.getDay(), String.valueOf(i)+1));
			}
		}
		return lTime;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((koma == null) ? 0 : koma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LectureTime other = (LectureTime) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (koma == null) {
			if (other.koma != null)
				return false;
		} else if (!koma.equals(other.koma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LectureTime [day=" + day + ", koma=" + koma + "]";
	}
}
