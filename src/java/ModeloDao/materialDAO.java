/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;
import Interfaces.CRUDmaterial;
import Model.material;
import Config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class materialDAO implements CRUDmaterial{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    material r=new material();

    @Override
    public List listar() {
    ArrayList<material> list=new ArrayList<>();
        String sql="select id_material, tipo_material, nombre_material FROM material inner join tipo_material on material.id_tipo_material_fk =  tipo_material.id_tipo_material";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                material material=new material();
                material.setIdMaterial(rs.getInt("id_material"));
                material.setTipoNombre(rs.getString("tipo_material"));
                material.setNombreMaterial(rs.getString("nombre_material"));
                list.add(material);
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());
        }
        return list;

    }
    
    

    @Override
    public material list(int id) {
         ArrayList<material> list=new ArrayList<>();
        String sql="select id_material, id_tipo_material_fk, tipo_material, nombre_material FROM material inner join tipo_material on material.id_tipo_material_fk =  tipo_material.id_tipo_material where id_material="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdMaterial(rs.getInt("id_material"));
                r.setIdTipoMaterial(rs.getInt("id_tipo_material_fk"));
                r.setTipoNombre(rs.getString("tipo_material"));
                r.setNombreMaterial(rs.getString("nombre_material"));

          
            }
        }catch(Exception e){
                            System.out.println("Error " + e.getMessage());

        }
        return r;    }

    @Override
    public boolean add(material material) {
        String sql ="insert into material (id_tipo_material_fk, nombre_material) values('"+material.getIdTipoMaterial()+"','"+material.getNombreMaterial()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
                                        System.out.println("Error " + e.getMessage());

        }
        return false;    }

    @Override
    public boolean edit(material material) {
    String sql = "update material set id_tipo_material_fk='"+material.getIdTipoMaterial()+"',nombre_material='"+material.getNombreMaterial()+"'where id_material="+material.getIdMaterial();
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;    }

    @Override
    public boolean eliminat(int id) {
String sql="delete from material where id_material ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        }    
   
        public material buscar(int id){
        material m = new material();
        String sql="select * from material where id_material="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        System.out.println(sql);
        while(rs.next()){
        m.setIdMaterial(rs.getInt("id_material"));
        m.setIdTipoMaterial(rs.getInt("id_tipo_material_fk"));
        m.setNombreMaterial(rs.getString("nombre_material"));
        }
        }
        catch(Exception e){
        }
        return m;
    }
}
