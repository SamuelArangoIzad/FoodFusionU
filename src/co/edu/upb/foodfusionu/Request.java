package co.edu.upb.foodfusionu;
import java.util.*;

public class Request {

    public void realizarPedido() {
        Scanner scanner = new Scanner(System.in);
        List<OrderItem> cart = new ArrayList<>();

        Map<String, Food[]> menus = new HashMap<>();

        menus.put(" Lunes", new Food[]{
        new Food("Tostadas de aguacate y huevo", "Nutritivo y rico en proteinas y grasas saludables", 5.99, 200, 400),
        new Food("Ensalada de pollo a la parrilla", "Baja en calorias y alta en proteinas y vitaminas", 7.99, 300, 220),
        new Food("Batido de proteinas con frutas", "Ideal para recuperarse despues del ejercicio", 4.99, 350, 260)
        });

        menus.put(" Martes", new Food[]{
        new Food("Batido de frutas y yogur", "Refrescante y lleno de vitaminas y probioticos", 6.49, 250, 380),
        new Food("Tacos de pavo con guarnicion de quinoa", "Bajos en grasa y ricos en fibra y proteinas", 8.99, 350, 320),
        new Food("Manzana con mantequilla de almendras", "Satisfactorio y equilibrado", 2.99, 180, 160)
        });

        menus.put(" Miercoles", new Food[]{
        new Food("Avena con platano y nueces", "Energetico y alto en fibra y grasas saludables", 5.49, 300, 420),
        new Food("Ensalada de atun con garbanzos", "Rica en proteinas y fibra, baja en grasas", 10.00, 600, 1500),
        new Food("Yogur griego con miel y almendras", "Lleno de proteinas y energía", 3.99, 250, 280)
        });

        menus.put(" Jueves", new Food[]{
        new Food("Yogur con granola y frutas", "Satisfactorio y rico en proteinas y fibras", 4.79, 280, 360),
        new Food("Sandwich de pavo con aguacate", "Sano y lleno de proteínas y grasas saludables", 6.99, 350, 320),
        new Food("Palitos de zanahoria con hummus", "Nutritivo y bajo en calorias", 3.49, 200, 180)
        });

        menus.put(" Viernes", new Food[]{
        new Food("Tortilla de espinacas y tomate", "Lleno de proteinas y vitaminas", 5.79, 280, 320),
        new Food("Sopa de pollo con verduras", "Reconfortante y rico en proteinas", 7.49, 350, 280),
        new Food("Puñado de almendras y nueces", "Lleno de grasas saludables y proteinas", 4.29, 220, 180)
        });

        System.out.println("------Bienvenido al sistema de pedidos de alimentos en linea---------");

        while (true) {
        	
        System.out.print("Elija el día de la semana(Lunes,etc) o 'Salir' para finalizar:");
        String selectedDay = scanner.nextLine();

        if (selectedDay.equalsIgnoreCase(" Salir")) {
        break;
        }

        if (!menus.containsKey(selectedDay)) {
        System.out.println("Día no válido. Intente nuevamente.");
        continue;
        }

        Food[] menu = menus.get(selectedDay);

        System.out.println("Menu de alimentos para " + selectedDay + ":");

        for (int i = 0; i < menu.length; i++) {
        System.out.println((i + 1) + ". " + menu[i].getName() + " - $" + menu[i].getPrice());
        System.out.println(" Características: " + menu[i].getDescription());
        System.out.println(" Gramos: " + menu[i].getGrams() + "g");
        System.out.println(" Calorías: " + menu[i].getCalories() + " kcal");
        }

        System.out.print("Ingrese número del artículo que agregara al carrito (0 para finalizar):");
        int choice = scanner.nextInt();
        if (choice == 0) {
        break;
        }
        if (choice < 1 || choice > menu.length) {
        System.out.println("Opción no válida. Intente nuevamente.");
        continue;
        }
        System.out.print("Ingrese la cantidad:");
        int quantity = scanner.nextInt();
        if (quantity <= 0) {
        System.out.println("La cantidad debe ser mayor que cero. Intente nuevamente.");
        continue;
        }

        Food selectedFood = menu[choice - 1];
        OrderItem orderItem = new OrderItem(selectedFood, quantity);
        cart.add(orderItem);
        scanner.nextLine(); // Consumir la nueva línea

        System.out.println("Artículo agregado al carrito.");
         }

         double total = calculateTotal(cart);

         System.out.println("Su pedido ha sido confirmado.");
         System.out.println("Total a pagar: $" + total);

         int metodoPago;
         while (true) {
         System.out.println("Seleccione el método de pago:");
         System.out.println("1. Pago en efectivo");
         System.out.println("2. Pago en línea");
         System.out.print("Write Here: ");
         metodoPago = scanner.nextInt();

         if (metodoPago == 1 || metodoPago == 2) {
         break;
         } else {
         System.out.println("Opción de pago no válida. Intente nuevamente.");
         }
         }

         if (metodoPago == 1) {
         System.out.println("Pagará en efectivo al recoger su pedido.");
         } else if (metodoPago == 2) {
         realizarPago(total);
         }

         int valorDado = (int)Math.floor(Math.random()*58+1);
         System.out.println("Tiempo estimado de recogida: " + valorDado + " Minutos");
         
         }

         public static double calculateTotal(List<OrderItem> items) {
         double total = 0.0;
         for (OrderItem item : items) {
         total += item.getFoodItem().getPrice() * item.getQuantity();
         }
         return total;
         }



         static class Food{
    	
         private String name;
         private String description;
         private double price;
         private int grams;
         private int calories;
         public Food(String name, String description, double price, int grams, int calories) {
         this.name = name;
         this.description = description;
         this.price = price;
         this.grams = grams;
         this.calories = calories;
         }

          public String getName() {
          return name;
          }

          public String getDescription() {
          return description;
          }

          public double getPrice() {
          return price;
          }

          public int getGrams() {
          return grams;
          }

          public int getCalories() {
          return calories;
          }
          }	
    	
    	
          static class OrderItem {
          private Food foodItem;
          private int quantity;

          public OrderItem(Food foodItem, int quantity) {
          this.foodItem = foodItem;
          this.quantity = quantity;
          }

          public Food getFoodItem() {
          return foodItem;
          }

          public int getQuantity() {
          return quantity;
          }
          }
    

          public static void realizarPago(double total) {
          Scanner scanner = new Scanner(System.in);
          System.out.print("Ingrese su numero de tarjeta de debito:");
          String numeroTarjeta = scanner.nextLine();
          System.out.print("Ingrese la fecha de vencimiento (MM/AA):");
          String fechaVencimiento = scanner.nextLine();
          System.out.print("Ingrese el codigo de seguridad (CVV):");
          String cvv = scanner.nextLine();

          System.out.println("Pago exitoso. Se ha cargado $" + total + " a su tarjeta debito.");
          System.out.println("En esta tarjeta: " + numeroTarjeta + " Con esta Fecha de vencimiento: " + fechaVencimiento +" Con este codigo" + cvv);
        
          
          }
          
}


