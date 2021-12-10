/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author crist
 */
public class material {
    private int idMaterial;
    private int idTipoMaterial;
    private String nombreMaterial;
    private String TipoNombre;

    public material() {
    }

    public material(int idMaterial, int idTipoMaterial, String nombreMaterial) {
        this.idMaterial = idMaterial;
        this.idTipoMaterial = idTipoMaterial;
        this.nombreMaterial = nombreMaterial;
    }


    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(int idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getTipoNombre() {
        return TipoNombre;
    }

    public void setTipoNombre(String TipoNombre) {
        this.TipoNombre = TipoNombre;
    }
    
    
    
}
