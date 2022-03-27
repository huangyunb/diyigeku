package com.example.couple.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EquationDao {
//  随机抽取一组普通题目,返回一组题目
    ResultSet chouputong(Connection conn ) throws SQLException;
//  随机抽取一组括号题目,返回一组题目
    ResultSet choukuohao(Connection conn ) throws SQLException;
//  随机抽取一组分式题目,返回一组题目
    ResultSet choufenshi(Connection conn ) throws SQLException;

}
