package vn.edu.ctu.thoikhoabieu;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "thoikhoabieu")
public class ThoiKhoaBieu {
	@Id
	private String id;
	@Indexed
	private String mssv;
	@Indexed
	private String hocky;
	@Indexed
	private String namhoc;
	private String ngaydatdau;
	private List<HocPhan> hocphan;

	public ThoiKhoaBieu() {
	}

	public ThoiKhoaBieu(String id, String mssv, String hocky, String namhoc,
			String ngaydatdau, List<HocPhan> hocphan) {
		this.id = id;
		this.mssv = mssv;
		this.hocky = hocky;
		this.namhoc = namhoc;
		this.ngaydatdau = ngaydatdau;
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

	public String getHocky() {
		return hocky;
	}

	public void setHocky(String hocky) {
		this.hocky = hocky;
	}

	public String getNamhoc() {
		return namhoc;
	}

	public void setNamhoc(String namhoc) {
		this.namhoc = namhoc;
	}

	public String getNgaydatdau() {
		return ngaydatdau;
	}

	public void setNgaydatdau(String ngaydatdau) {
		this.ngaydatdau = ngaydatdau;
	}

	public List<HocPhan> getHocphan() {
		return hocphan;
	}

	public void setHocphan(List<HocPhan> hocphan) {
		this.hocphan = hocphan;
	}

	public void addHocPhan(HocPhan hocphan) {
		this.getHocphan().add(hocphan);
	}

	public void xoaHPKH(String mahocphan) {
		for (int i = 0; i < hocphan.size(); i++) {
			if (hocphan.get(i).getMahocphan().equals(mahocphan)) {
				hocphan.remove(i);
			}
		}
	}
}
