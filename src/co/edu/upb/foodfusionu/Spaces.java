package co.edu.upb.foodfusionu;


import java.io.*;
import java.util.*;

public class Spaces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al Sistema de Reserva de la Universidad");
            System.out.println(" ");
            System.out.println("1. Ver espacios almacenados");
            System.out.println("2. Alquilar un espacio");
            System.out.println("3. Eliminar un espacio");
            System.out.println("4. Regresar al menu principal");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (opcion) {
                case 1:
                    verEspaciosAlmacenados();
                    break;
                case 2:
                    alquilarEspacio(scanner);
                    break;
                case 3:
                	eliminarEspacio(scanner);
                    break;
                case 4:
                	return;
                	
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    private static void eliminarEspacio(Scanner scanner) {
        System.out.print("Ingrese el Bloque a eliminar (A, B, C, etc.): ");
        String bloque = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el Día de la Semana a eliminar (Lunes a Viernes): ");
        String diaSemana = scanner.nextLine();

        System.out.print("Ingrese el Espacio a eliminar: ");
        String espacio = scanner.nextLine();

        System.out.print("Ingrese el Horario a eliminar (Ejemplo, 9:00-10:30): ");
        String horario = scanner.nextLine();

        boolean eliminado = eliminarReserva(bloque, diaSemana, espacio, horario);

        if (eliminado) {
            System.out.println("O.K.");
        } else {
            System.out.println("La reserva no pudo ser encontrada o eliminada.");
        }
    }

    private static boolean eliminarReserva(String bloque, String diaSemana, String espacio, String horario) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 4
                        && partes[0].equalsIgnoreCase(bloque)
                        && partes[1].equalsIgnoreCase(diaSemana)
                        && partes[2].equalsIgnoreCase(espacio)
                        && partes[3].equalsIgnoreCase(horario)) {
                    // No agregamos esta línea a la lista, lo que la elimina
                } else {
                    lineas.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservas.txt"))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    

    private static void verEspaciosAlmacenados() {
    	 try (BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"))) {
    	        String line;
    	        int numReserva = 1;
    	        System.out.println("Espacios almacenados:");
    	        while ((line = reader.readLine()) != null) {
    	            String[] partes = line.split(",");
    	            if (partes.length == 4) {
    	                System.out.println("Reserva #" + numReserva + ":");
    	                System.out.println(partes[0] + "," + partes[1] + "," + partes[2] + "," + partes[3]);
    	                System.out.println();
    	                numReserva++;
    	            }
    	        }
    	        if (numReserva == 1) {
    	            System.out.println("No hay reservas almacenadas.");
    	        }
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }

    private static void alquilarEspacio(Scanner scanner) {
        System.out.print("Ingrese el Bloque (A, B, C, etc.): ");
        String bloque = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese el Día de la Semana (Lunes a Viernes): ");
        String diaSemana = scanner.nextLine();

        System.out.print("Ingrese el Espacio: ");
        String espacio = scanner.nextLine();

        System.out.print("Ingrese el Horario que usará el espacio (Ejemplo, 9:00-10:30): ");
        String horario = scanner.nextLine();

        boolean ocupado = verificarOcupado(bloque, diaSemana, espacio, horario);

        if (ocupado) {
            System.out.println("Lo siento, ese espacio ya está ocupado en ese horario.");
        } else {
            guardarReserva(bloque, diaSemana, espacio, horario);
            System.out.println("Reserva exitosa.");
        }
    }

    private static boolean verificarOcupado(String bloque, String diaSemana, String espacio, String horario) {
    	  try (BufferedReader reader = new BufferedReader(new FileReader("reservas.txt"))) {
    	        String line;
    	        while ((line = reader.readLine()) != null) {
    	            String[] partes = line.split(",");
    	            if (partes.length == 4
    	                    && partes[0].equalsIgnoreCase(bloque)
    	                    && partes[1].equalsIgnoreCase(diaSemana)
    	                    && partes[2].equalsIgnoreCase(espacio)) {
    	                String[] horariosReservados = partes[3].split("-");
    	                String[] horariosNuevo = horario.split("-");

    	                // Verificar superposición de horarios
    	                if (horariosNuevo.length == 2 && horariosReservados.length == 2) {
    	                    String inicioReservado = horariosReservados[0];
    	                    String finReservado = horariosReservados[1];
    	                    String inicioNuevo = horariosNuevo[0];
    	                    String finNuevo = horariosNuevo[1];

    	                    if ((inicioNuevo.compareTo(finReservado) < 0 && finNuevo.compareTo(inicioReservado) > 0) ||
    	                            (inicioReservado.compareTo(finNuevo) < 0 && finReservado.compareTo(inicioNuevo) > 0)) {
    	                        return true; // Hay superposición
    	                    }
    	                }
    	            }
    	        }
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    	    return false;
    }

    private static void guardarReserva(String bloque, String diaSemana, String espacio, String horario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservas.txt", true))) {
            writer.write(bloque + "," + diaSemana + "," + espacio + "," + horario);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
