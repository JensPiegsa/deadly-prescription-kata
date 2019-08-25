package prescriptions;

import static java.util.Collections.unmodifiableList;

import java.time.Instant;
import java.util.List;

public class Prescription {

	private final String doctor;
	private final Patient patient;
	private final List<PrescriptionLine> prescriptionLines;
	private final Instant date;

	public Prescription(String doctor, Patient patient, List<PrescriptionLine> prescriptionLines, Instant date) {
		this.doctor = doctor;
		this.patient = patient;
		this.prescriptionLines = unmodifiableList(prescriptionLines);
		this.date = date;
	}

	public String getDoctor() {
		return doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public List<PrescriptionLine> getLines() {
		return prescriptionLines;
	}

	public Instant getDate() {
		return date;
	}
}
