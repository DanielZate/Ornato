/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Interfaces.CRUDproducto;
import Model.producto;
import java.util.List;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class productoDAO implements CRUDproducto{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    producto r=new producto();
    
    @Override
    public List listar() {
 ArrayList<producto> list=new ArrayList<>();
        String sql="select id_producto, nombre_producto, tipo_producto FROM producto \n" +
"inner join tipoproducto on producto.id_tipo_producto_fk =  tipoproducto.id_tipo_producto";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                producto producto=new producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombreTipo(rs.getString("tipo_producto"));
                producto.setNombreProducto(rs.getString("nombre_producto"));
                list.add(producto);
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());
        }
        return list;   
    }

    @Override
    public producto list(int id) {
ArrayList<producto> list=new ArrayList<>();
        String sql="select id_producto,  id_tipo_producto_fk, nombre_producto, tipo_producto FROM producto \n" +
"inner join tipoproducto on producto.id_tipo_producto_fk =  tipoproducto.id_tipo_producto where id_producto ="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdProducto(rs.getInt("id_producto"));
                r.setIdTipoProducto(rs.getInt("id_tipo_producto_fk"));
                r.setNombreTipo(rs.getNString("tipo_producto"));
                r.setNombreProducto(rs.getString("nombre_producto"));

        
            }
        }catch(Exception e){
                            System.out.println("Error " + e.getMessage());

        }
        return r;        }

    @Override
    public boolean add(producto producto) {
        String sql ="insert into producto (id_tipo_producto_fk, nombre_producto) values('"+producto.getIdTipoProducto()+"','"+producto.getNombreProducto()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
              System.out.println("Error " + e.getMessage());

        }
        return false;        }

    @Override
    public boolean edit(producto producto) {
String sql = "update producto set id_tipo_producto_fk='"+producto.getIdTipoProducto()+"',nombre_producto='"+producto.getNombreProducto()+"'where id_producto ="+producto.getIdProducto();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;      
    }

    @Override
    public boolean eliminat(int id) {
String sql="delete from producto where id_producto ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        }    
    
         public producto buscar(int id){
        producto p = new producto();
        String sql="select * from producto where id_producto="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        System.out.println(sql);
        while(rs.next()){
        p.setIdProducto(rs.getInt(1));
        p.setIdTipoProducto(rs.getInt(2));
        p.setNombreProducto(rs.getString(3));
        }
        }
        catch(Exception e){
        }
        return p;
    }
    
}
