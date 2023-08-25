from capa_datos_persona.usuario import Usuario
from capa_datos_persona.usuarioDao import UsuarioDAO
from logger_base import log

opcion = None
while opcion != 5:
    print('opciones: ')
    print('1. listar usuarios')
    print('2. agregar usuarios')
    print('3. modificar usuarios')
    print('4. eliminar usuario')
    print('5. salir')
    opcion = int(input('digite una opcion de 1 a 5'))
    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for usuario in usuarios:
            log.info(usuario)

    elif opcion == 2:
        username_var = input('digite el nombre de usuario: ')
        password_var = input('digite su contraseña: ')
        usuario = Usuario(username=username_var, password=password_var)
        usuario_insertado = UsuarioDAO.insertar(usuario)
        log.info(f'usuario insertado: {usuario_insertado}')

    elif opcion ==3:
        id_usuario_var = int(input('digite el id del usuario  a modificar: '))
        username_var = input('digite el nombre de usuario a modificar: ')
        password_var = input('digite su contraseña a modificar: ')
        usuario = Usuario(id_usuario=id_usuario_var,username=username_var, password=password_var)
        usuario_actualizado = UsuarioDAO.actualizar(usuario)
        log.info(f'Usuario actualizado: {usuario_actualizado}')

    elif opcion == 4:
        id_usuario_var = int(input('digite el id del usuario  a eliminar: '))
        usuario = Usuario(id_usuario=id_usuario_var)
        usuario_eliminado = UsuarioDAO.eliminar(usuario)
        log.info(f'Usuario eliminado: {usuario_eliminado}')
else:
    log.info('salimos de la aplicacion: hasta pronto !!!!')
