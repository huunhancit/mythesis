package vn.edu.ctu.dao;

import java.util.List;

import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;

public interface LopHocPhanDAO {
	public void createLopHocPhan(LopHocPhan lopHocPhan);

	public List<LopHocPhan> findLopHocPhanByMaHP(String hocky, String namhoc,
			String mahocphan);

	public List<LopHocPhan> findLop(String hocky, String namhoc);

	public void registryHP(String hocky, String namhoc, String mahocphan,
			String malophocphan, SinhVien sinhvien);

	public LopHocPhan getLopHocPhan(String hocky, String namhoc,
			String mahocphan, String malophocphan);

	public void xoaLop(String hocky, String namhoc, String mahocphan,
			String malophocphan, SinhVien sv);
}
