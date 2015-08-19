package vn.edu.ctu.model.kehoach;

public class HocPhan {
	private String mahocphan;
	private String tenhocphan;
	private int sotc;
	private String batbuoc;
	private String tuchon;
	private String hocphantienquyet;
	private int trangthai;

	public HocPhan() {
	}

	public HocPhan(String mahocphan, String tenhocphan, int sotc,
			String batbuoc, String tuchon, String hocphantienquyet,
			int trangthai) {
		this.mahocphan = mahocphan;
		this.tenhocphan = tenhocphan;
		this.sotc = sotc;
		this.batbuoc = batbuoc;
		this.tuchon = tuchon;
		this.hocphantienquyet = hocphantienquyet;
		this.trangthai = trangthai;
	}

	public String getMahocphan() {
		return mahocphan;
	}

	public void setMahocphan(String mahocphan) {
		this.mahocphan = mahocphan;
	}

	public String getTenhocphan() {
		return tenhocphan;
	}

	public void setTenhocphan(String tenhocphan) {
		this.tenhocphan = tenhocphan;
	}

	public int getSotc() {
		return sotc;
	}

	public void setSotc(int sotc) {
		this.sotc = sotc;
	}

	public String getBatbuoc() {
		return batbuoc;
	}

	public void setBatbuoc(String batbuoc) {
		this.batbuoc = batbuoc;
	}

	public String getTuchon() {
		return tuchon;
	}

	public void setTuchon(String tuchon) {
		this.tuchon = tuchon;
	}

	public String getHocphantienquyet() {
		return hocphantienquyet;
	}

	public void setHocphantienquyet(String hocphantienquyet) {
		this.hocphantienquyet = hocphantienquyet;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

}
