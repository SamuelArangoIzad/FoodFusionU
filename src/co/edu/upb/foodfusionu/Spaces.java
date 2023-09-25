package co.edu.upb.foodfusionu;

import java.io.*;
import java.util.Scanner;

public class Spaces {
	
	//____________________________________________________________________________________________________________________________________________________________________________________________________
    static int MAX_SPACES_PER_DAY = 6;
    static int DAYS_OF_WEEK = 6;
    static int HOURS_PER_DAY = 24;
    String block = " ";
    private boolean[][][] reservations;

    

	//____________________________________________________________________________________________________________________________________________________________________________________________________
    
    public Spaces() {
    reservations = new boolean[DAYS_OF_WEEK][MAX_SPACES_PER_DAY][HOURS_PER_DAY];
    }

    public boolean reserveSpace(int dayOfWeek, int spaceIndex, int startHour, int endHour, String block) {
    if (dayOfWeek < 0 || dayOfWeek >= DAYS_OF_WEEK || spaceIndex < 0 || spaceIndex >= MAX_SPACES_PER_DAY || startHour < 0 || startHour >= HOURS_PER_DAY || endHour < 0 || endHour >= HOURS_PER_DAY) {
    System.out.println("Entradas Inválidas, Verifique");
    return false;
    }

    if (reservationExists(dayOfWeek, spaceIndex, startHour, endHour, block)) {
    System.out.println("Esta Reserva Ya Existe");
    return false;
    }

        System.out.println("Confirmar reserva:");
        System.out.println("Día de la semana: " + dayOfWeek);
        System.out.println("Espacio: " + spaceIndex);
        System.out.println("Hora de inicio: " + startHour);
        System.out.println("Hora de fin: " + endHour);
        System.out.println("Bloque: " + block);
        System.out.print("¿Confirmar reserva? (Sí/No): ");

        Scanner scanner = new Scanner(System.in);
        String confirmacion = scanner.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("si") || confirmacion.equalsIgnoreCase("sí")) {
        for (int hour = startHour; hour < endHour; hour++) {
        reservations[dayOfWeek][spaceIndex][hour] = true;
        }
        if (saveReservationInfo(dayOfWeek, spaceIndex, startHour, endHour, block)) {
        this.setBlock(block);
        System.out.println("Reserva completa");
        return true;
        } else {
        System.out.println("Error al guardar la información");
        }
        } else {
        System.out.println("Reserva cancelada");
        }

        return false;
        }


	//____________________________________________________________________________________________________________________________________________________________________________________________________
    
    public boolean saveReservationInfo(int dayOfWeek, int spaceIndex, int startHour, int endHour, String block) {
    String fileName = "reservas.txt";
    System.out.println("Guardado ");

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
    printWriter.println("Reserva realizada:");
    printWriter.println("Día de la semana: " + dayOfWeek);
    printWriter.println("Espacio: " + spaceIndex);
    printWriter.println("Hora de inicio: " + startHour);
    printWriter.println("Hora de fin: " + endHour);
    printWriter.println("Bloque: " + block);
    printWriter.println();
    return true;
    } catch (IOException e) {
    e.printStackTrace();
    return false;
    }
    }

    public String getBlock() {
    return block;
    }

    public void setBlock(String block) {
    this.block = block;
    }

    

	//____________________________________________________________________________________________________________________________________________________________________________________________________
    
    public boolean reservationExists(int dayOfWeek, int spaceIndex, int startHour, int endHour, String block) {
    try (Scanner scanner = new Scanner(new File("reservas.txt"))) {
    while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.contains("Día de la semana: " + dayOfWeek) &&
    line.contains("Espacio: " + spaceIndex) &&
    line.contains("Hora de inicio: " + startHour) &&
    line.contains("Hora de fin: " + endHour) &&
    line.contains("Bloque: " + block)) {
    return true;
    }
    }
    } catch (FileNotFoundException e) {
    e.printStackTrace();
    }
    return false;
    }
    
    
    

	//____________________________________________________________________________________________________________________________________________________________________________________________________
    
    public void mostrarInformacionReservas() {
    String fileName = "reservas.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    String line;
    System.out.println("Información de Reservas:");
    while ((line = br.readLine()) != null) {
    System.out.println(line);
    }
    } catch (IOException e) {
    e.printStackTrace();
    }
    }
    
  //____________________________________________________________________________________________________________________________________________________________________________________________________
    
    public boolean espacioReservado(int dayOfWeek, int spaceIndex, int startHour, int endHour, String block) {
    try (Scanner scanner = new Scanner(new File("reservas.txt"))) {
    while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.contains("Día de la semana: " + dayOfWeek) &&
    line.contains("Espacio: " + spaceIndex) &&
    line.contains("Hora de inicio: " + startHour) &&
    line.contains("Hora de fin: " + endHour) &&
    line.contains("Bloque: " + block)) {
    return true; // El espacio ya está reservado
    }
    }
    } catch (FileNotFoundException e) {
    e.printStackTrace();
    }
    return false; // El espacio está disponible
    }
       
}
