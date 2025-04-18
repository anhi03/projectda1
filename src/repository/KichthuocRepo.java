/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Kichthuoc;

/**
 *
 * @author Admin
 */
public class KichthuocRepo {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
     public ArrayList<Kichthuoc> getallkt(){
        ArrayList<Kichthuoc> list1 = new ArrayList<>();
        sql = "SELECT id, maKichThuoc, tenKichThuoc, trangthai FROM KichThuoc WHERE trangthai=1";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Kichthuoc kt = new Kichthuoc();
                kt.setId(rs.getInt(1));
                kt.setMakichthuoc(rs.getString(2));
                kt.setTenkichthuoc(rs.getString(3));
                kt.setTrangthai(rs.getBoolean(4));  // Lấy đúng trạng thái từ DB
                list1.add(kt);
            }
            return list1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addkt(Kichthuoc kt) {
        sql = "insert into KichThuoc( maKichThuoc, tenKichThuoc) values (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kt.getMakichthuoc());
            ps.setObject(2, kt.getTenkichthuoc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updatekt(Kichthuoc size, String ma) {
        sql = "UPDATE KichThuoc SET tenKichThuoc = ?, trangthai = ? WHERE maKichThuoc = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, size.getTenkichthuoc());
            ps.setObject(2, size.getTrangthai());
            ps.setObject(3, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deletekt(String ma) {
    sql = "UPDATE KichThuoc SET trangthai = 0 WHERE maKichThuoc = ?";
    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setObject(1, ma);
        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}
}
