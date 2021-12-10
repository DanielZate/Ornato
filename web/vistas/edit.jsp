<%-- 
    Document   : edit.jsp
    Created on : 9/11/2021, 03:02:42 PM
    Author     : user
--%>

<%@page import="Model.rol"%>
<%@page import="ModeloDao.rolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        rolDAO dao = new rolDAO();
        int id=Integer.parseInt((String)request.getAttribute("idrol"));
        rol rol=(rol)dao.list(id);
        %>
          <h1>Modificar rol</h1>
        <form action="Controller">
            <label>ROL</label>
            <input type="hidden" name="idrol" value="<%=rol.getIdrol()%>">
            <input type="text" name="rol" value="<%=rol.getRol()%>">
            <input type="submit" name="accion" value="actualizar">
            <a href="Controller?accion=listar">Regresar</a>
        </form>
    </body>
</html>
