// Calificacion
var contador;

function calificar(item) {
  console.log(item);
  contador = item.id[0];
  let nombre = item.id.substring(1);
  for (let i = 0; i < 5; i++) {
    if (i < contador) {
      document.getElementById((i + 1) + nombre).style.color = "orange";
    } else {
      document.getElementById((i + 1) + nombre).style.color = "black";
    }
  }
}

function mensaje(nombre) {
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

  const meses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
  const dias = ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'];
  let diaSemana = dias[fecha.getDay()];
  let dia = fecha.getDate();
  let mes = meses[fecha.getMonth()];
  let fechaTexto = `${diaSemana}, ${dia}/${mes}`;
  document.getElementById('fecha').innerHTML = fechaTexto;

  document.getElementById('contenedor').classList.toggle('animar');
};

const formatoHora = (hora) => {
  if (hora < 10)
    hora = '0' + hora;
  return hora;
};

setInterval(mostrarReloj, 1000);



//boton up
$(document).ready(function(){

	$('.ir-arriba').click(function(){
		$('body, html').animate({
			scrollTop: '0px'
		}, 300);
	});

	$(window).scroll(function(){
		if( $(this).scrollTop() > 0 ){
			$('.ir-arriba').slideDown(300);
		} else {
			$('.ir-arriba').slideUp(300);
		}
	});

});




