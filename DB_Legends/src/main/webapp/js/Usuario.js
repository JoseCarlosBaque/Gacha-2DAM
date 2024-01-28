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

