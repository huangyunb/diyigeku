package com.example.couple.dao;

import com.example.couple.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp extends BaseDao implements UserDao {

	@Override
	public ResultSet selectUserByLogin(Connection conn, User user) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		return super.selectData(conn, sql,user.getUsername(), user.getPassword());
	}

	@Override
	public ResultSet selectUserByName(Connection conn, String username) throws SQLException {
		String sql = "select * from user where username = ?";
		return super.selectData(conn, sql,username);
	}

	@Override
	public int addUser(Connection conn, User user) throws SQLException {
		String sql = "insert into user values (?, ? ,?);";
		Object[] objs = {user.getUsername(), user.getPassword(),user.getScore()};
		return super.updateDate(conn, sql, objs);
	}

	@Override
	public int baocunchengji(Connection conn,String name, int score) throws SQLException {
		String sql = "insert into score( score_name , score) values (?, ?)";
		String sql2 = "update user set score = ? where username = ?";
		int i = super.updateDate(conn, sql , name , score);
		int j = super.updateDate(conn, sql2 , score , name);
		return i+j;
	}

	@Override
	public ResultSet chakanchengji(Connection conn, String name) throws SQLException {
		String sql ="select * from score where score_name = ? ";
		return super.selectData(conn , sql , name);
	}

}
