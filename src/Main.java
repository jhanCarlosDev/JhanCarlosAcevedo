import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola, Bienvenido a mi supermercado");
        Scanner scanner = new Scanner(System.in);

        //instancia de clase
        RegistroVentas registro = new RegistroVentas();
        SimulacionDeInventario simulacion = new SimulacionDeInventario();
        Promedio promedio = new Promedio(simulacion.getInventario());

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1 Registrar una venta");
            System.out.println("2 Simulacion de inventario");
            System.out.println("3 Consultar todas las ventas");
            System.out.println("0 Salir");
            System.out.print("Seleccione una opción: ");

            int numero = scanner.nextInt();
            scanner.nextLine();

            switch (numero) {
                case 1:
                    registro.iniciarRegistro();
                    break;
                case 2:
                    simulacion.iniciarSimulacion();
                    break;
                case 3:
                    ConsultarRegistro.mostrarTodasLasVentas(registro);
                    break;
                case 4:
                    promedio.mostrarProductosMasYMenosVendidos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa... ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
