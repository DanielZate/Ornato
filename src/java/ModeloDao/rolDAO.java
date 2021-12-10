
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUD;
import Model.rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class rolDAO implements CRUD{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    rol r=new rol();
    @Override
    public List listar() {
        ArrayList<rol> list=new ArrayList<>();
        String sql="select * from rol";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                rol rol=new rol();
                rol.setIdrol(rs.getInt("id_rol"));
                rol.setRol(rs.getString("rol"));
                list.add(rol);
            }
        }catch(Exception e){
        }
        return list;
    }

    @Override
    public rol list(int id) {
        String sql="select * from rol where id_rol="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdrol(rs.getInt("id_rol"));
                r.setRol(rs.getString("rol"));
                
            }
        }catch(Exception e){
        }
        return r;
    }

    @Override
    public boolean add(rol rol) {
        String sql ="insert into rol (rol) values('"+rol.getRol()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean edit(rol rol) {
        String sql = "update rol set rol='"+rol.getRol()+"'where id_rol="+rol.getIdrol();
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }

    @Override
    public boolean eliminat(int id) {
        String sql="delete from rol where id_rol ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
        }
    
    
    public String listarRolSelect() {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select id_rol, rol ");
        query.append(" from rol ");
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
