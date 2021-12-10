<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<title>Login V18</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../css/util.css">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
        
        <link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #665252;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
					<div class="logo">	
					<img src="./images/recurso2.png"  class="logo_imagen">
                                        
				</div>
				<form action="srvUsuario?accion=verificar" method="POST"  class="login100-form validate-form" >
					<div>
						<br><br><br>
					<span class="login100-form-title p-b-43" >
						Iniciar Sesión 
					</span>
				</div>
					<a href="index.html">Volver</a>
					
					<div class="wrap-input100 validate-input" >
                                            <input class="input100"  type="text" name="txtUsu" id="txtUsu" value="" placeholder="Correo electrónico">
						<span class="focus-input100">Correo electrónico</span>
			
					</div>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="password" name="txtPass" id="txtPass" value=""  placeholder="Contraseña">
						<span class="focus-input100">Contraseña</span>
				
					</div>
					<div class="flex-sb-m w-full p-t-3 p-b-32">

</div>
<div class="flex-sb-m w-full p-t-3 p-b-32">

                                          <div class="social-auth-links text-center">
     
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-info"></i> Mensaje: 
        ${msje}</a>
    </div>
    
					<div>
							<a href="ControllerUsu?accion=crearNuevo" class="txt1">
								¿No tienes una cuenta?
							</a>
						</div>
					</div>
			
<br><br>
					<div class="container-login100-form-btn">
                                             <input type="submit" name="verificar" value="Verificar"  class="login100-form-btn"> 

                                            
					</div>
					
					

					
				</form>

<div class="login100-more" style="background-image: url('./images/img-login.jpg');">				</div>

			</div>
		</div>
	</div>


	


	<script src="../js/main.js"></script>

</body>
</html>