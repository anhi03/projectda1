package repository;


import Utils.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.NhanVien;

public class NhanVienRepos {

    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT id, maNhanVien, ten, gioiTinh, soDienThoai, email, taiKhoan, matKhau, vaiTro, trangThai FROM NhanVien WHERE trangThai = 1";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public Integer add(NhanVien n) {
        String sql = """
                     INSERT INTO NhanVien
                        (maNhanVien, ten, gioiTinh, soDienThoai, email, taiKhoan, matKhau, vaiTro, trangThai) 
                     VALUES (?,?,?,?,?,?,?,?,?)""";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, n.getMaNhanVien());
            pstm.setString(2, n.getTen());
            pstm.setBoolean(3, n.isGioiTinh());
            pstm.setString(4, n.getSoDienThoai());
            pstm.setString(5, n.getEmail());
            pstm.setString(6, n.getTaiKhoan());
            pstm.setString(7, n.getMatKhau());
            pstm.setBoolean(8, n.isVaiTro());
            pstm.setBoolean(9, n.isTrangThai());

            return pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public Integer update(NhanVien n) {
        String sql = """
                     UPDATE NhanVien SET
                        ten = ?, gioiTinh = ?, soDienThoai = ?, email = ?, taiKhoan = ?, matKhau = ?, vaiTro = ?, trangThai = ? 
                     WHERE maNhanVien = ?""";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, n.getTen());
            pstm.setBoolean(2, n.isGioiTinh());
            pstm.setString(3, n.getSoDienThoai());
            pstm.setString(4, n.getEmail());
            pstm.setString(5, n.getTaiKhoan());
            pstm.setString(6, n.getMatKhau());
            pstm.setBoolean(7, n.isVaiTro());
            pstm.setBoolean(8, n.isTrangThai());
            pstm.setString(9, n.getMaNhanVien());

            return pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public boolean delete(String maNV) {
        String sql = "UPDATE NhanVien SET trangThai = 0 WHERE maNhanVien = ?";
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<NhanVien> search(String keyword) {
        ArrayList<NhanVien> lists = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien WHERE maNhanVien LIKE ? OR ten LIKE ? OR soDienThoai LIKE ? OR email LIKE ? OR taiKhoan LIKE ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String searchString = "%" + keyword + "%";
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, searchString);
            }

            ResultSet rs = ps.executeQuery();
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
                lists.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }
}
