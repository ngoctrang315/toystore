package webp.four.common.Service.Interface;

import java.util.List;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public interface IStoreService {
	List<Store> search(String keyword);

	List<Store> getAll();

	Store get(int storeId);

	void delete(int storeId);

	void edit(Store store);

	void editWallet(Store store);

	void insert(Store store);

	void Activate(Store store);

	void Deactivate(Store store);

	List<Gunpla> getGunplas(Store store);

	User getOwner(Store store);

	void deactiveStoreOfUser(User user);

	int getThisMonthJoinStore();

	Store getStoreByUserId(int userId);

	boolean checkExist(int uid);
}
