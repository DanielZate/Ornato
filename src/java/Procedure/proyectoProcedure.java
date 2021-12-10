package Procedure;

import Config.Conexion;
import Model.proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class proyectoProcedure {
        Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    proyecto r=new proyecto();


    
    public List listarEjecucion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="CALL  sp_listar_proyectos_en_ejecucion";
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
                proyecto.setEstadoProyecto(rs.getString("estado_proyecto"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
    
     public List listarPeticion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="CALL sp_listar_proyectos_en_peticion";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                proyecto.setNombreUsu(rs.getString("Usuario"));
                proyecto.setMicroProyecto(rs.getBoolean("micro_proyecto"));
                proyecto.setFechaInicio(rs.getDate("fecha_inicio"));
                proyecto.setEstadoProyecto(rs.getString("estado_proyecto"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
     
          public List listarFinalizados() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="CALL spl_listar_proyectos_Finalizado";
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
          
   public List listarCotizacion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="CALL spl_listar_proyectos_cotizacion";
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
                proyecto.setEstadoProyecto(rs.getString("estado_proyecto"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
   
      public List listarRechazados() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="CALL sp_listar_proyectos_rechazados";
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
     
              
              
  public List ContarRechazados() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="SELECT COUNT(id_proyecto) as Rechazado from proyecto WHERE estado_proyecto = \"Rechazado\";";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("Rechazado"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }

  public List ContarCotizacion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="SELECT COUNT(id_proyecto) as Cotizacion from proyecto WHERE estado_proyecto = \"Cotizacion\";";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("Cotizacion"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
  
  public List ContarFinalizados() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="SELECT COUNT(id_proyecto) as Finalizado from proyecto WHERE estado_proyecto = \"Finalizado\";";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("Finalizado"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
  
  public List ContarPeticion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="SELECT COUNT(id_proyecto) as Peticion from proyecto WHERE estado_proyecto = \"Peticion\";";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("Peticion"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
  
    public List ContarEjecucion() {
    ArrayList<proyecto> list=new ArrayList<>();
        String sql="SELECT COUNT(id_proyecto) as Ejecucion from proyecto WHERE estado_proyecto = \"Ejecucion\";";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                proyecto proyecto=new proyecto();
                proyecto.setIdProyecto(rs.getInt("Ejecucion"));
                list.add(proyecto);
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return list;
    }
}
