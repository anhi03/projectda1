/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SPchitietDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<String> getProductList(){
        List<String> list = new ArrayList<>();
        sql = "select tenSP from SanPham where trangthai=1";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("tenSP"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
    
    public ArrayList<String> getCOLORList(){
        List<String> list = new ArrayList<>();
        sql = "select tenmau from MauSac where trangthai=1";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("tenmau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
    
    public ArrayList<String> getSIZEList(){
        List<String> list = new ArrayList<>();
        sql = "select tenKichThuoc from KichThuoc where trangthai=1";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("tenKichThuoc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
}
