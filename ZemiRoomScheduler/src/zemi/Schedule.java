package zemi;

import java.util.List;

public abstract class Schedule {

	Status status;
	String laboratory;

	public Status getStatus() {
		return status;
	}

	public String getLaboratory() {
		return laboratory;
	}

	abstract List<LectureTime> getSchedule();
}
