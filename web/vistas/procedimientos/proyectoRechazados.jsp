<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<%@page import="Procedure.proyectoProcedure"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.proyecto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
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
                        <h6 class="pro-user-name mt-0 mb-0">Daniel Alzate</h6>
                        <span class="pro-user-desc">Administrador</span>
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
                                <span>Recuperar contraseña</span>
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
                            <li class="menu-title">Inicio</li>

                            <li>
                                <a href="ControllerUsu?accion=menuAdmin">
                                    <i data-feather="home"></i>
                                    <span class="badge badge-success float-right"></span>
                                    <span> Inicio </span>
                                </a>
                            </li>




                            <li class="menu-title">Funcionalidad</li>
                            <li>
                                <a href="javascript: void(0);">
                                    <i data-feather="briefcase"></i>
                                    <span> Proyectos </span>
                                   <img src="./images/DobleFelcha.png" height="30px"  margin-left="100px" >
                                </a>
                                <ul class="nav-second-level" aria-expanded="false">
                                    <li>
                                        <a href="Controllertipomat?accion=listar">Tipo Material</a>
                                    </li>
                                    <li>
                                        <a  href="ControllerMaterial?accion=listar">Material</a>
                                    </li>
                                    <li>
                                        <a href="Controllertipopro?accion=listar">Tipo Productos</a>
                                    </li>
                                    <li>
                                        <a href="ControllerProducto?accion=listar">Producto</a>
                                    </li>
                                    <li>
                                        <a href="">Material Detalle</a>
                                    </li>
                                    <li>
                                        <a href="ControllerMedio?accion=listar">Medio</a>
                                    </li>
                                    <li>
                                        <a href="detalleProyecto/show">Detalle Proyecto</a>
                                    </li>
                                    <li>
                                        <a href="ControllerProyecto?accion=listar">Proyecto</a>
                                    </li>
                                  
                                </ul>
                            </li>

                            <li>
                                <a href="./tutorial.html" aria-expanded="false">
                                    <i data-feather="file-text"></i>
                                    <span> Peticiones </span>

                                </a>
                            </li>


                            

                            <li>
                                <a href="ControllerUsu?accion=listar" aria-expanded="false">
                                    <i data-feather="grid"></i>
                                    <span > Usuarios </span>

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
 
  <center><h1>Proyectos Rechazados</h1></center>  
  <br>

         <a href="ControllerProyecto?accion=listar" role="button" class="btn btn-secondary mr-2 "  >Proyectos</a>
 
        <a href="ControllerProyecto?accion=Rechazados" role="button" class="btn btn-secondary mr-2">Rechazados</a>
  
        <a href="ControllerProyecto?accion=Peticiones" role="button" class="btn btn-secondary mr-2">Peticiones</a>

        <a href="ControllerProyecto?accion=Cotizacion" role="button" class="btn btn-secondary mr-2">Cotizacion</a>

        <a href="ControllerProyecto?accion=Ejecucion" role="button" class="btn btn-secondary mr-2" >Ejecucion</a>

        <a href="ControllerProyecto?accion=Finalizados" role="button" class="btn btn-secondary mr-2">Finalizados</a>
        
        
        

        <br><br>
    <table class="table table-responsive">
        <tr>
            <th>#</th>
            <th>Cliente</th>
            <th>Fecha de Inicio</th>
            <th>Fecha Rechazacion</th>
            <th>Valor</th>         
            <th>Micro Proyecto</th>            
            <th>Estado</th>
            <th></th>
            <th colspan="2">Acciones</th>
        </tr>
            </thead>
             <%
            proyectoProcedure dao=new proyectoProcedure();
            List<proyecto> list=dao.listarRechazados();

            Iterator<proyecto>iter=list.iterator();
            proyecto u = null;
            while(iter.hasNext()){
                u=iter.next();
            %>
           <tbody>
                <tr>
                    <td><%= u.getIdProyecto()%></td>
                    <td><%= u.getNombreUsu()%></td>
                    <td><%= u.getFechaInicio()%></td>
                    <td><%= u.getFechaFinalizacion() %></td>
                    <td><%= u.getValorProyecto()%></td>                    
                    <td><%= u.getMicroProyecto()%></td>
                    <td><%= u.getEstadoProyecto() %></td>
                    
 <td>
                
            <a href="ControllerProyecto?accion=editarSinFecha&id=<%=u.getIdProyecto()%>" role="button" class="btn btn-primary text-white">Editar</a>
            </td>
            <td>
                <a  onclick="javascript:return confirm('¿Esta seguro que desea eliminar el registro?');" role="button" class="btn btn-danger text-white">Eliminar</a>
            </td>
                        <td>                
            <a href="ControllerDetalle?accion=verDetalles&id=<%=u.getIdProyecto()%>" role="button" class="btn btn-info text-white">Ver Detalles</a>
            </td>
                </tr>
                       <%
                    }

                %>
            </tbody>
      </table>
</div>
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
