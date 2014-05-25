package zemi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Calculate {
	List<Schedule> schedules;
	List<LectureTime> defaultTime=new ArrayList<LectureTime>();
	List<LectureTime> twoFiveTime=new ArrayList<LectureTime>();
	List<LectureTime> twoFourTime=new ArrayList<LectureTime>();
	final static String[] days =LectureTime.days;
	final static String[] komas =LectureTime.komas;
	

	public Calculate(List<Schedule> schedules) {
		this.schedules = schedules;
		for(String day: days){
            for(String koma: komas){
                defaultTime.add(new LectureTime(day,koma));
                if(!koma.equals("1")){
                    twoFiveTime.add(new LectureTime(day,koma));
                    if(!koma.equals("5")){
                        twoFourTime.add(new LectureTime(day,koma));
                    }
                }
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

		List<Map.Entry<Reservation, List<LectureTime>>> lres=new ArrayList<Map.Entry<Reservation,List<LectureTime>>>(reservableTimes.entrySet());
		Collections.sort(lres,new Comparator<Map.Entry<Reservation, List<LectureTime>>>(){
			@Override
			public int compare(Entry<Reservation, List<LectureTime>> o1,
					Entry<Reservation, List<LectureTime>> o2) {
				return o1.getValue().size() - o2.getValue().size();
			}
		});
		List<Reservation> result = calcForTime(lres,twoFourTime);
		if(result==null)
            result = calcForTime(lres,twoFiveTime);
		if(result==null)
            result = calcForTime(lres,defaultTime);
		return result;
	}
		
		private List<Reservation> calcForTime(List<Map.Entry<Reservation, List<LectureTime>>> lres, List<LectureTime> times){
		
		List<LectureTime> vacantSeminarRoomTime = new ArrayList<LectureTime>(times);
		List<LectureTime> occupiedSeminarRoomTime = new ArrayList<LectureTime>();
		List<Reservation> reservations = new ArrayList<Reservation>();
		for(Map.Entry<Reservation, List<LectureTime>> resTime: lres){
			List<LectureTime> reservableTime=resTime.getValue();
			boolean flag=false;
			for(LectureTime time: vacantSeminarRoomTime){
				if(reservableTime.contains(time)){
					vacantSeminarRoomTime.remove(time);
					occupiedSeminarRoomTime.add(time);
					Reservation res =resTime.getKey();
					res.setLectureTime(time);
					reservations.add(res);
					flag=true;
					break;
				}
			}
			if(flag==false){
				return null;
			}
		}
		
		return reservations;
	}

}
