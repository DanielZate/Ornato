/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUDmedio;
import Model.medio;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class medioDAO implements CRUDmedio {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    medio r=new medio();
    
    @Override
    public List listar() {
        ArrayList<medio> list=new ArrayList<>();
        String sql="SELECT IdMedio, url, fecha_finalizacion from medio\n" +
"inner join proyecto on medio.IdProyectoFk = proyecto.id_proyecto";
        try{         
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                medio medio=new medio();
                medio.setIdmedio(rs.getInt("IdMedio"));
                medio.setFecha(rs.getDate("fecha_finalizacion"));
                medio.setUrl(rs.getString("url"));

                list.add(medio);
                
         
            }
        }
        catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        
        return list;    
    }

    @Override
    public medio list(int id) {
        String sql="SELECT IdMedio,  url, IdProyectoFk from medio\n" +
"inner join proyecto on medio.IdProyectoFk = proyecto.id_proyecto where id_proyecto="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdmedio(rs.getInt("IdMedio"));
                r.setIdProyecto(rs.getInt("IdProyectoFk"));
                r.setUrl(rs.getString("url"));
                
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return r;    
    }
    

    @Override
    public boolean add(medio medio) {
        String sql="insert into medio (IdProyectoFk , url, foto) values(?,?,?)";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
                ps.setInt(1, medio.getIdProyecto());
                ps.setString(2, medio.getUrl());
                ps.setBlob(3, medio.getFoto());
                
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
  
        }
        return false;   
    }

    @Override
    public boolean edit(medio medio) {
                String sql = "update medio set IdProyectoFk="+medio.getIdProyecto()+",url='"+medio.getUrl()+"' where IdMedio="+medio.getIdmedio()+"";
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
 String sql="delete from medio where IdMedio ="+id;
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return false;
        }    
    
    
        public medio listarRegistrar(int id) {
        String sql="SELECT id_proyecto from proyecto where id_proyecto="+id;
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                r.setIdProyecto(rs.getInt("id_proyecto"));
                
            }
        }catch(Exception e){
                        System.out.println("Error " + e.getMessage());

        }
        return r;    
    }
 
    public void listarImagen(int id, HttpServletResponse response) throws IOException {
			
			String sql = "SELECT * FROM medio where IdMedio="+id;
			InputStream inputStream=null;
			OutputStream outputStream=null;
			BufferedInputStream bufferedInputStream=null;
			BufferedOutputStream bufferedOutputStream=null;
			response.setContentType("image/*");
			
			try {    
        outputStream=response.getOutputStream();
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery();
        if(rs.next()) {
            inputStream=rs.getBinaryStream("Foto");
		      }
		bufferedInputStream=new BufferedInputStream(inputStream);
		bufferedOutputStream=new BufferedOutputStream(outputStream);				
		int i=0;
        while((i=bufferedInputStream.read())!=-1) {
	bufferedOutputStream.write(i);
	}
	}catch(Exception e) {
				
        }
	}
}
