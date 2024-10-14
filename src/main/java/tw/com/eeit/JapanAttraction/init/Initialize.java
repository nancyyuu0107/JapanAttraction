package tw.com.eeit.JapanAttraction.init;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;
import tw.com.eeit.JapanAttraction.util.ConnectionFactory;


@WebListener
public class Initialize implements ServletContextListener {

	// 路徑字串表示初始化資料的存放路徑
	private String INITIALIZATION_DATA_PATH = "META-INF/initialization_data/";

	public void contextInitialized(ServletContextEvent sce) {
		// 代表 Web 應用程式的生命週期事件，例如啟動、停止

		// 取得 ServletContext 物件，它代表了整個 Web 應用程式的環境和資源
		ServletContext context = sce.getServletContext();

		// 初始化 (初始化 ServletContext 屬性)
		// 將應用程式的根路徑（context path）存儲在名為 "root" 的屬性中
		context.setAttribute("root", context.getContextPath());

		// Web 應用程式名稱(JapanAttraction)存儲在名為 "webName" 的屬性
		context.setAttribute("webName", "JapanAttraction");
		
		// 組件視圖的存放路徑存儲在名為 "component" 的屬性
		context.setAttribute("component", "/WEB-INF/view/component");

		// 以下為「在資料庫塞入預設值」的程式
		// 獲取 "META-INF/initialization_data/" 的實際檔案系統路徑，
		// 並將這個路徑賦值給 INITIALIZATION_DATA_PATH 變數
		INITIALIZATION_DATA_PATH = context.getRealPath(INITIALIZATION_DATA_PATH);
	}
}
//		try (Connection conn = ConnectionFactory.getConnection()) {
//			createDB(conn); // 建立資料庫
//			createTableAndInsertData(conn); // 建立Member資料表並加入預設值
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	private void createDB(Connection conn) throws SQLException {
//		// 如果PawPoster資料庫不存在，則建立PawPoster資料庫
//		String SQL = "IF DB_ID('JapanAttraction') IS NULL CREATE DATABASE JapanAttraction";
//
//		Statement state = conn.createStatement();
//		state.execute(SQL);
//		state.close();
//	}
//
//	private void createTableAndInsertData(Connection conn) throws Exception {
//		// 如果JapanAttraction資料表不存在，則建立JapanAttraction資料表
//		String SQL = "IF OBJECT_ID('[JapanAttraction].[dbo].[Attraction]') IS NULL " + "CREATE TABLE [JapanAttraction].[dbo].[Attraction]("
//				+ " [attraction_id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL," + " [attraction_name] [nvarchar](50) NOT NULL,"
//				+ " [location] [nvarchar](50)," + " [attraction_photo] [varbinary](max) ,"
//				+ " [discribe] [nvarchar](MAX)"+ ")";
//		Statement state = conn.createStatement();
//		state.execute(SQL);
//		state.close();
//		
//		// 如果JapanAttraction資料表中沒有任何一筆資料，則新增。
//		if (!conn.createStatement().executeQuery("SELECT [attraction_id] FROM [JapanAttraction].[dbo].[Attraction]").next()) {
//			BufferedReader br = new BufferedReader(new FileReader(INITIALIZATION_DATA_PATH + "Attraction.json"));
//			List<Attraction> attractionList = new Gson().fromJson(br, new TypeToken<List<Attraction>>() {
//			}.getType());
//			br.close();
//			
//			SQL = "INSERT INTO [JapanAttraction].[dbo].[Attraction] ([attraction_name], [location], [discribe], [attraction_photo]) VALUES (?, ?, ?, ?)";
//			
//			// 新增資料到資料表
//			PreparedStatement pstmt = conn.prepareStatement(SQL);
//			for (Attraction a : attractionList) {
//				pstmt.setString(1, a.getAttractionName());
//				pstmt.setString(2, a.getLocation());
//				pstmt.setString(3, a.getDiscribe());
//				
//		
////				BufferedInputStream bis = new BufferedInputStream(
////						new FileInputStream(INITIALIZATION_DATA_PATH + "/photo/attraction/" + a.getAttractionPhoto() + ".jpg"));
////				String base64Photo = "data:image/png;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes());
////				bis.close();
//				
//				pstmt.setBytes(4, a.getAttractionPhoto());
//				pstmt.addBatch();
//			}
//			
//			pstmt.executeBatch();
//			pstmt.close();	
//			
//    }
//}
//}
