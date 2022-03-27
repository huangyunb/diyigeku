package com.example.couple.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.couple.dao.UserDaoImp;
import com.example.couple.entity.User;
import com.example.couple.util.DBHelper;

public class UserServiceImp implements UserService {

	private UserDaoImp ad;
	UserDaoImp ud = new UserDaoImp();
		public UserServiceImp() {
			ad = new UserDaoImp();
		}

		@Override
		public User findUserByLogin(User user) {
			Connection conn = DBHelper.getConnection();
			try {
				ResultSet set = ad.selectUserByLogin(conn, user);
				if(set.next()) {
					String username = set.getString("username");
					String password = set.getString("password");
					System.out.println();
					return new User(username, password);
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				ad.closeAll();
			}
			return null;
		}
		
		@Override
		public User findUserByName(String username) {
			Connection conn = DBHelper.getConnection();
			try {
				ResultSet set = ad.selectUserByName(conn, username);
				if(set.next()) {
					String password = set.getString("password");
					return new User(username, password);
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				ad.closeAll();
			}
			return null;
		}

		@Override
		public int addUser(User user) {
			Connection conn = DBHelper.getConnection();
			try {
				return ad.addUser(conn, user);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				ad.closeAll();
			}

			return 0;
		}

	@Override
	public int baocunchengji(String name,int score) {
		Connection conn = DBHelper.getConnection();
		try{
			int set = ud.baocunchengji(conn , name, score);
			System.out.println(set);
			return set;
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ud.closeAll();
		}
		return 0;
	}

	@Override
	public int[] suoyouchengji( String name ) {
		Connection conn = DBHelper.getConnection();
		try{
			ResultSet set1 = ud.chakanchengji(conn,name);
			int n =0;
			while(set1.next()){
				n++;
			}
			int[] chengjidan = new int[n];
			ResultSet set2 = ud.chakanchengji(conn,name);
			int i = 0;
			while (set2.next()){
				chengjidan[i] = set2.getInt("score");
				i++;
			}
			return chengjidan;
		}catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ud.closeAll();
		}
		return new int[0];
	}
}
