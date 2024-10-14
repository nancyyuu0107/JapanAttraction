package tw.com.eeit.JapanAttraction.service;

import java.sql.Connection;
import java.util.List;

import tw.com.eeit.JapanAttraction.model.bean.Attraction;
import tw.com.eeit.JapanAttraction.model.dao.AttractionDao;
import tw.com.eeit.JapanAttraction.util.ConnectionFactory;

public class AttractionService {
	public void createAttraction(Attraction a) {
		
		// 建立連線
		try(Connection conn = ConnectionFactory.getConnection()) {
		// 建立物件執行新增景點方法
		AttractionDao attractionDao = new AttractionDao(conn);
		attractionDao.createAttraction(a);
		
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新增失敗:" + e.getMessage());
		}
	}
	
	public List<Attraction> getAllAttraction() {
		List<Attraction> attractions = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			AttractionDao attractionDao = new AttractionDao(conn);
			attractions = attractionDao.findAll();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return attractions;
		
	}
	
	
	public Attraction findById(Integer attractionId) {
		
		Attraction a = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			
			AttractionDao attractionDao = new AttractionDao(conn);
			a = attractionDao.findById(attractionId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
		
	}
	
	public void deleteById(int attractionId)  {
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			AttractionDao attractionDao = new AttractionDao(conn);
			attractionDao.deleteById(attractionId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("刪除失敗:" + e.getMessage());
		}
		
		
	}
	
	
	public void updateAttraction(Attraction a) {
		
		try (Connection conn = ConnectionFactory.getConnection()){
			AttractionDao attractionDao = new AttractionDao(conn);
			attractionDao.updateAttraction(a);
			
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新失敗:" + e.getMessage());
		}
	}
	
	public List<Attraction> findByName(String location) {
		List<Attraction> attractions = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			AttractionDao attractionDao = new AttractionDao(conn);
			attractions = attractionDao.findByName(location);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return attractions;
		
	}
	
	public Attraction findAttractionName(String attractionName) {
		Attraction a = null;
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			AttractionDao attractionDao = new AttractionDao(conn);
			a = attractionDao.findAttractionName(attractionName);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
		
	}
	
}
