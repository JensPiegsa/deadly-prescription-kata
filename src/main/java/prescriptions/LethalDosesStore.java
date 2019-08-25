package prescriptions;

public interface LethalDosesStore {

	long getLethalDosePerDay(String ingredient, boolean isAdult);

}
