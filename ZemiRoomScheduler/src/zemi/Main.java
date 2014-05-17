package zemi;

import java.util.List;

public class Main {
	static List<Schedule> schedules;
	static List<Reservation> reservations;

	public static void main(String[] args) {
		Calculate calc = new Calculate(IO.input());
		reservations = calc.calc(1);
		IO.output(reservations);

	}

}
