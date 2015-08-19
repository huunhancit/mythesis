package vn.edu.ctu.model.lophocphan;

public class SinhVien {
	private String mssv;
	private String hoten;

	public SinhVien() {
	}

	public SinhVien(String mssv, String hoten) {
		this.mssv = mssv;
		this.hoten = hoten;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

}
