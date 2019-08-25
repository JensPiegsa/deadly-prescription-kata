package prescriptions;

import static java.util.Collections.unmodifiableList;

import java.util.List;

public class Drug {

	private final long dosage;
	private final List<String> ingredients;

	public Drug(long dosage, List<String> ingredients) {
		this.dosage = dosage;
		this.ingredients = unmodifiableList(ingredients);
	}

	public long getDosage() {
		return dosage;
	}

	public List<String> getIngredients() {
		return ingredients;
	}
}
