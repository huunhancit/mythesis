package vn.edu.ctu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.ctu.dao.StudentDAO;
import vn.edu.ctu.function.DateSystem;
import vn.edu.ctu.function.ImportSinhVien;
import vn.edu.ctu.model.student.Student;

@Controller
public class LoginController {
	@Autowired
	StudentDAO studentDAO;

	// show dang nhap
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap mm) {
		mm.put("student", new Student());
		return "login";
	}

	// Kiem tra dang nhap
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public String thongTinSinhVien(@ModelAttribute("student") Student student,
			ModelMap mm, HttpSession session) {
		String ms = student.getMssv();
		String pw = student.getPassword();
		boolean check = studentDAO.checkLogin(ms, pw);
		String result = "";
		if (check) {
			session.setAttribute("ms", ms);
			session.setAttribute("hoten", studentDAO.showStudent(ms).getHoten());
			session.setAttribute("namhoc", DateSystem.getNamHocSystem());
			session.setAttribute("hocky", DateSystem.getHocKySystem());
			mm.put("sv", studentDAO.showStudent(ms));
			result = "home";
		}
		if (!check) {
			mm.put("fail",
					"<script>alert('Sai tài khoản hoặc mật khẩu')</script>");
			result = "login";
		}
		return result;
	}

	// show trang chu
	@RequestMapping(value = "/showhome", method = RequestMethod.GET)
	public String showhome(@ModelAttribute("student") Student student,
			ModelMap mm, HttpSession session) {
		String mssv = (String) session.getAttribute("ms");
		String hoten = (String) session.getAttribute("hoten");
		String namhoc = (String) session.getAttribute("namhoc");
		String hocky = (String) session.getAttribute("hocky");
		if (mssv == null || hoten == null || namhoc == null || hocky == null) {
			return "redirect:";
		} else {
			mm.put("sv", studentDAO.showStudent(mssv));
			return "home";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpSession session) throws Exception {
		ImportSinhVien sv = new ImportSinhVien(
				"/home/dhnhan/upload/sinhvien.xlsx");
		List<Student> sinhViens = sv.importSV();
		for (Student sinhVien : sinhViens) {
			this.studentDAO.createStudent(sinhVien);
		}
		return "redirect:";
	}
}
