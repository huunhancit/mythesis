package vn.edu.ctu.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.edu.ctu.model.lophocphan.Buoi;
import vn.edu.ctu.model.lophocphan.DotHoc;
import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;

public class ImportLopHocPhan {
	private String path;

	public ImportLopHocPhan() {
	}

	public ImportLopHocPhan(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<LopHocPhan> importLop(String hocky, String namhoc)
			throws IOException {
		List<LopHocPhan> lophocphan = new ArrayList<LopHocPhan>();
		FileInputStream file = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cell0 = row.getCell(0);
			if (cell0 != null && cell0.toString().equals("STT")) {
				continue;
			} else if (cell0 == null) {
				break;
			} else {
				LopHocPhan lop = new LopHocPhan();
				lop.setHocky(hocky);
				lop.setNamhoc(namhoc);
				lop.setMahocphan(row.getCell(1).toString());
				lop.setTenhocphan(row.getCell(10).toString());
				lop.setSotc((int) Float.parseFloat(row.getCell(11).toString()));
				lop.setMalophocphan(row.getCell(1).toString()
						+ row.getCell(2).toString());
				lop.setSiso((int) Float.parseFloat(row.getCell(9).toString()));
				lop.setSisoconlai((int) Float.parseFloat(row.getCell(9)
						.toString()));
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				Buoi b = new Buoi(row.getCell(3).toString(), Tiet.convertTiet(
						row.getCell(4).toString(), row.getCell(5).toString()),
						row.getCell(6).toString());
				List<Buoi> buoi = new ArrayList<Buoi>();
				buoi.add(b);
				DotHoc dh = new DotHoc("Đợt 1", row.getCell(12).toString(),
						buoi);
				List<DotHoc> dothoc = new ArrayList<DotHoc>();
				dothoc.add(dh);
				lop.setDothoc(dothoc);
				lop.setDanhsachsinhvien(new ArrayList<SinhVien>());
				lophocphan.add(lop);
			}
		}
		return lophocphan;
	}

}
