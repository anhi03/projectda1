/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SPchitiet {
    private int id;
    private String maSPChiTiet;
    private int idsanpham;
    private int idmausac;
    private int idkichthuoc;
    
    private String tenSanPham;
    private String tenMauSac;
    private String tenKichThuoc;
    
    private int soluongton;
    private Long giaban;
    private Boolean trangthai;

    public SPchitiet() {
    }

    public SPchitiet(int id, String maSPChiTiet, int idsanpham, int idmausac, int idkichthuoc, int soluongton, Long giaban, Boolean trangthai) {
        this.id = id;
        this.maSPChiTiet = maSPChiTiet;
        this.idsanpham = idsanpham;
        this.idmausac = idmausac;
        this.idkichthuoc = idkichthuoc;
        this.soluongton = soluongton;
        this.giaban = giaban;
        this.trangthai = trangthai;
    }

    public SPchitiet(int id, String maSPChiTiet, int idsanpham, int idmausac, int idkichthuoc, int soluongton, Long giaban, Boolean trangthai, String tenSanPham, String tenMauSac, String tenKichThuoc) {
        this.id = id;
        this.maSPChiTiet = maSPChiTiet;
        this.idsanpham = idsanpham;
        this.idmausac = idmausac;
        this.idkichthuoc = idkichthuoc;
        this.soluongton = soluongton;
        this.giaban = giaban;
        this.trangthai = trangthai;
        this.tenSanPham = tenSanPham;
        this.tenMauSac = tenMauSac;
        this.tenKichThuoc = tenKichThuoc;
    }

    public SPchitiet( String maSPChiTiet, String tenSanPham, String tenMauSac, String tenKichThuoc, int soluongton, Long giaban, Boolean trangthai) {
        
        this.maSPChiTiet = maSPChiTiet;
        this.tenSanPham = tenSanPham;
        this.tenMauSac = tenMauSac;
        this.tenKichThuoc = tenKichThuoc;
        this.soluongton = soluongton;
        this.giaban = giaban;
        this.trangthai = trangthai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSPChiTiet() {
        return maSPChiTiet;
    }

    public void setMaSPChiTiet(String maSPChiTiet) {
        this.maSPChiTiet = maSPChiTiet;
    }

    public int getIdsanpham() {
        return idsanpham;
    }

    public void setIdsanpham(int idsanpham) {
        this.idsanpham = idsanpham;
    }

    public int getIdmausac() {
        return idmausac;
    }

    public void setIdmausac(int idmausac) {
        this.idmausac = idmausac;
    }

    public int getIdkichthuoc() {
        return idkichthuoc;
    }

    public void setIdkichthuoc(int idkichthuoc) {
        this.idkichthuoc = idkichthuoc;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public Long getGiaban() {
        return giaban;
    }

    public void setGiaban(Long giaban) {
        this.giaban = giaban;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }
    
    public Object[] addtorow(){
        return new Object[]{
            this.getId(), this.getMaSPChiTiet(), this.getTenSanPham(), this.getTenMauSac(), this.getTenKichThuoc(),
            this.getSoluongton(), this.getGiaban(), this.getTrangthai()
        };
    }
}
