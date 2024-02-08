/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function validarFormulario() {
    var usuario = document.getElementById("usuario").value;
    var password = document.getElementById("password").value;
    var tecnologias = document.querySelector("input[name='tec']:checked");
    var genero = document.querySelector("input[name='genero']:checked");
    var profesion = document.getElementById("profesion").value;
    if (usuario === "" || password === "" || !tecnologias || !genero || profesion === "") {
        alert("Por favor, complete todos los campos obligatorios.");
        return false;
    }
    return true;
}
/*Funcion Para Elegir El Modal Que Se Mostrara*/
function openModal(target) {
    $("#" + target).modal("show");
}

/*Funcion Para los Single's*/
function obtenerPersonaje(lista) {
    var x = Math.floor(Math.random() * lista.length);
    return x;
}

/*Funcion para los multis*/


/*Funcion para enseñar el id*/
function mostarId() {
    var labelToShow = document.getElementById("idToShow");
    if (labelToShow.style.display === "none") {
        labelToShow.style.display = "block";
    } else {
        labelToShow.style.display = "none";
    }
}

///* Función para restar vida */
//function restarVida(cantidad) {
//    // Obtener la vida actual
//    var vida = parseInt(document.getElementById("health").textContent);
//    // Restar la cantidad especificada
//    vida -= cantidad;
//    // Actualizar el valor de la vida en el elemento HTML
//    document.getElementById("health").textContent = vida;
//    // Calcular y mostrar el porcentaje de vida
//    var porcentaje = calcularPorcentaje(vida);
//    document.getElementById("healthPercentage").textContent = porcentaje;
//}  

///*Funcion para porcentaje*/
//function calcularPorcentaje(vida) {
//    var porcentaje = (vida / 40000) * 100;
//    var porcentajeFormateado = porcentaje.toFixed(2); // Redondeamos el resultado a dos decimales
//
//    if (porcentajeFormateado.endsWith('.00')) {
//        return parseInt(porcentajeFormateado) + '%'; // Mostrar solo el número entero si los decimales son .00
//    } else {
//        return porcentajeFormateado + '%'; // Mostrar el porcentaje con dos decimales si no termina con .00
//    }
//}