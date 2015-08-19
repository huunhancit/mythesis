package vn.edu.ctu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.ctu.dao.LopHocPhanDAO;
import vn.edu.ctu.model.lophocphan.Buoi;
import vn.edu.ctu.model.lophocphan.DotHoc;
import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;

@Controller
public class DanhMucHocPhanController {
	@Autowired
	LopHocPhanDAO lopHocPhanDAO;

	@RequestMapping(value = "/danhmuchocphan", method = RequestMethod.GET)
	public String DanhMucHocPhan(HttpSession session, ModelMap mm) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		return "danhmuchocphan";
	}

	@RequestMapping(value = "/searchdm", method = RequestMethod.POST)
	public String searchDanhMucHocPhan(HttpSession session, ModelMap mm,
			HttpServletRequest request) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		String namhoc = request.getParameter("namhoc");
		String hocky = request.getParameter("hocky");
		String mahocphan = request.getParameter("search");
		List<LopHocPhan> lop = this.lopHocPhanDAO.findLopHocPhanByMaHP(hocky,
				namhoc, mahocphan);
		if (lop.size() != 0) {
			mm.put("hocphan", lop.get(0));
			mm.put("lop", lop);
		}
		mm.put("size", lop.size());
		return "danhmuchocphan";
	}

	@RequestMapping(value = "/tao", method = RequestMethod.GET)
	public String createLopHocPhan() {
		Buoi b1 = new Buoi("2", "123", "101/C1");
		Buoi b2 = new Buoi("3", "45", "101/C1");
		List<Buoi> buoi = new ArrayList<Buoi>();
		buoi.add(b1);
		buoi.add(b2);
		DotHoc d1 = new DotHoc("Đợt 1", "1,2,3,4,5,6,7,8,,9,10,11", buoi);

		Buoi b3 = new Buoi("4", "123", "101/C1");
		Buoi b4 = new Buoi("5", "45", "101/C1");
		List<Buoi> buoi1 = new ArrayList<Buoi>();
		buoi1.add(b3);
		buoi1.add(b4);
		DotHoc d2 = new DotHoc("Đợt 2", "12,13,14,15", buoi1);

		List<DotHoc> dothoc = new ArrayList<DotHoc>();
		dothoc.add(d1);
		dothoc.add(d2);
		List<SinhVien> danhsachsinhvien = new ArrayList<SinhVien>();
		LopHocPhan lop = new LopHocPhan();
		lop.setNamhoc("2014-2015");
		lop.setHocky("2");
		lop.setMahocphan("CT101");
		lop.setTenhocphan("Lập trình căn bản");
		lop.setSotc(3);
		lop.setMalophocphan("CT10102");
		lop.setSiso(40);
		lop.setSisoconlai(40);
		lop.setDothoc(dothoc);
		lop.setDanhsachsinhvien(danhsachsinhvien);
		this.lopHocPhanDAO.createLopHocPhan(lop);
		return "";
	}
}
