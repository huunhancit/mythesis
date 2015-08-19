package vn.edu.ctu.thoikhoabieu;

import java.util.List;

import vn.edu.ctu.model.lophocphan.DotHoc;

public class HocPhan {
	private String mahocphan;
	private String tenhocphan;
	private String malophocphan;
	private int sotc;
	private List<DotHoc> dothoc;

	public HocPhan() {
	}

	public HocPhan(String mahocphan, String tenhocphan, String malophocphan,
			int sotc, List<DotHoc> dothoc) {
		this.mahocphan = mahocphan;
		this.tenhocphan = tenhocphan;
		this.malophocphan = malophocphan;
		this.sotc = sotc;
		this.dothoc = dothoc;
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

	public String getMalophocphan() {
		return malophocphan;
	}

	public void setMalophocphan(String malophocphan) {
		this.malophocphan = malophocphan;
	}

	public int getSotc() {
		return sotc;
	}

	public void setSotc(int sotc) {
		this.sotc = sotc;
	}

	public List<DotHoc> getDothoc() {
		return dothoc;
	}

	public void setDothoc(List<DotHoc> dothoc) {
		this.dothoc = dothoc;
	}

}
