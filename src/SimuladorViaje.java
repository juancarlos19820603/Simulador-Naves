import java.util.Scanner; // Importa la clase Scanner para leer datos del usuario desde el teclado. 
import java.util.InputMismatchException; //se utiliza para manejar excepciones relacionadas con entradas no válidas.
                 //La clase InputMismatchException pertenece al paquete java.util y se utiliza en Java para manejar excepciones que ocurren cuando un programa espera un tipo de entrada pero recibe un tipo diferente.

public class SimuladorViaje { // Define la clase principal del programa.
    private static int planetaSeleccionado = -1; // Variable para almacenar el índice del planeta seleccionado (-1 significa "no seleccionado").
    private static int naveSeleccionada = -1;   // Variable para almacenar el índice de la nave seleccionada (-1 significa "no seleccionada").
    private static boolean simulacionIniciada = false; // Variable para verificar si la simulación ha sido iniciada.

    public static void main(String[] args) { // Método principal donde comienza la ejecución del programa.
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario.
        int opcion=0; // Variable para almacenar la opción seleccionada del menú.

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
    if (planetaSeleccionado != -1 && naveSeleccionada != -1 && !simulacionIniciada) { // Muestra la opción de iniciar el viaje si ambos están seleccionados y la simulación no ha comenzado.
        System.out.println("3. Iniciar simulación del viaje");
    }
    System.out.println("4. Salir"); // Siempre muestra la opción de salir.
    System.out.print("Elige una opción: "); // Solicita al usuario que elija una opción.

    try {
        opcion = scanner.nextInt(); // Intenta leer la opción ingresada por el usuario.
    } catch (InputMismatchException e) {
        System.out.println("Por favor, introduce un número válido."); // Mensaje de error si el usuario ingresa algo que no es un número.
        scanner.next(); // Limpia la entrada inválida.
        continue; // Regresa al inicio del bucle para mostrar nuevamente el menú.
    }

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
            if (planetaSeleccionado != -1 && naveSeleccionada != -1 && !simulacionIniciada) { // Verifica si se seleccionaron ambos, planeta y nave, y si la simulación no ha comenzado.
                iniciarSimulacion(planetas, distancias); // Llama al método para iniciar la simulación del viaje.
                simulacionIniciada = true; // Marca la simulación como iniciada.
            } else if (simulacionIniciada) {
                System.out.println("La simulación ya fue iniciada. Reinicia el programa para otro viaje."); // Informa si la simulación ya fue iniciada.
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

    public static void iniciarSimulacion(String[] planetas, double[] distancias) {
        if (planetaSeleccionado == -1) { // Verifica si se seleccionó un planeta.
            System.out.println("No has seleccionado un planeta. Ve a la opción 1."); // Mensaje si no se seleccionó un planeta.
            return; // Finaliza el método si no hay planeta seleccionado.
        }
        double distancia = distancias[planetaSeleccionado] * 1000000; // Convierte la distancia de millones de km a km.
        double velocidad = 100000; // Define la velocidad de la nave seleccionada (constante en este caso).
        double tiempo = distancia / velocidad; // Calcula el tiempo estimado del viaje en horas.

        System.out.println("Iniciando viaje a " + planetas[planetaSeleccionado] + "..."); // Muestra el destino del viaje.
        System.out.printf("Distancia: %.2f km. Tiempo estimado: %.2f horas.\n", distancia, tiempo); // Imprime detalles del viaje.

        for (int progreso = 0; progreso <= 100; progreso += 10) { // Simula el progreso del viaje.
            System.out.println("Progreso del viaje: " + progreso + "%"); // Imprime el progreso actual.
            if (Math.random() < 0.3) { // Genera eventos aleatorios con una probabilidad del 30%.
                System.out.println("¡Evento aleatorio! Un asteroide se acerca. Resuelve el problema.");
            }
            try {
                Thread.sleep(1000); // Pausa el programa por 1 segundo.
            } catch (InterruptedException e) { // Maneja interrupciones en el hilo.
                System.out.println("Error en la simulación.");
            }
        }
        System.out.println("¡Has llegado a " + planetas[planetaSeleccionado] + " con éxito!"); // Mensaje de éxito al llegar.
    }
}
