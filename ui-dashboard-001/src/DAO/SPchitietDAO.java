/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.Dbconnection;
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
        sql = "select id from SanPham where trangthai=1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
    
    public ArrayList<String> getCOLORList(){
        List<String> list = new ArrayList<>();
        sql = "select id from MauSac where trangthai=1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
    
    public ArrayList<String> getSIZEList(){
        List<String> list = new ArrayList<>();
        sql = "select id from KichThuoc where trangthai=1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                list.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) list;
    }
}
