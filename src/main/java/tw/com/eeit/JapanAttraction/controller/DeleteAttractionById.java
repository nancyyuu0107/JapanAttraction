package tw.com.eeit.JapanAttraction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.eeit.JapanAttraction.service.AttractionService;

@WebServlet("/DeleteAttractionById")
public class DeleteAttractionById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Integer id = Integer.valueOf(request.getParameter("id")) ;
	
	AttractionService attractionService = new AttractionService();
	attractionService.deleteById(id);
	
	response.getWriter().write("done");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
