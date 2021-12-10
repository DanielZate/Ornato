const form=document.getElementById("formRol");
const campos=document.querySelectorAll('#formRol input');
console.log("hola")
const reglas={
    textos: /^[a-zA-ZÀ-ÿ\s]{1,40}$/
    
}

const inputs={
    rol:false
}
const validarInput=(regla,grupo,input)=>{
    if(regla.test(input.value)){
        document.getElementById(`g-${grupo}`).classList.remove('error');
        document.getElementById(`g-${grupo}`).classList.add('succes');
        document.querySelector(`#g-${grupo} i`).classList.add('fa-check-circle');
        document.querySelector(`#g-${grupo} i`).classList.remove('fa-exclamation-circle');
        document.querySelector(`#g-${grupo} .msn-error`).classList.remove('msn-error-visible');
        inputs[grupo]=true;
    }
    else{
        document.getElementById(`g-${grupo}`).classList.remove('succes');
        document.getElementById(`g-${grupo}`).classList.add('error');
        document.querySelector(`#g-${grupo} i`).classList.add('fa-exclamation-circle');
        document.querySelector(`#g-${grupo} i`).classList.remove('fa-check-circle');
        document.querySelector(`#g-${grupo} .msn-error`).classList.add('msn-error-visible');
        inputs[grupo]=false;
    } 
}
     


const validarCampos=(e)=>{
    //console.log("Se presiono una tecla");
    //console.log(e.target.name);
    switch(e.target.name){
        case "rol.rol":
            validarInput(reglas.textos,e.target.id,e.target);
        break;
        
            
    }
    
}

form.addEventListener('submit',e =>{
   
    
    if(inputs.rol){
        //alert('El usuario ha sido registrado');
        //form.reset();
        document.querySelectorAll('succes').forEach((icono)=>{
            icono.classList.remove('succes');
        })
        document.querySelector('.form-error').classList.remove('form-error-visible');
        
    }
    else{
        e.preventDefault();
        document.querySelector('.form-error').classList.add('form-error-visible');
        
    }
})

campos.forEach((campo)=>{

    campo.addEventListener('keyup',validarCampos);
    campo.addEventListener('blur',validarCampos);
})