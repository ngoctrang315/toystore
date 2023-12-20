package webp.four.common.Service.Interface;

import java.util.List;

import webp.four.common.Model.FavoriteGunpla;
import webp.four.common.Model.FavoriteStore;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Role;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public interface IUserService {
	List<User> search(String keyword);

	List<User> getAll();

	User get(String username);
	
	User get(int id);

	void delete(String username);

	void edit(User user);

	void insert(User user);

	String getRoleName(User user);

	List<Store> getFavoriteStores(User user);

	List<Gunpla> getFavoriteGunplas(User user);

	void addStoreFavorite(User user, Store store);

	void addGunplaFavorite(User user, Gunpla gunpla);
	
	List<String> getAllUserName();
	
	int getThisMonthJoinUser();

	Role getRole(User user);
	
	boolean checkExist(String username);
	
	void promote(int userId);
}
