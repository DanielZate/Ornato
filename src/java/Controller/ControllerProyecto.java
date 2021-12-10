/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.proyecto;


import java.time.format.DateTimeFormatter;

import ModeloDao.proyectoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ControllerProyecto", urlPatterns = {"/ControllerProyecto"})
public class ControllerProyecto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
   
   String editSinFecha="vistas/editProyectoSinFecha.jsp";
    String listar="vistas/proyecto.jsp";
    String listarEjeucionEmpleado="vistas/empleado/ProyectosEjecucion.jsp";
    String listarCotizacionEmpleado="vistas/empleado/ProyectosCotizacion.jsp";
    String listarEjeucion="vistas/procedimientos/proyectoEjecucion.jsp";
    String listarCotizacion="vistas/procedimientos/proyectoCotizacion.jsp";
    String listarFinalizados="vistas/procedimientos/proyectoFinalizados.jsp";
    String listarPeticion="vistas/procedimientos/proyectoPeticion.jsp";
    String listarRechazados="vistas/procedimientos/proyectoRechazados.jsp";
    String edit="vistas/editProyecto.jsp";
    
    proyecto p=new proyecto();
    proyectoDAO dao=new proyectoDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerProyecto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProyecto at " + request.getContextPath() + "</h1>");
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
            
        }else if(action.equalsIgnoreCase("Ejecucion")){
            acceso=listarEjeucion;
            }
        else if(action.equalsIgnoreCase("Peticiones")){
            acceso=listarPeticion;
            }
        else if(action.equalsIgnoreCase("Rechazados")){
            acceso=listarRechazados;
            }
        else if(action.equalsIgnoreCase("Finalizados")){
            acceso=listarFinalizados;
            }
        else if(action.equalsIgnoreCase("Cotizacion")){
            acceso=listarCotizacion;
            }
        else if(action.equalsIgnoreCase("EjecucionEmpleado")){
            acceso=listarEjeucionEmpleado;
            }
        else if(action.equalsIgnoreCase("CotizacionEmpleado")){
            acceso=listarCotizacionEmpleado;
            }
        else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("idPro", request.getParameter("id"));
        acceso=edit;
        }
                else if (action.equalsIgnoreCase("editarSinFecha")){
            request.setAttribute("idPro", request.getParameter("id"));
        acceso=editSinFecha;
                }
                else if (action.equalsIgnoreCase("Actualizar")){
  
                
       String b2 = null;
       
                int id=Integer.parseInt(request.getParameter("idPro"));
                int valor =Integer.parseInt(request.getParameter ("valor"));
                String estado=request.getParameter("Estado");
                String inicio=request.getParameter("fechaInicio");
                String fechafinal=request.getParameter("fechaFinalizacion");
                
                
                
                Boolean micro=Boolean.valueOf(request.getParameter("micro"));
              
                if(micro==true){
                   b2 = "1";
                    p.setMicroString(b2);
                }else if(micro==false){
                    b2 = "0";
                     p.setMicroString(b2);
                }
                              
                
                System.out.println(b2);
                System.out.println(micro);
     
                         
                p.setIdProyecto(id);
                p.setValorProyecto(valor);
                p.setEstadoProyecto(estado);           
                p.setInicio(inicio);
                p.setFinalizacion(fechafinal);
               
       
                  dao.edit(p);
              
                
                acceso=listar;

           
    
        }        else if (action.equalsIgnoreCase("Actualizar.")){
  
  
       String b2 = null;
       
                int id=Integer.parseInt(request.getParameter("idPro"));
                int valor =Integer.parseInt(request.getParameter ("valor"));
                String estado=request.getParameter("Estado");
                String inicio=request.getParameter("fechaInicio");

                Boolean micro=Boolean.valueOf(request.getParameter("micro"));
              
                if(micro==true){
                   b2 = "1";
                    p.setMicroString(b2);
                }else if(micro==false){
                    b2 = "0";
                     p.setMicroString(b2);
                }
                              
                
                System.out.println(b2);
                System.out.println(micro);
     
                         
                p.setIdProyecto(id);
                p.setValorProyecto(valor);
                p.setEstadoProyecto(estado);           
                p.setInicio(inicio);
               
       
                  dao.editsinFecha(p);
              
                
                acceso=listar;

           
    
        }
        
        
        else if(action.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            p.setIdProyecto(id);
            dao.eliminat(id);
            
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

}
