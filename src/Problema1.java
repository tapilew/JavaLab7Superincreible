//ENUNCIADO Nombre de clase: Problema1, Nombre en el menu: Matriz Traspuesta
/* Diseñe un programa que permita al usuario ingresar una matriz entera de
n x m. Haga una segunda matriz con la traspuesta de la matriz original. Imprima
ambas matrices.Dada una matriz entera de tamaño m x n, solicita al usuario que
ingrese los elementos. */

// impotaciones de librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// clase principal del programa
public class Problema1 {
    // inicializacion de variables
    private static int[][] matrizOriginal;
    private static int[][] matrizTraspuesta;

    // metodo main, encargado de inicar todo el programa
    public static void main(String[] args) {
        Problema1 problema = new Problema1();
        problema.ejecutarPrograma();
    }


    //Método para ejecutar el programa.

    public static void ejecutarPrograma() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            matrizOriginal = new int[filas][columnas];

            // Ingresar los elementos de la matriz original
            for (int i = 0; i < filas; i++) {
                // for para recorrer las filas
                for (int j = 0; j < columnas; j++) {
                    // for para recorrer las columnas
                    System.out.println("Ingrese el elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]:");
                    matrizOriginal[i][j] = Integer.parseInt(br.readLine());
                }
            }

            // Crear la matriz traspuesta
            matrizTraspuesta = new int[columnas][filas];
            // for para recorrer las filas
            for (int i = 0; i < filas; i++) {
                // for para recorrer las columnas
                for (int j = 0; j < columnas; j++) {
                    // asignar el valor de la matriz original a la matriz traspuesta
                    matrizTraspuesta[j][i] = matrizOriginal[i][j];
                }
            }

            // Imprimir matriz original
            System.out.println("Matriz original:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matrizOriginal[i][j] + " ");
                }
                System.out.println();
            }

            // Imprimir matriz traspuesta
            System.out.println("Matriz traspuesta:");
            for (int i = 0; i < columnas; i++) {
                for (int j = 0; j < filas; j++) {
                    System.out.print(matrizTraspuesta[i][j] + " ");
                }//trata de probar denuevo
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Ha ocurrido un error de entrada/salida");
            ejecutarPrograma();
        } catch (NumberFormatException e) {
            System.err.println("Ha ingresado un número inválido");
            ejecutarPrograma();
        }
    }
}
