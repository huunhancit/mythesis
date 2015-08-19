package vn.edu.ctu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vn.edu.ctu.model.student.Student;

public class StudentDAOImpl implements StudentDAO {
	public static final String COLLECTION = "student";
	@Autowired
	private MongoTemplate mongoTemplate;

	public StudentDAOImpl() {
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createStudent(Student student) {
		this.mongoTemplate.save(student);
	}

	@Override
	public boolean checkLogin(String mssv, String password) {
		// passwd = md5(password)
		Query query = new Query(Criteria.where("_id").is(mssv).and("password")
				.is(password));
		long dem = this.mongoTemplate.count(query, COLLECTION);
		if (dem > 0) {
			return true;
		} else
			return false;
	}

	@Override
	public Student showStudent(String mssv) {
		Query query = new Query(Criteria.where("_id").is(mssv));
		return this.mongoTemplate.findOne(query, Student.class, COLLECTION);
	}

	@Override
	public List<Student> getListStudent() {
		List<Student> students = new ArrayList<Student>();
		students = this.mongoTemplate.find(new Query(),Student.class);
		return students;
	}

}
