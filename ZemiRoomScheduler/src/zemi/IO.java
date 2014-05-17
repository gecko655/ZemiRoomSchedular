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

	static void output(List<Reservation> reservations) {

	}

}
