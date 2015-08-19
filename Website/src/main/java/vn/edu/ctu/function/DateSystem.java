package vn.edu.ctu.function;

import java.util.Calendar;

public class DateSystem {
	public static String getHocKySystem() {
		String hocky = "";
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		if (month >= 8 && month <= 12) {
			hocky = "1";
		} else if (month >= 1 && month <= 5) {
			hocky = "2";
		} else {
			hocky = "he";
		}
		return hocky;
	}

	public static String getNamHocSystem() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int y = year - 1;
		return "" + y + "-" + year;
	}
}
