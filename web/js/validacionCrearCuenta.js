const frm=document.getElementById('formulario');
const campos=document.querySelectorAll('#formulario input');
//console.log(campos)

const reglas={
        nombre: /^[a-zA-_.ZáéíóúÁÉÍÓÚñÑ /s]*$/,
	password: /^.{8,30}$/, // 4 a 12 digitos.
	correo:/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        numeros: /^\d{1,10}$/

}

const inputs={
    nombre:false,
    apellido:false,
    numdoc:false,
    correo:false,
    password:false,
    telefono:false
    
}



const validarInput=(regla,grupo,input)=>{    
            if(regla.test(input.value)){
                document.querySelector(`#g-${grupo} .form-icono`).classList.remove('form-icono-visible');
                document.querySelector(`#g-${grupo} .msn-error`).classList.remove('msn-error-visible');
        inputs[grupo]=true;
        inputs['password']=true;
            }else{
                document.querySelector(`#g-${grupo} .form-icono`).classList.add('form-icono-visible');
                document.querySelector(`#g-${grupo} .msn-error`).classList.add('msn-error-visible');
        inputs[grupo]=false;
         inputs['password']=false;
            }
}


const validarCampos=(e)=>{
   // console.log("se presiono una tecla")
    //console.log(e.target.name)
    
    
    
        switch(e.target.name){
        case "password":
            validarInput(reglas.password,e.target.name,e.target);
        break;   
        case "nombre":
            validarInput(reglas.nombre,e.target.name,e.target);
        break;
        case "apellido":
            validarInput(reglas.nombre,e.target.name,e.target);
        break;
        case "numdoc":
            validarInput(reglas.numeros,e.target.name,e.target);
        break;
        case "correo":
            validarInput(reglas.correo,e.target.name,e.target);
        break;
        case "telefono":
            validarInput(reglas.numeros,e.target.name,e.target);
        break;  
 
    }
}




frm.addEventListener('submit', e =>{

       if(inputs.nombre && inputs.apellido && inputs.numdoc && inputs.correo && inputs.telefono && inputs.password){
        console.log("Guardar")
        console.log(inputs.password)
         document.querySelector('.form-error').classList.remove('form-error-visible');
         
    }else{
         e.preventDefault();
         console.log("Error")
        console.log( inputs.password)
         document.querySelector('.form-error').classList.add('form-error-visible');
    }

})

campos.forEach((campo)=>{
    campo.addEventListener('blur', validarCampos);
    campo.addEventListener('keyup', validarCampos);
})