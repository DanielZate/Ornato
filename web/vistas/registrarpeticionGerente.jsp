<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                        <a href="ControllerProyecto?accion=listar">Proyecto</a>
                                    </li>
                                  
                                    <li>
                                        <a href="Controllertipomat?accion=listar">Tipo Material</a>
                                    </li>
                                    <li>
                                        <a  href="ControllerMaterial?accion=listar">Material</a>
                                    </li>
                                    <li>
                                        <a href="./Controllertipopro?accion=listar">Tipo Producto</a>
                                    </li>
                                    <li>
                                        <a href="ControllerProducto?accion=listar">Producto</a>
                                    </li>
                                  
                                </ul>
                            </li>

                            <li>
                                <a href="" aria-expanded="false">
                                    <i data-feather="file-text"></i>
                                    <span> Peticiones </span>

                                </a>
                            </li>


                            

                            <li>
                                <a href="./ControllerUsu?accion=listar" aria-expanded="false">
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
       <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="ControllerPeticionGerente?menu=peticion" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Producto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="idproducto" value="${producto.getIdProducto()}" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <input type="submit" name="accion" value="buscarproducto" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="productos"  value="${producto.getNombreProducto()}" class="form-control">
                            </div>
                            
                           
                        </div>
                         <div class="form-group">
                            <label>Material</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="idmaterial" value="${material.getIdMaterial()}" class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <input type="submit" name="accion" value="buscarmaterial" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="material" value="${material.getNombreMaterial()}" class="form-control">
                            </div>
                            
                           
                        </div>
                         <div class="form-group">
                            <label>Alto</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="alto" class="form-control">
                            </div>
                            
                        </div>
                         <div class="form-group">
                            <label>Ancho</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="ancho" class="form-control">
                            </div>
                            
                        </div>
                         <div class="form-group">
                            <label>Profundidad</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="profundidad" class="form-control">
                            </div>
                            
                        </div>
                         <div class="form-group">
                            <label>Cantidad</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="number" name="cantidad" class="form-control">
                            </div>
                            
                        </div>
   
                                <input type="hidden" name="preciodetalle" class="form-control">
                     
                            
                        
                         <div class="form-group">
                            <label>Observacion</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-4">
                                <input type="text" name="observacion" class="form-control">
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <input type="submit" name="accion" value="agregar" class="btn btn-outline-info">
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Codigo</th>
                                    <th>Producto</th>
                                    <th>Material</th>
                                    <th>Alto</th>
                                    <th>Ancho</th>
                                    <th>Profundidad</th>
                                    <th>Cantidad</th>                    
                                    <th>Observacion</th>
                                
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lis" items="${lista}" >
                                <tr>
                                    <td>${lis.getItem()}</td>
                                    <td>${lis.getIdProducto()}</td>
                                    <td>${lis.getNombreProducto()}</td>
                                    <td>${lis.getNombrematerial()}</td>
                                    <td>${lis.getAlto()}</td>
                                    <td>${lis.getAncho()}</td>
                                    <td>${lis.getProfundidad()}</td>
                                    <td>${lis.getCantidad()}</td>
                                    <td>${lis.getObservacion()}</td>
                                  
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                  </div>
                    <div class="card-footer">
                        <a onclick="javascript:return alert('su peticion ha sido enviada');"href="ControllerPeticionGerente?menu=peticion&accion=GenerarPeticion" class="btn btn-success">Generar Peticion</a>
                    </div>
 
            </div>
                </div>
        </div>
                            
           
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
