package vn.edu.ctu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.ctu.dao.ThoiKhoaBieuDAO;
import vn.edu.ctu.function.AddDate;
import vn.edu.ctu.function.TKB;
import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

@Controller
public class ThoiKhoaBieuController {
	@Autowired
	ThoiKhoaBieuDAO thoiKhoaBieuDAO;

	@RequestMapping(value = "/thoikhoabieu", method = RequestMethod.GET)
	public String xemThoiKhoaBieu(HttpSession session, ModelMap mm) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String hocky = (String) session.getAttribute("hocky");
		String namhoc = (String) session.getAttribute("namhoc");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		String tuan = "1";
		ThoiKhoaBieu tkb = this.thoiKhoaBieuDAO.findTKBBy(mssv, hocky, namhoc);
		if (tkb != null) {
			List<HocPhan> hocphan = tkb.getHocphan();
			mm.put("ngay", tkb.getNgaydatdau());
			mm.put("a", TKB.getTKBBYTuanThu("3", tuan, hocphan).size());
			mm.put("thu2", TKB.getTKBBYTuanThu("2", tuan, hocphan));
			mm.put("thu3", TKB.getTKBBYTuanThu("3", tuan, hocphan));
			mm.put("thu4", TKB.getTKBBYTuanThu("4", tuan, hocphan));
			mm.put("thu5", TKB.getTKBBYTuanThu("5", tuan, hocphan));
			mm.put("thu6", TKB.getTKBBYTuanThu("6", tuan, hocphan));
			mm.put("thu7", TKB.getTKBBYTuanThu("7", tuan, hocphan));
		}
		mm.put("tuan", "1");
		return "xemthoikhoabieubytuan";
	}

	@RequestMapping(value = "/xemthoikhoabieu", method = RequestMethod.POST)
	public String xemFullThoiKhoaBieu(HttpSession session, ModelMap mm,
			HttpServletRequest request) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		String namhoc1 = request.getParameter("namhoc");
		String hocky1 = request.getParameter("hocky");
		ThoiKhoaBieu tkb = this.thoiKhoaBieuDAO
				.findTKBBy(mssv, hocky1, namhoc1);
		if (tkb != null) {
			mm.put("tkb", tkb.getHocphan());
		}
		return "xemthoikhoabieu";
	}

	@RequestMapping(value = "/xembytuan", method = RequestMethod.POST)
	public String tkb1(ModelMap mm, HttpSession session,
			HttpServletRequest request) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		String tuan = request.getParameter("tuan");
		String namhoc = (String) session.getAttribute("namhoc");
		String hocky = (String) session.getAttribute("hocky");
		ThoiKhoaBieu tkb = thoiKhoaBieuDAO.findTKBBy(mssv, hocky, namhoc);
		mm.put("tuan", tuan);
		int t = Integer.parseInt(tuan);
		String tem = tkb.getNgaydatdau();
		if (tkb != null) {
			mm.put("ngay", AddDate.addDays(tem, (t - 1) * 7));
			List<HocPhan> hocphan = tkb.getHocphan();
			mm.put("a", TKB.getTKBBYTuanThu("3", tuan, hocphan).size());
			mm.put("thu2", TKB.getTKBBYTuanThu("2", tuan, hocphan));
			mm.put("thu3", TKB.getTKBBYTuanThu("3", tuan, hocphan));
			mm.put("thu4", TKB.getTKBBYTuanThu("4", tuan, hocphan));
			mm.put("thu5", TKB.getTKBBYTuanThu("5", tuan, hocphan));
			mm.put("thu6", TKB.getTKBBYTuanThu("6", tuan, hocphan));
			mm.put("thu7", TKB.getTKBBYTuanThu("7", tuan, hocphan));
		}
		return "xemthoikhoabieubytuan";
	}
}
