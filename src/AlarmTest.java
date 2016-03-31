import net.fortuna.ical4j.model.Dur;
import net.fortuna.ical4j.model.component.VAlarm;
import net.fortuna.ical4j.model.property.Action;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Duration;
import net.fortuna.ical4j.model.property.Repeat;

public class AlarmTest {

	public static void main(String[] args) {
		
		
		
		VAlarm reminder = new VAlarm(new Dur(0, -1, 0, 0));

		 // repeat reminder four (4) more times every fifteen (15) minutes..
		 reminder.getProperties().add(new Repeat(4));
		 reminder.getProperties().add(new Duration(new Dur(0, 0, 15, 0)));

		 // display a message..
		 reminder.getProperties().add(Action.DISPLAY);
		 reminder.getProperties().add(new Description("Progress Meeting at 9:30am"));
	}

}
