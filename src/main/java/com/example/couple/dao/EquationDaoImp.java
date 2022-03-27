package com.example.couple.dao;

import com.example.couple.util.rand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EquationDaoImp extends BaseDao implements EquationDao{

    @Override
    public  ResultSet chouputong(Connection conn) throws SQLException {
        rand rand = new rand();
        int[] timu = new int[20];
        timu = rand.randNoCommon(1,999);
        String sql = "select * from putong where id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? ";

        ResultSet set = super.selectData(conn , sql , timu[0], timu[1] , timu[2], timu[3],timu[4],timu[5],timu[6],timu[7],timu[8],timu[9],timu[10],timu[11],timu[12],timu[13],timu[14],timu[15],timu[16],timu[17],timu[18],timu[19]);
        return set;
    }

    @Override
    public ResultSet choukuohao(Connection conn) throws SQLException {
        rand rand = new rand();
        int[] timu = new int[20];
        timu = rand.randNoCommon(1,999);
        System.out.println(timu[0] +"\t"+ timu[1]);
        String sql = "select * from kuohao where id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? ";
        ResultSet set = super.selectData(conn , sql , timu[0], timu[1] , timu[2], timu[3],timu[4],timu[5],timu[6],timu[7],timu[8],timu[9],timu[10],timu[11],timu[12],timu[13],timu[14],timu[15],timu[16],timu[17],timu[18],timu[19]);
        return set;
    }

    @Override
    public ResultSet choufenshi(Connection conn) throws SQLException {
        rand rand = new rand();
        int[] timu = new int[20];
        timu = rand.randNoCommon(1,999);
        String sql = "select * from fenshi where id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ? or id = ?" +
                " or id = ? ";
        ResultSet set = super.selectData(conn , sql , timu[0], timu[1] , timu[2], timu[3],timu[4],timu[5],timu[6],timu[7],timu[8],timu[9],timu[10],timu[11],timu[12],timu[13],timu[14],timu[15],timu[16],timu[17],timu[18],timu[19]);
        return set;
    }



}
