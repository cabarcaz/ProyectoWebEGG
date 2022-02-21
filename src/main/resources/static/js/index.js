// Calificacion
var contador;
function calificar(item){
  console.log(item);
  contador=item.id[0];
  let nombre=item.id.substring(1);
  for(let i=0;i<5;i++){
    if(i<contador){
      document.getElementById((i+1)+nombre).style.color="orange";
    }else{
      document.getElementById((i+1)+nombre).style.color="black";
    }
  }
}

function mensaje(nombre){
  Swal.fire({
  icon: 'success',
  title: 'Comentario enviado',
  showConfirmButton: false,
  timer: 2500
})
}


// Reloj
const mostrarReloj = () => {
  let fecha = new Date();
  let hr = formatoHora(fecha.getHours());
  let min = formatoHora(fecha.getMinutes());
  let seg = formatoHora(fecha.getSeconds());
  document.getElementById('hora').innerHTML = `${hr}:${min}:${seg}`;

  const meses =['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
  const dias =['Domingo', 'Lunes','Martes','Miercoles','Jueves','Viernes','Sabado'];
  let diaSemana = dias[fecha.getDay()];
  let dia = fecha.getDate();
  let mes = meses[fecha.getMonth()];
  let fechaTexto= `${diaSemana}, ${dia}/${mes}`;
  document.getElementById('fecha').innerHTML = fechaTexto;

  document.getElementById('contenedor').classList.toggle('animar');
};

const formatoHora = (hora) => {
if(hora<10)
  hora = '0'+hora;
  return hora;
};

setInterval(mostrarReloj,1000);

//Ingrediente
class Ingrediente{
  constructor(nombre,cantidad){
    this._nombre = nombre;
    this._cantidad = cantidad;
  }
  get nombre(){return this._nombre;}
  set nombre(nombre){this._nombre = nombre;}

  get cantidad(){return this._cantidad;}
  set cantidad(cantidad){this._cantidad = cantidad;}
}

const ingredientes =[
  new Ingrediente('Nombre del ingrediente', 'Cantidad del ingrediente'),
];
function mostrarIngredientes(){
  console.log('Mostrar Ingredientes.');
  let texto ='';
  for(let ingrediente of ingredientes){
    texto += `<li>${ingrediente.nombre} - ${ingrediente.cantidad}</li>`
  }
  document.getElementById('ingredientes').innerHTML = texto;
}
function agregarIngrediente(){
  const forma = document.forms['forma'];
  const nombre = forma['nombre'];
  const cantidad = forma['cantidad'];
  if(nombre.value !='' && cantidad.value !=''){
    const ingrediente = new Ingrediente(nombre.value, cantidad.value);
    ingredientes.push(ingrediente);
    mostrarIngredientes();
  }else{
    console.log('sin información para agregar.')
  }
}