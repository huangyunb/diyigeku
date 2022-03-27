package com.example.couple.service;

import com.example.couple.dao.EquationDaoImp;
import com.example.couple.entity.Equation;
import com.example.couple.util.DBHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquationServiceImp implements EquationService {
    private EquationDaoImp ed;

    public EquationServiceImp() {
        ed = new EquationDaoImp() ;
    }
    @Override
    public Equation[] chouputong() {
        Connection conn = DBHelper.getConnection();
        Equation eq[] = new Equation[20];
        try{
            ResultSet set = ed.chouputong(conn);
            int i=0;
            while(set.next()){
                System.out.println(set);
                eq[i] = new Equation(set.getInt("id"),set.getString("suanshi"),set.getString("jieguo"));
                i++;
            }
        }catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ed.closeAll();
        }
        return eq;
    }

    @Override
    public Equation[] choukuohao() {
        Connection conn = DBHelper.getConnection();
        Equation eq[] = new Equation[20];
        try{
            ResultSet set = ed.choukuohao(conn);
            int i=0;
            while(set.next()){
                eq[i] = new Equation(set.getInt("id"),set.getString("suanshi"),set.getString("jieguo"));
                i++;
            }
        }catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ed.closeAll();
        }
        return eq;
    }

    @Override
    public Equation[] choufenshi() {
        Connection conn = DBHelper.getConnection();
        Equation eq[] = new Equation[20];
        try{
            ResultSet set = ed.choufenshi(conn);
            int i=0;
            while(set.next()){
                System.out.println(set);
                eq[i] = new Equation(set.getInt("id"),set.getString("suanshi"),set.getString("jieguo"));
                i++;
            }
        }catch (SQLException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            ed.closeAll();
        }
        return eq;
    }
}
