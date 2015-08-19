package vn.edu.ctu.function;
 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddDate {
	public static String addDays(String d, int days) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(formatter.parse(d));
			cal.add(Calendar.DATE, days); // minus number would decrement the days
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter.format(cal.getTime());
	}
}
