package co.edu.upb.foodfusionu;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Recommendations {
	private static ArrayList<String> productosSeleccionados = new ArrayList<>();

	public static void recomendaciones() {
		CarritoDeCompras carrito = new CarritoDeCompras();
		Scanner scanner = new Scanner(System.in);
	    ArrayList<String> productosSeleccionados = new ArrayList<>(); // Almacena productos seleccionados
	    ArrayList<Double> preciosSeleccionados = new ArrayList<>(); // Almacena precios de productos seleccionados

		double total = 0.0;

		while (true) {
			// Mostrar las opciones al usuario
			System.out.println("Recomendaciones del día:");
			System.out.println(" ");
			System.out.println("1. Empanadas(Buena Opción para desayunar ;D)");
			System.out.println("2. Arepas(Para quedar bien satisfecho)");
			System.out.println("3. De dulce(Más elegido para onces )");
			System.out.println("4. Bebidas (Lo mejor para cualquier momento)");
			System.out.println("5. Ver y gestionar el carrito de compras");
			System.out.println(" ");
			System.out.println("0. Salir");

			System.out.print("Elija una opción: ");

			//Esta parte muestra un menu de categorias de empanadas etc etc y la opcion de salir y solicita que
			//los usuarios ingresen un numero que represente la categoria deseada lee la entrada del usuario utilizando un objeto scanner
			//y tambien con la funcion de objeto scanner valida las opciones y el programa termina y regresa al menu principal en caso
			//de opcion 0

			int opcionSeleccionada = scanner.nextInt();
			scanner.nextLine(); // Limpiar el salto de línea

			// Validar la opción seleccionada
			if (opcionSeleccionada == 0) {
				System.out.println("¡Hasta luego!");
				break;
			}

			// Mostrar productos basados en la opción seleccionada
			switch (opcionSeleccionada) {
			case 1: // Empanadas
				String[] empanadas = {
						"1. Empanada de carne - $2,500",
						"2. Empanada de pollo - $2,000",
						"3. Empanada de queso - $2,000",
						"4. Empanada de jamón y queso - $2,500",
						"5. Empanada de champiñones - $2,500"
				};
				for (String empanada : empanadas) {
					System.out.println(empanada);
				}
				break;

			case 2: // Arepas
				String[] arepas = {
						"1. Arepas de queso - $3,000",
						"2. Arepas de choclo - $3,500 (La favorita de muchos)",
						"3. Arepas de carne desmechada - $4,000",
						"4. Arepas de jamón y queso - $3,500",
						"5. Arepas de pollo - $3,000"
				};
				for (String arepa : arepas) {
					System.out.println(arepa);
				}
				break;

			case 3: // Dulces
				System.out.println("1. Churros - $2,500");
				System.out.println("2. Donas - $3,000");
				// Agrega otros dulces aquí con sus precios
				break;

			case 4: // Bebidas
				String[] bebidas = {
						"1. Tinto - $1,000",
						"2. Café - $1,500",
						"3. Chocolate - $2,000",
						"4. Jugos naturales - $2,500"
				};
				for (String bebida : bebidas) {
					System.out.println(bebida);
				}
				break;

			case 5:
				carrito.gestionarProductosSeleccionados();;
				break;
			default:
				break;
			}
			// se le agregan valores a los productos

			// Solicitar al usuario que seleccione un producto
			System.out.print("Seleccione un producto (o 0 para finalizar el pedido): ");
			int productoSeleccionado = scanner.nextInt();
			scanner.nextLine(); // Limpiar el salto de línea

			if (productoSeleccionado == 0) {
				break; // Termina el pedido si el usuario selecciona 0
			}

			// Registra el producto seleccionado y su precio en el pedido
			if (opcionSeleccionada >= 1 && opcionSeleccionada <= 4) {
			    String producto = obtenerProducto(opcionSeleccionada, productoSeleccionado);
			    double precio = obtenerPrecio(opcionSeleccionada, productoSeleccionado);

			    productosSeleccionados.add(producto); // Agrega productos seleccionados
			    preciosSeleccionados.add(precio); // Agrega precios de productos seleccionados

			    carrito.agregarAlCarrito(producto, 1);
			    agregarProductoSeleccionado(producto); // Agregar a la lista de productos seleccionados

			    // Agregar producto seleccionado al archivo de texto con su precio
			    Recommendations.guardarProductosEnArchivo("productos_seleccionados.txt", productosSeleccionados, preciosSeleccionados);
			}

			// Mostrar el pedido y calcular el total a pagar
			System.out.println("Pedido enviado correctamente alcarrito de compras");
			carrito.agregarProductosDesdeRecomendaciones(productosSeleccionados, preciosSeleccionados);
			
		}
		
	
	}
	
	public static boolean guardarProductosEnArchivo(String nombreArchivoDestino, ArrayList<String> productos, ArrayList<Double> precios) {
	    String escritorio = System.getProperty("user.home") + "\\Documents\\" + nombreArchivoDestino;
	    try {
	        FileWriter fileWriter = new FileWriter(escritorio, true);
	        for (int i = 0; i < productos.size(); i++) {
	            fileWriter.write(productos.get(i) + " - $" + precios.get(i) + "\n");
	        }
	        fileWriter.close();
	        System.out.println("Archivo guardado con éxito en el escritorio.");
	        return true;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	//  Muestra qué se ordenó
	public static String obtenerProducto(int opcion, int seleccion) {
		switch (opcion) {
		case 1: // Empanadas
			String[] empanadas = {
					"Empanada de carne",
					"Empanada de pollo",
					"Empanada de queso",
					"Empanada de jamón y queso",
					"Empanada de champiñones"
			};
			return empanadas[seleccion - 1];

		case 2: // Arepas
			String[] arepas = {
					"Arepas de queso",
					"Arepas de choclo",
					"Arepas de carne desmechada",
					"Arepas de jamón y queso",
					"Arepas de pollo"
			};
			return arepas[seleccion - 1];

		case 3: // De dulce
			if (seleccion == 1) {
				return "Churros";
			} else if (seleccion == 2) {
				return "Donas";
			}
			// Agrega otros dulces aquí

		case 4: // Bebidas
			String[] bebidas = {
					"Tinto",
					"Café",
					"Chocolate",
					"Jugos naturales"
			};
			return bebidas[seleccion - 1];

		default:
			return "";
		}
	}

	// Obtener el precio del producto basado en la opción y la selección del usuario
	public static double obtenerPrecio(int opcion, int seleccion) {
		switch (opcion) {
		case 1: // Empanadas
			double[] preciosEmpanadas = {2500, 2000, 2000, 2500, 2500};
			return preciosEmpanadas[seleccion - 1];

		case 2: // Arepas
			double[] preciosArepas = {3000, 3500, 4000, 3500, 3000};
			return preciosArepas[seleccion - 1];

		case 3: // Dulces
			if (seleccion == 1) {
				return 2500; // Precio de Churros
			} else if (seleccion == 2) {
				return 3000; // Precio de Donas
			}
			// Agrega otros dulces aquí

		case 4: // Bebidas
			double[] preciosBebidas = {1000, 1500, 2000, 2500};
			return preciosBebidas[seleccion - 1];

		default:
			return 0.0;
		}
	}
	public static void agregarProductoSeleccionado(String producto) {
		productosSeleccionados.add(producto);
	}

	public static ArrayList<String> getProductosSeleccionados() {
		return productosSeleccionados;
	}

}