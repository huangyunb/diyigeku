package com.example.couple.service;

import com.example.couple.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserService {
	
	User findUserByLogin(User user);

	User findUserByName(String username);

	int addUser(User user);

	//    保存用户此次做题的成绩，返回int类型
	int baocunchengji( String name, int score);

	//    查看所有成绩 ， 返回一个保存成绩的数组
	int[] suoyouchengji( String name);


}
