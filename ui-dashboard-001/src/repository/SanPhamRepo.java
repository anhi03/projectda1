/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Utils.Dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Sanpham;


/**
 *
 * @author Admin
 */
public class SanPhamRepo {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public ArrayList<Sanpham> getall(){
        ArrayList<Sanpham> list = new ArrayList<>();
        sql = "select id, maSP, tenSP, moTa, id_loaiSanPham, trangthai from SanPham where trangthai=1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sanpham sp = new Sanpham();
                sp.setId(rs.getInt(1));
                sp.setMasp(rs.getString(2));
                sp.setTensp(rs.getString(3));
                sp.setMota(rs.getString(4));
                sp.setId_lsp(rs.getInt(5));
                sp.setTrangthai(rs.getBoolean(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Sanpham> getall_remove(){
        ArrayList<Sanpham> list = new ArrayList<>();
        sql = "select id, maSP, tenSP, moTa, id_loaiSanPham, trangthai from SanPham where trangthai=0";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Sanpham sp = new Sanpham();
                sp.setId(rs.getInt(1));
                sp.setMasp(rs.getString(2));
                sp.setTensp(rs.getString(3));
                sp.setMota(rs.getString(4));
                sp.setId_lsp(rs.getInt(5));
                sp.setTrangthai(rs.getBoolean(6));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int add(Sanpham sp){
        sql = "insert into SanPham (maSP, tenSP, moTa, id_loaiSanPham) values (?,?,?,?)";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMasp());
            ps.setObject(2, sp.getTensp());
            ps.setObject(3, sp.getMota());
            ps.setObject(4, sp.getId_lsp());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update(Sanpham product, String ma){
        sql = "update SanPham set tenSP=?, moTa=?, id_loaiSanPham=?, trangthai=? where MaSP = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, product.getTensp());
            ps.setObject(2, product.getMota());
            ps.setObject(3, product.getId_lsp());
            ps.setObject(4, product.getTrangthai());
            ps.setObject(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int remove(String ma) {
        sql = "UPDATE Sanpham SET trangthai = 0 WHERE MaSP = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int khoiphuc(String ma) {
        sql = "UPDATE Sanpham SET trangthai = 1 WHERE MaSP = ?";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<Sanpham> search(String keyword) {
    ArrayList<Sanpham> list = new ArrayList<>();
    String sql = "SELECT * FROM Sanpham WHERE masp LIKE ? OR tensp LIKE ? OR mota LIKE ?";

    try (Connection con = Dbconnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
         
        String searchPattern = "%" + keyword + "%";
        ps.setString(1, searchPattern);
        ps.setString(2, searchPattern);
        ps.setString(3, searchPattern);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Sanpham sp = new Sanpham();
                sp.setId(rs.getInt(1));
                sp.setMasp(rs.getString(2));
                sp.setTensp(rs.getString(3));
                sp.setMota(rs.getString(4));
                sp.setId_lsp(rs.getInt(5));
                sp.setTrangthai(rs.getBoolean(6));
                list.add(sp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}


}
