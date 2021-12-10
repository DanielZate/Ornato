<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<%@page import="Model.medio"%>
<%@page import="ModeloDao.medioDAO"%>
<%@page import="ModeloDao.proyectoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <center><h1>Agregar Medio</h1></center>  
    <form action="ControllerMedio"> 

       <%
  proyectoDAO dao = new proyectoDAO();

  %>
          <%
            medioDAO dao2=new medioDAO();
            int id=Integer.parseInt((String)request.getAttribute("idMe"));
            medio p=(medio)dao2.list(id);
        %>
  <input type="hidden" name="txtid" value="<%= p.getIdmedio() %>">
  
          <div class="mb-3" id="g-tipodoc">
        <label>Proyecto</label>
        <div id="form-group-input">
            <select name="proyecto">
                <option value="<%= p.getIdProyecto()%>"><%= p.getFecha() %></option>
                <%= dao.listarProyectoSelect() %>

        </select>
    </div>
    </div>
               

        <div class="mb-3" id="g-nombre">
        <label >URL</label>
        <div id="form-group-input">
        <input type="text" name="url" value="<%= p.getUrl() %>">
        </div>
    </div>
    
 
        <br>
        <input type="submit" name="accion" class="btn btn-secondary" value="Actualizar"> 
    </form>
    </body>
</html>
<%        
    } else {
        response.sendRedirect("./index.html");
    }
%>
