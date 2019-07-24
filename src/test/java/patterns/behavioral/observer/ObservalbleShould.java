package patterns.behavioral.observer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class ObservalbleShould {

	@Test
	public void notify_observers_when_state_changes_in_observed() {
		Observed observed = new Observed();
		Observable observable1 = mock(ObservableOne.class);
		Observable observable2 = mock(ObservableTwo.class);
		observed.addObserver(observable1);
		observed.addObserver(observable2);
		observed.callEvent("Event");
		verify(observable1).notified("Event");
		verify(observable2).notified("Event");
		
	}

}
