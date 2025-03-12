import java.util.*;


class Producto {
    String nombre;
    int id;
    double precio;
    int cantidad;
    int ventas = 0;

    Producto(String nombre, int id, double precio, int cantidad) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    Producto comprar(int cantidadComprada) {
        Producto nuevoEstado = new Producto(nombre, id, precio, Math.max(0, cantidad - cantidadComprada));
        nuevoEstado.ventas = this.ventas + cantidadComprada;  // 👈 Se actualizan las ventas
        return nuevoEstado;
    }

    public String toString() {
        return nombre + "  ID: " + id + "  Precio: $" + precio + "  Stock: " + cantidad;
    }
}

public class SimulacionDeInventario {
    private List<Producto> inventario;
    private Scanner scanner;

    public SimulacionDeInventario() {
        inventario = new ArrayList<>(Arrays.asList(
                new Producto("Computador", 1, 1200.99, 14),
                new Producto("Mouse", 2, 25.50, 9),
                new Producto("Teclado", 3, 45.99, 5)
        ));
        scanner = new Scanner(System.in);
    }

    public void iniciarSimulacion() {
        while (true) {
            System.out.println(" Menú de Inventario:");
            System.out.println("1 Mostrar inventario");
            System.out.println("2 Comprar un producto");
            System.out.println("3 Agregar un nuevo producto");
            System.out.println("4 Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarInventario();
                    break;
                case 2:
                    realizarCompra();
                    break;
                case 3:
                    agregarProducto();
                    break;
                case 4:
                    System.out.println("Saliendo del inventario...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public void realizarCompra() {
        System.out.println("Inventario disponible:");
        mostrarInventario();

        System.out.print("Ingrese el ID del producto a comprar: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidadComprada = scanner.nextInt();

        double totalCompra = calcularTotalCompra(idProducto, cantidadComprada);
        if (totalCompra == -1) {
            System.out.println("Producto no encontrado o cantidad insuficiente.");
            return;
        }

        System.out.println("Total a pagar: $" + totalCompra);
        System.out.print("¿Desea confirmar la compra? (s/n): ");
        String confirmar = scanner.next().toLowerCase();

        if (confirmar.equals("s")) {
            comprarProducto(idProducto, cantidadComprada);
            System.out.println("Compra realizada con éxito.");


            System.out.println("Inventario actualizado:");
            mostrarInventario();
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    public void agregarProducto() {
        System.out.print("Ingrese el nombre del nuevo producto: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el ID del nuevo producto: ");
        int id = scanner.nextInt();

        System.out.print("Ingrese el precio del nuevo producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock: ");
        int cantidad = scanner.nextInt();

        inventario.add(new Producto(nombre, id, precio, cantidad));

        System.out.println("Producto agregado con éxito.");
        System.out.println("Inventario actualizado:");
        mostrarInventario();
    }

    public double calcularTotalCompra(int idProducto, int cantidadComprada) {
        for (Producto producto : inventario) {
            if (producto.id == idProducto) {
                if (producto.cantidad >= cantidadComprada) {
                    return producto.precio * cantidadComprada;
                }
                return -1;
            }
        }
        return -1;
    }

    public void comprarProducto(int idProducto, int cantidadComprada) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).id == idProducto) {
                inventario.set(i, inventario.get(i).comprar(cantidadComprada));
                return;
            }
        }
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            inventario.forEach(System.out::println);
        }
    }


    public List<Producto> getInventario() {
        return inventario;
    }

    public static void main(String[] args) {
        SimulacionDeInventario simulacion = new SimulacionDeInventario();
        simulacion.iniciarSimulacion();
    }
}
