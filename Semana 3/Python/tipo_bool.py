
# Bool contiene los valores de true y false
# Los tipos numericos, es false para el 0, true para los demas valores
valor = 0
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = 15
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

# Tipo string -> False '', True demas valores
valor = ''
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = 'Ignacio'
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

# Tipo de colecciones -> False para colecciones vacias
# Tipo de colecciones  -> True para todas las demas
# Lista
valor = []
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = [2, 3, 4]
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

# Tupla
valor = ()
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = (5,)
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

# Diccionario
valor = {}
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

valor = {'nombre': 'Ignacio', 'apellido': 'Buchter'}
resultado = bool(valor)
print(f'valor: {valor}, resultado: {resultado}')

# Sentencias de control con bool
if valor:
    print('regresa verdadero')
else:
    print('regresa falso')

# Ciclos
variable = 17
while variable:
    print('regresa verdadero')
    break
else:
    print('regresa falso')





