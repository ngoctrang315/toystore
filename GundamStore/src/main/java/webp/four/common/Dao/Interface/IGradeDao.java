package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;

public interface IGradeDao {

	List<Grade> search(String keyword);

	List<Grade> getAll();

	void delete(Grade grade);

	void edit(Grade grade);

	void insert(Grade grade);

	Grade get(String id);

}
