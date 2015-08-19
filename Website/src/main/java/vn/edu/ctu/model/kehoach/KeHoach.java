package vn.edu.ctu.model.kehoach;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kehoach")
public class KeHoach {
	@Id
	private String id;
	@Indexed
	private String mssv;
	private String manganh;
	private String tennganh;
	private int khoahoc;
	@Indexed
	private String namhoc;
	@Indexed
	private String hocky;
	private int tongsotc;
	private int tongsohocphan;
	private List<HocPhan> hocphan;

	public KeHoach() {
	}

	public KeHoach(String id, String mssv, String manganh, String tennganh,
			int khoahoc, String namhoc, String hocky, int tongsotc,
			int tongsohocphan, List<HocPhan> hocphan) {
		this.id = id;
		this.mssv = mssv;
		this.manganh = manganh;
		this.tennganh = tennganh;
		this.khoahoc = khoahoc;
		this.namhoc = namhoc;
		this.hocky = hocky;
		this.tongsotc = tongsotc;
		this.tongsohocphan = tongsohocphan;
		this.hocphan = hocphan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getManganh() {
		return manganh;
	}

	public void setManganh(String manganh) {
		this.manganh = manganh;
	}

	public String getTennganh() {
		return tennganh;
	}

	public void setTennganh(String tennganh) {
		this.tennganh = tennganh;
	}

	public int getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(int khoahoc) {
		this.khoahoc = khoahoc;
	}

	public String getNamhoc() {
		return namhoc;
	}

	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}

	public String getHocky() {
		return hocky;
	}

	public void setHocky(String hocky) {
		this.hocky = hocky;
	}

	public int getTongsotc() {
		return tongsotc;
	}

	public void setTongsotc(int tongsotc) {
		this.tongsotc = tongsotc;
	}

	public int getTongsohocphan() {
		return tongsohocphan;
	}

	public void setTongsohocphan(int tongsohocphan) {
		this.tongsohocphan = tongsohocphan;
	}

	public List<HocPhan> getHocphan() {
		return hocphan;
	}

	public void setHocphan(List<HocPhan> hocphan) {
		this.hocphan = hocphan;
	}

	public void setTrangThaiDk(String mahocphan) {
		for (HocPhan hp : hocphan) {
			if (hp.getMahocphan().equals(mahocphan)) {
				hp.setTrangthai(1);
			}
		}
	}

	public void setTrangThaiChuaDK(String mahocphan) {
		for (HocPhan hp : hocphan) {
			if (hp.getMahocphan().equals(mahocphan)) {
				hp.setTrangthai(0);
			}
		}
	}
}
