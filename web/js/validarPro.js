const frm=document.getElementById('formulario');
const campos=document.querySelectorAll('#formulario input');
console.log(campos)

const reglas={
        nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/ // Letras y espacios, pueden llevar acentos.

}

const inputs={

    Nombre:false
}

const validarCampos=(e)=>{
     switch(e.target.name){
         case "Nombre":
             if(reglas.nombre.test(e.target.value)){
                 document.querySelector('#g-Producto .form-icono').classList.remove('form-icono-visible');
                 document.querySelector('#g-Producto .msn-error').classList.remove('msn-error-visible');
                 inputs['Nombre']=true;
             }else{
                 document.querySelector('#g-Producto .form-icono').classList.add('form-icono-visible');
                 document.querySelector('#g-Producto .msn-error').classList.add('msn-error-visible');
                 inputs['Nombre']=false;
            }
         break;
     }
}

frm.addEventListener('submit', e =>{

    if(inputs.Nombre){
        console.log(inputs.tipopro)
         document.querySelector('.form-error').classList.remove('form-error-visible');
         
    }else{
         e.preventDefault();
        console.log(inputs.tipopro)
         document.querySelector('.form-error').classList.add('form-error-visible');
    }
})



campos.forEach((campo)=>{
    campo.addEventListener('blur', validarCampos);
     campo.addEventListener('keyup', validarCampos);
})