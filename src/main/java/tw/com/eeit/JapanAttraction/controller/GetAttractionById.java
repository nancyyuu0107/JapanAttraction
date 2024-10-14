//package tw.com.eeit.JapanAttraction.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import tw.com.eeit.JapanAttraction.model.bean.Attraction;
//import tw.com.eeit.JapanAttraction.service.AttractionService;
//import tw.com.eeit.JapanAttraction.util.PathConverter;
//
//@WebServlet("/BackShowAttraction")
//@MultipartConfig
//public class GetAttractionById extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	String attractionId = request.getParameter("id");
//	
//	
//	
//	AttractionService attractionService = new AttractionService();
//	Attraction attraction = attractionService.findById(Integer.valueOf(attractionId));
//	
//	request.setAttribute("a", attraction);
//	
//	request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request,
//			response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
