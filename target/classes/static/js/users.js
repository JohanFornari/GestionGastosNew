// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable();
    cargarUsuarios();
  });
  
  async function cargarUsuarios(){
      const request = await fetch('usuarios',{
          method: 'GET',
          headers: {
              'Accept':'application/json',
              'Content-Type':'application/json'
          }
      });
  
      const usuarios = await request.json();
	  console.log(usuarios)
  
      let listadoHtml='';
  
  
  
  
      for( let usuario of usuarios){
          let botonEliminar ='<td><a href="#" type="button" class="btn btn-danger" onclick="eliminarUsuario('+usuario.id+')">Eliminar</a>';
          let botonActualizar ='<a href="#" type="button" class="btn btn-primary" onclick="actualizarUsuario('+usuario+')">Actualizar</a></td>';
          let usuarioHtml = '</td><td>'+usuario.nombre+'</td><td>'+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td>'+'<td>'+usuario.direccion+'</td>'+ ' <div class="container-fluid">' + botonEliminar + botonActualizar + '</div></tr>';
			
          listadoHtml += usuarioHtml;
		  console.log(usuarioHtml)
      }
      document.querySelector("#dataTable tbody").outerHTML = listadoHtml;
  
  }
  
  async function eliminarUsuario(id){
  
      if(!confirm("Quiere eliminar el usuario?")){
          return;
      }
      const request = await fetch('usuario/'+id,{
          method: 'Delete',
          headers: {
              'Accept':'application/json',
              'Content-Type':'application/json'
          }
      });
  
      location.reload()
  
  }
  
  async function registrarUsuario(datos) {

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
  


  