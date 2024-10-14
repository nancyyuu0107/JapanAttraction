package tw.com.eeit.JapanAttraction.service;

import java.sql.Connection;

import tw.com.eeit.JapanAttraction.model.bean.Users;
import tw.com.eeit.JapanAttraction.model.dao.UsersDao;
import tw.com.eeit.JapanAttraction.util.ConnectionFactory;

public class UsersService {

	
	public Users login(String email,String password) {
		try(Connection conn = ConnectionFactory.getConnection()) {
			UsersDao usersDao = new UsersDao(conn);
			
			Users user = usersDao.findMemberByEmailAndPassword(email, password);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
