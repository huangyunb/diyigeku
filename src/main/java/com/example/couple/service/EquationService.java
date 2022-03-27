package com.example.couple.service;

import com.example.couple.entity.Equation;

public interface EquationService {

//  随机抽取一组普通题目,返回一组题目
    Equation[] chouputong();
//  随机抽取一组括号题目,返回一组题目
    Equation[] choukuohao();
//  随机抽取一组分式题目,返回一组题目
    Equation[] choufenshi();
}
