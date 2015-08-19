package vn.edu.ctu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.ctu.dao.KeHoachDAO;
import vn.edu.ctu.dao.LopHocPhanDAO;
import vn.edu.ctu.dao.StudentDAO;
import vn.edu.ctu.function.CountTCKeHoach;
import vn.edu.ctu.function.ImportKeHoach;
import vn.edu.ctu.function.ImportLopHocPhan;
import vn.edu.ctu.model.kehoach.KeHoach;
import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.student.Student;

@Controller
public class KeHoachController {

	@Autowired
	StudentDAO studentDAO;
	@Autowired
	KeHoachDAO keHoachDAO;
	@Autowired
	LopHocPhanDAO lopHocPhanDAO;

	@RequestMapping(value = "/kehoach", method = RequestMethod.GET)
	public String loadPageKeHoach(ModelMap mm, HttpSession session,
			RedirectAttributes re) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		List<KeHoach> kehoach = this.keHoachDAO.findKeHoachBy(mssv);
		if (kehoach.size() > 0) {
			mm.put("kh", kehoach);
			mm.put("count", CountTCKeHoach.countTC(kehoach));
		}
		return "kehoach";
	}

	@RequestMapping(value = "/importkehoach", method = RequestMethod.POST)
	public String importKeHoach(@RequestParam("file") MultipartFile file,
			ModelMap mm, HttpSession session, RedirectAttributes re) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		if (!file.isEmpty()) {
			try {
				file.transferTo(new File("/var/upload/"
						+ file.getOriginalFilename()));
				ImportKeHoach im = new ImportKeHoach("/var/upload/"
						+ file.getOriginalFilename());
				Student st = this.studentDAO.showStudent(mssv);
				List<KeHoach> listkh = im.importFile(st.getMssv(),
						st.getManganh(), st.getNganhhoc(), st.getKhoahoc());
				if (this.keHoachDAO.findKeHoachBy(mssv).size() == 0) {
					for (KeHoach keHoach : listkh) {
						this.keHoachDAO.createKeHoach(keHoach);
					}
					re.addFlashAttribute("trangthai",
							"<script>alert('Kế hoạch thành công !');</script>");
				} else {
					re.addFlashAttribute("trangthai",
							"<script>alert('Import thất bại !');</script>");
				}
			} catch (Exception e) {
				mm.put("trangthai",
						"<script>alert('Import không thành công !')</script>");
			}
		}
		return "redirect:/kehoach";
	}

	@RequestMapping(value = "/importdanhsachlop", method = RequestMethod.GET)
	public String loadPageDanhSachLop(ModelMap mm, HttpSession session) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		return "importdanhsachlop";
	}

	@RequestMapping(value = "/importdanhsachlop", method = RequestMethod.POST)
	public String importKeHoach(ModelMap mm, HttpSession session,
			@RequestParam("filelop") MultipartFile filelop) {

		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		if (mssv == null || hoten == null) {
			return "redirect:";
		}
		String namhoc = (String) session.getAttribute("namhoc");
		String hocky = (String) session.getAttribute("hocky");
		if (!filelop.isEmpty()) {
			try {
				filelop.transferTo(new File("/var/upload/"
						+ filelop.getOriginalFilename()));
				ImportLopHocPhan lop = new ImportLopHocPhan("/var/upload/"
						+ filelop.getOriginalFilename());
				List<LopHocPhan> lophocphan = lop.importLop(hocky, namhoc);

				if (this.lopHocPhanDAO.findLop(hocky, namhoc).size() > 0) {
					mm.put("status",
							"<script>alert('Đã có danh sách lớp học phần !')</script>");
				} else {
					for (LopHocPhan l : lophocphan) {
						this.lopHocPhanDAO.createLopHocPhan(l);
					}
					mm.put("status",
							"<script>alert('Import thành công !')</script>");
				}
			} catch (Exception e) {
				mm.put("status",
						"<script>alert('Import thất bại ! " + e.toString()
								+ "')</script>");
			}
		}
		return "importdanhsachlop";
	}
	@RequestMapping(value = "/lop", method = RequestMethod.GET)
	public String importDanhsachKeHoach() throws IOException{
		List<Student> students = this.studentDAO.getListStudent();
		ImportKeHoach im = new ImportKeHoach("/var/upload/kehoach.xlsx");
		for (Student student : students) {
			List<KeHoach> listkh = im.importFile(student.getMssv(),
					student.getManganh(), student.getNganhhoc(), student.getKhoahoc());
			for (KeHoach keHoach : listkh) {
				this.keHoachDAO.createKeHoach(keHoach);
			}
		}
		return "";
	}
}
