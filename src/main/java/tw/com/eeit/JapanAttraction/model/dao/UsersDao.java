package tw.com.eeit.JapanAttraction.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.eeit.JapanAttraction.model.bean.Users;


public class UsersDao {


	private Connection conn;

	public UsersDao(Connection conn) {
		this.conn = conn;
	}
	
	public Users findMemberByEmailAndPassword(String userEmail, String password) throws SQLException {
		Users u = null;
		final String SQL = "SELECT * FROM  [JapanAttraction].[dbo].[Users] WHERE [userEmail] COLLATE Latin1_General_CS_AS = ? AND [password] COLLATE Latin1_General_CS_AS = ?";
		PreparedStatement preState = conn.prepareStatement(SQL);
		preState.setString(1, userEmail);
		preState.setString(2, password);

		ResultSet rs = preState.executeQuery();

		if (rs.next()) {
			u=new Users();
			u.setUserEmail(rs.getString("userEmail"));
			u.setUserName(rs.getString("userName"));
			u.setPassword(rs.getString("password"));
			u.setUserID(rs.getInt("userID"));
			u.setUserPhoto(rs.getBytes("userPhoto"));
			
		}

		rs.close();
		preState.close();
		return u;
		

	}
	
	
}
