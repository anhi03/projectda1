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
import model.Loaisanpham;

/**
 *
 * @author Admin
 */
public class LoaiSanPhamRepo {
    
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Loaisanpham> getalllsp(){
        ArrayList<Loaisanpham> list2 = new ArrayList<>();
        sql = "SELECT id, maLoaiSanPham, tenLoaiSanPham, trangthai FROM LoaiSanPham WHERE trangthai=1";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Loaisanpham lsp = new Loaisanpham();
                lsp.setId(rs.getInt(1));
                lsp.setMalsp(rs.getString(2));
                lsp.setTenlsp(rs.getString(3));
                lsp.setTrangthai(rs.getBoolean(4));  // Lấy đúng trạng thái từ DB
                list2.add(lsp);
            }
            return list2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int addlsp(Loaisanpham lsp) {
        sql = "insert into LoaiSanPham( maLoaiSanPham, tenLoaiSanPham) values (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, lsp.getMalsp());
            ps.setObject(2, lsp.getTenlsp());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updatelsp(Loaisanpham lsp, String ma) {
        sql = "UPDATE LoaiSanPham SET tenLoaiSanPham = ?, trangthai = ? WHERE maLoaiSanPham = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, lsp.getTenlsp());
            ps.setObject(2, lsp.getTrangthai());
            ps.setObject(3, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int deletelsp(String ma) {
    sql = "UPDATE LoaiSanPham SET trangthai = 0 WHERE maLoaiSanPham = ?";
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
