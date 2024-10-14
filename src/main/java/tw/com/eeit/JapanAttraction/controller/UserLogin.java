package tw.com.eeit.JapanAttraction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.eeit.JapanAttraction.model.bean.Users;
import tw.com.eeit.JapanAttraction.service.UsersService;
import tw.com.eeit.JapanAttraction.util.PathConverter;

@WebServlet("/UserLogin")
@MultipartConfig
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	UsersService usersService = new UsersService();
	Users user = usersService.login(email, password);
	
	if(user==null) {
		
		request.getSession().setAttribute("message","登入失敗");
		response.sendRedirect("Login");
	}
	
	else if("N@gmail.com".equals(email)) {
		request.getSession().setAttribute("loggedInUser",user);
		response.sendRedirect("BackAllAttraction");
		
	}
	
	
	else {
		
		request.getSession().setAttribute("loggedInUser",user);
		response.sendRedirect("Index");
		
	}

	}

}
