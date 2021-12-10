<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.proyecto"%>
<%@page import="Procedure.proyectoProcedure"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Shreyu - Admin & Dashboard Template</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        
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
                    <img src="" class="avatar-xs rounded-circle mr-2" alt="Shreyu" />

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
                                <a href="">
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
                                        <a href="./ControllerProyecto?accion=listar">Proyecto</a>
                                    </li>
                                    <li>
                                        <a href="./Controllertipomat?accion=listar">Tipo Material</a>
                                    </li>
                                    <li>
                                        <a  href="./ControllerMaterial?accion=listar">Material</a>
                                    </li>
                                    <li>
                                        <a href="./Controllertipopro?accion=listar">Tipo Productos</a>
                                    </li>
                                    <li>
                                        <a href="./ControllerProducto?accion=listar">Producto</a>
                                    </li>
                                
                                  
                                </ul>
                            </li>

                            <li>
                                <a href="./ControllerPeticionGerente?menu=peticion&accion=default" aria-expanded="false">
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

            </div>
            <!-- Left Sidebar End -->
 
            <!-- ============================================================== -->
            <!-- Start Page Content here -->
            <!-- ============================================================== -->

            <div class="content-page">
                <div class="content">
                    <div class="container-fluid">
                        <div class="row page-title align-items-center">
                            <div class="col-sm-4 col-xl-6">
                                <h4 class="mb-1 mt-0">Proyectos</h4>
                            </div>
                            <div class="col-sm-8 col-xl-6">
                                <form class="form-inline float-sm-right mt-3 mt-sm-0">
                                    <div class="form-group mb-sm-0 mr-2">
                                      
                                    </div>
                                    <div class="btn-group">
     
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a href="#" class="dropdown-item notify-item">
                                                <i data-feather="mail" class="icon-dual icon-xs mr-2"></i>
                                                <span>Email</span>
                                            </a>
                                            <a href="#" class="dropdown-item notify-item">
                                                <i data-feather="printer" class="icon-dual icon-xs mr-2"></i>
                                                <span>Print</span>
                                            </a>
                                            <div class="dropdown-divider"></div>
                                            <a href="#" class="dropdown-item notify-item">
                                                <i data-feather="file" class="icon-dual icon-xs mr-2"></i>
                                                <span>Re-Generate</span>
                                            </a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

<%
    proyectoProcedure dao=new proyectoProcedure();
    List<proyecto> listPe=dao.ContarPeticion();

Iterator<proyecto>iterPe=listPe.iterator();
proyecto pe = null;
while(iterPe.hasNext()){
    pe=iterPe.next();
    
%>         
<!-- content -->
                        <div class="row">
                            <div class="col-md-6 col-xl-4">
                                <div class="card">
                                    <div class="card-body p-0">
                                        <div class="media p-3">
                                            <div class="media-body">
                                                <span class="text-muted text-uppercase font-size-12 font-weight-bold">Peticiones</span>
                                                <h2 class="mb-0"><%= pe.getIdProyecto() %></h2>
                                            </div>
                                            <div class="align-self-center">
                                                <i class="fas fa-clipboard-list"></i>
                                                
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
<%
    }
    List<proyecto> listFi=dao.ContarFinalizados();

Iterator<proyecto>iterFi=listFi.iterator();
proyecto fi = null;
while(iterFi.hasNext()){
    fi=iterFi.next();
%>
                            <div class="col-md-6 col-xl-4">
                                <div class="card">
                                    <div class="card-body p-0">
                                        <div class="media p-3">
                                            <div class="media-body">
                                                <span class="text-muted text-uppercase font-size-12 font-weight-bold">Finalizados
                                                    </span>
                                                <h2 class="mb-0"><%= fi.getIdProyecto() %></h2>
                                            </div>
                                            <div class="align-self-center">
                                                <i class="fas fa-check"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

  <%                      
      }
          List<proyecto> list=dao.ContarRechazados();

Iterator<proyecto>iter=list.iterator();
proyecto u = null;
while(iter.hasNext()){
    u=iter.next();
          
                           %>

                            <div class="col-md-6 col-xl-4">
                                <div class="card">
                                    <div class="card-body p-0">
                                        <div class="media p-3">
                                            <div class="media-body">
                                                <span class="text-muted text-uppercase font-size-12 font-weight-bold">Rechazados
                                                    </span>
                                                <h2 class="mb-0"><%= u.getIdProyecto() %></h2>
                                            </div>
                                            <div class="align-self-center">
                                                <i class="fas fa-times"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>  
<%
    }
    List<proyecto> listCo=dao.ContarCotizacion();

Iterator<proyecto>iterCo=listCo.iterator();
proyecto c = null;
while(iterCo.hasNext()){
    c=iterCo.next();
    

%>
                            <div class="col-md-6 col-xl-4">
                                <div class="card">
                                    <div class="card-body p-0">
                                        <div class="media p-3">
                                            <div class="media-body">
                                                <span class="text-muted text-uppercase font-size-12 font-weight-bold">En cotizacion
                                                    </span>
                                                <h2 class="mb-0"><%= c.getIdProyecto()%></h2>
                                            </div>
                                            <div class="align-self-center">
                                                <i class="fas fa-search-dollar"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
<%
    }
    List<proyecto> listEje=dao.ContarEjecucion();

Iterator<proyecto>iterEje=listEje.iterator();
proyecto ej = null;
while(iterEje.hasNext()){
    ej=iterEje.next();
%>
                            <div class="col-md-6 col-xl-4">
                                <div class="card">
                                    <div class="card-body p-0">
                                        <div class="media p-3">
                                            <div class="media-body">
                                                <span class="text-muted text-uppercase font-size-12 font-weight-bold">En ejecucion
                                                    </span>
                                                <h2 class="mb-0"><%= ej.getIdProyecto() %></h2>
                                            </div>
                                            <div class="align-self-center">
                                                <i class="fas fa-tools"></i>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
<%
    }
%>
                        <!-- stats + charts -->
                        <div class="row">
                        


                            <div class="col-xl-7">
                                <div class="card">
                                    <div class="card-body pb-0">
                                        <ul class="nav card-nav float-right">
                                            
                                        </ul>
                                        <h5 class="card-title mb-0 header-title">Total Proyectos</h5>

                                        <div id="revenue-chart" class="apex-charts mt-3"  dir="ltr"></div>
                                    </div>
                                </div>
                            </div>

                        <!-- row -->
                
                        <!-- products -->
 
                            <div class="col-xl-5">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title mt-0 mb-0 header-title">Proyectos</h5>
                                        <div id="sales-by-category-chart" class="apex-charts mb-1 mt-8" dir="ltr"></div>
                                    </div> <!-- end card-body-->
                                </div> <!-- end card-->
                            </div> <!-- end col-->


                            <div class="col-xl-12">
                              
                                    
                            </div> <!-- end col-->
                        </div>
                        <!-- end row -->

                        <!-- widgets -->
                        

      

                    </div>
                </div> <!-- content -->

                

                <!-- Footer Start -->
              
                <!-- end Footer -->

            </div>

            <!-- ============================================================== -->
            <!-- End Page content -->
            <!-- ============================================================== -->


        </div>
        <!-- END wrapper -->

        <!-- Right Sidebar -->
        
            </div> <!-- end slimscroll-menu-->
        </div>
        <!-- /Right-bar -->

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
