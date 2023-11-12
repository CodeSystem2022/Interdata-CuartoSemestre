cursos = 'Java Javascrip Node Python Diseno'
lista_cursos = cursos.split()
print(f'Lista de cursos: {lista_cursos}')
print(type(lista_cursos))

cursos_separados_coma = 'Java,Python,Node,Node,JS,Spring'

lista_cursos = cursos_separados_coma.split(',', 2)
print(f'Lista de cursos: {lista_cursos}')
print(f'Cantidad de elementos: {len(lista_cursos)}')
