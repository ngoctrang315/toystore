package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.FavoriteGunpla;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.User;

public interface IFavoriteGunplaDao {

	List<FavoriteGunpla> getFrom(User user);

	void insert(User user, Gunpla gunpla);

}
