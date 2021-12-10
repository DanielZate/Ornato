/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDtipomat;
import Model.rol;
import Model.tipomaterial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class tipomaterialDAO implements CRUDtipomat{
       Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    tipomaterial tp=new tipomaterial();
    @Override
    public List listar() {

        ArrayList<tipomaterial> list = new ArrayList<>();
        String sql="select * from tipo_material";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
        tipomaterial tm = new tipomaterial();
        tm.setIdtipomaterial(rs.getInt("id_tipo_material"));
        tm.setTipomaterial(rs.getString("tipo_material"));
        list.add(tm);
        }
        }catch(Exception e){
        }
        return list;
    }

    @Override
    public tipomaterial list(int id) {
        ArrayList<tipomaterial> list = new ArrayList<>();
        String sql="select * from tipo_material where id_tipo_material="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
        tp.setIdtipomaterial(rs.getInt("id_tipo_material"));
        tp.setTipomaterial(rs.getString("tipo_material"));
        
        }
        }catch(Exception e){
        }
        return tp;
    }

    @Override
    public boolean add(tipomaterial tipomaterial) {
        String sql="insert into tipo_material (tipo_material)values('"+tipomaterial.getTipomaterial()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean edit(tipomaterial tipomaterial) {
        String sql="update tipo_material set tipo_material ='"+tipomaterial.getTipomaterial()+"'where id_tipo_material="+tipomaterial.getIdtipomaterial();
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean eliminat(int id) {
        String sql="delete from tipo_material where id_tipo_material="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        
        }
        return false;
    }
  
            public String listarMaterialSelect() {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select id_tipo_material, tipo_material ");
        query.append(" from tipo_material ");
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(query.toString());
            rs=ps.executeQuery();
            while(rs.next()){
                salidaTabla.append(" <option value= '");
                salidaTabla.append(rs.getInt(1));
                salidaTabla.append("'>");
                salidaTabla.append(rs.getString(2));
                salidaTabla.append("</option>");
            }
        }catch(SQLException e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
      return salidaTabla.toString();
    }
    }

    
    

