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

@WebServlet("/CreateAttraction")
@MultipartConfig
public class CreateAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String attractionName = request.getParameter("attractName");
		String location = request.getParameter("locationName");
		// 獲取客戶端通過 HTTP POST 方法上傳的文件部分（part）的方法
		String discribe = request.getParameter("discribes");
		Part attractionPhotoPart = request.getPart("attractPhoto");
		
		InputStream in = attractionPhotoPart.getInputStream();
		byte[] attractionPhoto = in.readAllBytes();
		in.close();
		
		// 封裝資料
		Attraction a = new Attraction();
		a.setAttractionName(attractionName);
		a.setLocation(location);
		a.setAttractionPhoto(attractionPhoto);
		a.setDiscribe(discribe);
		
		// 呼叫Service
		AttractionService attractionService = new AttractionService();
		attractionService.createAttraction(a);
		
		// 跳轉畫面
		response.sendRedirect("BackAllAttraction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
