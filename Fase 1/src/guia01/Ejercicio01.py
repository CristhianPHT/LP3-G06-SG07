def sumar_arreglo(arreglo):
  suma = 0
  for num in arreglo:
    suma += num
  return suma


arreglo = [1, 2, 3, 4, 5]
suma = sumar_arreglo(arreglo)
print("La suma de los elementos del arreglo es:", suma)