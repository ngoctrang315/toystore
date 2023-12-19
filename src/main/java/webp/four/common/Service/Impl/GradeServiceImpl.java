package webp.four.common.Service.Impl;

import java.util.List;

import webp.four.common.Dao.Impl.GradeDaoImpl;
import webp.four.common.Dao.Interface.IGradeDao;
import webp.four.common.Model.Grade;
import webp.four.common.Service.Interface.IGradeService;

public class GradeServiceImpl implements IGradeService{
	IGradeDao gradeDao = new GradeDaoImpl();
	@Override
	public List<Grade> search(String keyword) {
		// TODO Auto-generated method stub
		return gradeDao.search(keyword);
	}

	@Override
	public List<Grade> getAll() {
		// TODO Auto-generated method stub
		return gradeDao.getAll();
	}

	@Override
	public Grade get(String grade) {
		// TODO Auto-generated method stub
		return gradeDao.get(grade);
	}

	@Override
	public void delete(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.delete(grade);
	}

	@Override
	public void edit(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.edit(grade);
	}

	@Override
	public void insert(Grade grade) {
		// TODO Auto-generated method stub
		gradeDao.insert(grade);
	}

}
