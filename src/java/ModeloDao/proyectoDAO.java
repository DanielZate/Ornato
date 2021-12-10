
package ModeloDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Config.Conexion;
import Interfaces.CRUD;
import Model.proyecto;
import java.sql.CallableStatement;
import java.sql.SQLException;


public class proyectoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    proyecto r=new proyecto();
int re;

    
    public List listar() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="select proyecto.id_proyecto, CONCAT(usuario.nombre_usuario,   usuario.apellido_usuario) as Usuario,  \n" +
"proyecto.estado_proyecto, proyecto.fecha_inicio, proyecto.fecha_finalizacion,\n" +
"proyecto.micro_proyecto,proyecto.valor_proyecto from proyecto \n" +
"INNER JOIN usuario on proyecto.id_usuario_fk = usuario.id_usuario";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombreUsu(rs.getString("Usuario"));
                proyecto.setMicroProyecto(rs.getBoolean("micro_proyecto"));
                proyecto.setValorProyecto(rs.getInt("valor_proyecto"));
                proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
                proyecto.setFechaFinalizacion(rs.getDate("fecha_finalizacion"));
                proyecto.setEstadoProyecto(rs.getString("estado_proyecto"));
                list.add(proyecto);
            }
        }catch(Exception e){
             System.out.println("Error " + e.getMessage());
        }
        return list;
    }

    
    public proyecto list(int id) {
        String sql="select id_proyecto, fecha_inicio, fecha_finalizacion, micro_proyecto, valor_proyecto, estado_proyecto from proyecto WHERE id_proyecto ="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdProyecto(rs.getInt("id_proyecto"));
                r.setMicroProyecto(rs.getBoolean("micro_proyecto"));
                r.setValorProyecto(rs.getInt("valor_proyecto"));
                r.setFechaInicio(rs.getDate("fecha_inicio"));
                r.setFechaFinalizacion(rs.getDate("fecha_finalizacion"));
                r.setEstadoProyecto(rs.getString("estado_proyecto"));
                
            }
        }catch(Exception e){
        }
        return r;
    }
   
    
    public boolean add(proyecto proyecto) {
        String sql ="insert into proyecto (proyecto) values('"+proyecto.getIdUsuarioFk()+"','"+proyecto.getMicroProyecto()+"','"+proyecto.getValorProyecto()+"'"
                + ",'"+proyecto.getFechaInicio()+"','"+proyecto.getFechaFinalizacion()+"','"+proyecto.getEstadoProyecto()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
        }
        return false;
    }
    
    
    public boolean edit(proyecto proyecto) {
        String sql = "update proyecto set id_proyecto='"+proyecto.getIdProyecto()+"',fecha_inicio='"+proyecto.getInicio()+"',fecha_finalizacion='"+proyecto.getFinalizacion()+"',micro_proyecto='"+proyecto.getMicroString()+"',valor_proyecto='"+proyecto.getValorProyecto()+"',estado_proyecto='"+proyecto.getEstadoProyecto()+"'where id_proyecto="+proyecto.getIdProyecto();
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        
    }
    
        public boolean editsinFecha(proyecto proyecto) {
        String sql = "update proyecto set id_proyecto='"+proyecto.getIdProyecto()+"',fecha_inicio='"+proyecto.getInicio()+"',micro_proyecto='"+proyecto.getMicroString()+"',valor_proyecto='"+proyecto.getValorProyecto()+"',estado_proyecto='"+proyecto.getEstadoProyecto()+"'where id_proyecto="+proyecto.getIdProyecto();
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        
    }
    
            
    public boolean eliminat(int id) {
        String sql="delete from proyecto where id_proyecto ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        }
    
    
    public List procedimiento(){
        
        try{
          con=cn.getConnection();
          
          CallableStatement misentencia=con.prepareCall("{sp_listar_proyectos_en_ejecucion}");
          
          ResultSet rs=misentencia.executeQuery();
          
          while(rs.next()){
              
              System.out.println(rs.getInt(1)+ "" + rs.getInt(2)+ "" + rs.getBoolean(3));
          }
          
          rs.close();
            
        }catch(Exception e){
        
        }
        return null;
   
    }
    
                public String listarProyectoSelect() {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select id_proyecto, fecha_finalizacion ");
        query.append(" from proyecto ");
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(query.toString());
            rs=ps.executeQuery();
            while(rs.next()){
                salidaTabla.append(" <option value= '");
                salidaTabla.append(rs.getInt(1));
                salidaTabla.append("'>");
                salidaTabla.append(rs.getDate(2));
                salidaTabla.append("</option>");
            }
        }catch(SQLException e){
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
      return salidaTabla.toString();
    }
    
         public String idProyecto(){
    String idProyecto="";
    String sql = "select max(id_proyecto) from proyecto";
    try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
           while(rs.next()){
           idProyecto=rs.getString(1);
           }
    }catch(Exception e){
    System.out.println("Error idproyecto" + e.getMessage());
    }
    return idProyecto;
    }
    
    public int guardatPeticion(proyecto pro){
        String sql="insert into proyecto (estado_proyecto,id_usuario_fk,fecha_inicio)values (?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getEstadoProyecto());
            ps.setInt(2, pro.getIdUsuarioFk());
            ps.setString(3, pro.getInicio());
            ps.executeUpdate();
        }catch(Exception e){
        System.out.println("Error guardarPeticion" + e.getMessage());
        }
        return re;
    }
    
    public int guardarDetalleProyecto(proyecto proyecto){
        
        String sql="insert into detalleproyecto (alto,ancho,cantidad,id_producto_fk,id_proyecto_fk,observacion,precio_detalle,profundidad)values (?,?,?,?,?,?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setFloat(1,proyecto.getAlto());
            ps.setFloat(2,proyecto.getAlto());
            ps.setInt(3,proyecto.getCantidad());
            ps.setInt(4,proyecto.getIdProducto());
            ps.setInt(5,proyecto.getIdProyecto());
            ps.setString(6,proyecto.getObservacion());
            ps.setFloat(7,proyecto.getPrecioDetalle());
            ps.setFloat(8,proyecto.getProfundidad());
            ps.executeUpdate();
        }catch(Exception e){}
        return re;
    }
}
