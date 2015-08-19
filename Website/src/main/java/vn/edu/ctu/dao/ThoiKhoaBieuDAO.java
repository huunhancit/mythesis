package vn.edu.ctu.dao;

import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

public interface ThoiKhoaBieuDAO {

	public void createThoiKhoaBieu(ThoiKhoaBieu tkb);

	public ThoiKhoaBieu findTKBBy(String mssv, String hocky, String namhoc);

	public void addHocPhanTKB(String mssv, String hocky, String namhoc,
			HocPhan hocphan);

	public void xoaHocPhanTKB(String mssv, String hocky, String namhoc,
			String mahocphan);
}