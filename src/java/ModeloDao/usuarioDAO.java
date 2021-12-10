package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDusuarios;
import Model.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class usuarioDAO implements CRUDusuarios  {
   Conexion cn=new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   usuario r=new usuario();
int re;
    @Override
    public List listar() {
ArrayList<usuario> list=new ArrayList<>();
        String sql="SELECT id_usuario, rol, password, correo_usuario, nombre_usuario, apellido_usuario, tipo_doc_usuario, num_doc_usuario, telefono_usuario from  usuario   usuario inner join rol on usuario.id_rol_fk = rol.id_rol;";
        try{         
            

            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                usuario usuario=new usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomRol(rs.getString("rol"));
                usuario.setPassword(rs.getString("password"));
                usuario.setCorreoUsuario(rs.getString("correo_usuario"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setApellidoUsuario(rs.getString("apellido_usuario"));
                usuario.setTipoDocUsuario(rs.getString("tipo_doc_usuario"));
                usuario.setNumDocUsuario(rs.getInt("num_doc_usuario"));
                usuario.setTelefonoUsuario(rs.getInt("telefono_usuario"));
                
                list.add(usuario);
                
               
            }
        }
        catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        
        return list;    
    }

    
    @Override
    public usuario list(int id) {
        String sql="SELECT id_usuario, id_rol_fk, rol, password, correo_usuario, nombre_usuario, apellido_usuario, tipo_doc_usuario, num_doc_usuario, telefono_usuario from  usuario   usuario inner join rol on usuario.id_rol_fk = rol.id_rol where id_usuario="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdUsuario(rs.getInt("id_usuario"));
                r.setIdRolFk(rs.getInt("id_rol_fk"));
                r.setNomRol(rs.getString("rol"));
                r.setPassword(rs.getString("password"));
                r.setCorreoUsuario(rs.getString("correo_usuario"));
                r.setNombreUsuario(rs.getString("nombre_usuario"));
                r.setApellidoUsuario(rs.getString("apellido_usuario"));
                r.setTipoDocUsuario(rs.getString("tipo_doc_usuario"));
                r.setNumDocUsuario(rs.getInt("num_doc_usuario"));
                r.setTelefonoUsuario(rs.getInt("telefono_usuario"));

                
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return r;    
    }

        public usuario duplicidad(String correo) {
        String sql="SELECT COUNT(id_usuario) as usuarios from usuario where correo_usuario="+correo;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdUsuario(rs.getInt("usuarios"));                
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return r;    
    }
         public int registrarusuario(usuario u){
               String sql="insert into usuario (id_rol_fk,nombre_usuario,apellido_usuario,correo_usuario,password,tipo_doc_usuario,num_doc_usuario,telefono_usuario) values (?,?,?,?,?,?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, u.getIdRolFk());
            ps.setString(2, u.getNombreUsuario());
            ps.setString(3, u.getApellidoUsuario());
            ps.setString(4, u.getCorreoUsuario());
            ps.setString(5, u.getPassword());
            ps.setString(6,u.getTipoDocUsuario());
            ps.setInt(7, u.getNumDocUsuario());
            ps.setInt(8, u.getTelefonoUsuario());
            ps.executeUpdate();
        }catch(Exception e){}
        return re;

    }
         
    @Override
    public boolean add(usuario usuario) {
String sql="insert into usuario (id_rol_fk, password, correo_usuario, nombre_usuario, apellido_usuario, tipo_doc_usuario, num_doc_usuario,telefono_usuario ) values('"+usuario.getIdRolFk()+"','"+usuario.getPassword()+"','"+usuario.getCorreoUsuario()+"','"+usuario.getNombreUsuario()+"','"+usuario.getApellidoUsuario()+"','"+usuario.getTipoDocUsuario()+"','"+usuario.getNumDocUsuario()+"','"+usuario.getTelefonoUsuario()+"')";
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
    public boolean edit(usuario usuario) {
        String sql = "update usuario set id_rol_fk='"+usuario.getIdRolFk()+"',password='"+usuario.getPassword()+"',correo_usuario='"+usuario.getCorreoUsuario()+"',nombre_usuario='"+usuario.getNombreUsuario()+"',apellido_usuario='"+usuario.getApellidoUsuario()+"',tipo_doc_usuario='"+usuario.getTipoDocUsuario()+"',num_doc_usuario='"+usuario.getNumDocUsuario()+"',telefono_usuario='"+usuario.getTelefonoUsuario()+"'where id_usuario="+usuario.getIdUsuario();
        try{
        con = cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return false;

    }

    @Override
    public boolean eliminat(int id) {
String sql="delete from usuario where id_usuario ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
                System.out.println("Error " + e.getMessage());

        }
        return false;
       
    }
   
      public usuario identificar(String correo, String contraseña) {
        usuario usu = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.id_usuario, C.rol FROM USUARIO U \n" +
                    "INNER JOIN rol C ON U.id_rol_fk = C.id_rol\n" +
                    "WHERE U.correo_usuario  = '" + correo+ "'\n" +
                        "AND U.password = '"+ contraseña+"'";
        con = new Conexion();
        try{
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next() == true){
                usu = new usuario();
                usu.setIdUsuario(rs.getInt("id_usuario"));
                usu.setNomRol(rs.getString("rol"));
            }
        }catch(SQLException e){
            System.out.println("Error" + e.getMessage());
        }finally{
           
        }
        return usu;
    }

}
