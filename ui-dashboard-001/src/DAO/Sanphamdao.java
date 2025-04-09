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

/**
 *
 * @author Admin
 */
public class Sanphamdao {
    public List<String> getLoaiSanPhamList() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT tenLoaiSanPham FROM LoaiSanPham where trangthai=1"; 

        try (Connection conn = Dbconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(rs.getString("tenLoaiSanPham"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
