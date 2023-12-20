package webp.four.common.Service.Interface;

import java.util.List;

import webp.four.common.Model.Gunpla;
import webp.four.common.Model.Store;
import webp.four.common.Model.Grade;

public interface IGunplaService {
	Gunpla get(int id);

	void insert(Gunpla gunpla);

	List<Gunpla> search(String keyword);

	List<Gunpla> getAll();

	void delete(Gunpla gunpla);

	void edit(Gunpla gunpla);

	Grade getGrade(Gunpla gunpla);

	Store getStore(Gunpla gunpla);

	int countAll();

	List<Gunpla> findAll(int page);

	List<Gunpla> findNewest();

	List<Gunpla> findCheapest();

	Gunpla findTopPrice();

	List<Gunpla> findAll(int page, String gid);

	int countAll(String gid);

	List<Gunpla> search(int page, String keyword);

	int countAllKey(String keyword);
	
	List<Gunpla> getAllGunplaOfStore(int storeId);
}
