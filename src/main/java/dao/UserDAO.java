package dao;

import model.User;

public interface UserDAO {

	public int saveUser(User user);
	//verify if the user exists in our db
	public User loginUser(String email, String password);
	//get user to show data in home
	public User getUserByID(int userID);
	public int depositMoney(Double amount, int userID);
	public int withdrawMoney(Double amount, int userID);
}
