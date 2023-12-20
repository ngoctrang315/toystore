package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public interface IStoreDao {

	Store get(int id);

	List<Store> search(String keyword);

	List<Store> getAll();

	void delete(int id);

	void edit(Store store);

	void insert(Store store);

	void Active(Store store);

	void Deactive(Store store);
	
	void editWallet(Store store);
	
	int getThisMonthJoinStore();
	
	void deactiveStoreOfUser(User user);
	
	Store getStoreByUserId(int userId);

	boolean checkExist(int uid);
}
