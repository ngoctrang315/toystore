package webp.four.common.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import webp.four.common.Dao.Impl.GradeDaoImpl;
import webp.four.common.Dao.Impl.GunplaDaoImpl;
import webp.four.common.Dao.Impl.StoreDaoImpl;
import webp.four.common.Dao.Interface.IGradeDao;
import webp.four.common.Dao.Interface.IGunplaDao;
import webp.four.common.Dao.Interface.IStoreDao;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Service.Interface.IGunplaService;

public class GunplaServiceImpl implements IGunplaService {
	IGunplaDao gunplaDao = new GunplaDaoImpl();
	IStoreDao storeDao = new StoreDaoImpl();
	IGradeDao gradeDao = new GradeDaoImpl();

	@Override
	public Gunpla get(int id) {
		// TODO Auto-generated method stub
		return gunplaDao.get(id);
	}

	@Override
	public void insert(Gunpla gunpla) {
		// TODO Auto-generated method stub
		gunplaDao.insert(gunpla);

	}

	@Override
	public List<Gunpla> search(String keyword) {
		// TODO Auto-generated method stub
		return gunplaDao.search(keyword);
	}

	@Override
	public List<Gunpla> getAll() {
		// TODO Auto-generated method stub
		return gunplaDao.getAll();
	}

	@Override
	public void delete(Gunpla gunpla) {
		// TODO Auto-generated method stub
		gunplaDao.delete(gunpla);
	}

	@Override
	public void edit(Gunpla gunpla) {
		// TODO Auto-generated method stub
		gunplaDao.edit(gunpla);
	}

	@Override
	public Grade getGrade(Gunpla gunpla) {
		// TODO Auto-generated method stub
		return gradeDao.get(gunpla.getGradeId());
	}

	@Override
	public Store getStore(Gunpla gunpla) {
		return storeDao.get(gunpla.getStoreId());
	}

	@Override
	public int countAll() {
		return gunplaDao.countAll();
	}

	@Override
	public List<Gunpla> findAll(int page) {
		return gunplaDao.findAll((page - 1) * 6);
	}
	@Override
	public int countAll(String gid) {
		return gunplaDao.countAll(gid);
	}

	@Override
	public List<Gunpla> findAll(int page, String gid) {
		return gunplaDao.findAll((page - 1) * 6,gid);
	}
	@Override
	public List<Gunpla> search(int page, String keyword) {
		return gunplaDao.search(keyword,(page - 1) * 6);
	}
	@Override
	public int countAllKey(String keyword) {
		return gunplaDao.countAllKey(keyword);
	}
	@Override
	public List<Gunpla> findNewest() {
		return gunplaDao.findNewest();
	}
	@Override
	public List<Gunpla> findCheapest() {
		return gunplaDao.findCheapest();
	}
	@Override
	public Gunpla findTopPrice() {
		return gunplaDao.findTopPrice();
	}

	@Override
	public List<Gunpla> getAllGunplaOfStore(int storeId) {
		// TODO Auto-generated method stub
		return gunplaDao.getAllGunplaOfStore(storeId);
	}
	
}
