package co.edu.upb.foodfusionu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Information {
	
	 private User currentUser; 

	    public Information(User user) {
	        this.currentUser = user;
	 }

	// Menu
	private String[] comentarios = new String[100];
	private int numeroComentarios = 0;
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

	public void agregarComentario(String comentario) {
		if (numeroComentarios < comentarios.length) {
	        comentarios[numeroComentarios] = comentario + " - " + currentUser.getName(); 
	        numeroComentarios++;

	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("comentarios.txt", true));
	            writer.write(comentario + " - " + currentUser.getName());
	            writer.newLine();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error al guardar el comentario en el archivo.");
	        }
	    } else {
	        System.out.println("No se pueden agregar más comentarios.");
	    }
	}

	public void mostrarComentarios() {
		System.out.println("Comentarios:");
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("comentarios.txt"));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error al leer los comentarios desde el archivo.");
	    }
	}
	//Division food

	//Vegetales 
	public void agregarComentarioV(String comentario) {
		if (numeroComentariosV < comentariosV.length) {
	        comentariosV[numeroComentariosV] = comentario;
	        numeroComentariosV++;

	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter("comentarios.txt", true));
	            writer.write(comentario);
	            writer.newLine();
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Error al guardar el comentario en el archivo.");
	        }
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
		System.out.println("Comentarios:");
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("comentarios.txt"));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        reader.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error al leer los comentarios desde el archivo.");
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