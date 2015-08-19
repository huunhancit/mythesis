package vn.edu.ctu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.ctu.model.lophocphan.LopHocPhan;
import vn.edu.ctu.model.lophocphan.SinhVien;

public class LopHocPhanDAOImpl implements LopHocPhanDAO {
	public static final String COLLECTION = "lophocphan";
	@Autowired
	private MongoTemplate mongoTemplate;

	public LopHocPhanDAOImpl() {
	}

	public LopHocPhanDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createLopHocPhan(LopHocPhan lopHocPhan) {
		this.mongoTemplate.save(lopHocPhan, COLLECTION);
	}

	@Override
	public List<LopHocPhan> findLopHocPhanByMaHP(String hocky, String namhoc,
			String mahocphan) {
		Query query = new Query(Criteria.where("hocky").is(hocky).and("namhoc")
				.is(namhoc).and("mahocphan").is(mahocphan));
		List<LopHocPhan> lophocphan = this.mongoTemplate.find(query,
				LopHocPhan.class, COLLECTION);
		return lophocphan;
	}

	@Override
	public List<LopHocPhan> findLop(String hocky, String namhoc) {
		Query query = new Query(Criteria.where("hocky").is(hocky).and("namhoc")
				.is(namhoc));
		List<LopHocPhan> lophocphan = this.mongoTemplate.find(query,
				LopHocPhan.class, COLLECTION);
		return lophocphan;
	}

	@Override
	public void registryHP(String hocky, String namhoc, String mahocphan,
			String malophocphan, SinhVien sinhvien) {
		LopHocPhan lophocphan = this.getLopHocPhan(hocky, namhoc, mahocphan,
				malophocphan);
		lophocphan.addSinhVien(sinhvien);
		lophocphan.setSisoLop();
		this.mongoTemplate.save(lophocphan, COLLECTION);
	}

	@Override
	public LopHocPhan getLopHocPhan(String hocky, String namhoc,
			String mahocphan, String malophocphan) {
		Query query = new Query(Criteria.where("hocky").is(hocky).and("namhoc")
				.is(namhoc).and("mahocphan").is(mahocphan).and("malophocphan")
				.is(malophocphan));
		LopHocPhan lophocphan = this.mongoTemplate.findOne(query,
				LopHocPhan.class, COLLECTION);
		return lophocphan;
	}

	@Override
	public void xoaLop(String hocky, String namhoc, String mahocphan,
			String malophocphan, SinhVien sv) {
		LopHocPhan lop = this.getLopHocPhan(hocky, namhoc, mahocphan,
				malophocphan);
		lop.xoaSV(sv);
		lop.setSisoLop();
		this.mongoTemplate.save(lop, COLLECTION);
	}

}
