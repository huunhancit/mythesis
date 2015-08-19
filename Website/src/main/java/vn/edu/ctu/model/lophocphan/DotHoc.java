package vn.edu.ctu.model.lophocphan;

import java.util.List;

public class DotHoc {
	private String tendot;
	private String tuanhoc;
	private List<Buoi> buoi;

	public DotHoc() {
	}

	public DotHoc(String tendot, String tuanhoc, List<Buoi> buoi) {
		this.tendot = tendot;
		this.tuanhoc = tuanhoc;
		this.buoi = buoi;
	}

	public String getTendot() {
		return tendot;
	}

	public void setTendot(String tendot) {
		this.tendot = tendot;
	}

	public String getTuanhoc() {
		return tuanhoc;
	}

	public void setTuanhoc(String tuanhoc) {
		this.tuanhoc = tuanhoc;
	}

	public List<Buoi> getBuoi() {
		return buoi;
	}

	public void setBuoi(List<Buoi> buoi) {
		this.buoi = buoi;
	}

}
