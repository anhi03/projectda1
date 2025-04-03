package DAO;


import Utils.Dbconnection;
import model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NhanVienDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        sql = "SELECT id, maNhanVien, ten, gioiTinh, soDienThoai, email, taiKhoan, matKhau, vaiTro, trangThai FROM NhanVien WHERE trangThai = 1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien(
    rs.getInt("id"),
    rs.getString("maNhanVien"),
    rs.getString("ten"),
    rs.getString("soDienThoai"),  
    rs.getString("email"),       
    rs.getBoolean("gioiTinh"),   
    rs.getString("taiKhoan"),
    rs.getString("matKhau"),
    rs.getBoolean("vaiTro"),
    rs.getBoolean("trangThai")
);

                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getAllNhanVienIDs() {
        ArrayList<String> list = new ArrayList<>();
        sql = "SELECT maNhanVien FROM NhanVien WHERE trangThai = 1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("maNhanVien"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getAllTaiKhoan() {
        ArrayList<String> list = new ArrayList<>();
        sql = "SELECT taiKhoan FROM NhanVien WHERE trangThai = 1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("taiKhoan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<String> getAllEmails() {
        ArrayList<String> list = new ArrayList<>();
        sql = "SELECT email FROM NhanVien WHERE trangThai = 1";
        try {
            con = Dbconnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
