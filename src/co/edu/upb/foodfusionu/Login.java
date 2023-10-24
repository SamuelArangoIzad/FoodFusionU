package co.edu.upb.foodfusionu;

import java.util.Scanner;

public class Login {

	static Scanner scanner=new Scanner (System.in);

	private static User[] users = new User[100];
	private static int userCount=0;


	public static void initializeUsers() {
		users[0] = new User( 1,"Mateo","123");
		users[1] = new User( 2,"Cristian","123");
		users[2] = new User( 3,"Samuel","123");
		users[3] = new User( 4,"Sergio","123");
		users[4] = new User( 5,"Johan","123");
		userCount = 100;

	}


	public static User login() {

		System.out.print("Write Your Id: ");
		int userId = scanner.nextInt();
		scanner.nextLine();   


		System.out.print("Write Your UserName: ");
		String username = scanner.nextLine();

		//Esto limpia el bufer del scanner

		System.out.print("Write Your Password: ");
		String password = scanner.nextLine();


		//Aqui se importa las clases Scanner donde se podra permitir la entrada de distintos datos por parte del 
		//usuario en la clase login tiene un metodo estatic llamado login que toma dos arreglos como parametros id un arreglo de enteros
		//y name un arreglo de cadenas de texto estos arreglos se utilizan para almacenar IDs de usuario y nombres de usuario el metodo login solicita al usuario que ingrese su
		//ID y su nombre primero se solicita8 ID mediante scanner.nextInt() y luego se solicita el nombre mediante scanner.nextLine()se crea las variables y consecuentemente
		//se inicializa en 0 esta variable se utiliza para rastrear el indice donde se almacenaran los datos del usuario en los arreglos id y name se utiliza el bucle while para buscar un espacio
		//disponible y se utiliza el bucle while para buscar un espacio donde

		//Disponibilidad en el indice de arrays



		for(int ii=0;ii<userCount;ii++) {
			User user = users[ii];

			if(user != null && user.getId() == userId && user.getName().equals(username)&&user.getPassword().equals(password)) {
				return user;	
			}


		}

		System.out.println("Authentication Failed. Invalid ID or PassWord.");

		return null;

	}
	//y asi se encuentra un espacio disponible completamente el motodo login devuelve el valor de seccion que representa la posicion donde se almacenaron los datos del usuario en los arreglos



	//Almacenar los datos en los arrays



	public static void addUser(User user) {

		if(userCount < users.length) {
			users[userCount] = user;
			userCount++;
			System.out.println("User Registered Successfully.");

		}else {
			System.out.println("User Registration Failed. User Limit reached.");	
		}


	}
}


//=======================================================================================================================================

