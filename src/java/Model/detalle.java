
package Model;

import java.io.InputStream;

public class detalle {
    
    private int idDetalle;
    private int idProducto;
    private int idProyecto;  
    private int alto;
    private int ancho;
    private int profundidad;
    private int cantidad;
    private String observacion;
    private int precioDetalle;
    
    private int cantidadMaterial;
    private String nombreMaterial;   
    private String nombreProducto;
    private String url;
    private InputStream foto;

    public detalle() {
    }

    public detalle(int idDetalle, int idProducto, int idProyecto, int alto, int ancho, int profundidad, int cantidad, String observacion, int precioDetalle) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.idProyecto = idProyecto;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.cantidad = cantidad;
        this.observacion = observacion;
        this.precioDetalle = precioDetalle;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
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

    public int getPrecioDetalle() {
        return precioDetalle;
    }

    public void setPrecioDetalle(int precioDetalle) {
        this.precioDetalle = precioDetalle;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    
    
    
}
