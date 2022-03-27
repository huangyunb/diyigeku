package com.example.couple.entity;

public class Equation {
    private int id ;
    private String suanshi ;
    private String jieguo ;
    private String daan;

    public Equation(int id ,String suanshi, String jieguo) {
        this.id = id;
        this.suanshi = suanshi;
        this.jieguo = jieguo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSuanshi(String suanshi) {
        this.suanshi = suanshi;
    }

    public void setJieguo(String jieguo) {
        this.jieguo = jieguo;
    }

    public int getId() {
        return id;
    }

    public String getSuanshi() {
        return suanshi;
    }

    public String getJieguo() {
        return jieguo;
    }

    public String getDaan() {
        return daan;
    }

    public void setDaan(String daan) {
        this.daan = daan;
    }
}
