package webp.four.common.Service.Interface;

import java.util.List;

import webp.four.common.Model.Grade;
import webp.four.common.Model.Store;

public interface IGradeService {
	List<Grade> search(String keyword);

	List<Grade> getAll();

	Grade get(String grade);

	void edit(Grade grade);

	void insert(Grade grade);

	void delete(Grade grade);
}
