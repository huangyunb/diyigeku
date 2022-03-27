package com.example.couple.dao;

import com.example.couple.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {

	ResultSet selectUserByLogin(Connection conn, User user)throws SQLException;

	ResultSet selectUserByName(Connection conn, String username) throws SQLException;

	int addUser(Connection conn, User user)throws SQLException;
	//    保存用户此次做题成绩，输入成绩，返回修改了几行数据
	int baocunchengji(Connection conn , String name, int score)throws SQLException;
	//查看某用户的所有答题成绩，返回查询到的数据
	ResultSet chakanchengji(Connection conn, String name ) throws SQLException;
}
