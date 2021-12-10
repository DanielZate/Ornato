/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author user
 */
public class tipomaterial {
    private int idtipomaterial;
    private String tipomaterial;

    public int getIdtipomaterial() {
        return idtipomaterial;
    }

    public void setIdtipomaterial(int idtipomaterial) {
        this.idtipomaterial = idtipomaterial;
    }

    public String getTipomaterial() {
        return tipomaterial;
    }

    public void setTipomaterial(String tipomaterial) {
        this.tipomaterial = tipomaterial;
    }

    public tipomaterial(int idtipomaterial, String tipomaterial) {
        this.idtipomaterial = idtipomaterial;
        this.tipomaterial = tipomaterial;
    }

    public tipomaterial() {
    }
}
