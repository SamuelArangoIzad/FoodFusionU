
package co.edu.upb.foodfusionu;

import java.io.IOException;
import java.util.Scanner;


public class Principal {

	//El codigo comienza con la declaracion del paquete, que identifica el conjunto de clases que pertenecen a un proyecto determinado
	//en este caso, el paquete es co.edu.upb.foodFusionU

	//Continuacion el codigo importa dos clases de java java.io.IOException y java.util.scanner la primera clase se usa para manejar excepciones
	//de entreda/salida y la segunda se usa para leer entrada del usuario

	//La clase principal del programa es principal esta clase contiene el metodo main(), que es el punto de entrada del programa el metodo main comienza
	//crean el punto de entrada del programa y el metodo main comienza creando una variable int llamada opciondecontrol esta variable se usara para controlar si el 
	//usuario desea salir del programa o no a continaucion el metodo main entra en un bucle do while este bucle se ejecutara una y otra vez hasta que el usuario
	//seleccione la opcion 1 para salir del programa


	//En cada iteracion del bucle el metodo main() solicita al usuario que ingrese una opcion si el usuario ingresa la opcion 1 el metodo main() imprime el mensaje "Exit.."
	//luego el bucle termina y el programa se cierra




	static Scanner scanner=new Scanner (System.in);
	public static void main(String [] args) throws IOException{

		//Variable de control para saber si cerrar el programa o no

		int opciondecontrol=0;

		Login.initializeUsers();

		//=================================================================================================================================================

		//SALIDA O CONTINUACION DEL PROGRAMA 

		//=================================================================================================================================================






		//Si el usuario ingresa la opcion 2 el metodo main() llama al metodo login() el metodo login() recibe dos arreglos como parametros un arreglo de int que contiene los IDs
		//de usuario y un arreglo de String que contiene los nombres de usuario

		//=================================================================================================================================================

		//SECCION DE LOGIN

		//=================================================================================================================================================	


		System.out.println("LOGIN");

		//Usamos una array ya definida ya que un arraylist es de tipo dinamico
		//realmente implemente arraylist pero mejor se llego a la conclusion de implementar lo enseñado
		//para llevarlo a la practica y crear algo bueno que se adapte y cumpla con nuestras especificaciones y         
		//Y tambien que vaya acorde a lo aprendido

		User authenticatedUser = Login.login();
		if(authenticatedUser !=null) {
			System.out.println("Login Successful.");
			Menu.vermenu(authenticatedUser);

		}


		//=================================================================================================================================================

		//SECCION DE MENU 

		//=================================================================================================================================================








		//El metodo login() busca el ID de usuario , finalmente el metodo main() llama el metodo vermenu() el metodo vermenu() imprime el menu de la aplicacion de 
		//comida 



	}


}


//=======================================================================================================================================

