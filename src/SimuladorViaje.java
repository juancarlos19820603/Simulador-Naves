import java.util.Scanner;

public class SimuladorViaje {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Arrays de planetas y sus distancias
        String[] planetas = {"Marte", "Júpiter", "Saturno"};
        double[] distancias = {225.0, 778.0, 1430.0}; // Distancias en millones de km

        do {
            System.out.println("=== Simulador de Viaje Interplanetario ===");
            System.out.println("1. Seleccionar un planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3. Iniciar simulación del viaje");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    seleccionarPlaneta(planetas, distancias);
                    break;
                case 2:
                    seleccionarNave();
                    break;
                case 3:
                    iniciarSimulacion(planetas, distancias);
                    break;
                case 4:
                    System.out.println("Gracias por usar el simulador. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
