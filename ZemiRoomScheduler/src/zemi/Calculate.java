package zemi;

import java.util.List;

public class Calculate {
	List<Schedule> schedules;

	public Calculate(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	List<Reservation> calc(List<Reservation> reservations, int num) {
		for(Schedule schedule: schedules){
            System.err.println(schedule);
		}
		return null;
	}

}
