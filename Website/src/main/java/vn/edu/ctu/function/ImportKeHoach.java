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

import vn.edu.ctu.model.kehoach.HocPhan;
import vn.edu.ctu.model.kehoach.KeHoach;

public class ImportKeHoach {
	private String path;

	public ImportKeHoach() {
	}

	public ImportKeHoach(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<KeHoach> importFile(String mssv, String manganh,
			String tennganh, int khoahoc) throws IOException {
		List<KeHoach> kehoach = new ArrayList<KeHoach>();
		FileInputStream file = new FileInputStream(new File(path));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell firstcell = row.getCell(0);
			Cell cell2 = row.getCell(1);
			if (cell2.toString().equals("Mã học phần")
					|| cell2.toString().equals("Ke hoach hoc tap")) {
				continue;
			} else if (firstcell != null
					&& firstcell.toString().equals("Hoc ky")) {
				KeHoach kh = new KeHoach();
				kh.setMssv(mssv);
				kh.setManganh(manganh);
				kh.setTennganh(tennganh);
				kh.setKhoahoc(khoahoc);
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				kh.setHocky(row.getCell(1).toString());
				kh.setNamhoc(row.getCell(3).toString());
				kh.setTongsotc((int) Float
						.parseFloat(row.getCell(5).toString()));
				kh.setTongsohocphan((int) Float.parseFloat(row.getCell(7)
						.toString()));
				kh.setHocphan(new ArrayList<HocPhan>());
				kehoach.add(kh);
			} else {
				String mahocphan = row.getCell(1).toString();
				String tenhocphan = row.getCell(2).toString();
				int sotc = (int) Float.parseFloat(row.getCell(3).toString());
				String batbuoc = "";
				String tuchon = "";
				String hocphantienquyet = "";
				if (row.getCell(5) != null) {
					tuchon = row.getCell(5).toString();
				}
				if (row.getCell(4) != null) {
					batbuoc = row.getCell(4).toString();
				}
				if (row.getCell(6) != null) {
					hocphantienquyet = row.getCell(6).toString();
				}
				int trangthai = (int) Float.parseFloat(row.getCell(7)
						.toString());
				HocPhan hocphan = new HocPhan(mahocphan, tenhocphan, sotc,
						batbuoc, tuchon, hocphantienquyet, trangthai);
				kehoach.get(kehoach.size() - 1).getHocphan().add(hocphan);
			}
		}
		return kehoach;
	}

	public static void main(String arg[]) throws IOException {
		ImportKeHoach im = new ImportKeHoach("/home/dhnhan/upload/file.xlsx");
		List<KeHoach> kehoach = im
				.importFile("1111", "Y9", "Mang may tinh", 37);

		for (KeHoach kh : kehoach) {
			System.out.println(kh.getHocky());
			System.out.println(kh.getNamhoc());
			for (HocPhan hp : kh.getHocphan()) {
				System.out.println(hp.getMahocphan());
			}
		}
	}
}
