/* En colaboración de:
        Luis Tapia(Control de versiones, documentación y debbuging)
        Jim Santos(Coordinador, developer)
        José Rodriguez( developer, UML designer)
        Anibal Abrego(Developer, Beta Tester)*/
/*
    * Problema 1: Matriz Transpuesta >Josegab
    * Problema 2: Mayor de cada Fila en una Matriz - Anibal
    * Problema 3: Diagonal Secundaria de una Matriz
    * Problema 4: Ordenar Vectores de forma Ascendente >Jim Santos
    *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// clase principal del menu
public class MainMenu {
    public static void main(String[] args) {
        // inicializacion de variables
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion = 0;
        // do while para mostrar el menu
        do {
            limpiarPantalla();
            mostrarMenu();
            // try catch para capturar errores de entrada
            try {
                System.out.print("Elige una opción: ");
                String input = reader.readLine();
                opcion = Integer.parseInt(input);
                // switch para elegir la opcion del menu
                switch (opcion) {
                    case 1:
                        Problema1.ejecutarPrograma();
                        break;
                    case 2:
                        Problema2.ejecutarPrograma();
                        break;
                    case 3:
                        Problema3.ejecutarPrograma();
                        break;
                    case 4:
                        Problema4.iniciar();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");

                        System.exit(0);
                    default:
                        System.err.println("\nOpción no válida. Inténtalo de nuevo.");
                }
                // if para que no se cierre el programa
                if (opcion != 5) {
                    System.out.print("Presiona Enter para continuar...");
                    reader.readLine();
                }
                // catch para capturar errores de entrada
            } catch (IOException e) {
                System.err.println("Error de entrada/salida. " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Por favor ingresa un número válido.");
            }
            // while para que no se cierre el programa
        } while (opcion != 5);
    }

    // metodo para limpiar la pantalla
    private static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\n");
        }
    }
    // metodo para mostrar el menu
    private static void mostrarMenu() {
        System.out.println("MAIN MENU LABORATORIO 6:");
        System.out.println("[1]____Matriz Transpuesta");
        System.out.println("[2]____Mayor de cada Fila en una Matriz");
        System.out.println("[3]____Diagonal Secundaria de una Matriz");
        System.out.println("[4]____Ordenar Vectores de forma Ascendente");
        System.out.println("[5]____Salir");
        System.out.println("____________________________________________");
    }
}