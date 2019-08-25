package prescriptions;

public class PrescriptionLine {

	private final Drug drug;
	private final Posology posology;

	public PrescriptionLine(Drug drug, Posology posology) {
		this.drug = drug;
		this.posology = posology;
	}

	public Drug getDrug() {
		return drug;
	}

	public Posology getPosology() {
		return posology;
	}
}
