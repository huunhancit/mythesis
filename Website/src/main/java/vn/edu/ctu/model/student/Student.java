package vn.edu.ctu.model.student;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	@Id
	private String mssv;
	private String password;
	private String hoten;
	private String diachi;
	private String gioitinh;
	private String ngaysinh;
	private String lop;
	private int khoahoc;
	private String manganh;
	private String nganhhoc;
	private String khoa;

	public Student() {
	}

	public Student(String mssv, String password, String hoten, String diachi,
			String gioitinh, String ngaysinh, String lop, int khoahoc,
			String manganh, String nganhhoc, String khoa) {
		this.mssv = mssv;
		this.password = password;
		this.hoten = hoten;
		this.diachi = diachi;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.lop = lop;
		this.khoahoc = khoahoc;
		this.manganh = manganh;
		this.nganhhoc = nganhhoc;
		this.khoa = khoa;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getKhoahoc() {
		return khoahoc;
	}

	public void setKhoahoc(int khoahoc) {
		this.khoahoc = khoahoc;
	}

	public String getManganh() {
		return manganh;
	}

	public void setManganh(String manganh) {
		this.manganh = manganh;
	}

	public String getNganhhoc() {
		return nganhhoc;
	}

	public void setNganhhoc(String nganhhoc) {
		this.nganhhoc = nganhhoc;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

}