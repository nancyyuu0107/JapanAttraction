package tw.com.eeit.JapanAttraction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;
import tw.com.eeit.JapanAttraction.service.AttractionService;
import tw.com.eeit.JapanAttraction.util.PathConverter;

@WebServlet("/FindByName")
public class FindByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript;charset=UTF-8");
		
		String location = request.getParameter("location");
		
		AttractionService attractionService = new AttractionService();
		List<Attraction> cities = attractionService.findByName(location);
		
	
		request.setAttribute("city", cities);
	
		request.getRequestDispatcher(PathConverter.convertToWebInfPath("City")).forward(request,
				response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
