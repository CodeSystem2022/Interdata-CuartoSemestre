from capa_datos_persona.usuario import Usuario
from capa_datos_persona.crusor_del_pool import CursorDelPool
from logger_base import log

class UsuarioDAO:
    '''
    DAO --> Data Access Object para la tabla de usuario
    CRUD --> Create - Read - Update - Delete
    '''

    _SELECT = 'SELECT * FROM usuario ORDER BY id_usuario'
    _INSERTAR = 'INSERT INTO usuario(username, password) VALUE (%s, %s)'
    _ACTUALIZAR = 'UPDATE usuario SET username=%s, password=%s WHERE id_usuario=%s'
    _ELIMINAR = 'DELETE FROM usuario WHERE id_usuario=%S'

    @classmethod
    def seleccionar(cls):
        with CursorDelPool() as cursor:
            log.debug('seleccionando usuarios')
            cursor.execute(cls._SELECT)
            registros = cursor.fetchall()
            usuarios = []
            for registro in registros:
                usuario = Usuario(registro[0], registro[1], registro[2])
                usuarios.append(usuario)
                return usuarios

    @classmethod
    def insertar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'usuario a insertar: {usuario}')
            valores = (usuario.username, usuario.password)
            cursor.execute(cls._INSERTAR, valores)
            return cursor.rowcount

    @classmethod
    def actualizar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'usuario a actualizar: {usuario}')
            valores = (usuario.username, usuario.password, usuario.id_usuario)
            cursor.execute(cls._ACTUALIZAR, valores)
            return cursor.rowcount

    @classmethod
    def eliminar(cls, usuario):
        with CursorDelPool() as cursor:
            log.debug(f'usuario a eliminar: {usuario}')
            valores = (usuario.id_usuario)
            cursor.execute(cls._ELIMINAR, valores)
            return cursor.rowcount

if __name__ == '__main__':
    # eliminar un registro
    usuario = Usuario(id_persona=3)
    usuario_eliminado = UsuarioDAO.eliminar(usuario)
    log.debug(f'usuario eliminado: {usuario_eliminado}')

    # actualizar un registro
    usuario = Usuario(id_usuario=1, username='Ignacio', password='333')
    usuario_modificado = UsuarioDAO.actualizar(usuario)
    log.debug(f'usuario modificado: {usuario_modificado}')

    # insertar un registro
    usuario = Usuario(username='juan', password='349')
    usuario_insertado = UsuarioDAO.insertar(usuario)
    log.debug(f'usuario Insertado: {usuario_insertado}')

    # seleccionar objetos
    usuario = UsuarioDAO.seleccionar()
    for usuario in usuario:
        log.debug(usuario)
