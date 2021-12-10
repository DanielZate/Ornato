const form=document.getElementById("formMedio");
const campos=document.querySelectorAll('#formMedio input');
console.log("hola")
const reglas={
    url: /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/
    
}

const inputs={
   nomMedio:false
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
        case "medio.Url":
            validarInput(reglas.url,e.target.id,e.target);
        break;
        
            
    }
    
}

form.addEventListener('submit',e =>{
   
    
    if(inputs.nomMedio){
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