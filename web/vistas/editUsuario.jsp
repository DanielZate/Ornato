<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if (session.getAttribute("usuario") != null) {
%>
<%@page import="ModeloDao.rolDAO"%>
<%@page import="Model.usuario"%>
<%@page import="ModeloDao.usuarioDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
</head>
        <!-- App favicon -->

        <!-- plugins -->
                <link href="./css/validacionF.css" rel="stylesheet" type="text/css" />

        <link href="./css/flatpickr.css" rel="stylesheet" type="text/css" />

        <!-- App css -->
        <link href="./css/bootstrapIndex.css" rel="stylesheet" type="text/css" />
       
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
                                        <a href="Controllertipopro?accion=listar">Tipo Productos</a>
                                    </li>
                                    <li>
                                        <a href="ControllerProducto?accion=listar">Producto</a>
                                    </li>
                                  
                                </ul>
                            </li>

                            <li>
                                <a href="ControllerPeticionGerente?menu=peticion&accion=default" aria-expanded="false">
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
        <%
            rolDAO dao2=new rolDAO();
            
            usuarioDAO dao=new usuarioDAO();
            int id=Integer.parseInt((String)request.getAttribute("idPro"));
            usuario p=(usuario)dao.list(id);
        %>
          <style type="text/css">
.divcontenedor
{
width:1150px;
height:auto;
padding:5px;


}
.divA
{
  height:auto;
    width:800px;
     margin-left: 180px; 
     
}
.divA label{
    color:black ;
    font-size: medium  ;
}
  </style>
         <center><h2>Modificar Usuario</h2></center>
      <a href="./ControllerUsu?accion=listar" class="btn btn-secondary">Volver</a>


        <br>
        <div class="divcontenedor">
            <div class="divA">
                <form action="ControllerUsu" id="formulario">
                    <input type="hidden" name="idUsu" value="<%= p.getIdUsuario() %>">
  <div class="form-row">
    <div class="form-group col-md-6" id="g-nombre">
      <label form="nombre">Nombres </label>
       <div class="frm-group-input">
      <input type="text" class="form-control"name="nombre" id="nombre" value="<%= p.getNombreUsuario()%>">
        <i class="form-icono fas fa-exclamation-circle"></i>
        <span class="msn-error"> Solo puede ingresar letras</span>
      </div></div>
    
    
    <div class="form-group col-md-6" id="g-apellido">
      <label for="apellido">Apellidos</label>
            <div class="frm-group-input">
      <input type="text" class="form-control" name="apellido" id="apellido" value="<%= p.getApellidoUsuario()%>"  >
          <i class="form-icono fas fa-exclamation-circle"></i>
        <span class="msn-error">Solo puede ingresar letras</span>
    </div></div>
  <br>
                    
       <div class="form-group col-md-6">
      <label form="correo">Tipo de documento </label>
        <div id="form-group-input">
            <select name="tipodoc" class="form-control">
                  <option value="<%= p.getTipoDocUsuario()%>"> <%= p.getTipoDocUsuario() %></option>
        <option value="Cédula de Ciudadanía" name="tipodoc">Cédula de Ciudadanía</option>
        <option value="Tarjeta de Identidad"name="tipodoc">Tarjeta de Identidad</option>
        <option value="Cédula de Extranjería"name="tipodoc">Cédula de Extranjería</option>
        </select>
    </div>
    </div>
    <div class="form-group col-md-6" id="g-numdoc">
      <label for="numdoc">Numero de documento</label>
            <div class="frm-group-input" >
      <input type="number" class="form-control" name="numdoc" id="numdoc" value="<%= p.getNumDocUsuario()%>">
        <i class="form-icono fas fa-exclamation-circle"></i>
        <span class="msn-error">Solo puede ingresar numeros, max 10 digitos</span>
    </div></div>
      
      
      <div class="form-group col-md-6" id="g-correo">
      <label form="nomusuario">Correo </label>
            <div class="frm-group-input">
      <input type="text" class="form-control"name="correo" id="correo" value="<%= p.getCorreoUsuario()%>">
      <i class="form-icono fas fa-exclamation-circle"></i>
      <span class="msn-error">Correo no valido Ej:usuario@gmail.com</span>
    </div></div>
    
    <div class="form-group col-md-6" id="g-telefono">
      <label for="inputPassword4">Telefono</label>
            <div class="frm-group-input">
      <input type="number" class="form-control" name="telefono" id="telefono" value="<%= p.getTelefonoUsuario()%>">
        <i class="form-icono fas fa-exclamation-circle"></i>
        <span class="msn-error">Solo puede ingresar numeros, mix 10 digitos</span>
    </div></div>
      
      <div class="form-group col-md-6">
      <label form="rol">Rol </label>
        <div id="form-group-input">
            <select name="rol" class="form-control">
                             <option value="<%= p.getIdRolFk() %>"><%= p.getNomRol() %></option>
                    <%= dao2.listarRolSelect()%>
        </select>
    </div>
    </div>
    <div class="form-group col-md-6" id="g-password">
      <label for="inputPassword4">Contraseña</label>
         <div class="frm-group-input">
      <input type="password" name="password" id="password" class="form-control"  value="<%= p.getPassword() %>">
        <i class="form-icono fas fa-exclamation-circle"></i>
      <span class="msn-error"> La password debe incluir como minmo 8 caracteres  </span>
    </div></div>
      
  </div>                   
                           <div class="form-error">
            <center><p>El formulario no ha sido completado corectamente</p></center>
        </div>        
        <br>
       <input type="submit" name="accion" class="btn btn-secondary" value="Actualizar"> 
       
        </div>
        
     </form>  
               
                       
            
        </div>
                
                

    
</div>
            
       <!-- Right bar overlay-->
       <div class="rightbar-overlay"></div>

       <!-- Vendor js
       <script src="./js/ValidacionUsua.js"></script> -->
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
