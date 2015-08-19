package vn.edu.ctu.model.lophocphan;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lophocphan")
public class LopHocPhan {
	@Id
	private String id;
	@Indexed
	private String hocky;
	@Indexed
	private String namhoc;
	@Indexed
	private String mahocphan;
	private String tenhocphan;
	private int sotc;
	@Indexed
	private String malophocphan;
	private int siso;
	private int sisoconlai;
	List<DotHoc> dothoc;
	List<SinhVien> danhsachsinhvien;

	public LopHocPhan() {
	}

	public LopHocPhan(String id, String hocky, String namhoc, String mahocphan,
			String tenhocphan, int sotc, String malophocphan, int siso,
			int sisoconlai, List<DotHoc> dothoc, List<SinhVien> danhsachsinhvien) {
		this.id = id;
		this.hocky = hocky;
		this.namhoc = namhoc;
		this.mahocphan = mahocphan;
		this.tenhocphan = tenhocphan;
		this.sotc = sotc;
		this.malophocphan = malophocphan;
		this.siso = siso;
		this.sisoconlai = sisoconlai;
		this.dothoc = dothoc;
		this.danhsachsinhvien = danhsachsinhvien;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMalophocphan() {
		return malophocphan;
	}

	public void setMalophocphan(String malophocphan) {
		this.malophocphan = malophocphan;
	}

	public int getSiso() {
		return siso;
	}

	public void setSiso(int siso) {
		this.siso = siso;
	}

	public int getSisoconlai() {
		return sisoconlai;
	}

	public void setSisoconlai(int sisoconlai) {
		this.sisoconlai = sisoconlai;
	}

	public List<DotHoc> getDothoc() {
		return dothoc;
	}

	public void setDothoc(List<DotHoc> dothoc) {
		this.dothoc = dothoc;
	}

	public List<SinhVien> getDanhsachsinhvien() {
		return danhsachsinhvien;
	}

	public void setDanhsachsinhvien(List<SinhVien> danhsachsinhvien) {
		this.danhsachsinhvien = danhsachsinhvien;
	}

	public void addSinhVien(SinhVien sinhvien) {
		this.danhsachsinhvien.add(sinhvien);
	}

	public void setSisoLop() {
		this.sisoconlai = this.siso - danhsachsinhvien.size();
	}

	public boolean checkExitsSV(String mssv) {
		for (SinhVien sinhVien : danhsachsinhvien) {
			if (sinhVien.getMssv().equals(mssv)) {
				return true;
			}
		}
		return false;
	}

	public void xoaSV(SinhVien sv) {
		for (int i = 0; i < danhsachsinhvien.size(); i++) {
			if (danhsachsinhvien.get(i).getMssv().equals(sv.getMssv())) {
				this.danhsachsinhvien.remove(i);
			}
		}
	}

}
