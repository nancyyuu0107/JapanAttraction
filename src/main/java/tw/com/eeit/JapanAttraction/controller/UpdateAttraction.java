package tw.com.eeit.JapanAttraction.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;
import tw.com.eeit.JapanAttraction.service.AttractionService;
import tw.com.eeit.JapanAttraction.util.PathConverter;

@WebServlet("/UpdateAttraction")
@MultipartConfig
public class UpdateAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Integer attractionID = Integer.valueOf(request.getParameter("id")) ;
		String attractionName = request.getParameter("attractName");
		String location = request.getParameter("locationName");
		// 獲取客戶端通過 HTTP POST 方法上傳的文件部分（part）的方法
		String discribe = request.getParameter("discribes");
		Part attractionPhotoPart = request.getPart("attractPhoto");
		
		AttractionService attractionService = new AttractionService();
		Attraction a = new Attraction();
		a = attractionService.findById(attractionID);
		
		InputStream in = attractionPhotoPart.getInputStream();
		byte[] attractionPhoto = in.readAllBytes();
		in.close();
		
		
		a.setAttractionName(attractionName);
		a.setLocation(location);
		a.setAttractionPhoto(attractionPhoto);
		a.setDiscribe(discribe);
		
		attractionService.updateAttraction(a);
	
		// 重導頁面
//		request.getRequestDispatcher(PathConverter.convertToWebInfPath("BackAllAttraction"));
		
		response.sendRedirect("BackAllAttraction");
		


}
}