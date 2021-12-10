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
public class tipoproducto {
    private int idtipoproducto;
    private String tipoproducto;

    public int getIdtipoproducto() {
        return idtipoproducto;
    }

    public void setIdtipoproducto(int idtipoproducto) {
        this.idtipoproducto = idtipoproducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public tipoproducto(int idtipoproducto, String tipoproducto) {
        this.idtipoproducto = idtipoproducto;
        this.tipoproducto = tipoproducto;
    }

    public tipoproducto() {
    }
}
