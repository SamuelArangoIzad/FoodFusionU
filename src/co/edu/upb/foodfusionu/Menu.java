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

	System.out.println("______[PANEL]______");

	int option = 0;

	do {
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
	Offers.verofertas();
	break;

	case 4:
	int subOption;

	do {
	Spaces spaces = new Spaces();
	System.out.println("___[OPCIONES]___");
	System.out.println(" ");
	System.out.println("1. Ver Espacios Reservados");
	System.out.println("2. Alquilar un Espacio");
	System.out.println("3. Comentarios");
	System.out.println("4. Regresar al menú principal");
	System.out.print("Escribe aquí: ");
	subOption = scanner.nextInt();
	scanner.nextLine();

	switch (subOption) {
	case 1:
	System.out.println("");
	spaces.mostrarInformacionReservas();
	System.out.println(" ");
	break;

	case 2:
	int dayOfWeek = 0;
	int spaceIndex = 0;
	int startHour = 0;
	int endHour = 0;
	String blockSpace = "";

	System.out.println("RESERVAR UN ESPACIO");
	System.out.println("Selecciona un Bloque: ");
	System.out.println("1. Bloque A");
	System.out.println("2. Bloque L");
	System.out.println("3. Bloque I");
	System.out.println("4. Bloque K");
    System.out.print("Escribe la opción: ");
	int blockOption = scanner.nextInt();	
	scanner.nextLine();

    switch (blockOption) {
	case 1:
	blockSpace = "Bloque A";
	break;
	case 2:
	blockSpace = "Bloque L";
	break;
	case 3:
	blockSpace = "Bloque I";
	break;
	case 4:
	blockSpace = "Bloque K";
	break;
	default:
	System.out.println("Opción de Bloque inválida. Reservación fallida.");
	break;
    }

	if (!blockSpace.isEmpty()) {
	if (spaces.espacioReservado(dayOfWeek, spaceIndex, startHour, endHour, blockSpace)) {
	System.out.println("Ocupado");
	} else {
	System.out.println("Ingresa el Día de la Semana");
	System.out.println("1. Lunes");
	System.out.println("2. Martes");
	System.out.println("3. Miércoles");
	System.out.println("4. Jueves");
	System.out.println("5. Viernes");
	System.out.print("Escribe aquí la opción: ");
    dayOfWeek = scanner.nextInt();

	System.out.print("Ingresa el Índice del Espacio (1-5): ");
	spaceIndex = scanner.nextInt();

	System.out.print("Ingresa la Hora de Inicio (6 AM - 6 PM): ");
	startHour = scanner.nextInt();

	System.out.print("Ingresa la Hora de Fin (6 AM - 6 PM): ");
    endHour = scanner.nextInt();

	if (dayOfWeek >= 1 && dayOfWeek <= 5) {
	boolean reservationsSuccess = spaces.reserveSpace(dayOfWeek, spaceIndex, startHour, endHour, blockSpace);

    if (reservationsSuccess) {
	System.out.println("Espacio reservado con éxito en " + blockSpace + "!");
	} else {
	System.out.println("Error al reservar espacio. Por favor, verifica la entrada o la disponibilidad del espacio.");
	}
	} else {
	System.out.println("Opción de Día inválida. Reservación fallida.");
	}
	}
	}
	break;

	case 3:
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
	information.mostrarComentariosE();
	break;

	case 2:
		
	scanner.nextLine();
	System.out.print("Agregar comentario: ");
	String nuevoComentarioE = scanner.nextLine();
	information.agregarComentarioE(nuevoComentarioE);
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

	case 4:
		
	System.out.println("Regresando...");
	
	break;

	default:
	System.out.println("Escribe una opción válida;");
	break;
	}
	} while (subOption != 4);
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
