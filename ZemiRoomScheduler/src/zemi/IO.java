package zemi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

public class IO {
	static List<Schedule> input() {
		inputTimetable();
		List<Schedule> schedules=new ArrayList<Schedule>();
		try {
			List<String[]> list ;
			list = Csv.load(new File("./testdata/graduate.csv"), new CsvConfig(), new StringArrayListHandler());
			for(String[] entry:list){
				String name=entry[0];
				String lab=entry[1];
				Status status=Status.valueOf(entry[2]);
				List<Integer> lectures=new ArrayList<Integer>();
				for(int i=3;i<entry.length;i++){
					lectures.add(Integer.parseInt(entry[i]));
				}
				schedules.add(new StudentSchedule(lab,status,lectures));
			}
			list = Csv.load(new File("./testdata/undergraduate.csv"), new CsvConfig(), new StringArrayListHandler());
			for(String[] entry:list){
				String name=entry[0];
				String lab=entry[1];
				Status status=Status.valueOf(entry[2]);
				List<Integer> lectures=new ArrayList<Integer>();
				for(int i=3;i<entry.length;i++){
					lectures.add(Integer.parseInt(entry[i]));
				}
				schedules.add(new StudentSchedule(lab,status,lectures));
			}
			list = Csv.load(new File("./testdata/teacher.csv"), new CsvConfig(), new StringArrayListHandler());
			for(String[] entry:list){
				String name=entry[0];
				String lab=entry[1];
				Status status=Status.valueOf(entry[2]);
				TeacherTime time=new TeacherTime(entry[3], entry[4], entry[5]);
				schedules.add(new TeacherSchedule(lab,status,time));
			}
			
			return schedules;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Reservation> inputReservationReq() {
		
		List<Reservation> reservations = new ArrayList<Reservation>();
        List<String[]> list ;
        try {
			list = Csv.load(new File("./testdata/reservationReq.csv"), new CsvConfig(), new StringArrayListHandler());
            for(String[] entry:list){
            	ArrayList<Status> attendee = new ArrayList<Status>();
                String lab=entry[0];
                for(int i=1;i<entry.length;i++){
                    attendee.add(Status.valueOf(entry[i]));
                }
                Reservation res = new Reservation(lab,attendee);
                reservations.add(res);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return reservations;

		
	}

	private static void inputTimetable(){
		LectureTimetable table = LectureTimetable.getInstance();
        List<String[]> list ;
        try {
			list = Csv.load(new File("./testdata/timetable.csv"), new CsvConfig(), new StringArrayListHandler());
            for(String[] entry:list){
                int lectureNum=Integer.valueOf(entry[0]);
                String day=entry[1];
                String koma=entry[2];
                LectureTime time= new LectureTime(day, koma);
                table.setLectureTime(lectureNum, time);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
	}

	static void output(List<Reservation> reservations) {

	}

}
