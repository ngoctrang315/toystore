package webp.four.common.Dao.Interface;

import java.util.List;

import webp.four.common.Model.User;

public interface IUserDao {

	List<User> search(String keyword);

	List<User> getAll();

	User get(String username);

	void delete(String username);

	void edit(User user);

	void insert(User user);

	User get(int id);
	
	List<String> getAllUserName();
	
	int getThisMonthJoinUser();
	
	boolean checkExist(String username);
	
	void promote(int userId);
}
