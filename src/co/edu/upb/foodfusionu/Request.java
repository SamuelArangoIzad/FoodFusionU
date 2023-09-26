package co.edu.upb.foodfusionu;

import java.util.*;

public class Request {

	 public void realizarPedido() {
	        Scanner scanner = new Scanner(System.in);
	        List<OrderItem> cart = new ArrayList<>();

	        Map<String, Food[]> menus = new HashMap<>();

	        menus.put("Comida Vegetariana", new Food[]{
	                new Food("Ensalada de verduras frescas", "Ensalada refrescante con una variedad de verduras frescas.", 9.99, 250, 120),
	                new Food("Ensalada de Quinua y Vegetales", "Ensalada nutritiva con quinua y una seleccion de vegetales.", 10.99, 300, 180),
	                new Food("Tacos con lentejas", "Tacos vegetarianos rellenos de lentejas y sabores frescos.", 8.99, 350, 220),
	                new Food("Pizza vegetariana", "Pizza con una variedad de verduras y queso.", 11.99, 400, 280),
	                new Food("Ensalada Basica", "Ensalada sencilla pero deliciosa.", 7.99, 200, 160),
	                new Food("Barras nutritivas", "Barras energéticas llenas de ingredientes saludables.", 6.49, 150, 190)
	        });

	        menus.put("Dulces", new Food[]{
	                new Food("Brownie de chocolate", "Delicioso brownie de chocolate.", 4.99, 200, 250),
	                new Food("Helado de frutas", "Helado refrescante con sabores naturales de frutas.", 3.99, 180, 210),
	                new Food("Crepes de nutella", "Crepes rellenos de Nutella y platanos.", 5.49, 250, 280),
	                new Food("Churro relleno", "Churro crujiente relleno de crema.", 2.99, 220, 200),
	                new Food("Obleas", "Obleas con arequipe.", 3.49, 180, 220),
	                new Food("Postre de limon", "Postre refrescante con sabor a limon.", 4.79, 230, 190)
	        });

	        menus.put("Salados", new Food[]{
	                new Food("Papas de paquete", "Papas crujientes con condimentos.", 4.99, 300, 350),
	                new Food("Empanada", "Empanada rellena de carne y papas.", 3.99, 220, 180),
	                new Food("Arepa e huevo", "Arepa rellena de huevo.", 5.49, 260, 240),
	                new Food("Sandwich", "Sandwich con una variedad de ingredientes.", 6.99, 350, 320),
	                new Food("Croissant", "Croissant recién horneado.", 3.49, 180, 210),
	                new Food("Nachos con queso", "Nachos crujientes con queso derretido.", 4.79, 220, 280)
	        });

	        menus.put("Nutritiva", new Food[]{
	                new Food("Ensalada de quinoa y aguacate", "Ensalada nutritiva con quinua, aguacate y verduras frescas.", 8.99, 280, 220),
	                new Food("Ensalada de proteina", "Ensalada rica en proteínas con pollo a la parrilla.", 9.99, 300, 260),
	                new Food("Batidos Nutritivos", "Batidos ideales para recuperarse despues del ejercicio.", 6.49, 250, 200),
	                new Food("Bowls de avena y fruta", "Bowls llenos de avena y frutas frescas.", 7.99, 320, 280),
	                new Food("Sandwich de pavo", "Sandwich de pavo con ingredientes saludables.", 5.99, 280, 240),
	                new Food("Sopa de lentejas", "Sopa reconfortante llena de lentejas y verduras.", 4.29, 200, 180)
	        });

	        menus.put("Comida Rapida", new Food[]{
	                new Food("Hamburguesa en combo", "Hamburguesa jugosa con papas y bebida.", 10.99, 600, 750),
	                new Food("Perro caliente en combo", "Perro caliente con papas y bebida.", 8.99, 550, 680),
	                new Food("Salchipapa", "Papas con salchicha y salsas.", 6.49, 450, 550),
	                new Food("Papas locas", "Papas con diversos condimentos.", 5.99, 400, 500),
	                new Food("Pizza", "Pizza con una variedad de ingredientes.", 11.99, 750, 800),
	                new Food("Tacos", "Tacos rellenos de carne y diversas especias.", 9.99, 600, 720),
	                new Food("Hot dog", "Perro caliente con ingredientes variados.", 7.49, 500, 620)
	        });

	        menus.put("Bebidas", new Food[]{
	                new Food("Energizantes", "Bebida energizante para revitalizarte.", 2.99, 180, 220),
	                new Food("Gaseosa", "Bebida refrescante de cola.", 1.99, 150, 180),
	                new Food("Agua", "Agua pura y refrescante", 1.49, 0, 0),
	                new Food("Granizados", "Bebida congelada con sabores.", 3.49, 250, 300),
	                new Food("Jugos naturales", "Bebida congelada con sabores.", 2.49, 200, 240),
	                new Food("Té verde", "Té verde caliente o frio.", 1.99, 180, 210)
	        });

	        System.out.println("------Bienvenido al sistema de pedidos de alimentos en linea---------");

	        while (true) {
	            System.out.println("Elija una categoria de menu (Comida Vegetariana, Dulces, Salados, Nutritiva, Comida Rapida, Bebidas), o escriba 'Salir' para finalizar:");
	            String selectedCategory = scanner.nextLine();

	            if (selectedCategory.equalsIgnoreCase("Salir")) {
	                break;
	            }
	            if (!menus.containsKey(selectedCategory)) {
	                System.out.println("Categoria no valida. Intente nuevamente.");
	                continue;
	            }
	            Food[] menu = menus.get(selectedCategory);

	            System.out.println("Menu de alimentos para " + selectedCategory + ":");
	           
	            for (int i = 0; i < menu.length; i++) {
	                System.out.println((i + 1) + ". " + menu[i].getName() + " - $" + menu[i].getPrice());
	                System.out.println(" Caracteristicas: " + menu[i].getDescription());
	                System.out.println(" Gramos: " + menu[i].getGrams() + "g");
	                System.out.println(" Calorias: " + menu[i].getCalories() + " kcal");
	            }

	            System.out.println("Ingrese el numero del artículo que desea agregar al carrito (0 para finalizar):");
	            int choice = scanner.nextInt();
	            if (choice == 0) {
	                break;
	            }
	            if (choice < 1 || choice > menu.length) {
	                System.out.println("Opcion no válida. Intente nuevamente.");
	                continue;
	            }
	            System.out.println("Ingrese la cantidad:");
	            int quantity = scanner.nextInt();
	            if (quantity <= 0) {
	                System.out.println("La cantidad debe ser mayor que cero. Intente nuevamente.");
	                continue;
	            }

	            Food selectedFood = menu[choice - 1];
	            OrderItem orderItem = new OrderItem(selectedFood, quantity);
	            cart.add(orderItem);
	            scanner.nextLine();
	        }

	        double total = calculateTotal(cart);

	        System.out.println("Su pedido ha sido confirmado.");
	        System.out.println("Total a pagar: $" + total);

	        System.out.println("Seleccione el metodo de pago:");
	        System.out.println("1. Pago en efectivo");
	        System.out.println("2. Pago en línea");
	        int metodoPago = scanner.nextInt();

	        if (metodoPago == 1) {
	            System.out.println("Pagara en efectivo al recoger su pedido.");
	        } else if (metodoPago == 2) {
	            realizarPago(total);
	        } else {
	            System.out.println("Opcion de pago no válida.");
	        }

	        System.out.println("Tiempo estimado de recogida: 30 minutos");
	        
	    }

	    public static double calculateTotal(List<OrderItem> items) {
	        double total = 0.0;
	        for (OrderItem item : items) {
	            total += item.getFoodItem().getPrice() * item.getQuantity();
	        }
	        return total;
	    }

	    static class Food {
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
	        System.out.println("Ingrese su numero de tarjeta de débito:");
	        String numeroTarjeta = scanner.nextLine();
	        System.out.println("Ingrese la fecha de vencimiento (MM/AA):");
	        String fechaVencimiento = scanner.nextLine();
	        System.out.println("Ingrese el codigo de seguridad (CVV):");
	        String cvv = scanner.nextLine();

	        System.out.println("Pago exitoso. Se ha cargado $" + total + " a su tarjeta debito.");
	       
	    }

	   /* public static void main(String[] args) {
	        Request pedido = new Request();
	        pedido.realizarPedido();
	    }
	    */
          
}


