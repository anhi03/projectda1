/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class Sanpham {

    private int id;
    private String masp;
    private String tensp;
    private String mota;
    private int id_lsp;
    private String tenlsp;
    private Boolean trangthai;

    public Sanpham() {
    }

    public Sanpham(int id, String masp, String tensp, String mota, int id_lsp, Boolean trangthai) {
        this.id = id;
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.id_lsp = id_lsp;
        this.trangthai = trangthai;
    }

    public Sanpham(String masp, String tensp, String mota, int id_lsp, String tenlsp, Boolean trangthai) {
        this.masp = masp;
        this.tensp = tensp;
        this.mota = mota;
        this.id_lsp = id_lsp;
        this.tenlsp = tenlsp;
        this.trangthai = trangthai;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getId_lsp() {
        return id_lsp;
    }

    public void setId_lsp(int id_lsp) {
        this.id_lsp = id_lsp;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getTenlsp() {
        return tenlsp;
    }

    public void setTenlsp(String tenlsp) {
        this.tenlsp = tenlsp;
    }

    
    public Object[] addtorow() {
    return new Object[]{
        this.getId(),
        this.getMasp(),
        this.getTensp(),
        this.getMota(),
        this.getTenlsp(),
        this.getTrangthai()
    };
}


    
}
