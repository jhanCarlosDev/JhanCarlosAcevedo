import java.util.List;

public class Promedio {
    private List<Producto> inventario;

    public Promedio(List<Producto> inventario) {
        this.inventario = inventario;
    }

    public void mostrarProductosMasYMenosVendidos() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        Producto masVendido = inventario.get(0);
        Producto menosVendido = inventario.get(0);

        for (Producto producto : inventario) {
            if (producto.ventas > masVendido.ventas) {  // Ahora analiza las ventas reales
                masVendido = producto;
            }
            if (producto.ventas < menosVendido.ventas) {
                menosVendido = producto;
            }
        }

        System.out.println("Producto más vendido: " + masVendido.nombre + " - Vendidos: " + masVendido.ventas + " - Precio: $" + masVendido.precio);
        System.out.println("Producto menos vendido: " + menosVendido.nombre + " - Vendidos: " + menosVendido.ventas + " - Precio: $" + menosVendido.precio);
    }
}
