/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author crist
 */
public class proyecto {
    private int idProyecto;
    private int idUsuarioFk;
    private boolean microProyecto;
    private int valorProyecto;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private String estadoProyecto;
    private String nombreUsu;
    private String inicio;
    private String finalizacion;
    private String microString;

    
        int item;
    
   
    int cantidad;
    String observacion;
    float precioDetalle;
    float alto;
    float ancho;
    float profundidad;
    
    int idProducto;
    String nombreProducto;
    String nombrematerial;
    
    public proyecto() {
    }

    public proyecto(int idProyecto, int idUsuarioFk, boolean microProyecto, int valorProyecto, Date fechaInicio, Date fechaFinalizacion, String estadoProyecto) {
        this.idProyecto = idProyecto;
        this.idUsuarioFk = idUsuarioFk;
        this.microProyecto = microProyecto;
        this.valorProyecto = valorProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.estadoProyecto = estadoProyecto;
    }

    public proyecto(int item, int cantidad, String observacion, float precioDetalle, float alto, float ancho, float profundidad, int idProducto, String nombreProducto, String nombrematerial) {
        this.item = item;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.precioDetalle = precioDetalle;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.nombrematerial = nombrematerial;
    }

    

    
    
    public proyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(int idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }

    public boolean getMicroProyecto() {
        return microProyecto;
    }

    public void setMicroProyecto(boolean microProyecto) {
        this.microProyecto = microProyecto;
    }  

    public int getValorProyecto() {
        return valorProyecto;
    }

    public void setValorProyecto(int valorProyecto) {
        this.valorProyecto = valorProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public void setMicroProyecto(String micro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(String finalizacion) {
        this.finalizacion = finalizacion;
    }

    public String getMicroString() {
        return microString;
    }

    public void setMicroString(String microString) {
        this.microString = microString;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public float getPrecioDetalle() {
        return precioDetalle;
    }

    public void setPrecioDetalle(float precioDetalle) {
        this.precioDetalle = precioDetalle;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }
    
    
    
    
    
}
