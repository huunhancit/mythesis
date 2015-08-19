package vn.edu.ctu.function;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import vn.edu.ctu.dao.ThoiKhoaBieuDAO;
import vn.edu.ctu.model.lophocphan.Buoi;
import vn.edu.ctu.model.lophocphan.DotHoc;
import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

public class TKB {
	@Autowired
	ThoiKhoaBieuDAO thoiKhoaBieuDAO;

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

	public static List<HocPhan> getTKBBYTuanThu(String thu, String tuan,
			List<HocPhan> hp) {
		List<HocPhan> hocphan = new ArrayList<HocPhan>();
		for (HocPhan h : hp) {
			for (DotHoc d : h.getDothoc()) {
				if (checkTuan(tuan, d.getTuanhoc())) {
					List<DotHoc> dot = new ArrayList<DotHoc>();
					dot.add(d);
					h.setDothoc(dot);
					for (Buoi b : d.getBuoi()) {
						if (b.getThu().equals(thu)) {
							hocphan.add(h);
						}
					}
				}
			}
		}
		return hocphan;
	}

	public List<HocPhan> thu() {
		ThoiKhoaBieu tkb = this.thoiKhoaBieuDAO.findTKBBy("1111428", "2",
				"2014-2015");
		List<HocPhan> hocphan = tkb.getHocphan();
		return getTKBBYTuanThu("2", "1", hocphan);
	}

	public static void main(String arg[]) {
		TKB k = new TKB();
		for (HocPhan hp : k.thu()) {
			System.out.println(hp.getMahocphan());
		}
	}
}
