package zemi;

import java.util.List;

public abstract class Schedule {

	Status status;
	String laboratory;

	abstract List<LectureTime> getSchedule();
}
