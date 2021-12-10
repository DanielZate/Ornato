
package Controller;

import Model.usuario;
import ModeloDao.usuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */

@WebServlet(name = "srvUsuario", urlPatterns = {"/srvUsuario"})
public class srvUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    usuario u=new usuario();

String index = "index.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String acceso="";
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {
                    case "verificar":
                        System.out.println("entro");
                        verificar(request, response);
                        break;
                    case "cerrar":
                        response.sendRedirect("login.jsp");
                        cerrarsession(request, response);
                    break; 
                    default:
                        response.sendRedirect("login.jsp");
                           cerrarsession(request, response);
                }
          
            }
        } catch (Exception e) {
            try {
                System.out.println("Error");
                request.setAttribute("msje", "Credenciales Incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);

            } catch (Exception ex) {
                System.out.println("Error" + e.getMessage());
            }
        }

    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("volver")){
            
            acceso=index;
             
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);     
    
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    private void verificar(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession sesion;
        usuarioDAO dao;
        usuario usuario;
        
                String correo = request.getParameter("txtUsu");
                String contraseña = request.getParameter("txtPass");
                
        
        dao = new usuarioDAO();

        System.out.println("hola");
                 
         u=dao.identificar(correo, contraseña);
         System.out.println(u.getIdUsuario());
          System.out.println(u.getNomRol());
 
       
     if (u !=null && "Gerente".equals(u.getNomRol()) ) {
            sesion = request.getSession();
            sesion.setAttribute("usuario", u);
            request.setAttribute("msje", "Bienvenido al sistema");
           
           System.out.println("Hola admin");
      this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/principal.jsp").forward(request, response); 
            
        }else if(u !=null && "Empleado".equals(u.getNomRol()) ){
           sesion = request.getSession();
            sesion.setAttribute("vendedor", u);
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/empleado/ProyectosCotizacion.jsp").forward(request, response); 
        }else if(u !=null && "Cliente".equals(u.getNomRol()) ){
           sesion = request.getSession();
            sesion.setAttribute("cliente", u);
            this.getServletConfig().getServletContext().getRequestDispatcher("/vistas/cliente/proyectos.jsp").forward(request, response); 
        }
        else{
            request.setAttribute("msje", "Credenciales Incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
  
    }

    private void cerrarsession(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("login.jsp");
        
    }


}
