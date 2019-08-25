package prescriptions;

import java.time.Period;

public class Posology {

	private int portionsPerIntake;
	private int timesPerDay;
	private Period periodOfIntake;

	public int getPortionsPerIntake() {
		return portionsPerIntake;
	}

	public int getTimesPerDay() {
		return timesPerDay;
	}

	public Period getPeriodOfIntake() {
		return periodOfIntake;
	}
}
