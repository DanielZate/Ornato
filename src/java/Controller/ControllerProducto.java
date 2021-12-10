/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.producto;
import ModeloDao.productoDAO;
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
@WebServlet(name = "ControllerProducto", urlPatterns = {"/ControllerProducto"})
public class ControllerProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        String listar="vistas/producto.jsp";    
        String add="vistas/addProducto.jsp";
        String edit="vistas/editProducto.jsp";
    producto u=new producto();
    productoDAO dao=new productoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerProducto at " + request.getContextPath() + "</h1>");
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
        else if(action.equalsIgnoreCase("Agregar")){
            int idProducto=Integer.parseInt(request.getParameter("Producto"));
            String nombre=request.getParameter("Nombre");
           
                      
            u.setIdTipoProducto(idProducto);
            u.setNombreProducto(nombre);

            dao.add(u);
            acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar")){
           int id=Integer.parseInt(request.getParameter("id"));
           u.setIdProducto(id);
           dao.eliminat(id);
            
            acceso=listar;
           } 
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idPro", request.getParameter("id"));
        acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            int id=Integer.parseInt(request.getParameter("txtid"));
            int idProducto=Integer.parseInt(request.getParameter("Producto"));
            String nombre=request.getParameter("Nombre");
            
            u.setIdProducto(id);
            u.setIdTipoProducto(idProducto);
            u.setNombreProducto(nombre);
            dao.edit(u);
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
