/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author crist
 */
public class medio {
    private int idmedio;
    private int idProyecto;
    private String url;
    private InputStream foto;
    private Date fecha; 
    private String proyecto;

   
    public medio() {
    }

    public medio(int idmedio, int idProyecto, String url, InputStream foto) {
        this.idmedio = idmedio;
        this.idProyecto = idProyecto;
        this.url = url;
        this.foto = foto;
    }

    

    

    public int getIdmedio() {
        return idmedio;
    }

    public void setIdmedio(int idmedio) {
        this.idmedio = idmedio;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    
    
    
}
