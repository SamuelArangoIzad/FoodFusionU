package co.edu.upb.foodfusionu;

public class Information {

	// Menu
	private String[] comentarios = new String[100];
	private int numeroComentarios = 1;

	//Foods

	//Vegetales
	private String[] comentariosV = new String[100];
	private int numeroComentariosV= 0;
	//Postres
	private String[] comentariosP = new String[100];
	private int numeroComentariosP= 0;
	//Salados
	private String[] comentariosS = new String[100];
	private int numeroComentariosS= 0;
	//Nutritiva
	private String[] comentariosN = new String[100];
	private int numeroComentariosN= 0;
	//Comida Rapida
	private String[] comentariosCR = new String[100];
	private int numeroComentariosCR= 0;
	//Comida Rapida
	private String[] comentariosB = new String[100];
	private int numeroComentariosB= 0;
	//Espacios
	private String[] comentariosE = new String[100];
	private int numeroComentariosE= 0;

	//Menu

	public Information() {
		comentarios[0] = "Gracias a esta aplicación he tenido un mejor conocimiento de los productos vendidos por estudiantes, recomendada las hamburguesas son deliciosas";
	}

	public void agregarComentario(String comentario) {
		if (numeroComentarios < comentarios.length) {
			comentarios[numeroComentarios] = comentario;
			numeroComentarios++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentarios() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentarios; i++) {
			System.out.println(comentarios[i]);
			System.out.println(); 
		}
	}

	//Division food

	//Vegetales 
	public void agregarComentarioV(String comentario) {
		if (numeroComentariosV  < comentariosV.length) {
			comentariosV[numeroComentariosV ] = comentario;
			numeroComentariosV++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosV() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosV; i++) {
			System.out.println(comentariosV[i]);
			System.out.println(); 
		}
	}

	//Postres
	public void agregarComentarioP(String comentario) {
		if (numeroComentariosP  < comentariosP.length) {
			comentariosP[numeroComentariosP ] = comentario;
			numeroComentariosP++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosP() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosP; i++) {
			System.out.println(comentariosP[i]);
			System.out.println(); 
		}
	}

	//Salados
	public void agregarComentarioS(String comentario) {
		if (numeroComentariosS  < comentariosS.length) {
			comentariosS[numeroComentariosS ] = comentario;
			numeroComentariosS++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosS() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosS; i++) {
			System.out.println(comentariosS[i]);
			System.out.println(); 
		}
	}

	//Nutritiva

	public void agregarComentarioN(String comentario) {
		if (numeroComentariosN  < comentariosN.length) {
			comentariosN[numeroComentariosN ] = comentario;
			numeroComentariosN++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosN() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosN; i++) {
			System.out.println(comentariosN[i]);
			System.out.println(); 
		}
	}

	//Comida Rapida

	public void agregarComentarioCR(String comentario) {
		if (numeroComentariosCR  < comentariosCR.length) {
			comentariosCR[numeroComentariosCR ] = comentario;
			numeroComentariosCR++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosCR() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosCR; i++) {
			System.out.println(comentariosCR[i]);
			System.out.println(); 
		}
	}

	//Bebidas

	public void agregarComentarioB(String comentario) {
		if (numeroComentariosB  < comentariosB.length) {
			comentariosB[numeroComentariosB ] = comentario;
			numeroComentariosB++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosB() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosB; i++) {
			System.out.println(comentariosB[i]);
			System.out.println(); 
		}
	}

	//Espacios

	public void agregarComentarioE(String comentario) {
		if (numeroComentariosE  < comentariosE.length) {
			comentariosE[numeroComentariosE ] = comentario;
			numeroComentariosE++;
		} else {
			System.out.println("No se pueden agregar más comentarios.");
		}
	}

	public void mostrarComentariosE() {
		System.out.println("\nComentarios:");
		for (int i = 0; i < numeroComentariosE; i++) {
			System.out.println(comentariosE[i]);
			System.out.println(); 
		}
	}


}