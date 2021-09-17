select usuarios.idUsuarios, usuarios.nombres, usuarios.apellidos, usuarios.tipoDocumento,usuarios.identificacion, usuarios.rolUsuario,usuarios.direccion, usuarios.telefono,usuarios.correo,usuarios.edad, vendedores.usuario,vendedores.clave
from barriodb.usuarios 
inner join barriodb.vendedores on usuarios.idUsuarios = vendedores.idVendedores;
