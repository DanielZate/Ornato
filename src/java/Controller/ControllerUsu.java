/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.usuario;
import ModeloDao.usuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
@WebServlet(name = "ControllerUsu", urlPatterns = {"/ControllerUsu"})
public class ControllerUsu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    String listar="vistas/usuarios.jsp";
    String add="vistas/addusuario.jsp";
    String edit="vistas/editUsuario.jsp";
    String ingresar="vistas/loginUsu.jsp";
    String menuAdmin= "vistas/principal.jsp";
    String menuEmpleado= "vistas/menuEmpleado.jsp";
    String menuCliente= "vistas/menuUsu.jsp";
    usuario u=new usuario();
    usuarioDAO dao=new usuarioDAO();
    
    static String generaContraseña(){
        char[] mayusculas = {'A','B','C','D','E','F','G'};
        char[] minusculas = {'a','b','c','d','e','f','g'};
        char[] numeros = {'1','2','3','4','5','6','7','8','9','0'};
        
        StringBuilder caracteres = new StringBuilder();
        caracteres.append(mayusculas);
        caracteres.append(minusculas);
        caracteres.append(numeros);
        
        StringBuilder contraseña = new StringBuilder();
        
        for(int i=0; i<=15; i ++){
        int cantidadCaracteres = caracteres.length();
        int numeroRandom =(int)(Math.random()*cantidadCaracteres);
        
        contraseña.append((caracteres.toString()).charAt(numeroRandom));
        }
        
        return contraseña.toString();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }else if(action.equalsIgnoreCase("crearNuevo")){
            acceso=ingresar;
        }else if(action.equalsIgnoreCase("menuAdmin")){
            acceso=menuAdmin;
        }
        else if(action.equalsIgnoreCase("menuEmpleado")){
            acceso=menuEmpleado;
        }
        else if(action.equalsIgnoreCase("menuUsu")){
            acceso=menuCliente;
        }
        
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idPro", request.getParameter("id"));
        acceso=edit;
            
      
        
          


          
        }   else if(action.equalsIgnoreCase("Agregar")){
            
            
            int idRol=Integer.parseInt(request.getParameter("rol"));
            String password=(generaContraseña());
            String correo=request.getParameter("correo");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String tipodoc=request.getParameter("tipodoc");
            String numdoc=request.getParameter("numdoc");
            String telefono=request.getParameter("telefono");
            
            
                      
            String hola = "'"+correo+"'";
            
            String tipo = tipodoc;
            
            System.out.println(hola);
            
       System.out.println(tipo);
          usuario p=(usuario)dao.duplicidad(hola);
            
          p.getIdUsuario();
          
          System.out.println( p.getIdUsuario());
            
            
          if(p.getIdUsuario()>=1){
              JOptionPane.showMessageDialog(null, "Este correo ya esta en uso");
               acceso=add;
                       
          }else{
              
            u.setIdRolFk(idRol);
            u.setPassword(password);
            u.setCorreoUsuario(correo);
            u.setNombreUsuario(nombre);
            u.setApellidoUsuario(apellido);
            u.setTipoDocUsuario(tipodoc);
            u.setNumDocUsuario(numdoc);
            u.setTelefonoUsuario(telefono);
            dao.add(u);
            acceso=listar;
            //enviaar correo
           Properties propiedad =new Properties();
           propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
           propiedad.setProperty("mail.smtp.starttls.enable", "true");
           propiedad.setProperty("mail.smtp.port", "587");
           propiedad.setProperty("mail.smtp.auth", "true");
           
           Session sesion = Session.getDefaultInstance(propiedad);
           String correoEnvia="ornato2021@gmail.com";
           String contrasena="ornatosena2021";
           String destinatario = request.getParameter("correo");
           String asunto = "Registro en Ornato";
           String mensaje="Ud ha sido registrad@ en Ornato con el rol de empleado y su contraseña es " +password;
           
           MimeMessage mail = new MimeMessage(sesion);
           
           try {
               mail.setFrom(new InternetAddress(correoEnvia));
               mail.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
               mail.setSubject(asunto);
               mail.setText(mensaje);
               
               Transport transporte = sesion.getTransport("smtp");
               transporte.connect(correoEnvia,contrasena);
               transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
               transporte.close();
               
               
           } catch (AddressException ex) {
               Logger.getLogger(ControllerUsu.class.getName()).log(Level.SEVERE, null, ex);
           } catch (MessagingException ex) {
               Logger.getLogger(ControllerUsu.class.getName()).log(Level.SEVERE, null, ex);
           }
    
        }
    }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id=Integer.parseInt(request.getParameter("idUsu"));
           int idRol=Integer.parseInt(request.getParameter("rol"));
            String password=request.getParameter("password");
            String correo=request.getParameter("correo");
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String tipodoc=request.getParameter("tipodoc");
            String numdoc=request.getParameter("numdoc");
            String telefono=request.getParameter("telefono");
            
            u.setIdUsuario(id);
            u.setIdRolFk(idRol);
            u.setPassword(password);
            u.setCorreoUsuario(correo);
            u.setNombreUsuario(nombre);
            u.setApellidoUsuario(apellido);
            u.setTipoDocUsuario(tipodoc);
            u.setNumDocUsuario(numdoc);
            u.setTelefonoUsuario(telefono);
            dao.edit(u);
            acceso=listar;
            
            
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            u.setIdUsuario(id);
            dao.eliminat(id);
            
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("ingresar")){
                String correo = request.getParameter("email");
                String contraseña = request.getParameter("pass");
                 String apellido=request.getParameter("apellido");
                
                System.out.println(correo);                     
                System.out.println(contraseña);
  System.out.println(apellido);
                
            
            }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                     throws ServletException, IOException {
        String acceso="";
        String accion=request.getParameter("accion");
        
        
        

        
         //registrar usuario
       if(accion.equalsIgnoreCase("Enviar")){
           String nombre1=request.getParameter("nombre");
           String apellido1=request.getParameter("apellido");
           String correo1=request.getParameter("correo");
           String contraseña1=request.getParameter("password");
           String tipodoc1=request.getParameter("tipodoc");
           String numdoc1=request.getParameter("numdoc");
           String telefono1=request.getParameter("telefono");
           
           
           
            String hola = "'"+correo1+"'";
          
            
          usuario p=(usuario)dao.duplicidad(hola);
            
          p.getIdUsuario();
          
          System.out.println( p.getIdUsuario());
            
            
          if(p.getIdUsuario()>=1){
              JOptionPane.showMessageDialog(null, "Este correo ya esta en uso");
               acceso=ingresar;
               
          }else{
          
           u.setIdRolFk(3);
           u.setNombreUsuario(nombre1);
           u.setApellidoUsuario(apellido1);
           u.setCorreoUsuario(correo1);
           u.setPassword(contraseña1);
           u.setTipoDocUsuario(tipodoc1);
           u.setNumDocUsuario(numdoc1);
           u.setTelefonoUsuario(telefono1);
           dao.registrarusuario(u);
            System.out.println("usuario registrado");
           request.getRequestDispatcher("index.html").forward(request, response);
           
                        Properties propiedad =new Properties();
           propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
           propiedad.setProperty("mail.smtp.starttls.enable", "true");
           propiedad.setProperty("mail.smtp.port", "587");
           propiedad.setProperty("mail.smtp.auth", "true");
           
           Session sesion = Session.getDefaultInstance(propiedad);
           String correoEnvia="ornato2021@gmail.com";
           String contrasena="ornatosena2021";
           String destinatario = request.getParameter("correo");
           String asunto = "Registro en Ornato";
           String mensaje="Usted ha sido registrado en Ornato exitosamente";
           
           MimeMessage mail = new MimeMessage(sesion);
           
           try {
               mail.setFrom(new InternetAddress(correoEnvia));
               mail.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
               mail.setSubject(asunto);
               mail.setText(mensaje);
               
               Transport transporte = sesion.getTransport("smtp");
               transporte.connect(correoEnvia,contrasena);
               transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
               transporte.close();
               
               
           } catch (AddressException ex) {
               Logger.getLogger(ControllerUsu.class.getName()).log(Level.SEVERE, null, ex);
           } catch (MessagingException ex) {
               Logger.getLogger(ControllerUsu.class.getName()).log(Level.SEVERE, null, ex);
           }
          
          }
          }  else if(accion.equalsIgnoreCase("volver"))    {
              acceso=ingresar;
          }
              RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
