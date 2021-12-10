/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;
import Model.material;
import Model.producto;
import Model.proyecto;
import ModeloDao.materialDAO;
import ModeloDao.productoDAO;
import ModeloDao.proyectoDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author User
 */
@WebServlet(name = "ControllerPeticionEmpleado", urlPatterns = {"/ControllerPeticionEmpleado"})
public class ControllerPeticionEmpleado extends HttpServlet {
     material m = new material();
    materialDAO daom = new materialDAO();
    producto p = new producto();
    productoDAO daop = new productoDAO();
    proyecto pro = new proyecto();
    proyectoDAO prodao = new proyectoDAO();
    List<proyecto>lista=new ArrayList<>();
    int item;
    int codigo;
    String producto;
    String material;
    float alto;
    float ancho;
    float profundidad;
    float preciodetalle;
    int cantidad;
    String observacion; 
    float subtotal;
    SimpleDateFormat sdf= new SimpleDateFormat("YYYY/MM/dd");
    Date fecha = new Date();
    String fechaActual= sdf.format(fecha);

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
       
            String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
if(menu.equals("peticion")){
            switch(accion){
                case "buscarmaterial":
                int id=Integer.parseInt(request.getParameter("idmaterial"));
                m.setIdMaterial(id);
                m=daom.buscar(id);
                request.setAttribute("producto", p);
                request.setAttribute("subtotal", subtotal);
                request.setAttribute("material", m);
                request.setAttribute("lista", lista);
                break;
                case "buscarproducto":
                    int idpro=Integer.parseInt(request.getParameter("idproducto"));
                    p.setIdProducto(idpro);
                    p=daop.buscar(idpro);
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    break;
               case "agregar":
                   request.setAttribute("producto", p);
                   subtotal=0;
                    item=item+1;
                    codigo=p.getIdProducto();
                    producto = request.getParameter("productos");
                    material = request.getParameter("material");
                    alto= Float.parseFloat(request.getParameter("alto"));
                    ancho= Float.parseFloat(request.getParameter("ancho"));
                    profundidad= Float.parseFloat(request.getParameter("profundidad"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    observacion = request.getParameter("observacion");
                    pro=new proyecto();
                    pro.setItem(item);
                    pro.setIdProducto(codigo);
                    pro.setNombreProducto(producto);
                    pro.setNombrematerial(material);
                    pro.setAlto(alto);
                    pro.setAncho(ancho);
                    pro.setProfundidad(profundidad);
                    pro.setCantidad(cantidad);
                    pro.setObservacion(observacion);
                    lista.add(pro);
                   
                    request.setAttribute("subtotal", subtotal);
                    request.setAttribute("lista", lista);
                    break;   
               case "GenerarPeticion":
                   //Guardar proyecto
                   pro.setEstadoProyecto("Peticion");
                   //pro.setFechaFinalizacion("2021-11-28");
                   pro.setInicio(fechaActual);
                   //pro.setMicroProyecto(true);
                   //pro.setValorProyecto(subtotal);
                   pro.setIdUsuarioFk(2);
                   prodao.guardatPeticion(pro);
                   //Guardar DetalleProyecto
                   int idproy = Integer.parseInt(prodao.idProyecto());
                   for(int i = 0; i< lista.size();i++){
                       pro = new proyecto();
                       pro.setIdProyecto(idproy);
                       pro.setIdProducto(lista.get(i).getIdProducto());
                       pro.setAlto(lista.get(i).getAlto());
                       pro.setAncho(lista.get(i).getAncho());
                       pro.setCantidad(lista.get(i).getCantidad());
                       pro.setObservacion(lista.get(i).getObservacion());
                       pro.setProfundidad(lista.get(i).getProfundidad());
                       prodao.guardarDetalleProyecto(pro);
             
                   }
      
                   break;
            default:
                
            }
                request.getRequestDispatcher("vistas/registrarpeticionEmpleado.jsp").forward(request, response);
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
        processRequest(request, response);
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
