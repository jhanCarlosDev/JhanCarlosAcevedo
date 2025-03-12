import java.util.List;
import java.util.Map;

public class ConsultarRegistro {
    public static void mostrarTodasLasVentas(RegistroVentas registro) {
        List<Map<String, String>> ventas = registro.obtenerVentas();

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        for (Map<String, String> venta : ventas) {
            System.out.println("Código: " + venta.get("codigo") +
                    ", ID Cliente: " + venta.get("idCliente") +
                    ", Fecha: " + venta.get("fecha"));
        }
    }
}
