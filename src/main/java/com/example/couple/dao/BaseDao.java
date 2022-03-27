package com.example.couple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet set;
	
	public ResultSet selectData(Connection conn, String sql, Object... objs) throws SQLException{
		this.conn = conn;
		ps = conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			ps.setObject(i+1, objs[i]);
		}
		set = ps.executeQuery();
		return set;
	}

	public int updateDate(Connection conn, String sql, Object... objs) throws SQLException{
		this.conn = conn;
		ps =  conn.prepareStatement(sql);
		for(int i = 0; i<objs.length; i++){
			ps.setObject(i+1, objs[i]);
		}
		return ps.executeUpdate();

	}
	
	public void closeAll(){
		try {
			if(set != null){
				set.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
	}

	
}
