package tw.com.eeit.JapanAttraction.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;

public class AttractionDao {

	private Connection conn;

	public AttractionDao(Connection conn) {
		this.conn = conn;
	}

	// 新增
	public void createAttraction(Attraction a) throws SQLException {

		final String SQL = "INSERT INTO [JapanAttraction].[dbo].[Attraction] ([attraction_name], [location], [discribe], [attraction_photo]) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(SQL);

		pstmt.setString(1, a.getAttractionName());
		pstmt.setString(2, a.getLocation());
		pstmt.setString(3, a.getDiscribe());
		pstmt.setBytes(4, a.getAttractionPhoto());

		pstmt.execute();

	}

	// FindAll
	public List<Attraction> findAll() throws SQLException {

		List<Attraction> attractions = new ArrayList<Attraction>();

		final String SQL = "SELECT * FROM [Attraction]";
		PreparedStatement pstmt = conn.prepareStatement(SQL);

		// executeQuery()方法执行查询后，会返回一个ResultSet对象，该对象包含了查询返回的所有数据行。
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Attraction a = new Attraction();
			a.setAttractionID(rs.getInt("attraction_id"));
			a.setAttractionName(rs.getString("attraction_name"));
			a.setLocation(rs.getString("location"));
			a.setDiscribe(rs.getString("discribe"));
			a.setAttractionPhoto(rs.getBytes("attraction_photo"));

			attractions.add(a);
		}

		rs.close();
		pstmt.close();

		return attractions;
	}

	// FindById
	public Attraction findById(Integer attractionId) throws SQLException {

		Attraction a = null;

		final String SQL = "SELECT * FROM [JapanAttraction].[dbo].[Attraction] WHERE [attraction_id] = ?";

		PreparedStatement pstmt = conn.prepareStatement(SQL);

		pstmt.setInt(1, attractionId);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			a = new Attraction();
			a.setAttractionID(rs.getInt("attraction_id"));
			a.setAttractionName(rs.getString("attraction_name"));
			a.setLocation(rs.getString("location"));
			a.setDiscribe(rs.getString("discribe"));
			a.setAttractionPhoto(rs.getBytes("attraction_photo"));
		}
		rs.close();
		pstmt.close();

		return a;

	}

	// 刪除
	public void deleteById(int attractionId) throws SQLException {
		final String SQL = "DELETE FROM [JapanAttraction].[dbo].[Attraction] WHERE [attraction_id] = ?";
		PreparedStatement pstmt = conn.prepareStatement(SQL);

		pstmt.setInt(1, attractionId);
		pstmt.execute();
		pstmt.close();
	}

	// 更新
	public void updateAttraction(Attraction a) throws SQLException {
		final String SQL = "UPDATE [dbo].[Attraction] SET [attraction_name] = ? ,[location] = ? ,[attraction_photo] = ?  ,[discribe] = ? WHERE [attraction_id]=?";
		
		// 沒有更改照片的語法
		final String SQL_WITHOUTPHOTO = "UPDATE [dbo].[Attraction] SET [attraction_name] = ? ,[location] = ?  ,[discribe] = ? WHERE [attraction_id]=?";
		
		PreparedStatement pstmt;
		if(a.getAttractionPhoto()!=null) {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, a.getAttractionName());
			pstmt.setString(2, a.getLocation());
			pstmt.setBytes(3, a.getAttractionPhoto());
			pstmt.setString(4, a.getDiscribe());
			pstmt.setInt(5, a.getAttractionID());
		} else {
			
			pstmt=conn.prepareStatement(SQL_WITHOUTPHOTO);
			pstmt.setString(1, a.getAttractionName());
			pstmt.setString(2, a.getLocation());
			pstmt.setString(4, a.getDiscribe());
			pstmt.setInt(5, a.getAttractionID());
		}
		
		pstmt.execute();
		pstmt.close();
		
	}
	
	
	public List<Attraction> findByName(String location) throws SQLException {

		List<Attraction> attractions = new ArrayList<Attraction>();

		final String SQL = "SELECT * FROM [Attraction] WHERE [location] like ? ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		
		pstmt.setString(1,"%"+ location+"%");

		// executeQuery()方法执行查询后，会返回一个ResultSet对象，该对象包含了查询返回的所有数据行。
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Attraction a = new Attraction();
			a.setAttractionID(rs.getInt("attraction_id"));
			a.setAttractionName(rs.getString("attraction_name"));
			a.setLocation(rs.getString("location"));
			a.setDiscribe(rs.getString("discribe"));
			a.setAttractionPhoto(rs.getBytes("attraction_photo"));

			attractions.add(a);
		}

		rs.close();
		pstmt.close();

		return attractions;
	}
	
	
	public Attraction findAttractionName(String attractionName) throws SQLException {

		Attraction a = null;;

		final String SQL = "SELECT * FROM [Attraction] WHERE [attraction_name] like ? ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		
		pstmt.setString(1,"%"+ attractionName +"%");

		// executeQuery()方法执行查询后，会返回一个ResultSet对象，该对象包含了查询返回的所有数据行。
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			a = new Attraction();
			a.setAttractionID(rs.getInt("attraction_id"));
			a.setAttractionName(rs.getString("attraction_name"));
			a.setLocation(rs.getString("location"));
			a.setDiscribe(rs.getString("discribe"));
			a.setAttractionPhoto(rs.getBytes("attraction_photo"));

			
		}

		rs.close();
		pstmt.close();

		return a;
	}
	
	
}
