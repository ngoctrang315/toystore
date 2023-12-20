package webp.four.common.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import webp.four.common.Dao.Impl.FavoriteGunplaDaoImpl;
import webp.four.common.Dao.Impl.FavoriteStoreDaoImpl;
import webp.four.common.Dao.Impl.GunplaDaoImpl;
import webp.four.common.Dao.Impl.RoleDaoImpl;
import webp.four.common.Dao.Impl.StoreDaoImpl;
import webp.four.common.Dao.Impl.UserDaoImpl;
import webp.four.common.Dao.Interface.IFavoriteGunplaDao;
import webp.four.common.Dao.Interface.IFavoriteStoreDao;
import webp.four.common.Dao.Interface.IGunplaDao;
import webp.four.common.Dao.Interface.IRoleDao;
import webp.four.common.Dao.Interface.IStoreDao;
import webp.four.common.Dao.Interface.IUserDao;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Interface.IStoreService;

public class StoreServiceImpl implements IStoreService {
	IUserDao userDao = new UserDaoImpl();
	IFavoriteGunplaDao favGunplaDao = new FavoriteGunplaDaoImpl();
	IFavoriteStoreDao favStoreDao = new FavoriteStoreDaoImpl();
	IGunplaDao gunplaDao = new GunplaDaoImpl();
	IStoreDao storeDao = new StoreDaoImpl();
	@Override
	public List<Store> search(String keyword) {
		// TODO Auto-generated method stub
		return storeDao.search(keyword);
	}

	@Override
	public List<Store> getAll() {
		// TODO Auto-generated method stub
		return storeDao.getAll();
	}

	@Override
	public Store get(int storeId) {
		// TODO Auto-generated method stub
		return storeDao.get(storeId);
	}

	@Override
	public void delete(int storeId) {
		// TODO Auto-generated method stub
		storeDao.delete(storeId);
	}

	@Override
	public void edit(Store store) {
		// TODO Auto-generated method stub
		storeDao.edit(store);
	}

	@Override
	public void insert(Store store) {
		// TODO Auto-generated method stub
		storeDao.insert(store);
	}
	@Override
	public void Activate(Store store) {
		// TODO Auto-generated method stub
		storeDao.Active(store);
	}
	@Override
	public void Deactivate(Store store) {
		// TODO Auto-generated method stub
		storeDao.Deactive(store);
	}
	@Override
	public List<Gunpla> getGunplas(Store store) {
		// TODO Auto-generated method stub
		return gunplaDao.getFrom(store.getStoreId());
	}
	@Override
	public User getOwner(Store store) {
		// TODO Auto-generated method stub
		return userDao.get(store.getUserId());
	}

	@Override
	public int getThisMonthJoinStore() {
		// TODO Auto-generated method stub
		return storeDao.getThisMonthJoinStore();
	}

	@Override
	public void deactiveStoreOfUser(User user) {
		// TODO Auto-generated method stub
		storeDao.deactiveStoreOfUser(user);
	}

	@Override
	public void editWallet(Store store) {
		// TODO Auto-generated method stub
		storeDao.editWallet(store);
	}

	@Override
	public Store getStoreByUserId(int userId) {
		// TODO Auto-generated method stub
		return storeDao.getStoreByUserId(userId);
	}

	@Override
	public boolean checkExist(int uid) {
		// TODO Auto-generated method stub
		return storeDao.checkExist(uid);
	}
}
