/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDtipopro;
import Model.tipoproducto;
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
public class tipoproductoDAO implements CRUDtipopro{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    tipoproducto tp = new tipoproducto();
    @Override
    public List listar() {
        ArrayList<tipoproducto>list=new ArrayList<>();
        String sql="select * from tipoproducto";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
        tipoproducto tippro=new tipoproducto();
        tippro.setIdtipoproducto(rs.getInt("id_tipo_producto"));
        tippro.setTipoproducto(rs.getString("tipo_producto"));
        list.add(tippro);
        }
        }catch(Exception e){
        }
        return list;
        
    }

    @Override
    public tipoproducto list(int id) {
        ArrayList<tipoproducto>list=new ArrayList<>();
        String sql="select * from tipoproducto where id_tipo_producto="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
        tp.setIdtipoproducto(rs.getInt("id_tipo_producto"));
        tp.setTipoproducto(rs.getString("tipo_producto"));
        
        }
        }catch(Exception e){
        }
        return tp;
    }

    @Override
    public boolean add(tipoproducto tipoproducto) {
        String sql="insert into tipoproducto (tipo_producto) values('"+tipoproducto.getTipoproducto()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean edit(tipoproducto tipoproducto) {
        String sql ="update tipoproducto set tipo_producto = '"+tipoproducto.getTipoproducto()+"'where id_tipo_producto="+tipoproducto.getIdtipoproducto();
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
        String sql="delete from tipoproducto where id_tipo_producto="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }
    
        public String listarProductoSelect() {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select id_tipo_producto, tipo_producto ");
        query.append(" from tipoproducto ");
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
