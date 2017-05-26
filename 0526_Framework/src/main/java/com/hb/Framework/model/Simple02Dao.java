package com.hb.Framework.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Simple02Dao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Simple02Dao() {
		Connection myconn = null;
		try {
			Class.forName("org.h2.Driver");
			myconn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        conn = myconn;
	}
	
	public List<Simple02Vo> selectAll() throws SQLException{
		List<Simple02Vo> list = new ArrayList<Simple02Vo>();
		String sql = "select * from simple2";
		try{
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			Simple02Vo vo = new Simple02Vo();
			vo.setSabun(rs.getInt("sabun"));
			vo.setName(rs.getString("name"));
			vo.setNalja(rs.getString("nalja"));
			vo.setPay(rs.getInt("pay"));
			list.add(vo);
		}
		}finally {
			close();			
		}
		return list;
	}
	
	public void close() throws SQLException{
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();

	}
}
