package tw.com.eeit.JapanAttraction.controller.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;
import tw.com.eeit.JapanAttraction.service.AttractionService;
import tw.com.eeit.JapanAttraction.util.PathConverter;

@WebServlet("/BackUpdate")
public class ToBackUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer attractionID = Integer.valueOf(request.getParameter("id"));

		AttractionService attractionService = new AttractionService();
		Attraction attraction = attractionService.findById(attractionID);
		
		request.setAttribute("id", attractionID);
		request.setAttribute("a", attraction);
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
