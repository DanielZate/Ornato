<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("vendedor") != null) {
%>
<%@page import="Model.detalle"%>
<%@page import="Model.detalle"%>
<%@page import="ModeloDao.detalleDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.proyecto"%>
<%@page import="java.util.List"%>
<%@page import="Procedure.proyectoProcedure"%>
<!DOCTYPE html>
<html lang="en">
   <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <title>Proyectos</title>
</head>
        <!-- App favicon -->

        <!-- plugins -->
        <link href="./css/flatpickr.css" rel="stylesheet" type="text/css" />

        <!-- App css -->
        <link href="./css/bootstrapIndex.css" rel="stylesheet" type="text/css" />
        <link href="./css/icons.min.css" rel="stylesheet" type="text/css" />
        <link href="./css/app.min.css" rel="stylesheet" type="text/css" />
        <link href="./css/font-awesome.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">


    </head>

    <body class="left-side-menu-dark">
        <!-- Begin page -->
        <div id="wrapper">

            <!-- Topbar Start -->
            <div class="navbar navbar-expand flex-column flex-md-row navbar-custom">
                <div class="container-fluid">
                    <!-- LOGO -->
                    <a href="./index.html" class="navbar-brand mr-0 mr-md-2 logo">
                        <span class="logo-lg">
                            <img src="./images/Imagen2.png" alt="" height="30" />
 
                    </a>

                        <li class="dropdown notification-list align-self-center profile-dropdown">
                            <a class="nav-link dropdown-toggle nav-user mr-0" data-toggle="dropdown" href="#" role="button"
                                aria-haspopup="false" aria-expanded="false">
                                <div class="media user-profile ">
                                    <img src="" alt="user-image" class="rounded-circle align-self-center" />
                                    <div class="media-body text-left">
                                        <h6 class="pro-user-name ml-2 my-0">
                                            <span class="pro-user-desc text-muted d-block mt-1">Administrator </span>
                                        </h6>
                                    </div>
                                    <span data-feather="chevron-down" class="ml-2 align-self-center"></span>
                                </div>
                            </a>
                           
                                </a>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- end Topbar -->

            <!-- ========== Left Sidebar Start ========== -->
            <div class="left-side-menu">
                <div class="media user-profile mt-2 mb-2">
                    <img src="./images/icono.png" class="avatar-sm rounded-circle mr-2" alt="Shreyu" />
                    <img src="./images/users/avatar-7.jpg" class="avatar-xs rounded-circle mr-2" alt="Shreyu" />

                    <div class="media-body">
                        <h6 class="pro-user-name mt-0 mb-0"></h6>
                        <span class="pro-user-desc">Empleado</span>
                    </div>
                    <div class="dropdown align-self-center profile-dropdown-menu">
                        <a class="dropdown-toggle mr-0" data-toggle="dropdown" href="#" role="button" aria-haspopup="false"
                            aria-expanded="false">
                            <span data-feather="chevron-down"></span>
                        </a>
                        <div class="dropdown-menu profile-dropdown">
                            <a href="" class="dropdown-item notify-item">
                                <i data-feather="user" class="icon-dual icon-xs mr-2"></i>
                                <span>Mi Cuenta</span>
                            </a>

                            <a href="javascript:void(0);" class="dropdown-item notify-item">
                                <i data-feather="settings" class="icon-dual icon-xs mr-2"></i>
                                <span>Recuperar contrase??a</span>
                            </a>

                            <div class="dropdown-divider"></div>

                            <a href="./srvUsuario?accion=volver" class="dropdown-item notify-item">
                                <i data-feather="log-out" class="icon-dual icon-xs mr-2"></i>
                                <span>Cerrar sesion</span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="sidebar-content">
                    <!--- Sidemenu -->
                    <div id="sidebar-menu" class="slimscroll-menu">
                        <ul class="metismenu" id="menu-bar">
                 

                            <li>

                            </li>




                            <li class="menu-title">OPCIONES</li>
                            <li>
                                <a href="" aria-expanded="false">
                                    <i data-feather="file-text"></i>
                                    <span> Proyectos </span>

                                </a>
                            </li>
                            <li>
                                <a href="./ControllerDetalle?accion=listarE" aria-expanded="false">
                                    <i data-feather="file-text"></i>
                                    <span> Productos </span>

                                </a>
                            </li>

                            <li>
                                <a href="ControllerPeticionEmpleado?menu=peticion&accion=default" aria-expanded="false">
                                    <i data-feather="file-text"></i>
                                    <span> Peticiones </span>

                                </a>
                            </li>


           

                          
                        </ul>
                    </div>
                    <!-- End Sidebar -->

                    <div class="clearfix"></div>
                </div>
                <!-- Sidebar -left -->

                <!-- Sidebar -left -->

            </div>
            <!-- Left Sidebar End -->
 
            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">

   <center><h1>Detalles del proyecto</h1></center> 
    <form action="ControllerDetalle"> 
        <a href="javascript: history.go(-1)" class="btn btn-secondary">Volver</a>
            <table class="table table-responsive">
        <tr>
            <th>#</th>
            <th>Producto</th>
            <th>Alto</th>
            <th>Ancho</th>
            <th>Profundidad</th>         
            <th>Cantidad</th>            
            <th>Observacion</th>
            <th>Precio</th>

        </tr>
            </thead>

          <%
              
            detalleDAO dao=new detalleDAO();
            int id=Integer.parseInt((String)request.getAttribute("idPro"));
          
            List<detalle> list=dao.listar(id);

            Iterator<detalle>iter=list.iterator();
            detalle u = null;
            while(iter.hasNext()){
                u=iter.next();

            %>          
       
 
           <tbody>
           
           <td><%= u.getIdDetalle() %></td>
           <td><%= u.getNombreProducto()%></td>
           <td><%= u.getAlto()%></td>
           <td><%= u.getAncho()%></td>
           <td><%= u.getProfundidad()%></td>
           <td><%= u.getCantidad()%></td>
           <td><%= u.getObservacion()%></td>
           <td><%= u.getPrecioDetalle()%></td>

              

                   
                </tr>            
                <%
                    }

                %>
            </tbody>
      </table>
</div>
       <!-- Right bar overlay-->
       <div class="rightbar-overlay"></div>

       <!-- Vendor js -->
       <script src="./js/vendor.min.js"></script>

       <!-- optional plugins -->
       <script src="./js/moment.min.js"></script>
       <script src="./js/apexcharts.min.js"></script>
       <script src="./js/flatpickr.min.js"></script>

       <!-- page js -->
       <script src="./js/dashboard.init.js"></script>

       <!-- App js -->
       <script src="./js/app.min.js"></script>


</body>
</html>
<%        
    } else {
        response.sendRedirect("./index.html");
    }
%>
