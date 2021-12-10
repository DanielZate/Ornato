/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.detalle;
import ModeloDao.detalleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ControllerDetalle", urlPatterns = {"/ControllerDetalle"})
public class ControllerDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String verDetalle="vistas/detallesPro.jsp";
    String verDetalleE="vistas/empleado/detallesProyectosE.jsp";
    String listar="vistas/proyecto.jsp"; 
    String listarU="vistas/cliente/proyectos.jsp"; 
    String listarE="vistas/empleado/productos.jsp"; 
    String edit="vistas/editDetalle.jsp";
    detalle d=new detalle();
    detalleDAO dao=new detalleDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerDetalle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDetalle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        if(action.equalsIgnoreCase("verDetalles")){
            request.setAttribute("idPro", request.getParameter("id"));
            acceso=verDetalle;
            
        }
        else if(action.equalsIgnoreCase("listarU")){
            acceso=listarU;
            
                }else if(action.equalsIgnoreCase("listarE")){
            acceso=listarE;
                
                }
        
        else if(action.equalsIgnoreCase("verDetallesE")){
            request.setAttribute("idPro", request.getParameter("id"));
            acceso=verDetalleE;
            
                }else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            d.setIdDetalle(id);
            dao.eliminat(id);
            
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("editar")){            
            request.setAttribute("idDe", request.getParameter("id"));
        acceso=edit;
        }
        
        else if(action.equalsIgnoreCase("Actualizar")){            
            
                int id=Integer.parseInt(request.getParameter("idDe"));
                int alto =Integer.parseInt(request.getParameter ("Alto"));
                int ancho=Integer.parseInt(request.getParameter("Ancho"));
                int profundidad=Integer.parseInt(request.getParameter("Profundidad"));
                int cantidad=Integer.parseInt(request.getParameter("Cantidad"));
                String observacion=request.getParameter("observacion");
                int precio=Integer.parseInt(request.getParameter("Precio"));
            
                
                
                
                d.setIdDetalle(id);
                d.setAlto(alto);
                d.setAncho(ancho);
                d.setProfundidad(profundidad);
                d.setCantidad(cantidad);
                d.setObservacion(observacion);
                d.setPrecioDetalle(precio);
                
               dao.edit(d);
               
               acceso=listar;
                
            }
   
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);     
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("verDetallesE")){
            request.setAttribute("idPro", request.getParameter("id"));
            acceso=verDetalleE;
            
                
            }
   
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);     
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

}
