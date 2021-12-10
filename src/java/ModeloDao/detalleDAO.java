/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Config.Conexion;
import Model.detalle;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author User
 */
public class detalleDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    detalle r=new detalle();
    
        public List listar() {
 ArrayList<detalle> list=new ArrayList<>();
        String sql="SELECT producto.nombre_producto ,detalleproyecto.alto, detalleproyecto.ancho, detalleproyecto.precio_detalle, detalleproyecto.profundidad, medio.url, medio.foto, medio.IdMedio  FROM detalleproyecto\n" +
"INNER join producto on detalleproyecto.id_producto_fk = producto.id_producto\n" +
"INNER JOIN proyecto on detalleproyecto.id_proyecto_fk = proyecto.id_proyecto\n" +
"INNER JOIN medio on proyecto.id_proyecto = medio.IdProyectoFk  "
                + "WHERE proyecto.estado_proyecto = \"Finalizado\"";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                detalle detalle=new detalle(); 
                detalle.setIdProyecto(rs.getInt("IdMedio"));
                detalle.setFoto(rs.getBinaryStream("foto"));
                detalle.setNombreProducto(rs.getString("nombre_producto"));
                detalle.setAlto(rs.getInt("alto"));
                detalle.setAncho(rs.getInt("ancho"));
                detalle.setProfundidad(rs.getInt("profundidad"));
                detalle.setPrecioDetalle(rs.getInt("precio_detalle"));
                detalle.setUrl(rs.getString("url"));
                list.add(detalle);
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());
        }
        return list;   
    }
        
        
    public List listar(int id){
        ArrayList<detalle> list=new ArrayList<>();
        String sql="SELECT detalleproyecto.id_detalle, producto.nombre_producto ,detalleproyecto.alto, detalleproyecto.ancho, detalleproyecto.profundidad, \n" +
"detalleproyecto.cantidad, detalleproyecto.observacion, detalleproyecto.precio_detalle\n" +
"from detalleproyecto\n" +
"inner join proyecto on detalleproyecto.id_proyecto_fk = proyecto.id_proyecto\n" +
"inner join producto on detalleproyecto.id_producto_fk = producto.id_producto\n" +
"where proyecto.id_proyecto ="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                detalle detalle=new detalle();
                detalle.setIdDetalle(rs.getInt("id_detalle"));           
                detalle.setNombreProducto(rs.getString("nombre_producto"));
                detalle.setAlto(rs.getInt("alto"));
                detalle.setAncho(rs.getInt("ancho"));
                detalle.setProfundidad(rs.getInt("profundidad"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setObservacion(rs.getString("observacion"));
                detalle.setPrecioDetalle(rs.getInt("precio_detalle"));
                list.add(detalle);
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());
        }
        return list;
    }
    
    
    
    
        public detalle list(int id) {
        String sql="SELECT detalleproyecto.id_detalle, producto.nombre_producto as producto ,detalleproyecto.alto, detalleproyecto.ancho, detalleproyecto.profundidad, detalleproyecto.cantidad, detalleproyecto.observacion, detalleproyecto.precio_detalle\n" +
"from detalleproyecto inner join producto on detalleproyecto.id_producto_fk = producto.id_producto WHERE detalleproyecto.id_detalle ="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdDetalle(rs.getInt("id_detalle"));
                r.setNombreProducto(rs.getString("producto"));
                r.setAlto(rs.getInt("alto"));
                r.setAncho(rs.getInt("ancho"));
                r.setProfundidad(rs.getInt("profundidad"));
                r.setCantidad(rs.getInt("cantidad"));
                r.setObservacion(rs.getString("observacion"));
                r.setPrecioDetalle(rs.getInt("precio_detalle"));
                
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return r;    
    }
        public boolean edit(detalle detalle) {
                String sql = "update detalleproyecto set alto='"+detalle.getAlto()+"', ancho='"+detalle.getAncho()+"', cantidad='"+detalle.getCantidad()+"', observacion='"+detalle.getObservacion()+"', precio_detalle='"+detalle.getPrecioDetalle()+"', profundidad='"+detalle.getProfundidad()+"' where id_detalle=" +detalle.getIdDetalle();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
    }
    
    
        public boolean eliminat(int id) {
        String sql="call eliminar_detalles("+id+")";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        }
}
