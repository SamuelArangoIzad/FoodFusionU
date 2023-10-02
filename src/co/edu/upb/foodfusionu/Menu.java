package co.edu.upb.foodfusionu;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	// En esta clase se define el menú principal y se procesan las selecciones del usuario.
	// Se utiliza un bucle do-while para mostrar el menú y procesar las selecciones del usuario.
	// El bucle se ejecutará hasta que el usuario seleccione la opción 0 para salir.

	static Scanner scanner = new Scanner(System.in);

	public static void vermenu(User authenticatedUser) throws IOException {

	if (authenticatedUser == null) {
	System.out.println("Acceso denegado. Por favor, inicie sesión");
	return;
	}

	int option = 0;

	do {
		
	System.out.println("______[PANEL]______");

	System.out.println("");
	System.out.println("1. Comidas");    // Juan
	System.out.println("");
	System.out.println("2. Pedido");     // Tomas
	System.out.println("");
	System.out.println("3. Ofertas");    // Tomas
	System.out.println("");
	System.out.println("4. Espacios");   // Samuel
	System.out.println("");
	System.out.println("5. Recomendaciones");  // Sergio
	System.out.println("");
	System.out.println("6. Información");   // Johan
	System.out.println("");
	System.out.println("0. Salir");

	System.out.print("Escribe una opción: ");
	option = scanner.nextInt();
	scanner.nextLine();

	switch (option) {

	case 1:
	Foods foods = new Foods();
	foods.vercomidas();
	break;

	case 2:
	Request request = new Request();
	request.realizarPedido();
	break;

	case 3:
	Offers.verOfertas();
	break;

	case 4:
	
	Spaces reservaUniversidad = new Spaces();		
	reservaUniversidad.main(null);	
	
	break;
	

	//____________________________________________________________________________________________________________________________________________________________________________________________________
		
	case 5:
		
	Recommendations recommendations = new Recommendations();
	recommendations.recomendaciones();
		
	break;
		
	
	

	//____________________________________________________________________________________________________________________________________________________________________________________________________
		
	case 6:
		
	Information information = new Information();
    int infoOption;

	    do {
		System.out.println("\nMenú:");
		System.out.println("1. Mostrar Comentarios");
		System.out.println("2. Agregar Comentario");
		System.out.println("3. Salir");
		System.out.print("Selecciona una opción: ");
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
		System.out.println("Opción no válida. Inténtalo de nuevo.");
		break;
		}
		} while (infoOption != 3);
		break;

		case 0:
		System.out.println("Saliendo...");
		Principal.main(null);
		return;
		
		default:
		System.out.println("Opción inválida. Escribe una opción válida");
	    break;
		}
		
		} while (option != 0);
		
		}
		}



//=======================================================================================================================================




