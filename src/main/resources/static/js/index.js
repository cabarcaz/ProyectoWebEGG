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

//boton up
$(document).ready(function () {

  $('.ir-arriba').click(function () {
    $('body, html').animate({
      scrollTop: '0px'
    }, 300);
  });

  $(window).scroll(function () {
    if ($(this).scrollTop() > 0) {
      $('.ir-arriba').slideDown(300);
    } else {
      $('.ir-arriba').slideUp(300);
    }
  });

});

const ingredientes = [
  new Ingrediente('Nombre del ingrediente', 'Cantidad del ingrediente'),
];

function mostrarIngredientes() {
  console.log('Mostrar Ingredientes.');
  let texto = '';
  for (let ingrediente of ingredientes) {
    texto += `<li>${ingrediente.nombre} - ${ingrediente.cantidad}</li>`
  }
  document.getElementById('ingredientes').innerHTML = texto;
}

function agregarIngrediente() {
  const forma = document.forms['forma'];
  const nombre = forma['nombre'];
  const cantidad = forma['cantidad'];
  if (nombre.value != '' && cantidad.value != '') {
    const ingrediente = new Ingrediente(nombre.value, cantidad.value);
    ingredientes.push(ingrediente);
    mostrarIngredientes();
  } else {
    console.log('sin información para agregar.')
  }

}

// funciones de boton agregar

function agregar(string, index) {
  //  console.log(event)
  let nextIndex = index + 1;
  let row = document.getElementById(string + nextIndex);
  if (row != null) {
    row.classList.remove("no-mostrar");
  }
  console.log("holis entre a agregar");
}

function eliminar(string, index) {
  let row = document.getElementById(string + index);
  if (string == "ingrediente") {
    if (index != 0) {
      let nombre = document.getElementById('nombre' + index);
      let cantidad = document.getElementById('cantidad' + index);
      nombre.value = '';
      cantidad.value = '';
      if (row != null) {
          row.classList.add("no-mostrar")
        };
    }
  }
  if (string == "paso") {
    if (index != 0) {
      let texto = document.getElementById('procedimiento' + index);
      texto.value = '';
      if (row != null) {
          row.classList.add("no-mostrar")
        };
    }
  }

  console.log("holis entre a eliminar");
}