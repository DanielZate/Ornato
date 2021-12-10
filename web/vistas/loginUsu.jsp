<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login V18</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="./css/validacionF.css" rel="stylesheet" type="text/css" />

	<link rel="stylesheet" type="text/css" href="./css/util.css">
	<link rel="stylesheet" type="text/css" href="./css/mainUsu.css">
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

<!--===============================================================================================-->
</head>
<body style="background-color: #665252;">
	
      <style type="text/css">
.caja {
   margin:20px auto 20px auto;	
   border:1px solid #d9d9d9;
   height:80px;
   overflow: hidden;
   width: 450px;
   position:relative;
   font-size: large;
   border-radius: 10px;
   color: rgb(242, 242, 242);

}
select {
   background: transparent;
   border: none;
   font-size: 14px;
   height: 80px;
   padding: 5px;
   width: 450px;
   font-size: large;
   color: black;
}
.opctiones{
    background-color: rgb(242, 242, 242);
    margin:40px auto 40px auto;
  
}
select:focus{ outline: none;}


  </style>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
					<div class="logo">	
					<img src="./images/recurso2.png"  class="logo_imagen">
				</div>

				<form class="login100-form validate-form" action="./ControllerUsu" method="POST" id="formulario">
					<div>
					<span class="login100-form-title p-b-43" >
						Crear cuenta
					</span>
				</div>
<a href="login.jsp">Volver</a>  	
					
					<div class="wrap-input100 validate-input" id="g-nombre" >
                                            <div class="frm-group-input">
                                            <input class="input100" type="text" name="nombre" id="nombre" placeholder="Nombre">
						<span class="focus-input100">Nombre</span>
						        <i class="form-icono fas fa-exclamation-circle"></i>
                                                <span class="msn-error"> Solo puede ingresar letras</span>
                                            </div></div>
                                    <br>
					
					<div class="wrap-input100 validate-input"  id="g-apellido" class="frm-group-input">
                                            <input class="input100" type="text" name="apellido" placeholder="Apellido" id="Apellido">
						<span class="focus-input100">Apellido</span>
		  <i class="form-icono fas fa-exclamation-circle"></i>
                                                <span class="msn-error"> Solo puede ingresar letras</span>
					</div>
                            
                    <div class="caja" id="g-tipodoc" class="frm-group-input" >
                    <select name="tipodoc" id="tipodoc">
            <option value="Cédula de Ciudadanía" name="tipodoc"class="opctiones">Cédula de Ciudadanía</option>
        <option value="Tarjeta de Identidad"name="tipodoc"class="opctiones">Tarjeta de Identidad</option>
        <option value="Cédula de Extranjería"name="tipodoc"class="opctiones">Cédula de Extranjería</option>
  </select>                                                
					</div>
					
                 		                    
                    <div class="wrap-input100 validate-input" id="g-numdoc" class="frm-group-input">
						<input class="input100" type="number" name="numdoc"  id="numdoc"placeholder="Numero de documento">
						<span class="focus-input100">Número de documento</span>
					        <i class="form-icono fas fa-exclamation-circle"></i>
        <span class="msn-error">Solo puede ingresar numeros, max 10 digitos</span>
					</div>
                                    <br>

					<div class="wrap-input100 validate-input" id="g-telefono" class="frm-group-input">
						<input class="input100" type="number" name="telefono" placeholder="Telefono" id="Telefono">
						<span class="focus-input100">Número telefónico</span>
                                            <i class="form-icono fas fa-exclamation-circle"></i>
                                             <span class="msn-error">Solo puede ingresar numeros, max 10 digitos</span>
					</div>
                                    <br>

                    <div class="wrap-input100 validate-input" id="g-correo" class="frm-group-input">
                        <input class="input100" type="text" name="correo" placeholder="Correo" id="Correo">
						<span class="focus-input100">Correo electrónico</span>
					      <i class="form-icono fas fa-exclamation-circle"></i>
      <span class="msn-error">Correo no valido Ej:usuario@gmail.com</span>
					</div>
					
                                    <br>
					<div class="wrap-input100 validate-input" id="g-password" class="frm-group-input">
						<input class="input100" type="password" name="password" placeholder="Contraseña" id="password" >
						<span class="focus-input100">Contraseña</span>
			                    <i class="form-icono fas fa-exclamation-circle"></i>
                                             <span class="msn-error">Debe ser mayor a 8 digitos</span>
					</div>
					
			<br><br>
        <div class="form-error">
            <center><p>El formulario no ha sido completado corectamente</p></center>
        </div>  
					<div class="container-login100-form-btn">
                                            <input type="submit" name="accion" value="Enviar" class="login100-form-btn"  >
					</div>
					
							
				</form>

				<div class="login100-more" style="background-image: url('./images/img-login.jpg');">
				</div>
			</div>
		</div>
	</div>
	
   <script src="./js/validacionCrearCuenta.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
