package zemi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculate {
	List<Schedule> schedules;
	List<LectureTime> defaultTime=new ArrayList<LectureTime>();
	final static String[] days =LectureTime.days;
	final static String[] komas =LectureTime.komas;
	

	public Calculate(List<Schedule> schedules) {
		this.schedules = schedules;
		for(String day: days){
            for(String koma: komas){
                defaultTime.add(new LectureTime(day,koma));
            }
		}
	}

	public List<Reservation> calc(List<Reservation> resrvs, int num) {
		Map<Reservation,List<LectureTime>> reservableTimes=new HashMap<Reservation,List<LectureTime>>();
		for(Reservation reservation: resrvs){
			List<LectureTime> reservableTime = new ArrayList<LectureTime>(defaultTime);
			for(Schedule schedule: schedules){
				if(schedule.getLaboratory().equals(reservation.getLaboratory())&&reservation.getAttendee().contains(schedule.getStatus())){
					for(LectureTime time: schedule.getSchedule()){
                        reservableTime.remove(time);
					}
				}
			}
			reservableTimes.put(reservation,reservableTime);
		}
		Set<Reservation> keys = reservableTimes.keySet();
		List<LectureTime> vacantSeminarRoomTime = new ArrayList<LectureTime>(defaultTime);
		List<LectureTime> occupiedSeminarRoomTime = new ArrayList<LectureTime>();
		List<Reservation> reservations = new ArrayList<Reservation>();
		for(Reservation res: keys){
			List<LectureTime> reservableTime=reservableTimes.get(res);
			for(LectureTime time: vacantSeminarRoomTime){
				if(reservableTime.contains(time)){
					vacantSeminarRoomTime.remove(time);
					occupiedSeminarRoomTime.add(time);
					res.setLectureTime(time);
					reservations.add(res);
					break;
				}
			}
		}
		
		return reservations;
	}

}
