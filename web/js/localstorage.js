
const frm=document.getElementById('form-peticion');
const detPeticion=document.getElementById('detallePeticion');

let peticion=[];

//funciones
const mostrarPeticion=()=>{
    detPeticion.innerHTML='';
    peticion=JSON.parse(localStorage.getItem('peticion'));
    console.log(peticion);

    if(peticion===null){
        peticion=[];
    }
    else{
        peticion.forEach(elemento=>{
            detPeticion.innerHTML+=`
            <td>${elemento.producto}</td>
            <td>${elemento.altura}</td>
            <td>${elemento.ancho}</td>
            <td>${elemento.profundidad}</td>
            <td>${elemento.cantidad}</td>
            <td>${elemento.observacion}</td>
            <td>${elemento.material}</td>
            <td><button class="btn-enviar">Borrar</button></td>`;
        });
    }
}
const agregarPeticion=(producto,altura,ancho,profundidad,cantidad,observacion,material)=>{

    let item={
        producto:producto,
        altura:altura,
        ancho:ancho,
        profundidad:profundidad,
        cantidad:cantidad,
        observacion:observacion,
        material:material
    }

    peticion.push(item);
    console.log(peticion);
}

const guardarPeticion=()=>{
    localStorage.setItem('peticion',JSON.stringify(peticion));
    mostrarPeticion();
}
const eliminarProducto=(producto)=>{
    let indexP;
    peticion.forEach((elemento,index)=>{
        if(elemento.producto===producto){
            indexP=index;
        }
    });

    peticion.splice(indexP,1);
    guardarPeticion();

}

//eventos

frm.addEventListener('submit',(e)=>{
    e.preventDefault();

    let prod = document.getElementById('producto').value;
    let alt = document.getElementById('altura').value;
    let ancho=document.getElementById('ancho').value;
    let prof=document.getElementById('profundidad').value;
    let cant=document.getElementById('cantidad').value;
    let obser=document.getElementById('observacion').value;
    let mat=document.getElementById('material').value;
    

    //crear metodo para agregar cada producto

    agregarPeticion(prod,alt,ancho,prof,cant,obser,mat);
    guardarPeticion();

    frm.reset();
})
document.addEventListener('DOMContentLoaded',mostrarPeticion);

detPeticion.addEventListener('click',(e)=>{
    e.preventDefault();
    //console.log(e);
    //console.log(e.target.innerText);

    if(e.target.innerText==="Borrar"){
        //console.log(e.path[2].childNodes[0].innerText);
        let product=e.path[2].childNodes[0].innerText;
        eliminarProducto(product);
    }
})