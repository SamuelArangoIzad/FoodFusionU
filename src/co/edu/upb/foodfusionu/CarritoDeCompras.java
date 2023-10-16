package co.edu.upb.foodfusionu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarritoDeCompras {
	private static final Map<String, Double> preciosProductos = new HashMap<>();

	private ArrayList<String> carrito = new ArrayList<>();
	private ArrayList<Integer> cantidades = new ArrayList<>();
	private double total = 0.0;

	static {
		// Define los precios de los productos aquí
		preciosProductos.put("Empanada de carne", 2500.0);
		preciosProductos.put("Empanada de pollo", 2000.0);
		preciosProductos.put("Empanada de queso", 2000.0);
		preciosProductos.put("Empanada de jamón y queso", 2500.0);
		preciosProductos.put("Empanada de champiñones", 2500.0);
		preciosProductos.put("Arepas de queso", 3000.0);
		preciosProductos.put("Arepas de choclo", 3500.0);
		preciosProductos.put("Arepas de carne desmechada", 4000.0);
		preciosProductos.put("Arepas de jamón y queso", 3500.0);
		preciosProductos.put("Arepas de pollo", 3000.0);
		preciosProductos.put("Churros", 2500.0);
		preciosProductos.put("Donas", 3000.0);
		preciosProductos.put("Tinto", 1000.0);
		preciosProductos.put("Café", 1500.0);
		preciosProductos.put("Chocolate", 2000.0);
		preciosProductos.put("Jugos naturales", 2500.0);
	}

	public void agregarAlCarrito(String producto, int cantidad) {
		if (preciosProductos.containsKey(producto)) {
			carrito.add(producto);
			cantidades.add(cantidad);
			total += preciosProductos.get(producto) * cantidad;
			System.out.println(producto + " agregado al carrito (Cantidad: " + cantidad + ")");
		} else {
			System.out.println("Producto no válido.");
		}
	}

	public void verResumen() {
		System.out.println("----- Resumen del Carrito -----");
		for (int i = 0; i < carrito.size(); i++) {
			String producto = carrito.get(i);
			int cantidad = cantidades.get(i);
			double precioUnitario = preciosProductos.get(producto);
			double subtotal = precioUnitario * cantidad;
			System.out.println(producto + " x" + cantidad + ": $" + subtotal);
		}
		System.out.println("Total a pagar: $" + total);
		System.out.println("------------------------------");
	}



	public void eliminarDelCarrito(String producto) {
		String productoBuscado = producto.trim().toLowerCase(); // Limpia y convierte a minúsculas
		int index = -1;
		for (int i = 0; i < carrito.size(); i++) {
			if (carrito.get(i).toLowerCase().equals(productoBuscado)) {
				index = i;
				break;
			}
		}

		if (index != -1) {
			total -= preciosProductos.get(carrito.get(index)) * cantidades.get(index);
			carrito.remove(index);
			cantidades.remove(index);
			System.out.println(producto + " eliminado del carrito.");
		} else {
			System.out.println("Producto no encontrado en el carrito.");
		}

		// Muestra los productos actualizados en el carrito
		verResumen();
	}


	public void modificarCantidad(String producto, int nuevaCantidad) {
		int index = carrito.indexOf(producto);
		if (index != -1) {
			double precioUnitario = preciosProductos.get(producto);
			double subtotalAnterior = precioUnitario * cantidades.get(index);
			cantidades.set(index, nuevaCantidad);
			double nuevoSubtotal = precioUnitario * nuevaCantidad;
			total += nuevoSubtotal - subtotalAnterior;
			System.out.println("Cantidad de " + producto + " modificada a " + nuevaCantidad);
		} else {
			System.out.println("Producto no encontrado en el carrito.");
		}
	}
	public void gestionarProductosSeleccionados() {
		ArrayList<String> productosSeleccionados = Recommendations.getProductosSeleccionados();

		System.out.println("----- Cart Management -----");

		if (productosSeleccionados.isEmpty()) {
			System.out.println("You have not selected any products from the Recommendations section.");
			return;
		}

		System.out.println("----- Selected Products -----");
		verResumen();
		System.out.println("-------------------------------");

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("----- Gestión del Carrito -----");
			System.out.println(" ");
			System.out.println("1. Agregar producto al carrito");
			System.out.println("2. Eliminar producto del carrito");
			System.out.println("3. Modificar cantidad de un producto");
			System.out.println("4. Ver productos en carrito");
			System.out.println("5. Finalizar pedido");
			System.out.print("Elija una opción: ");

			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar el salto de línea

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el nombre del producto: ");
				String producto = scanner.nextLine();
				System.out.print("Ingrese la cantidad: ");
				int cantidad = scanner.nextInt();
				agregarAlCarrito(producto, cantidad);
				break;
			case 2:
				System.out.print("Ingrese el nombre del producto a eliminar: ");
				String productoEliminar = scanner.nextLine();
				eliminarDelCarrito(productoEliminar);
				break;
			case 3:
				System.out.print("Ingrese el nombre del producto cuya cantidad desea modificar: ");
				String productoModificar = scanner.nextLine();
				System.out.print("Ingrese la nueva cantidad: ");
				int nuevaCantidad = scanner.nextInt();
				modificarCantidad(productoModificar, nuevaCantidad);
				break;
			case 4:
				verResumen();
				break;
			case 5:
				System.out.println("¡Pedido finalizado!\n" + "Gracias por su compra");
				return;
			default:
				System.out.println("Opción no válida.");
			}

		}

	}

}