import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Problema3 {
    private static Integer[][] matriz;
    private static Integer[] diagonalSecundaria;

    public static void main(String[] args) {
        Problema3 problema = new Problema3();
        problema.ejecutarPrograma();
    }

    public static void ejecutarPrograma() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Ingrese el tamaño de la matriz cuadrada:");
                int tamano = Integer.parseInt(br.readLine());
                if (tamano <= 0) {
                    throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor que 0");
                }
                matriz = new Integer[tamano][tamano];
                for (int i = 0; i < tamano; i++) {
                    for (int j = 0; j < tamano; j++) {
                        System.out.println("Ingrese el elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]:");
                        matriz[i][j] = Integer.parseInt(br.readLine());
                    }
                }
                diagonalSecundaria = new Integer[tamano];
                for (int i = 0; i < tamano; i++) {
                    diagonalSecundaria[i] = matriz[i][tamano - i - 1];
                }
                Arrays.sort(diagonalSecundaria, Collections.reverseOrder());

                System.out.println("Matriz ingresada:");
                for (int i = 0; i < matriz.length; i++) {
                    for (int j = 0; j < matriz[i].length; j++) {
                        System.out.print("[ " + matriz[i][j] + " ] ");
                    }
                    System.out.println();
                }

                System.out.println("La diagonal secundaria ordenada de mayor a menor es:");
                for (int i = 0; i < diagonalSecundaria.length; i++) {
                    System.out.println("diagonalSecundaria[" + i + "] = " + diagonalSecundaria[i]);
                }
                break;
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error de entrada/salida. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("Ha ingresado un número inválido. Intente de nuevo.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Intente de nuevo.");
            }
        }
    }
}
