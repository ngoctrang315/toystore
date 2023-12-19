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
import webp.four.common.Model.FavoriteGunpla;
import webp.four.common.Model.FavoriteStore;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Role;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;
import webp.four.common.Service.Interface.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	IRoleDao roleDao = new RoleDaoImpl();
	IFavoriteGunplaDao favGunplaDao = new FavoriteGunplaDaoImpl();
	IFavoriteStoreDao favStoreDao = new FavoriteStoreDaoImpl();
	IGunplaDao gunplaDao = new GunplaDaoImpl();
	IStoreDao storeDao = new StoreDaoImpl();

	@Override
	public List<User> search(String keyword) {
		// TODO Auto-generated method stub
		return userDao.search(keyword);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
	
	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		userDao.delete(username);
	}

	@Override
	public void edit(User user) {
		// TODO Auto-generated method stub
		userDao.edit(user);
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);

	}

	@Override
	public String getRoleName(User user) {
		// TODO Auto-generated method stub
		return roleDao.get(user.getRoleId()).getRoleName();
	}
	@Override
	public Role getRole(User user) {
		// TODO Auto-generated method stub
		return roleDao.get(user.getRoleId());
	}
	@Override
	public List<Store> getFavoriteStores(User user) {
		// TODO Auto-generated method stub
		List<Store> favList = new ArrayList<Store>();
		List<FavoriteStore> favIdList = favStoreDao.getFrom(user);
		if (favIdList.size() > 0) {
			for (FavoriteStore key : favIdList) {
				favList.add(storeDao.get(key.getStoreId()));
			}
		}
		return favList;
	}
	@Override
	public void addStoreFavorite(User user, Store store)
	{
		List<FavoriteStore> favIdList = favStoreDao.getFrom(user);
		Boolean check = false;
		if (favIdList.size() > 0) {
			for (FavoriteStore key : favIdList) {
				if(key.getStoreId() == store.getStoreId())
				{
					check=true;
					break;
				}
			}
			if (!check) favStoreDao.insert(user, store);
		}
		else favStoreDao.insert(user, store);
	}

	@Override
	public List<Gunpla> getFavoriteGunplas(User user) {
		// TODO Auto-generated method stub
		List<Gunpla> favList = new ArrayList<Gunpla>();
		List<FavoriteGunpla> favIdList = favGunplaDao.getFrom(user);
		if (favIdList.size() > 0) {
			for (FavoriteGunpla key : favIdList) {
				favList.add(gunplaDao.get(key.getGunplaId()));
			}
		}
		return favList;
	}
	@Override
	public void addGunplaFavorite(User user, Gunpla gunpla)
	{
		List<FavoriteGunpla> favIdList = favGunplaDao.getFrom(user);
		Boolean check = false;
		if (favIdList.size() > 0) {
			for (FavoriteGunpla key : favIdList) {
				if(key.getGunplaId() == gunpla.getGunplaId())
				{
					check=true;
					break;
				}
			}
			if (!check) favGunplaDao.insert(user, gunpla);
		}
		else favGunplaDao.insert(user, gunpla);
	}

	@Override
	public List<String> getAllUserName() {
		// TODO Auto-generated method stub
		return userDao.getAllUserName();
	}

	@Override
	public int getThisMonthJoinUser() {
		// TODO Auto-generated method stub
		return userDao.getThisMonthJoinUser();
	}

	public boolean checkExist(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExist(username);
	}

	@Override
	public void promote(int userId) {
		// TODO Auto-generated method stub
		userDao.promote(userId);
	}
}
