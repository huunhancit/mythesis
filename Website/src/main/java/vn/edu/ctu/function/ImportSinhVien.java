package vn.edu.ctu.function;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.edu.ctu.model.student.Student;

public class ImportSinhVien {
	private String path;

	public ImportSinhVien() {
	}

	public ImportSinhVien(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Student> importSV() throws Exception {
		List<Student> student = new ArrayList<Student>();
		FileInputStream file = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
			Student st = new Student(row.getCell(0).toString(), "12345",
					"Giang Cẩm Nghìn", "Cà Mau", "Nữ", "1/1/1993",
					"DI11Y9A1", 37, "DI", "Mạng máy tính",
					"Công nghệ thông tin");
			student.add(st);
		}
		return student;
	}
}
