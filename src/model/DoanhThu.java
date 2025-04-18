package model;

import java.util.Date;
import java.util.List;

public class DoanhThu {
 private Date ngayThanhToan;
    private String maNhanVien;
    private String tenNhanVien;
    private String tenSP;
    private int soLuongBan;
    private double tongTienTruocKM;
    private double tongTienKhuyenMai;
    private double tongTienSauKM;
    private static int sttCounter = 1;

    // Constructor
    public DoanhThu(Date ngayThanhToan, String maNhanVien, String tenNhanVien,
                    String tenSP, int soLuongBan,
                    double tongTienTruocKM, double tongTienKhuyenMai, double tongTienSauKM) {
        this.ngayThanhToan = ngayThanhToan;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tenSP = tenSP;
        this.soLuongBan = soLuongBan;
        this.tongTienTruocKM = tongTienTruocKM;
        this.tongTienKhuyenMai = tongTienKhuyenMai;
        this.tongTienSauKM = tongTienSauKM;
    }

    // Getter and Setter methods
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public double getTongTienTruocKM() {
        return tongTienTruocKM;
    }

    public void setTongTienTruocKM(double tongTienTruocKM) {
        this.tongTienTruocKM = tongTienTruocKM;
    }

    public double getTongTienKhuyenMai() {
        return tongTienKhuyenMai;
    }

    public void setTongTienKhuyenMai(double tongTienKhuyenMai) {
        this.tongTienKhuyenMai = tongTienKhuyenMai;
    }

    public double getTongTienSauKM() {
        return tongTienSauKM;
    }

    public void setTongTienSauKM(double tongTienSauKM) {
        this.tongTienSauKM = tongTienSauKM;
    }

    @Override
    public String toString() {
        return "DoanhThu{" +
                "ngayThanhToan=" + ngayThanhToan +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuongBan=" + soLuongBan +
                ", tongTienTruocKM=" + tongTienTruocKM +
                ", tongTienKhuyenMai=" + tongTienKhuyenMai +
                ", tongTienSauKM=" + tongTienSauKM +
                '}';
    }

    // Phương thức get STT
    public static String getStt() {
        return "STT" + sttCounter++;
    }

    // Tổng doanh thu sau KM
    public static double tinhTongTienSauKM(List<DoanhThu> danhSachDoanhThu) {
        double tong = 0;
        for (DoanhThu d : danhSachDoanhThu) {
            tong += d.getTongTienSauKM();
        }
        return tong;
    }
}
