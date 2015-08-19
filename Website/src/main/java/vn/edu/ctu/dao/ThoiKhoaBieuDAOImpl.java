package vn.edu.ctu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.ctu.thoikhoabieu.HocPhan;
import vn.edu.ctu.thoikhoabieu.ThoiKhoaBieu;

public class ThoiKhoaBieuDAOImpl implements ThoiKhoaBieuDAO {
	public static final String COLLECTION = "thoikhoabieu";
	@Autowired
	private MongoTemplate mongoTemplate;

	public ThoiKhoaBieuDAOImpl() {
	}

	public ThoiKhoaBieuDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createThoiKhoaBieu(ThoiKhoaBieu tkb) {
		this.mongoTemplate.save(tkb, COLLECTION);
	}

	@Override
	public ThoiKhoaBieu findTKBBy(String mssv, String hocky, String namhoc) {
		Query query = new Query(Criteria.where("hocky").is(hocky).and("namhoc")
				.is(namhoc).and("mssv").is(mssv));
		ThoiKhoaBieu thoikhoabieu = this.mongoTemplate.findOne(query,
				ThoiKhoaBieu.class, COLLECTION);
		return thoikhoabieu;
	}

	@Override
	public void addHocPhanTKB(String mssv, String hocky, String namhoc,
			HocPhan hocphan) {
		ThoiKhoaBieu thoikhoabieu = this.findTKBBy(mssv, hocky, namhoc);
		thoikhoabieu.addHocPhan(hocphan);
		this.mongoTemplate.save(thoikhoabieu, COLLECTION);
	}

	@Override
	public void xoaHocPhanTKB(String mssv, String hocky, String namhoc,
			String mahocphan) {
		ThoiKhoaBieu thoikhoabieu = this.findTKBBy(mssv, hocky, namhoc);
		thoikhoabieu.xoaHPKH(mahocphan);
		this.mongoTemplate.save(thoikhoabieu, COLLECTION);
	}

}
