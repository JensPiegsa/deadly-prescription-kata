package prescriptions;

import static java.util.Collections.unmodifiableList;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class LethalDosesChecker {

	private final LethalDosesStore lethalDoses;

	@Inject
	public LethalDosesChecker(LethalDosesStore lethalDoses) {
		this.lethalDoses = lethalDoses;
	}

	public List<String> checkDoses(Prescription prescription) {

		List<String> alerts = new ArrayList<>();

		Patient patient = prescription.getPatient();
		Instant dateOfBirth = patient.getDateOfBirth();
		Instant dateOfPrescription = prescription.getDate();
		boolean isAdult = Period.between(LocalDate.from(dateOfPrescription), LocalDate.from(dateOfBirth)).getYears() >= 18;

		Map<String, Long> dailyDosagePerIngredient =  new HashMap<>();
		List<PrescriptionLine> prescriptionLines = prescription.getLines();
		for (PrescriptionLine prescriptionLine : prescriptionLines) {
			Drug drug = prescriptionLine.getDrug();
			long drugDosage = drug.getDosage();
			List<String> ingredients = drug.getIngredients();
			Posology posology = prescriptionLine.getPosology();
			int portionPercentile = posology.getPortionsPerIntake();
			int timesPerDay = posology.getTimesPerDay();
			Period periodsOfIntake = posology.getPeriodOfIntake(); // TODO take periods of intakes into account
			for (String ingredient : ingredients) {
				Long currentDosage = dailyDosagePerIngredient.getOrDefault(ingredient, 0L);
				dailyDosagePerIngredient.put(ingredient, currentDosage + (portionPercentile / 100L * drugDosage * timesPerDay));
			}
		}
		for (String ingredient : dailyDosagePerIngredient.keySet()) {
			if (dailyDosagePerIngredient.get(ingredient) >= lethalDoses.getLethalDosePerDay(ingredient, isAdult)) {
				alerts.add("Prescription exceeds lethal dose per day for ingredient " + ingredient + "!");
			}
		}
		return unmodifiableList(alerts);
	}
}
