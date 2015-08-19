package vn.edu.ctu.dao;

import java.util.List;

import vn.edu.ctu.model.kehoach.KeHoach;

public interface KeHoachDAO {

	public void createKeHoach(KeHoach kehoach);

	public List<KeHoach> findKeHoachBy(String mssv);

	public KeHoach getListHPByHKNH(String mssv, String namhoc, String hocky);

	public void setTrangThaiDK(String mssv, String namhoc, String hocky,
			String mahocphan);

	public void setTrangThaiChuaDK(String mssv, String namhoc, String hocky,
			String mahocphan);
}
