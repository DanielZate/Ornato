/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.medio;
import ModeloDao.medioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author User
 */
@MultipartConfig
@WebServlet(name = "ControllerMedio", urlPatterns = {"/ControllerMedio"})
public class ControllerMedio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * 
     */
    
        String listar="vistas/proyecto.jsp";
    String add="vistas/addmedio.jsp";
    String edit="vistas/editMedio.jsp";
    medio u=new medio();
    medioDAO dao=new medioDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerMedio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerMedio at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }      

           
              else if(action.equalsIgnoreCase("AgregarMedio")){
                  
        request.setAttribute("idPro", request.getParameter("id"));
        acceso=add;
        } 
        
        else if(action.equalsIgnoreCase("eliminar")){
           int id=Integer.parseInt(request.getParameter("id"));
           u.setIdProyecto(id);
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
        String acceso="";
        String action=request.getParameter("accion");
    if(action.equalsIgnoreCase("Agregar")){
            

            int idProyecto=Integer.parseInt(request.getParameter("proyecto"));
            String url=request.getParameter("url");
            	
		    Part archivo = request.getPart("foto");
		    InputStream inputStream = archivo.getInputStream();
	
            
             int id=Integer.parseInt(request.getParameter("idtext"));
        
             String idString = String.valueOf(id);

                                    System.out.println(inputStream);

            
            if(id == 0 ){
                                    
                
                 System.out.println("Registrar");
            
            u.setIdProyecto(idProyecto);
            u.setUrl(url);
            u.setFoto(inputStream);
            dao.add(u);
            
            acceso=listar;
                
            
            }else{


             System.out.println("actualizar");
                
           
           System.out.println(id);
            System.out.println(idProyecto);
            System.out.println(url);
                        
            
            u.setIdmedio(id);
            u.setIdProyecto(idProyecto);
            u.setUrl(url);


            dao.edit(u);
            acceso=listar; 
            
            }
            

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
