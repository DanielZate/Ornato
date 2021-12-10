const formulario=document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
console.log('Tecla levantada');
const expresiones ={
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^.{8,}$/, // 4 a 12 digitos.
	correo:/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        numdoc: /^\d{1,11}$/,
	telefono: /^\d{1,10}$/ // 7 a 14 numeros.
}

const campos = {
    nombre: false,
    apellido: false,
    numdoc: false,
    correo: false,
    telefono: false,
    password: false
}

const validarFormulario = (e) => {
  switch (e.target.name){
        case "nombre":
            validarCampo(expresiones.nombre, e.target, e.target.name);
        break;
        case "apellido":
            validarCampo(expresiones.nombre, e.target, 'apellido');
        break;
        case "numdoc":
            validarCampo(expresiones.numdoc, e.target, 'numdoc');
        break;
        case "correo":
            validarCampo(expresiones.correo, e.target, 'correo');
        break;
        case "telefono":
            validarCampo(expresiones.telefono, e.target, 'telefono');
        break;
        case "password":
            validarCampo(expresiones.password, e.target, 'password');
        break;
        
  } 
}

const validarCampo = (expresion, input, campo) =>{
    if(expresion.test(input.value)){
                document.getElementById(`grupo__${campo}`).classList('formulario__grupo-incorrecto');
                document.getElementById(`grupo__${campo}`).classList('formulario__grupo-incorrecto i');
                document.querySelectorAll(`#grupo__${campo} i`).classList.add('formulario__grupo i');
           
    }else{
                document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
                document.querySelectorAll(`#grupo__${campo} i`).classList.add('formulario__grupo-incorrecto i');
              
    }
}

inputs.forEach((input) =>{
    input.addEventListener('keyup', validarFormulario)
    input.addEventListener('blur', validarFormulario);
});


formulario.addEventListener('submit', (e) => {
           e.preventDefault();
   if(campos.nombre && campos.apellido && campos.numdoc && campos.correo && campos.telefono && campos.password ){
       console.log(campos.nombre);

   }  else{
      document.querySelector('.mensaje').classList.add('mesaje-visible')
   }
});


