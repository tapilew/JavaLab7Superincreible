//ENUNCIADO Nombre de clase: Problema4, Nombre en el menu: Ordenar vectores
/*•	Declare 2 vectores. Uno contendrá el nombre de los estudiantes y
el otro la calificación final obtenida en el curso. Ordene de menor
a mayor ambos vectores*/
// impotaciones de librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Problema4 {
// inicializacion de variables
    private static String[] estudiantes = new String[0];
    private static int[] calificaciones = new int[0];
    private static int count = 0;

    // metodo main, encargado de inicar todo el programa
        public static void iniciar() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // try catch para capturar errores de entrada de estudiantes
            try {
                System.out.println("Deseas agregar un estudiante S/N?");
                String respuesta = br.readLine();

                // while para agregar estudiantes, mientras la respuesta sea S
                while (respuesta.equalsIgnoreCase("S")) {
                    System.out.println("Cuál es el nombre del estudiante?");
                    String nombre = br.readLine();
                    // metodo para obtener calificacion, pasamos el reader como parametro
                    int calificacion = obtenerCalificacion(br);

                    // metodo para agregar estudiante, pasamos el nombre y la calificacion como parametros
                    agregarEstudiante(nombre, calificacion);

                    // pregunta si se desea agregar otro estudiante
                    System.out.println("Deseas agregar otro estudiante S/N?");
                    respuesta = br.readLine();
                }
                // metodo para ordenar estudiantes por calificacion, no recibe parametros, ya que los vectores son globales
                ordenarEstudiantesPorCalificacion();

                // metodo para mostrar estudiantes y calificaciones, no recibe parametros, ya que los vectores son globales
                mostrarEstudiantesYCalificaciones();

            } catch (IOException e) {
                e.printStackTrace();//mira la mainmenu y lee lo que dice
            }
        }

        private static int obtenerCalificacion(BufferedReader br) throws IOException {
            int calificacion = 0;
            boolean isValid = false;
            while (!isValid) {
                System.out.println("Cuál fue su calificacion obtenida?");
                try {
                    calificacion = Integer.parseInt(br.readLine());
                    if (calificacion < 0 || calificacion > 100) {
                        System.out.println("La calificación debe estar entre 0 y 100");
                    } else {
                        isValid = true;
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("Por favor ingresa un numero valido");
                }
            }
            return calificacion;
        }
        // metodo para agregar estudiante, recibe como parametros el nombre y la calificacion,
        // y los agrega a los vectores, si los vectores son null o el count es igual al tamaño del vector,
        // se redimensionan los vectores
        private static void agregarEstudiante(String nombre, int calificacion) {
            if (estudiantes == null || count == estudiantes.length) {
                estudiantes = Arrays.copyOf(estudiantes, count + 1);
                calificaciones = Arrays.copyOf(calificaciones, count + 1);
            }
            estudiantes[count] = nombre;
            calificaciones[count] = calificacion;
            count++;
        }

        // metodo para ordenar estudiantes por calificacion, recibe como parametros los vectores
        // y los ordena de menor a mayor
        private static void ordenarEstudiantesPorCalificacion() {
            // ordenamiento burbuja, recorre el vector de calificaciones y compara cada elemento con el siguiente
            for (int i = 0; i < calificaciones.length - 1; i++) {

                for (int j = i + 1; j < calificaciones.length; j++) {
                    // si el elemento actual es mayor al siguiente, se intercambian los valores
                    if (calificaciones[i] > calificaciones[j]) {
                        // intercambio de valores
                        int tempC = calificaciones[i];
                        calificaciones[i] = calificaciones[j];
                        calificaciones[j] = tempC;
                        // intercambio de nombres
                        String tempS = estudiantes[i];
                        estudiantes[i] = estudiantes[j];
                        estudiantes[j] = tempS;
                    }
                }
            }
        }
        // metodo para mostrar estudiantes y calificaciones, recibe como parametros los vectores
        private static void mostrarEstudiantesYCalificaciones() {
            System.out.println("Estudiantes                Calificación");
            // recorre los vectores y muestra los valores
            for (int i = 0; i < estudiantes.length; i++) {
                System.out.println(estudiantes[i] + "\t\t\t" + calificaciones[i] + "/100 (" + obtenerCalificacionTexto(calificaciones[i]) + ")");
            }
        }

        // metodo para obtener calificacion en texto, recibe como parametro la calificacion
        private static String obtenerCalificacionTexto(int calificacion) {
            if (calificacion >= 90) {
                return "A";
            } else if (calificacion >= 80) {
                return "B";
            } else if (calificacion >= 70) {
                return "C";
            } else if (calificacion >= 60) {
                return "D";
            } else {
                return "F";
            }
        }
    }

