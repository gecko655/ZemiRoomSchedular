package zemi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.sf.orangesignal.csv.Csv;
import jp.sf.orangesignal.csv.CsvConfig;
import jp.sf.orangesignal.csv.handlers.StringArrayListHandler;

public class IO {
	static ArrayList<Schedule> input() {
		try {
			List<String[]> list = Csv.load(new File("test.csv"), new CsvConfig(), new StringArrayListHandler());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static void output(List<Reservation> reservations) {

	}

}
