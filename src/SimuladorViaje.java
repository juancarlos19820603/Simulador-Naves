import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario.

public class SimuladorViaje {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.
        int opcion; // Variable para almacenar la opción seleccionada por el usuario.

        // Arrays de planetas y sus distancias respectivas desde la Tierra en millones de kilómetros.
        String[] planetas = {"Marte", "Júpiter", "Saturno"};
        double[] distancias = {225.0, 778.0, 1430.0}; // Distancias en millones de km.

        // Bucle principal del programa que muestra el menú y procesa la entrada del usuario.
        do {
            // Imprime el menú de opciones para el usuario.
            System.out.println("=== Simulador de Viaje Interplanetario ===");
            System.out.println("1. Seleccionar un planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3. Iniciar simulación del viaje");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario.

            // Procesa la opción seleccionada mediante un bloque switch.
            switch (opcion) {
                case 1:
                    // Llama al método para seleccionar un planeta de destino.
                    seleccionarPlaneta(planetas, distancias);
                    break;
                case 2:
                    // Llama al método para seleccionar una nave espacial.
                    seleccionarNave();
                    break;
                case 3:
                    // Llama al método para iniciar la simulación del viaje.
                    iniciarSimulacion(planetas, distancias);
                    break;
                case 4:
                    // Mensaje de despedida al salir del programa.
                    System.out.println("Gracias por usar el simulador. ¡Adiós!");
                    break;
                default:
                    // Mensaje de error para opciones no válidas.
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 4); // Repite el menú mientras el usuario no elija la opción de salir (4).

        scanner.close(); // Cierra el objeto Scanner para liberar recursos.
    }
}
