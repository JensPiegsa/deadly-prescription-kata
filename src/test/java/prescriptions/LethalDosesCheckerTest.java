package prescriptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("LethalDosesChecker")
class LethalDosesCheckerTest {

	@Mock LethalDosesStore lethalDosesStore;
	@InjectMocks LethalDosesChecker checker;

	@Test @DisplayName("works.")
	void works() {
		// TODO
	}
}