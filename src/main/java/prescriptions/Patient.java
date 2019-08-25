package prescriptions;

import java.time.Instant;

public class Patient {

	private Instant dateOfBirth;
	private int sex;

	public Patient(Instant dateOfBirth, int sex) {
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}
}
