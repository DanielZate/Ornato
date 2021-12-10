const frm=document.getElementById('formulario');
const campos=document.querySelectorAll('#formulario input');
//console.log(campos)

const reglas={
        nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/ // Letras y espacios, pueden llevar acentos.

}

const inputs={

    tipomat:false
}

const validarCampos=(e)=>{
     switch(e.target.name){
         case "tipomat":
             if(reglas.nombre.test(e.target.value)){
                 document.querySelector('#g-Material .form-icono').classList.remove('form-icono-visible');
                 document.querySelector('#g-Material .msn-error').classList.remove('msn-error-visible');
                 inputs['tipomat']=true;
             }else{
                 document.querySelector('#g-Material .form-icono').classList.add('form-icono-visible');
                 document.querySelector('#g-Material .msn-error').classList.add('msn-error-visible');
                 inputs['tipomat']=false;
            }
         break;
     }
}


frm.addEventListener('submit', e =>{

    if(inputs.tipomat){
        console.log(inputs.tipomat)
         document.querySelector('.form-error').classList.remove('form-error-visible');
         
    }else{
         e.preventDefault();
        console.log(inputs.tipomat)
         document.querySelector('.form-error').classList.add('form-error-visible');
    }
})

campos.forEach((campo)=>{
    campo.addEventListener('blur', validarCampos);
     campo.addEventListener('keyup', validarCampos);
})