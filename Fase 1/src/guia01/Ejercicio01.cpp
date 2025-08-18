#include <iostream>
using namespace std;

const int N = 5;

int sumarArreglo(int arreglo[], int n) {
    int suma = 0;
    for (int i = 0; i < n; i++) {
        suma += arreglo[i];
    }
    return suma;
}

int main() {
    int arreglo[N] = {1, 2, 3, 4, 5};
    int suma = sumarArreglo(arreglo, N);
    cout << "La suma de los elementos del arreglo es: " << suma << endl;
    return 0;
}