package vn.edu.ctu.model.lophocphan;

public class Buoi {
	private String thu;
	private String tiet;
	private String phong;

	public Buoi() {
	}

	public Buoi(String thu, String tiet, String phong) {
		this.thu = thu;
		this.tiet = tiet;
		this.phong = phong;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getTiet() {
		return tiet;
	}

	public void setTiet(String tiet) {
		this.tiet = tiet;
	}

	public String getPhong() {
		return phong;
	}

	public void setPhong(String phong) {
		this.phong = phong;
	}

}
