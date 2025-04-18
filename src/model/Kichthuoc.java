 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Kichthuoc {
    private int id;
    private String makichthuoc;
    private String tenkichthuoc;
    private Boolean trangthai;
    
    public Kichthuoc() {
    }

    public Kichthuoc(int id, String makichthuoc, String tenkichthuoc, Boolean trangthai) {
        this.id = id;
        this.makichthuoc = makichthuoc;
        this.tenkichthuoc = tenkichthuoc;
        this.trangthai = trangthai;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakichthuoc() {
        return makichthuoc;
    }

    public void setMakichthuoc(String makichthuoc) {
        this.makichthuoc = makichthuoc;
    }

    public String getTenkichthuoc() {
        return tenkichthuoc;
    }

    public void setTenkichthuoc(String tenkichthuoc) {
        this.tenkichthuoc = tenkichthuoc;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Object[] addtorow(){
        return new Object[]{
            this.getId(),this.getMakichthuoc(), this.getTenkichthuoc(),this.getTrangthai()
        };
    }
}
