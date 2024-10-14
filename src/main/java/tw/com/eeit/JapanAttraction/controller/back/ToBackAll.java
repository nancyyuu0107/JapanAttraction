package tw.com.eeit.JapanAttraction.controller.back;

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


@WebServlet("/BackAllAttraction")
public class ToBackAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AttractionService attractionService = new AttractionService();
		List<Attraction> allAttractions = attractionService.getAllAttraction();
		
		request.setAttribute("allAttractions", allAttractions);
		
		// 調派請求
		// 当一个Servlet或JSP需要将请求转发给另一个Servlet、JSP页面或其他Web组件处理时，
		// 获取一个 RequestDispatcher 对象，然后调用其 forward() 方法进行转发。
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
