package co.edu.upb.foodfusionu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Foods {

	public  void vercomidas() {

		ListaComidas listaComidas = new ListaComidas();

		// Comida Vegetariana
		listaComidas.agregarPlato("Ensalada de verduras frescas", "Vegetarianas");
		listaComidas.agregarPlato("Ensalada de Quinua y Vegetales", "Vegetarianas");
		listaComidas.agregarPlato("Tacos con lentejas", "Vegetarianas");
		listaComidas.agregarPlato("Pizza vegetariana", "Vegetarianas");
		listaComidas.agregarPlato("Ensalada Basica", "Vegetarianas");

		// Dulces
		listaComidas.agregarPlato("Brownie de chocolate", "Postres");
		listaComidas.agregarPlato("Helado de frutas", "Postres");
		listaComidas.agregarPlato("Crepes de nutella", "Postres");
		listaComidas.agregarPlato("Churro relleno", "Postres");
		listaComidas.agregarPlato("Obleas", "Postres");

		// Salados
		listaComidas.agregarPlato("Papas de paquete", "Salados");
		listaComidas.agregarPlato("Empanada", "Salados");
		listaComidas.agregarPlato("Arepa e huevo", "Salados");
		listaComidas.agregarPlato("Sandwich", "Salados");
		listaComidas.agregarPlato("Croissant", "Salados");

		// Nutritiva
		listaComidas.agregarPlato("Ensalada de quinoa y aguacate", "Nutritivas");
		listaComidas.agregarPlato("Ensalada de proteina", "Nutritivas");
		listaComidas.agregarPlato("Batidos Nutritivos", "Nutritivas");
		listaComidas.agregarPlato("Bowls de avena y fruta", "Nutritivas");
		listaComidas.agregarPlato("Sandwich de pavo", "Nutritivas");

		// Comida Rapida
		listaComidas.agregarPlato("Hamburguesa en combo", "Comida rapida");
		listaComidas.agregarPlato("Perro calinete en combo", "Comida rapida");
		listaComidas.agregarPlato("Salchipapa", "Comida rapida");
		listaComidas.agregarPlato("Papas locas", "Comida rapida");
		listaComidas.agregarPlato("Pizza", "Comida rapida");
		listaComidas.agregarPlato("Tacos", "Comida rapida");

		//Bebidas
		listaComidas.agregarPlato("Energizantes", "Bebidas");
		listaComidas.agregarPlato("Gaseosa", "Bebidas");
		listaComidas.agregarPlato("Agua", "Bebidas");
		listaComidas.agregarPlato("Granizados", "Bebidas");
		listaComidas.agregarPlato("Jugos naturales", "Bebidas");

		// Obtener platos por tipo

		List<Platos> platosVegetarianos = listaComidas.obtenerPlatosPorTipo("Vegetarianas");
		List<Platos> postres = listaComidas.obtenerPlatosPorTipo("Postres");
		List<Platos> platosSalados = listaComidas.obtenerPlatosPorTipo("Salados");
		List<Platos> platosNutritivos = listaComidas.obtenerPlatosPorTipo("Nutritivas");
		List<Platos> ComidaRapida = listaComidas.obtenerPlatosPorTipo("Comida Rapida");
		List<Platos> Bebidas = listaComidas.obtenerPlatosPorTipo("Bebidas");

		// Imprimir los platos de cada tipo

		System.out.println(" ");
		System.out.println("Platos Vegetarianos:");
		System.out.println(" ");
		for (Platos plato : platosVegetarianos) {
			System.out.println(plato.getNombre());
		}

		System.out.println(" ");
		System.out.println("Postres:");
		System.out.println(" ");
		for (Platos plato : postres) {
			System.out.println(plato.getNombre());
		}

		System.out.println(" ");
		System.out.println("Platos Salados:");
		System.out.println(" ");
		for (Platos plato : platosSalados) {
			System.out.println(plato.getNombre());
		}

		System.out.println(" ");
		System.out.println("Platos Nutritivos:");
		System.out.println(" ");
		for (Platos plato : platosNutritivos) {
			System.out.println(plato.getNombre());
		}

		System.out.println(" ");
		System.out.println("Comida Rapida:");
		System.out.println(" ");
		for (Platos plato : ComidaRapida) {
			System.out.println(plato.getNombre());
		}

		System.out.println(" ");
		System.out.println("Bebidas:");
		System.out.println(" ");
		for (Platos plato : Bebidas) {
			System.out.println(plato.getNombre());
		}
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println(" ");
			System.out.println("Elige el tipo de plato:");
			System.out.println("1. Vegetarianas");
			System.out.println("2. Postres");
			System.out.println("3. Comida Salada");
			System.out.println("4. Comida Nutritiva");
			System.out.println("5. Comida Rapida");
			System.out.println("6. Bebidas");
			System.out.println("0. Salir");
			System.out.print("Write Your Option: ");

			//Esta es parte de juan contreras esto funciona con una clase principal llamada Foods
			//en el metodo ver comidas se crea una instancia de la clase listacomidas que se utiliza para almacenar los platos
			//se agregan los platos a la lista de comidas utilizando el metodo agregarplato cada plato tiene un nombre y una categoria quese pasa como argumentos
			//se crean listas separadas para cada categoria de plato como platos vegetarianos postres etc utilizando

			//el metodo obtenerplatos´portipo de la clase listacomidas luego se imprime una lista de platos para cada categoria en la consola utilizando bucles for each se inicia
			//un bucle infinito que muestre un meno interactivo en la consola el usuario puede elegir una categoria de plato ingresando un numero de 1 al 6 o salir del programa
			//usando 0
			//la clase platos utiliza para representar cada plato con propiedades nombre y tipo y la clase de lista de comidas se utiliza para mantener una lista
			//de platos y proporciona metodos para agregar platos y obtener platos por categoria
			int opcionTipoPlato = scanner.nextInt();
			Information information = new Information(null);
			int opcion;
			//Se tiene pensado que cuando el usuario eliga por ejemplo una comida de la lista de comidas me diga la informacion respecto a la comida categorias, calorias, proteina, grasa de la comida
			// nutrientes entre otros asuntos como el azucar y la sal y en que le puede beneficiar y en que cosas no por comida por eso se puede elegir dentro de las comidas cada comida y luego salir 
			if (opcionTipoPlato == 0) {
				System.out.println("¡Hasta luego!");
				break;
			}
			List<Platos> platosElegidos = null;
			String tipoPlatoElegido = "";

			switch (opcionTipoPlato) {

			case 1:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Vegetarianas");
				tipoPlatoElegido = "Vegetarianas";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}
				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosV();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioV = scanner.nextLine();
						information.agregarComentarioV(nuevoComentarioV);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);
				break;

			case 2:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Postres");
				tipoPlatoElegido = "Postres";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}
				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosP();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioP = scanner.nextLine();
						information.agregarComentarioP(nuevoComentarioP);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);
				break;
			case 3:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Salados");
				tipoPlatoElegido = "Salados";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}
				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosS();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioS = scanner.nextLine();
						information.agregarComentarioS(nuevoComentarioS);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);
				break;
			case 4:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Nutritivas");
				tipoPlatoElegido = "Nutritivas";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}

				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosN();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioN = scanner.nextLine();
						information.agregarComentarioN(nuevoComentarioN);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);

				break;
			case 5:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Comida Rapida");
				tipoPlatoElegido = "Comida Rapida";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}

				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosCR();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioCR = scanner.nextLine();
						information.agregarComentarioCR(nuevoComentarioCR);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);
				break;

			case 6:
				platosElegidos = listaComidas.obtenerPlatosPorTipo("Bebidas");
				tipoPlatoElegido = "Bebidas";

				System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");
				for (int i = 0; i < platosElegidos.size(); i++) {
					System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
				}

				do {
					System.out.println("\nComentarios de los platos:");
					System.out.println("1. Mostrar comentarios");
					System.out.println("2. Agregar comentario");
					System.out.println("3. Salir");
					System.out.print("Seleccione una opción: ");
					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Escribe tu comentario: ");
						information.mostrarComentariosB();
						break;
					case 2:
						scanner.nextLine();
						System.out.print("Agregar comentario: ");
						String nuevoComentarioB = scanner.nextLine();
						information.agregarComentarioB(nuevoComentarioB);
						System.out.println("Comentario agregado.");
						break;
					case 3:
						break;
					default:
						System.out.println("Opción no válida. Intente otra vez.");
					}
				} while (opcion != 3);
				break;

			default:
				System.out.print("Opción no válida. Por favor elige una opción válida: ");
				continue;
			}

			System.out.println("Platos disponibles en la categoría " + tipoPlatoElegido + ":");

			for (int i = 0; i < platosElegidos.size(); i++) {
				System.out.println((i + 1) + ". " + platosElegidos.get(i).getNombre());
			}

			System.out.print("Elige un plato por su número (0 para volver al menú anterior): ");

			int opcionPlato = scanner.nextInt();

			if (opcionPlato == 0) {
				continue;
			}

			if (opcionPlato > 0 && opcionPlato <= platosElegidos.size()) {
				Platos platoElegido = platosElegidos.get(opcionPlato - 1);
				System.out.println("Has elegido: " + platoElegido.getNombre());
			} else {
				System.out.print("Opción no válida. Por favor elige un número válido: ");
			}
		}
	}
}

class Platos {
	private String nombre;
	private String tipo;

	public Platos(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}
}

class ListaComidas {
	private List<Platos> platos;

	public ListaComidas() {
		platos = new ArrayList<>();
	}

	public void agregarPlato(String nombre, String tipo) {
		platos.add(new Platos(nombre, tipo));
	}

	public List<Platos> obtenerPlatosPorTipo(String tipo) {
		List<Platos> platosPorTipo = new ArrayList<>();
		for (Platos plato : platos) {
			if (plato.getTipo().equalsIgnoreCase(tipo)) {
				platosPorTipo.add(plato);
			}
		}
		return platosPorTipo;
	}
}
//=======================================================================================================================================