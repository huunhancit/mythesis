package vn.edu.ctu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.ctu.dao.KeHoachDAO;
import vn.edu.ctu.dao.LopHocPhanDAO;
import vn.edu.ctu.dao.StudentDAO;
import vn.edu.ctu.dao.ThoiKhoaBieuDAO;
import vn.edu.ctu.function.CheckFunction;
import vn.edu.ctu.function.CountTCKeHoach;
import vn.edu.ctu.model.kehoach.KeHoach;
import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;
import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

@Controller
public class DangKyHocPhanController {
	@Autowired
	StudentDAO studentDAO;
	@Autowired
	KeHoachDAO keHoachDAO;
	@Autowired
	LopHocPhanDAO lopHocPhanDAO;
	@Autowired
	ThoiKhoaBieuDAO thoiKhoaBieuDAO;

	@RequestMapping(value = "/dkhp", method = RequestMethod.GET)
	public String DangKyHocPhan(HttpSession session, ModelMap mm) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		mm.put("sv", studentDAO.showStudent(mssv));
		return "dangky";
	}

	@RequestMapping(value = "/dangkyhocphan", method = RequestMethod.GET)
	public String dangKyHocPhan(HttpSession session, ModelMap mm) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String hocky = (String) session.getAttribute("hocky");
		String namhoc = (String) session.getAttribute("namhoc");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}

		KeHoach kehoach = this.keHoachDAO.getListHPByHKNH(mssv, namhoc, hocky);
		if (kehoach != null) {
			mm.put("dshp", kehoach.getHocphan());
			mm.put("tonghp", kehoach.getHocphan().size());
			mm.put("tongtc", CountTCKeHoach.countTCHK(kehoach.getHocphan()));
		}
		ThoiKhoaBieu thoikhoabieu = this.thoiKhoaBieuDAO.findTKBBy(mssv, hocky,
				namhoc);
		if (thoikhoabieu != null) {
			mm.put("hocphandangky", thoikhoabieu.getHocphan());
			mm.put("tonghpdk", thoikhoabieu.getHocphan().size());
			mm.put("tongtcdk",
					CountTCKeHoach.countTCHK1(thoikhoabieu.getHocphan()));
		}
		return "dangkyhocphan";
	}

	@RequestMapping(value = "/xem/{mahocphan}", method = RequestMethod.GET)
	public String xemLopHocPhan(@PathVariable("mahocphan") String mahocphan,
			HttpSession session, ModelMap mm, RedirectAttributes re) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String hocky = (String) session.getAttribute("hocky");
		String namhoc = (String) session.getAttribute("namhoc");
		if (mssv == null || hoten == null || hocky == null || namhoc == null) {
			return "redirect:";
		}
		KeHoach kehoach = this.keHoachDAO.getListHPByHKNH(mssv, namhoc, hocky);
		if (kehoach != null) {
			mm.put("dshp", kehoach.getHocphan());
			mm.put("tonghp", kehoach.getHocphan().size());
			mm.put("tongtc", CountTCKeHoach.countTCHK(kehoach.getHocphan()));
		}
		ThoiKhoaBieu thoikhoabieu = this.thoiKhoaBieuDAO.findTKBBy(mssv, hocky,
				namhoc);
		if (thoikhoabieu != null) {
			mm.put("hocphandangky", thoikhoabieu.getHocphan());
			mm.put("tonghpdk", thoikhoabieu.getHocphan().size());
			mm.put("tongtcdk",
					CountTCKeHoach.countTCHK1(thoikhoabieu.getHocphan()));
		}
		List<LopHocPhan> lop = this.lopHocPhanDAO.findLopHocPhanByMaHP(hocky,
				namhoc, mahocphan);
		if (CheckFunction.checkExistSV(lop, mssv)) {
			mm.put("a", "<script>alert('Học phần đã đăng ký !')</script>");
		} else if (lop.size() > 0) {
			mm.put("lop", lop);
			mm.put("mahp", mahocphan);
			mm.put("size", lop.size());
		} else {
			mm.put("a", "<script>alert('Học phần không mở lớp !')</script>");
		}
		return "dangkyhocphan";
	}

	@RequestMapping(value = "/dkhocphan/{mahocphan}/{malophocphan}", method = RequestMethod.POST)
	public String DangKyHocPhan(HttpSession session, ModelMap mm,
			RedirectAttributes re, @PathVariable("mahocphan") String mahocphan,
			@PathVariable("malophocphan") String malophocphan) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String hocky = (String) session.getAttribute("hocky");
		String namhoc = (String) session.getAttribute("namhoc");
		if (mssv == null || hoten == null || hocky == null || namhoc == null) {
			return "redirect:";
		}
		LopHocPhan lophocphan = this.lopHocPhanDAO.getLopHocPhan(hocky, namhoc,
				mahocphan, malophocphan);
		ThoiKhoaBieu thoikhoabieu = this.thoiKhoaBieuDAO.findTKBBy(mssv, hocky,
				namhoc);
		if (thoikhoabieu == null) {
			ThoiKhoaBieu tkb = new ThoiKhoaBieu();
			tkb.setHocky(hocky);
			tkb.setNamhoc(namhoc);
			tkb.setMssv(mssv);
			tkb.setNgaydatdau("1/1/2014");
			tkb.setHocphan(new ArrayList<HocPhan>());
			this.thoiKhoaBieuDAO.createThoiKhoaBieu(tkb);
		}
		if (!lophocphan.checkExitsSV(mssv)) {
			if (lophocphan.getSisoconlai() > 0) {
				if (CheckFunction.checkTKB(lophocphan, thoikhoabieu) == null) {
					this.lopHocPhanDAO.registryHP(hocky, namhoc, mahocphan,
							malophocphan, new SinhVien(mssv, hoten));
					this.keHoachDAO.setTrangThaiDK(mssv, namhoc, hocky,
							mahocphan);
					HocPhan hp = new HocPhan(lophocphan.getMahocphan(),
							lophocphan.getTenhocphan(),
							lophocphan.getMalophocphan(), lophocphan.getSotc(),
							lophocphan.getDothoc());
					this.thoiKhoaBieuDAO.addHocPhanTKB(mssv, hocky, namhoc, hp);
					re.addFlashAttribute("a",
							"<script>alert('Đăng ký thành công !')</script>");
				} else {
					re.addFlashAttribute(
							"a",
							"<script>alert('Trùng thời khóa biểu !"
									+ CheckFunction.checkTKB(lophocphan,
											thoikhoabieu) + "')</script>");
				}
			} else {
				re.addFlashAttribute("a",
						"<script>alert('Lớp học phần đã đầy !')</script>");
			}
		}
		return "redirect:/dangkyhocphan";
	}

	@RequestMapping(value = "/xoa/{malophocphan}/{mahocphan}", method = RequestMethod.POST)
	public String xoaDangKy(HttpSession session, ModelMap mm,
			RedirectAttributes re, @PathVariable("mahocphan") String mahocphan,
			@PathVariable("malophocphan") String malophocphan) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String hocky = (String) session.getAttribute("hocky");
		String namhoc = (String) session.getAttribute("namhoc");
		if (mssv == null || hoten == null || hocky == null || namhoc == null) {
			return "redirect:";
		}
		SinhVien sv = new SinhVien(mssv, hoten);
		this.keHoachDAO.setTrangThaiChuaDK(mssv, namhoc, hocky, mahocphan);
		this.lopHocPhanDAO.xoaLop(hocky, namhoc, mahocphan, malophocphan, sv);
		this.thoiKhoaBieuDAO.xoaHocPhanTKB(mssv, hocky, namhoc, mahocphan);
		return "redirect:/dangkyhocphan";
	}

	@RequestMapping(value = "/thaydoi/{mahocphan}/{malophocphan}", method = RequestMethod.GET)
	public String loadLopHocPhan(@PathVariable("mahocphan") String mahocphan,
			@PathVariable("malophocphan") String malophocphan, ModelMap mm,
			HttpSession session) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String namhoc = (String) session.getAttribute("namhoc");
		String hocky = (String) session.getAttribute("hocky");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		List<LopHocPhan> lop = this.lopHocPhanDAO.findLopHocPhanByMaHP(hocky,
				namhoc, mahocphan);
		if (lop.size() > 0) {
			mm.put("ds", lop);
			mm.put("malophocphancu", malophocphan);
			mm.put("mahocphan", mahocphan);
			mm.put("tslop", lop.size());
		}
		return "lophocphan";
	}

	@RequestMapping(value = "/thaydoilop/{mahocphan}/{malophocphancu}/{malophocphanmoi}", method = RequestMethod.GET)
	public String thayDoiLopHocPhan(
			@PathVariable("mahocphan") String mahocphan,
			@PathVariable("malophocphancu") String malophocphancu,
			@PathVariable("malophocphanmoi") String malophocphanmoi,
			ModelMap mm, HttpSession session, RedirectAttributes re) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String namhoc = (String) session.getAttribute("namhoc");
		String hocky = (String) session.getAttribute("hocky");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		ThoiKhoaBieu tkb = this.thoiKhoaBieuDAO.findTKBBy(mssv, hocky, namhoc);
		tkb.xoaHPKH(mahocphan);
		LopHocPhan lopmoi = this.lopHocPhanDAO.getLopHocPhan(hocky, namhoc,
				mahocphan, malophocphanmoi);
		LopHocPhan lopcu = this.lopHocPhanDAO.getLopHocPhan(hocky, namhoc,
				mahocphan, malophocphancu);
		if (lopmoi.getSisoconlai() > 0) {
			if (CheckFunction.checkTKB(lopmoi, tkb) == null) {
				// lop hoc phan
				this.lopHocPhanDAO.xoaLop(hocky, namhoc, mahocphan,
						malophocphancu, new SinhVien(mssv, hoten));
				this.lopHocPhanDAO.registryHP(hocky, namhoc, mahocphan,
						malophocphanmoi, new SinhVien(mssv, hoten));
				// thoi khoa bieu
				this.thoiKhoaBieuDAO.xoaHocPhanTKB(mssv, hocky, namhoc,
						lopcu.getMahocphan());
				HocPhan hp = new HocPhan(lopmoi.getMahocphan(),
						lopmoi.getTenhocphan(), lopmoi.getMalophocphan(),
						lopmoi.getSotc(), lopmoi.getDothoc());
				this.thoiKhoaBieuDAO.addHocPhanTKB(mssv, hocky, namhoc, hp);
				mm.put("ja",
						"<script type='text/javascript'>{alert('Thay đổi thành công !');window.opener.location.reload();window.close();}</script>");
			} else {
				mm.put("ja",
						"<script type='text/javascript'>{alert('Trùng thời khóa biểu với "
								+ CheckFunction.checkTKB(lopmoi, tkb)
								+ " !');window.opener.location.reload();window.close();}</script>");
			}
		} else {
			mm.put("ja",
					"<script type='text/javascript'>{alert('Lớp học phần đã đầy  !');window.opener.location.reload();window.close();}</script>");
		}
		return "lophocphan";
	}

	// @RequestMapping(value = "/na", method = RequestMethod.GET)
	// public String sad(HttpSession session, ModelMap mm) {
	// String mssv = (String) session.getAttribute("ms");
	// String hoten = (String) session.getAttribute("hoten");
	// String hocky = (String) session.getAttribute("hocky");
	// String namhoc = (String) session.getAttribute("namhoc");
	// if (mssv == null || hoten == null) {
	// return "redirect:";
	// }
	// this.keHoachDAO.setTrangThaiChuaDK(mssv, namhoc, hocky, "CT333");
	// this.lopHocPhanDAO.xoaLop(hocky, namhoc, "CT333", "CT33301",
	// new SinhVien(mssv, hoten));
	// return "";
	// }
}
