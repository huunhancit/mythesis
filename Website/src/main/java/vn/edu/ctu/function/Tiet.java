package vn.edu.ctu.function;

public class Tiet {
	public static String convertTiet(String tietbatdau, String sotiet) {
		int bd = (int) Float.parseFloat(tietbatdau);
		int st = (int) Float.parseFloat(sotiet);
		String t = "";
		for (int i = bd; i < (bd + st); i++) {
			t = t + i;
		}
		return t;
	}
}
