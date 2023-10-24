package co.edu.upb.foodfusionu;

import java.io.IOException;
import java.util.Scanner;

import co.edu.upb.foodfusionu.Request.FoodFusionUApp;

public class Menu {

	// En esta clase se define el menú principal y se procesan las selecciones del usuario.
	// Se utiliza un bucle do-while para mostrar el menú y procesar las selecciones del usuario.
	// El bucle se ejecutará hasta que el usuario seleccione la opción 0 para salir.

	static Scanner scanner = new Scanner(System.in);

	public static void vermenu(User authenticatedUser) throws IOException {
		
		User currentUser = authenticatedUser;
		if (authenticatedUser == null) {
			System.out.println("Acceso denegado. Por favor, inicie sesion");
			return;
		}

		int option = 0;

		do {

			System.out.println("______[PANEL]______");

			System.out.println("");
			System.out.println("1. Menu y pedido\n");    // Juan
			
			System.out.println("2. Ofertas\n");     // Tomas
			
			System.out.println("3. Espacios\n");    // Samuel
			
			System.out.println("4. Recomendaciones\n");   // Sergio
			
			System.out.println("5. Carrito de Compras\n");// Sergio
			
			System.out.println("6. Información\n");
			
			System.out.println("0. Salir\n");

			System.out.print("Escribe una opcion: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {


			case 1:	
				FoodFusionUApp app = new Request().new FoodFusionUApp();
				app.ejecutar();

				break;

			case 2:
				Offers.verOfertas();
				break;

			case 3:

				Spaces reservaUniversidad = new Spaces();		
				reservaUniversidad.main(null);	

				break;


				//____________________________________________________________________________________________________________________________________________________________________________________________________

			case 4:

				Recommendations recommendations = new Recommendations();
				recommendations.recomendaciones();

				break;

			case 5:

				CarritoDeCompras carritoDeCompras = new CarritoDeCompras();
				carritoDeCompras.gestionarProductosSeleccionados();
				break;


				//____________________________________________________________________________________________________________________________________________________________________________________________________

			case 6:

				if (currentUser != null) {
			        Information information = new Information(currentUser);
			    
				int infoOption;

				do {
					System.out.println("\nMenu:");
					System.out.println("1. Mostrar Comentarios");
					System.out.println("2. Agregar Comentario");
					System.out.println("3. Salir");
					System.out.print("Selecciona una opcion: ");
					infoOption = scanner.nextInt();
					switch (infoOption) {

					case 1:
						System.out.println("Escribe tu comentario:");
						information.mostrarComentarios();
						break;

					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentario = scanner.nextLine();
						information.agregarComentario(nuevoComentario);
						System.out.println("Comentario agregado.");
						break;

					case 3:
						System.out.println("Volviendo...");
						break;

					default:
						System.out.println("Opción no valida. Intentalo de nuevo.");
						break;
					}
				} while (infoOption != 3);}
				break;

			case 0:
				System.out.println("Saliendo...");
				Principal.main(null);
				return;

			default:
				System.out.println("Opción inválida. Escribe una opcion valida");
				break;
			}

		} while (option != 0);

	}
	//=======================================================================================================================================

	




}







