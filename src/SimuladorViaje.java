import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario desde el teclado.

public class SimuladorViaje { // Define la clase principal del programa.
    private static int planetaSeleccionado = -1; // Variable para almacenar el índice del planeta seleccionado (-1 significa "no seleccionado").
    private static int naveSeleccionada = -1;   // Variable para almacenar el índice de la nave seleccionada (-1 significa "no seleccionada").

    public static void main(String[] args) { // Método principal donde comienza la ejecución del programa.
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.
        int opcion; // Variable para almacenar la opción seleccionada del menú.

        // Arrays que contienen los nombres de los planetas y sus respectivas distancias desde la Tierra en millones de kilómetros.
        String[] planetas = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
        double[] distancias = {91.7, 42.4, 78.3, 628.9, 1284.4, 2721.4, 4345.4};

        do {
            // Imprime el menú dinámico. Las opciones varían según las selecciones anteriores.
            System.out.println("=== Simulador de Viaje Interplanetario ===");
            if (planetaSeleccionado == -1) { // Muestra la opción de seleccionar un planeta solo si no se ha seleccionado.
                System.out.println("1. Seleccionar un planeta de destino");
            }
            if (naveSeleccionada == -1) { // Muestra la opción de seleccionar una nave solo si no se ha seleccionado.
                System.out.println("2. Seleccionar una nave espacial");
            }
            if (planetaSeleccionado != -1 && naveSeleccionada != -1) { // Muestra la opción de iniciar el viaje si ambos están seleccionados.
                System.out.println("3. Iniciar simulación del viaje");
            }
            System.out.println("4. Salir"); // Siempre muestra la opción de salir.
            System.out.print("Elige una opción: "); // Solicita al usuario que elija una opción.
            opcion = scanner.nextInt(); // Lee la opción ingresada por el usuario.

            // Procesa la opción seleccionada utilizando un switch.
            switch (opcion) {
                case 1:
                    if (planetaSeleccionado == -1) { // Verifica si el planeta aún no ha sido seleccionado.
                        seleccionarPlaneta(planetas, distancias, scanner); // Llama al método para seleccionar un planeta.
                    } else {
                        System.out.println("Ya has seleccionado un planeta."); // Informa si ya se seleccionó un planeta.
                    }
                    break;
                case 2:
                    if (naveSeleccionada == -1) { // Verifica si la nave aún no ha sido seleccionada.
                        seleccionarNave(scanner); // Llama al método para seleccionar una nave.
                    } else {
                        System.out.println("Ya has seleccionado una nave."); // Informa si ya se seleccionó una nave.
                    }
                    break;
                case 3:
                    if (planetaSeleccionado != -1 && naveSeleccionada != -1) { // Verifica si se seleccionaron ambos, planeta y nave.
                        //iniciarSimulacion(planetas, distancias); // Llama al método para iniciar la simulación del viaje.
                    } else {
                        System.out.println("Debes seleccionar un planeta y una nave antes de iniciar la simulación."); // Mensaje si faltan selecciones.
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el simulador. ¡Adiós!"); // Mensaje de despedida.
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente."); // Mensaje de error para opciones no válidas.
            }
        } while (opcion != 4); // Repite el menú hasta que el usuario elija salir.

        scanner.close(); // Cierra el objeto Scanner para liberar recursos.
    }

    public static void seleccionarPlaneta(String[] planetas, double[] distancias, Scanner scanner) {
        System.out.println("=== Selección de Planeta ==="); // Título de la sección de selección de planetas.
        for (int i = 0; i < planetas.length; i++) { // Itera sobre el array de planetas para mostrarlos con sus distancias.
            System.out.println((i + 1) + ". " + planetas[i] + " - Distancia: " + distancias[i] + " millones de km de la Tierra");
        }
        System.out.print("Selecciona un planeta (1-" + planetas.length + "): "); // Solicita al usuario que seleccione un planeta.
        int seleccion = scanner.nextInt(); // Lee la opción seleccionada.
        if (seleccion > 0 && seleccion <= planetas.length) { // Valida si la opción es válida.
            planetaSeleccionado = seleccion - 1; // Guarda el índice del planeta seleccionado.
            System.out.println("Has seleccionado " + planetas[planetaSeleccionado] + "."); // Confirma la selección.
        } else {
            System.out.println("Selección inválida."); // Mensaje de error para selección inválida.
        }
    }

    public static void seleccionarNave(Scanner scanner) {
        // Arrays que contienen los nombres de las naves y sus velocidades respectivas.
        String[] naves = {"New Horizons", "Crew Dragon", "Halcón Milenario"};
        double[] velocidades = {100000, 80000, 5000000}; // Velocidades en km/h.

        System.out.println("=== Selección de Nave ==="); // Título de la sección de selección de naves.
        for (int i = 0; i < naves.length; i++) { // Itera sobre el array de naves para mostrarlas con sus velocidades.
            System.out.println((i + 1) + ". " + naves[i] + " - Velocidad: " + velocidades[i] + " km/h");
        }
        System.out.print("Selecciona una nave (1-" + naves.length + "): "); // Solicita al usuario que seleccione una nave.
        int seleccion = scanner.nextInt(); // Lee la opción seleccionada.
        if (seleccion > 0 && seleccion <= naves.length) { // Valida si la opción es válida.
            naveSeleccionada = seleccion - 1; // Guarda el índice de la nave seleccionada.
            System.out.println("Has seleccionado la nave " + naves[naveSeleccionada] + "."); // Confirma la selección.
        } else {
            System.out.println("Selección inválida."); // Mensaje de error para selección inválida.
        }
    }
}
