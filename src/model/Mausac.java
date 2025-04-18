/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Mausac {
    private int id;
    private String mamausac;
    private String tenmausac;
    private Boolean trangthai;
    
    public Mausac() {
    }

    public Mausac(int id, String mamausac, String tenmausac, Boolean trangthai) {
        this.id = id;
        this.mamausac = mamausac;
        this.tenmausac = tenmausac;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMamausac() {
        return mamausac;
    }

    public void setMamausac(String mamausac) {
        this.mamausac = mamausac;
    }

    public String getTenmausac() {
        return tenmausac;
    }

    public void setTenmausac(String tenmausac) {
        this.tenmausac = tenmausac;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Object[] addtorow(){
        return new Object[]{
            this.getId(),this.getMamausac(), this.getTenmausac(),this.getTrangthai()
        };
    }
    
}
