# Profundizando en el tipo float
a = 3.0

# Constructor de tipo float -> Puede recibir tipos (int) y (str)
a = float(10) # Pasamos un tipo entero (int)
a = float('10') 

# Indicamos la cantidad de decimales que va a mostrar, sirve para contraerlo
print(f'a: {a:.2f}') 

# Notación Exponencial (valores positivos o negativos)
a = 3e5 # 3 exponencial 5, al número 3 le agregamos 5 ceros
print(f'a: {a}')

a = 3e-5
print(f'a: {a:.5f}')
print(f'a: {a:.9f}')

#Cualquier calculo que incluye un float, todo cambia a float

a = 4.0 + 5
print(a)
print(type(a))