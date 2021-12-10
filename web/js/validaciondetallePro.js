const form=document.getElementById("formDetpro");
const campos=document.querySelectorAll('#formDetpro input');
console.log("hola")
const reglas={
    textos_numeros: /^[a-zA-ZÀ-ÿ-.\s\d]{1,40}$/,
    numeros:/^[.\s\d]{1,10}$/
}

const inputs={
   altura:false,
   ancho:false,
   cantidad:false,
   observacion:false,
   precioDet:false,
   profundidad:false

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
        case "detalleProyecto.Alto":
            validarInput(reglas.textos_numeros,e.target.id,e.target);
        break;
        case "detalleProyecto.Ancho":
            validarInput(reglas.textos_numeros,e.target.id,e.target);
        break;
        case "detalleProyecto.Cantidad":
            validarInput(reglas.numeros,e.target.id,e.target);
        break;
        case "detalleProyecto.Observacion":
            validarInput(reglas.textos_numeros,e.target.id,e.target);
        break;
        case "detalleProyecto.PrecioDetalle":
            validarInput(reglas.numeros,e.target.id,e.target);
        break;
        case "detalleProyecto.Profundidad":
            validarInput(reglas.textos_numeros,e.target.id,e.target);
        break;
            
    }
    
}

form.addEventListener('submit',e =>{
   
    
    if(inputs.altura && inputs.ancho && inputs.cantidad && inputs.observacion && inputs.precioDet && inputs.profundidad){
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