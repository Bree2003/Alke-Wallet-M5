package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DBConnection;
import model.User;

public class UserDAOImpl  implements UserDAO{
	
	//query statement
	private String sql = "";
	//get connection
	private Connection con = null;
	//dinamyc query
	private PreparedStatement pstm = null;
	//get collection data
	private ResultSet rs = null;
	private User user = null;
	
	@Override
	public int saveUser(User user) {
		int row = 0;
		
		//sentence
		sql = "insert into users(uname,ulastname,uemail,upassword,ubalance) values (?,?,?,?,?);";
		//establish connection
		con = DBConnection.getConnection();
		
		try {
			//indicate our sql statement
			pstm = con.prepareStatement(sql);
			//set parameters
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getLastName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getPassword());
			pstm.setDouble(5, user.getBalance());
			//execute query and get number if the operaction is successful
			row = pstm.executeUpdate();
			//close objects
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return row;
	}
	@Override
	public User loginUser(String email, String password) {
		//sentence
		sql = "select * from users where uemail = ? and upassword = ?;";
		//establish connection
		con = DBConnection.getConnection();
		
		try {
			//indicate our sql statement
			pstm = con.prepareStatement(sql);
			//set parameters
			pstm.setString(1, email);
			pstm.setString(2, password);
			//execute query and get data
			rs = pstm.executeQuery();
			//save user
			if(rs.next()) {
				user = new User();
				//bring the data from the field
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("uname"));
				user.setLastName(rs.getString("ulastname"));
				user.setEmail(rs.getString("uemail"));
				user.setPassword(rs.getString("upassword"));
				user.setBalance(rs.getDouble("ubalance"));
			}
			//close objects
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return user;
	}
	@Override
	public User getUserByID(int userID) {
		//sentence
		sql = "select * from users where id = ?;";
		//establish connection
		con = DBConnection.getConnection();
		
		try {
			//indicate our sql statement
			pstm = con.prepareStatement(sql);
			//set parameters
			pstm.setInt(1, userID);
			//execute query and get data
			rs = pstm.executeQuery();
			//save user
			if(rs.next()) {
				user = new User();
				//bring the data from the field
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("uname"));
				user.setLastName(rs.getString("ulastname"));
				user.setEmail(rs.getString("uemail"));
				user.setPassword(rs.getString("upassword"));
				user.setBalance(rs.getDouble("ubalance"));
			}
			//close objects
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return user;
	}
	@Override
	public int depositMoney(Double amount, int userID) {
		int row = 0;
		
		//sentence
		sql = "UPDATE users SET ubalance = ubalance + ? WHERE id = ?;";
		//establish connection
		con = DBConnection.getConnection();
		
		try {
			//indicate our sql statement
			pstm = con.prepareStatement(sql);
			//set parameters
			pstm.setDouble(1, amount);
			pstm.setInt(2, userID);
			//execute query and get number if the operaction is successful
			row = pstm.executeUpdate();
			//close objects
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return row;
	}
	@Override
	public int withdrawMoney(Double amount, int userID) {
		int row = 0;
		
		//sentence
		sql = "UPDATE users SET ubalance = ubalance - ? WHERE id = ?;";
		//establish connection
		con = DBConnection.getConnection();
		
		try {
			//indicate our sql statement
			pstm = con.prepareStatement(sql);
			//set parameters
			pstm.setDouble(1, amount);
			pstm.setInt(2, userID);
			//execute query and get number if the operaction is successful
			row = pstm.executeUpdate();
			//close objects
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return row;
	}
}
