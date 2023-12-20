package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.FavoriteStore;
import webp.four.common.Model.Store;
import webp.four.common.Model.User;

public interface IFavoriteStoreDao {

	List<FavoriteStore> getFrom(User user);

	void insert(User user, Store store);

}
