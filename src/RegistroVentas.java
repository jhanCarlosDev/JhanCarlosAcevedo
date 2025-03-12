
import java.util.*;

public class RegistroVentas {
    private List<Map<String, String>> ventas = new ArrayList<>();

    public void registrarVenta(String codigo, String idCliente, String fecha) {
        ventas.add(Map.of(
                "codigo", codigo,
                "idCliente", idCliente,
                "fecha", fecha
        ));
    }

    public void iniciarRegistro() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Ingrese código de la venta: ");
            String codigo = scanner.nextLine();

            System.out.print("Ingrese ID del cliente: ");
            String idCliente = scanner.nextLine();

            System.out.print("Ingrese la fecha (YYYY-MM-DD HH:MM): ");
            String fecha = scanner.nextLine();

            registrarVenta(codigo, idCliente, fecha);

            System.out.print("¿Desea registrar otra venta? (s/n): ");
        } while (scanner.nextLine().trim().equalsIgnoreCase("s"));
    }

    public List<Map<String, String>> obtenerVentas() {
        return ventas;
    }
}
