# dar formato a un string
nombre = 'Ignacio'
edad = 20
mensaje_con_formato = 'Mi nombre es %s y tengo %s años' % (nombre, edad)
print(mensaje_con_formato)

# Creamos una tupla
persona = ('Ignacio', 'Buchter', 5000.00)
mensaje_con_formato = 'Hola %s %s . Tu sueldo es %.2f' # % persona # aqui le pasamos el objeto que es la tupla
print(mensaje_con_formato % persona)
