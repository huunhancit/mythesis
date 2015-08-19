package vn.edu.ctu.function;

import java.util.List;

import vn.edu.ctu.model.lophocphan.Buoi;
import vn.edu.ctu.model.lophocphan.DotHoc;
import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;
import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

public class CheckFunction {
	public static boolean checkExistSV(List<LopHocPhan> lop, String mssv) {
		for (LopHocPhan l : lop) {
			for (SinhVien sv : l.getDanhsachsinhvien()) {
				if (sv.getMssv().equals(mssv)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean checkTiet(String tiet1, String tiet2) {
		char t[] = tiet1.toCharArray();
		char t1[] = tiet2.toCharArray();
		boolean res = false;
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t1.length; j++) {
				if (t[i] == t1[j]) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean checkTuan(String tuan1, String tuan2) {
		String t1[] = tuan1.split(",");
		String t2[] = tuan2.split(",");
		boolean res = false;
		for (String i : t1) {
			for (String j : t2) {
				if (i.equals(j)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean checkBuoi(List<Buoi> buoi1, List<Buoi> buoi2) {
		boolean res = false;
		for (Buoi b1 : buoi1) {
			for (Buoi b2 : buoi2) {
				if (b1.getThu().equals(b2.getThu())
						&& checkTiet(b1.getTiet(), b2.getTiet())) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean checkDotHoc(List<DotHoc> dothoc1, List<DotHoc> dothoc2) {
		boolean res = false;
		for (DotHoc d1 : dothoc1) {
			for (DotHoc d2 : dothoc2) {
				if (checkTuan(d1.getTuanhoc(), d1.getTuanhoc())) {
					if (checkBuoi(d1.getBuoi(), d2.getBuoi())) {
						res = true;
					}
				}
			}
		}
		return res;
	}

	public static String checkTKB(LopHocPhan lophocphan,
			ThoiKhoaBieu thoikhoabieu) {
		if (thoikhoabieu != null) {
			for (HocPhan hp : thoikhoabieu.getHocphan()) {
				if (checkDotHoc(hp.getDothoc(), lophocphan.getDothoc())) {
					return hp.getMahocphan();
				}
			}
		}
		return null;
	}
}
