
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.GregorianCalendar;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistry;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VTimeZone;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.UidGenerator;

public class iCal {

	public static void main(String[] args)
			throws IOException, ValidationException, ParserException, URISyntaxException, ParseException {

		// Create a TimeZone
		TimeZoneRegistry registry = TimeZoneRegistryFactory.getInstance().createRegistry();
		TimeZone timezone = registry.getTimeZone("Europe/Berlin");
		VTimeZone tz = timezone.getVTimeZone();

		/** Appointment 1 : Erstkommunionwallfahrt **/
		// Start Date is on:April 04,2016 10:00 am
		java.util.Calendar startDate = new GregorianCalendar();
		startDate.setTimeZone(timezone);
		startDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
		startDate.set(java.util.Calendar.DAY_OF_MONTH, 30);
		startDate.set(java.util.Calendar.YEAR, 2016);
		startDate.set(java.util.Calendar.HOUR_OF_DAY, 10);
		startDate.set(java.util.Calendar.MINUTE, 0);
		startDate.set(java.util.Calendar.SECOND, 0);

		// End Date is on: April 04,2016 , 6:00 pm
		java.util.Calendar endDate = new GregorianCalendar();
		endDate.setTimeZone(timezone);
		endDate.set(java.util.Calendar.MONTH, java.util.Calendar.APRIL);
		endDate.set(java.util.Calendar.DAY_OF_MONTH, 30);
		endDate.set(java.util.Calendar.YEAR, 2016);
		endDate.set(java.util.Calendar.HOUR_OF_DAY, 18);
		endDate.set(java.util.Calendar.MINUTE, 0);
		endDate.set(java.util.Calendar.SECOND, 0);

		// Create the event
		String eventName = "Wallfahrtstag der Erstkommunionkinder";
		DateTime start = new DateTime(startDate.getTime());
		DateTime end = new DateTime(endDate.getTime());

		VEvent wTagEKWallfahrt = new VEvent(start, end, eventName);
		wTagEKWallfahrt.getProperties().add(new Description(
				"Wallfahrtstag der Erstkommunionkinder. Themenwallfahrtstag mit verschiedenen Angeboten im Pfarr- und Gemeindezentrum"));
		wTagEKWallfahrt.getProperties().add(new Location("Walldürn"));

		// add timezone info..
		wTagEKWallfahrt.getProperties().add(tz.getTimeZoneId());

		// generate unique identifier..
		UidGenerator ug = new UidGenerator("uidGen");
		Uid uid = ug.generateUid();
		wTagEKWallfahrt.getProperties().add(uid);

		/** Appointment 2 : **/

		// Start Date is on: May 14,2016 10:00 am
		java.util.Calendar startApp2 = new GregorianCalendar();
		startApp2.setTimeZone(timezone);
		startApp2.set(java.util.Calendar.MONTH, java.util.Calendar.MAY);
		startApp2.set(java.util.Calendar.DAY_OF_MONTH, 14);
		startApp2.set(java.util.Calendar.YEAR, 2016);
		startApp2.set(java.util.Calendar.HOUR_OF_DAY, 13);
		startApp2.set(java.util.Calendar.MINUTE, 0);
		startApp2.set(java.util.Calendar.SECOND, 0);

		// End Date is on: MAY 14,2016 , 3:00 pm
		java.util.Calendar endApp2 = new GregorianCalendar();
		endApp2.setTimeZone(timezone);
		endApp2.set(java.util.Calendar.MONTH, java.util.Calendar.MAY);
		endApp2.set(java.util.Calendar.DAY_OF_MONTH, 14);
		endApp2.set(java.util.Calendar.YEAR, 2016);
		endApp2.set(java.util.Calendar.HOUR_OF_DAY, 17);
		endApp2.set(java.util.Calendar.MINUTE, 0);
		endApp2.set(java.util.Calendar.SECOND, 0);

		// Create the event
		String eventName2 = "Motorradwallfahrt";

		DateTime start2 = new DateTime(startApp2.getTime());
		DateTime end2 = new DateTime(endApp2.getTime());
		VEvent mBikeEvent = new VEvent(start2, end2, eventName2);
		mBikeEvent.getProperties()
				.add(new Description("Motorradwallfahrt. Vorher Mittagessen im Pfarr-und Gemeindezentrum"
						+ "Gottesdient um 14 Uhr ; anschließend Motorradsegnung"));
		mBikeEvent.getProperties().add(new Location("Walldürn"));

		// add timezone info..
		mBikeEvent.getProperties().add(tz.getTimeZoneId());

		// generate unique identifier..
		UidGenerator ug1 = new UidGenerator("uidGen");
		Uid uid1 = ug1.generateUid();
		mBikeEvent.getProperties().add(uid1);

		/** Appointment 3 :Hauptwallfahrt **/

		// Start Date is on:22 May 2016
		java.util.Calendar startApp3 = new GregorianCalendar();
		startApp3.setTimeZone(timezone);
		startApp3.set(java.util.Calendar.MONTH, java.util.Calendar.MAY);
		startApp3.set(java.util.Calendar.DAY_OF_MONTH, 22);
		startApp3.set(java.util.Calendar.YEAR, 2016);
		startApp3.set(java.util.Calendar.HOUR_OF_DAY, 8);
		startApp3.set(java.util.Calendar.MINUTE, 0);
		startApp3.set(java.util.Calendar.SECOND, 0);

		// End Date is on: June 19 ,2016
		java.util.Calendar endApp3 = new GregorianCalendar();
		endApp3.setTimeZone(timezone);
		endApp3.set(java.util.Calendar.MONTH, java.util.Calendar.JUNE);
		endApp3.set(java.util.Calendar.DAY_OF_MONTH, 19);
		endApp3.set(java.util.Calendar.YEAR, 2016);
		endApp3.set(java.util.Calendar.HOUR_OF_DAY, 22);
		endApp3.set(java.util.Calendar.MINUTE, 0);
		endApp3.set(java.util.Calendar.SECOND, 0);

		// Create the event
		String eventName3 = "Hauptwallfahrtszeit 2016";

		DateTime start3 = new DateTime(startApp3.getTime());
		DateTime end3 = new DateTime(endApp3.getTime());
		VEvent wallfahrt = new VEvent(start3, end3, eventName3);
		wallfahrt.getProperties()
				.add(new Description(" \"Barmherzigkeit will ich, nicht Opfer!\"(Mt 9,13).\n Hautpwallfahrtszeit in Walldürn"));
		wallfahrt.getProperties().add(new Location("Walldürn"));

		// add timezone info..
		wallfahrt.getProperties().add(tz.getTimeZoneId());

		// generate unique identifier..
		UidGenerator ug2 = new UidGenerator("uidGen");
		Uid uid2 = ug2.generateUid();
		wallfahrt.getProperties().add(uid2);

		/** Appointment 4 :Fahrradwallfahrt **/

		// Start Date is on:22 May 2016
		java.util.Calendar startApp4 = new GregorianCalendar();
		startApp4.setTimeZone(timezone);
		startApp4.set(java.util.Calendar.MONTH, java.util.Calendar.SEPTEMBER);
		startApp4.set(java.util.Calendar.DAY_OF_MONTH, 10);
		startApp4.set(java.util.Calendar.YEAR, 2016);
		startApp4.set(java.util.Calendar.HOUR_OF_DAY, 13);
		startApp4.set(java.util.Calendar.MINUTE, 0);
		startApp4.set(java.util.Calendar.SECOND, 0);

		// End Date is on: June 19 ,2016
		java.util.Calendar endApp4 = new GregorianCalendar();
		endApp4.setTimeZone(timezone);
		endApp4.set(java.util.Calendar.MONTH, java.util.Calendar.SEPTEMBER);
		endApp4.set(java.util.Calendar.DAY_OF_MONTH, 10);
		endApp4.set(java.util.Calendar.YEAR, 2016);
		endApp4.set(java.util.Calendar.HOUR_OF_DAY, 22);
		endApp4.set(java.util.Calendar.MINUTE, 0);
		endApp4.set(java.util.Calendar.SECOND, 0);

		// Create the event
		String eventName4 = "Fahrradwallfahrt 2016";

		DateTime start4 = new DateTime(startApp4.getTime());
		DateTime end4 = new DateTime(endApp4.getTime());
		VEvent bikeWallfahrt = new VEvent(start4, end4, eventName4);
		bikeWallfahrt.getProperties()
				.add(new Description("Fahrradwallfahrt 2016 - nähere Informationen folgen"));
		bikeWallfahrt.getProperties().add(new Location("Walldürn"));

		// add timezone info..
		bikeWallfahrt.getProperties().add(tz.getTimeZoneId());

		// generate unique identifier..
		UidGenerator ug3 = new UidGenerator("uidGen");
		Uid uid3 = ug3.generateUid();
		bikeWallfahrt.getProperties().add(uid3);

		// Create a calendar
		net.fortuna.ical4j.model.Calendar icsCalendar = new net.fortuna.ical4j.model.Calendar();
		icsCalendar.getProperties().add(new ProdId("-//WallfahrtsleitungWallduern//iCal4j 1.0//DE"));
		icsCalendar.getProperties().add(Version.VERSION_2_0);
		icsCalendar.getProperties().add(CalScale.GREGORIAN);

		// Add the event and print
		icsCalendar.getComponents().add(wTagEKWallfahrt);
		icsCalendar.getComponents().add(mBikeEvent);
		icsCalendar.getComponents().add(wallfahrt);
		icsCalendar.getComponents().add(bikeWallfahrt);

		FileOutputStream fout = new FileOutputStream("wallfahrtstage2016.ics");

		CalendarOutputter outputter = new CalendarOutputter();
		outputter.output(icsCalendar, fout);
	}

}
