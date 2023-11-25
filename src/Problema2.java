//ENUNCIADO Nombre de clase: Problema2, Nombre en el menu: Mayor de cada fila
/* Dada una matriz entera de tamaño m x n, solicita al usuario que ingrese
los elementos. Luego, encuentra el elemento más grande en cada fila, guárdelo
en un vector y muestra dichos elementos.*/

// impotaciones de librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// clase principal del programa
public class Problema2 {
    // inicializacion de variables
    private static int[][] matriz;
    private static int[] mayores;

    // metodo main, encargado de inicar toooodo el programa
    public static void main(String[] args) {
        Problema2 problema = new Problema2();
        problema.ejecutarPrograma();
    }

    //Método para ejecutar el programa.
    public static void ejecutarPrograma() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // bucle while para que el programa siga preguntando hasta que se ingrese un numero valido
        while (true) {
            //try catch para capturar errores de entrada
            try {
                // Ingresar el número de filas y columnas de la matriz
                System.out.println("Ingrese el número de filas de la matriz:");
                int filas = Integer.parseInt(br.readLine());
                // if para validar que el numero de filas sea mayor a 0
                if (filas <= 0) {

                    throw new IllegalArgumentException("El número de filas debe ser mayor que 0");
                }
                // Ingresar el número de columnas de la matriz
                System.out.println("Ingrese el número de columnas de la matriz:");
                int columnas = Integer.parseInt(br.readLine());
                // if para validar que el numero de columnas sea mayor a 0
                if (columnas <= 0) {
                    throw new IllegalArgumentException("El número de columnas debe ser mayor que 0");
                }
                // Crear la matriz original
                matriz = new int[filas][columnas];
                for (int i = 0; i < filas; i++) {
                    // for para recorrer las filas
                    for (int j = 0; j < columnas; j++) {
                        // for para recorrer las columnas
                        System.out.println("Ingrese el elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]:");
                        // ingreso de elementos de la matriz
                        matriz[i][j] = Integer.parseInt(br.readLine());
                    }
                }
                // Crear el vector de mayores
                mayores = new int[filas];
                // for para recorrer las filas
                for (int i = 0; i < filas; i++) {
                    // for para recorrer las columnas
                    for (int j = 0; j < columnas; j++) {
                        // if para comparar los elementos de la matriz
                        if (matriz[i][j] > mayores[i]) {
                            // asignar el valor de la matriz a la posicion del vector
                            mayores[i] = matriz[i][j];
                        }
                    }
                }
                // Imprimir matriz original
                System.out.println("Matriz ingresada:");
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print("[ " + matriz[i][j] + " ] ");
                    }
                    System.out.println();
                }

                // Imprimir vector de mayores
                System.out.println("El vector de mayores es:");
                for (int i = 0; i < mayores.length; i++) {
                    System.out.println("mayores[" + i + "] = " + mayores[i]);
                }
                break;
            } catch (IOException e) {
                System.err.println("Ha ocurrido un error de entrada/salida. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.err.println("Ha ingresado un número inválido. Intente de nuevo.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage() + " Intente de nuevo.");
            }
        }
    }
}