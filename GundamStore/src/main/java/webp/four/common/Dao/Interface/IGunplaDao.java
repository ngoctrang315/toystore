package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.Gunpla;

public interface IGunplaDao {

	Gunpla get(int id);

	void insert(Gunpla gunpla);

	List<Gunpla> search(String keyword);

	List<Gunpla> getAll();

	void delete(Gunpla gunpla);

	void edit(Gunpla gunpla);

	List<Gunpla> getFrom(int id);

	List<Gunpla> findAll(int page);

	int countAll();

	List<Gunpla> findNewest();

	List<Gunpla> findCheapest();

	Gunpla findTopPrice();

	int countAll(String gid);

	List<Gunpla> findAll(int page, String gid);

	List<Gunpla> search(String keyword, int page);

	int countAllKey(String keyword);
	
	List<Gunpla> getAllGunplaOfStore(int storeId);

}
