package vn.edu.ctu.function;

import java.util.List;

import vn.edu.ctu.model.kehoach.HocPhan;
import vn.edu.ctu.model.kehoach.KeHoach;

public class CountTCKeHoach {
	public static int countTC(List<KeHoach> kehoach) {
		int count = 0;
		for (KeHoach kh : kehoach) {
			count = count + kh.getTongsotc();
		}
		return count;
	}

	public static int countTCHK(List<HocPhan> hocphan) {
		int count = 0;
		for (HocPhan hp : hocphan) {
			count = count + hp.getSotc();
		}
		return count;
	}

	public static int countTCHK1(List<vn.edu.ctu.thoikhoabieu.HocPhan> hocphan) {
		int count = 0;
		for (vn.edu.ctu.thoikhoabieu.HocPhan hp : hocphan) {
			count = count + hp.getSotc();
		}
		return count;
	}
}
