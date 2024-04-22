
$(document).ready(function () {

});

async function registrarUsuario() {

    let datos = {};

    datos.nombre = document.getElementById('id_nombre').value;
    datos.apellido = document.getElementById('id_apellido').value;
    datos.email = document.getElementById('id_email').value;
    datos.telefono = document.getElementById('id_telefono').value;
    datos.password = document.getElementById('id_password').value;
	datos.direccion = document.getElementById('id_address').value;
	datos.role = { "id_role": 1};

    if (datos.password != document.getElementById('id_repeat_password').value) {
        alert('La contraseña es diferente.');
        return;
    }

    const request = await fetch('usuario', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });


    window.location.href = 'tables.html';

    
}
