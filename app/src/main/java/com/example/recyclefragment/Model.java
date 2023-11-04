package com.example.recyclefragment;

public class Model {
    private String status;
    private int photo;
    private String dt;
    private String meeza;
    private String txn;
    private String egp;
    private int iv_arw;

    public Model (String status, int photo, String dt, String meeza, String txn, String egp,int iv_arw){
    this.status=status;
    this.photo=photo;
    this.dt=dt;
    this.meeza=meeza;
    this.txn=txn;
    this.egp=egp;
    this.iv_arw=iv_arw;


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getMeeza() {
        return meeza;
    }

    public void setMeeza(String meeza) {
        this.meeza = meeza;
    }

    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getEgp() {
        return egp;
    }

    public void setEgp(String egp) {
        this.egp = egp;
    }

    public int getIv_arw() {
        return iv_arw;
    }

    public void setIv_arw(int iv_arw) {
        this.iv_arw = iv_arw;
    }
}