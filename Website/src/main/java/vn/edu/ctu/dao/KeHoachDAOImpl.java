package vn.edu.ctu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.ctu.model.kehoach.KeHoach;

public class KeHoachDAOImpl implements KeHoachDAO {
	public static final String COLLECTION = "kehoach";
	@Autowired
	private MongoTemplate mongoTemplate;

	public KeHoachDAOImpl() {
	}

	public KeHoachDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createKeHoach(KeHoach kehoach) {
		this.mongoTemplate.save(kehoach, COLLECTION);
	}

	@Override
	public List<KeHoach> findKeHoachBy(String mssv) {
		Query query = new Query(Criteria.where("mssv").is(mssv));
		return this.mongoTemplate.find(query, KeHoach.class, COLLECTION);
	}

	@Override
	public KeHoach getListHPByHKNH(String mssv, String namhoc, String hocky) {
		Query query = new Query(Criteria.where("mssv").is(mssv).and("hocky")
				.is(hocky).and("namhoc").is(namhoc));
		return this.mongoTemplate.findOne(query, KeHoach.class, COLLECTION);
	}

	@Override
	public void setTrangThaiDK(String mssv, String namhoc, String hocky,
			String mahocphan) {
		KeHoach kehoach = this.getListHPByHKNH(mssv, namhoc, hocky);
		kehoach.setTrangThaiDk(mahocphan);
		this.mongoTemplate.save(kehoach, COLLECTION);
	}

	@Override
	public void setTrangThaiChuaDK(String mssv, String namhoc, String hocky,
			String mahocphan) {
		KeHoach kehoach = this.getListHPByHKNH(mssv, namhoc, hocky);
		kehoach.setTrangThaiChuaDK(mahocphan);
		this.mongoTemplate.save(kehoach, COLLECTION);
	}

}
