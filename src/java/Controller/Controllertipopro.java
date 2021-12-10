/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.tipoproducto;
import ModeloDao.tipoproductoDAO;
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
 * @author user
 */
@WebServlet(name = "Controllertipopro", urlPatterns = {"/Controllertipopro"})
public class Controllertipopro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controllertipopro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controllertipopro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    String listar="vistas/listartipopro.jsp";
    String editar="vistas/editartipopro.jsp";
    String add="vistas/addtipopro.jsp";
    tipoproducto tp=new tipoproducto();
    tipoproductoDAO dao = new tipoproductoDAO();

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
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("listar")){
        acceso=listar;
        }else if (accion.equalsIgnoreCase("add")){
        acceso=add;
        }else if (accion.equalsIgnoreCase("agregar")){
        String tipopro=request.getParameter("tipopro");
        tp.setTipoproducto(tipopro);
        dao.add(tp);
        acceso=listar;
        }else if (accion.equalsIgnoreCase("editar")){
            request.setAttribute("idtipopro", request.getParameter("id"));
        acceso=editar;
        }else if(accion.equalsIgnoreCase("actualizar")){
        int id =Integer.parseInt(request.getParameter("idtipopro"));
        String tipopro=request.getParameter("tipopro");
        tp.setIdtipoproducto(id);
        tp.setTipoproducto(tipopro);
        dao.edit(tp);
        acceso=listar;
        }else if(accion.equalsIgnoreCase("eliminar")){
        int id=Integer.parseInt(request.getParameter("id"));
        tp.setIdtipoproducto(id);
        dao.eliminat(id);
        acceso = listar;
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
