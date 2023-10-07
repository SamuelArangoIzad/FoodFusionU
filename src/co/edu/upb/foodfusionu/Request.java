package co.edu.upb.foodfusionu;

import java.util.*;

public class Request {
	public class PedidoDeComidaEnLinea{

	    private final Map<String, Food[]> menus = new HashMap<>();
	    private final List<OrderItem> cart = new ArrayList<>();
	    private final Scanner scanner = new Scanner(System.in);

	    private void inicializarMenus() {
	    	menus.put("Comida Vegetariana", new Food[]{
	                new Food("Ensalada de verduras frescas", " Esta refrescante ensalada esta compuesta por una mezcla de verduras frescas, como lechuga, tomate, pepino, zanahoria y pimiento. Se sirve con un aderezo ligero de vinagreta. ", 10000.00, 250, 120),
	                new Food("Ensalada de Quinua y Vegetales", " Esta nutritiva ensalada contiene quinua cocida mezclada con una seleccion de vegetales frescos como espinacas, pimientos, tomates cherry y aguacate. Se aliña con una vinagreta de limon y aceite de oliva. ", 23000.00, 300, 180),
	                new Food("Tacos con lentejas", "Estos tacos vegetarianos están rellenos de lentejas cocidas sazonadas con especias frescas como cilantro, comino y cayena. Se sirven en tortillas de maiz con acompañamientos como salsa de aguacate y cebolla morada.", 15000.00, 350, 220),
	                new Food("Pizza vegetariana", " Esta pizza está cubierta con una variedad de verduras frescas, como pimientos, champiñones, cebolla y aceitunas negras. Se hornea con queso derretido y salsa de tomate casera.", 20000.00, 400, 280),
	                new Food("Ensalada Basica", "Esta ensalada sencilla está compuesta por lechuga, tomate y pepino, aliñada con una vinagreta ligera de aceite de oliva y vinagre balsamico.", 7000.00, 200, 160),
	        });

	        menus.put("Dulces", new Food[]{
	                new Food("Brownie de chocolate", "Este delicioso brownie esta hecho con chocolate de alta calidad, mantequilla, azucar y huevos. Es denso y tiene un centro suave y chocolateado.", 6000.00, 200, 250),
	                new Food("Helado de frutas", "Este helado refrescante se prepara con una mezcla de frutas frescas y sabores naturales. Es una opción saludable y deliciosa para satisfacer tu antojo de postre.", 12000.00, 180, 210),
	                new Food("Crepes de nutella", "Estos crepes se rellenan con Nutella y platanos maduros. Se sirven espolvoreados con azucar glas y a menudo se comparten con helado.", 13000.00, 250, 280),
	                new Food("Churro relleno", "Estos churros son crujientes por fuera y suaves por dentro. Estan rellenos de crema de chocolate o vainilla y se espolvorean con azucar.", 2500.00, 220, 200),
	                new Food("Obleas", "Las obleas son delgadas galletas crujientes rellenas de arequipe, un dulce de leche suave y caramelizado.", 12000.00, 180, 220),
	        });

	        menus.put("Salados", new Food[]{
	                new Food("Papas de paquete", "Estas papas son crujientes y se sazonan con una mezcla de condimentos que incluye sal, pimienta y especias. Son un aperitivo delicioso y crujiente.", 2500.00, 300, 350),
	                new Food("Empanada", "Las empanadas son pasteles de masa rellenos de carne y papas, sazonados con cebolla, pimientos y especias. Se hornean hasta que la masa esté dorada y crujiente.", 3000.00, 220, 180),
	                new Food("Arepa e huevo", " Esta arepa está rellena de huevo y se cocina hasta que la masa este dorada y el huevo este cocido en el centro. Es un plato tradicional en algunas regiones.", 4500.00, 260, 240),
	                new Food("Sandwich", "El sandwich es una deliciosa combinacion de ingredientes como carne, jamon, queso, lechuga, tomate y otros ingredientes de tu elección. Puedes personalizarlo a tu gusto.", 5000.00, 350, 320),
	                new Food("Croissant", "Este croissant recien horneado esta hecho con una masa hojaldrada y se sirve caliente y crujiente. Es perfecto para el desayuno.", 4000.00, 180, 210),
	        });

	        menus.put("Nutritiva", new Food[]{
	                new Food("Ensalada de quinoa y aguacate", "Esta ensalada nutritiva contiene quinua cocida, aguacate, verduras frescas y se adereza con una vinagreta ligera. Es rica en proteinas y vitaminas.", 22500.00, 280, 220),
	                new Food("Ensalada de proteina", "Esta ensalada esta llena de proteínas y contiene pollo a la parrilla, lechuga, tomate, huevo duro y otros ingredientes frescos. Se sirve con un aderezo de tu eleccion.", 15000.00, 300, 260),
	                new Food("Batidos Nutritivos", "Estos batidos son ideales para la recuperación despues del ejercicio. Pueden contener una mezcla de frutas frescas, yogur, proteína en polvo y otros ingredientes saludables.", 12000.00, 250, 200),
	                new Food("Bowls de avena y fruta", "Estos bowls contienen avena cocida, frutas frescas como plátanos, fresas y nueces. Son una opción saludable y saciante para el desayuno o el almuerzo.", 9000.00, 320, 280),
	                new Food("Sandwich de pavo", "Este sandwich esta relleno de pavo magro, aguacate, lechuga y tomate. Es una opción baja en grasa y rica en proteinas.", 11000.00, 280, 240),
	        });

	        menus.put("Comida Rapida", new Food[]{
	                new Food("Hamburguesa en combo", "Esta jugosa hamburguesa se sirve en un combo que incluye papas fritas y una bebida.", 15000.00, 600, 750),
	                new Food("Perro caliente en combo", "El perro caliente es un clásico hot dog acompañado de papas fritas y una bebida. ", 14000.00, 550, 680),
	                new Food("Salchipapa", "Las salchipapas son una deliciosa combinación de papas fritas y salchichas. Se sirven con diversas salsas como ketchup, mostaza y mayonesa.", 12000.00, 450, 550),
	                new Food("Papas locas", "Estas papas se sirven con una variedad de condimentos y salsas que pueden incluir queso derretido, bacon, cebolla caramelizada y otros ingredientes creativos.", 19000.00, 400, 500),
	                new Food("Pizza", "La pizza se prepara con una variedad de ingredientes que pueden incluir pepperoni, champiñones, jamón, pimientos, cebolla y queso derretido sobre una base de masa crujiente.", 20000.00, 750, 800),
	                new Food("Tacos (3 unidades)", "Estos tacos están rellenos de carne sazonada con diversas especias y se sirven en tortillas de maíz o harina. Pueden acompañarse con ingredientes como lechuga, tomate, cebolla y salsa.", 15000.00, 600, 720),
	        });

	        menus.put("Bebidas", new Food[]{
	                new Food("Energizantes", "Bebida energizante para revitalizarte.", 5000.00, 180, 220),
	                new Food("Gaseosa", "Bebida refrescante de cola.", 2500.00, 150, 180),
	                new Food("Agua", "Agua pura y refrescante", 2000.00, 0, 0),
	                new Food("Granizados", "Bebida congelada sabor naranja.", 10000.00, 250, 300),
	                new Food("Jugos naturales", "Bebida fria sabor mandarina.", 6000.00, 200, 240),
	        });

	    }
	    public void realizarPedido() {
	        inicializarMenus();
	        System.out.println("-------------------Bienvenido al sistema de pedidos de alimentos en linea-------------------");

	        boolean pedidoRealizado = false; // Variable para rastrear si se ha realizado un pedido

	        while (true) {
	            mostrarCategoriasMenu();
	            String selectedCategory = scanner.nextLine();

	            if (selectedCategory.equalsIgnoreCase("Salir")) {
	                break;
	            } else if (!menus.containsKey(selectedCategory)) {
	                System.out.println("Categoria no valida. Intente nuevamente.");
	                continue;
	            }

	            mostrarMenu(selectedCategory);
	            int choice = leerEntero("Ingrese el numero del articulo que desee comprar(0 para finalizar):");
	            if (choice == 0) {
	                break;
	            } else if (choice < 1 || choice > menus.get(selectedCategory).length) {
	                System.out.println("Opcion no valida. Intente nuevamente.");
	                continue;
	            }

	            int quantity = leerEntero("Ingrese la cantidad:");
	            if (quantity <= 0) {
	                System.out.println("La cantidad debe ser mayor que cero. Intente nuevamente.");
	                continue;
	            }

	            agregarAlCarrito(selectedCategory, choice, quantity);
	            pedidoRealizado = true; // Se ha realizado un pedido
	        }

	        if (pedidoRealizado) {
	            double total = calcularTotal(cart);
	            System.out.println("Su pedido ha sido confirmado.");
	            System.out.println("Total a pagar: $" + total);
	            seleccionarMetodoDePago(total);
	        } else {
	            System.out.println("No se ha realizado ningun pedido. Gracias por usar FoodFusion.");
	        }
	    }

	    private void mostrarCategoriasMenu() {
	        System.out.println("Que tipo de comida te gusta (Comida Vegetariana, Dulces, Salados, Nutritiva, Comida Rapida, Bebidas) o escribe 'Salir' para finalizar el pedido:");
	    }

	    private void mostrarMenu(String selectedCategory) {
	        Food[] menu = menus.get(selectedCategory);
	        System.out.println("Menu de alimentos para " + selectedCategory + ":");
	        for (int i = 0; i < menu.length; i++) {
	            System.out.println((i + 1) + ". " + menu[i].getName() + " - $" + menu[i].getPrice());
	            System.out.println(" Caracteristicas: " + menu[i].getDescription());
	            System.out.println(" Gramos: " + menu[i].getGrams() + "g");
	            System.out.println(" Calorias: " + menu[i].getCalories() + " kcal");
	        }
	    }

	    private int leerEntero(String mensaje) {
	        int input = 0;
	        while (true) {
	            try {
	                System.out.println(mensaje);
	                input = Integer.parseInt(scanner.nextLine());
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Por favor, ingrese un numero válido.");
	            }
	        }
	        return input;
	    }

	    private void agregarAlCarrito(String selectedCategory, int choice, int quantity) {
	        Food selectedFood = menus.get(selectedCategory)[choice - 1];
	        OrderItem orderItem = new OrderItem(selectedFood, quantity);
	        cart.add(orderItem);
	    }

	    private double calcularTotal(List<OrderItem> items) {
	        double total = 0.0;
	        for (OrderItem item : items) {
	            total += item.getFoodItem().getPrice() * item.getQuantity();
	        }
	        return total;
	    }

	    private void seleccionarMetodoDePago(double total) {
	        System.out.println("Seleccione el metodo de pago:");
	        System.out.println("1. Pago en efectivo");
	        System.out.println("2. Pago en linea");
	        int metodoPago = leerEntero("");

	        if (metodoPago == 1) {
	            System.out.println("Pagara en efectivo al recoger su pedido, acuerdate que debes pagar un total de: " + total);

	        } else if (metodoPago == 2) {
	            realizarPago(total);
	        } else {
	            System.out.println("Opcion de pago no valida.");
	        }

	        System.out.println("Tiempo estimado de recogida: 30 minutos");
	    }

	    private void realizarPago(double total) {
	        System.out.println("Ingrese su numero de tarjeta de debito:");
	        String numeroTarjeta = scanner.nextLine();
	        System.out.println("Ingrese la fecha de vencimiento (MM/AA):");
	        String fechaVencimiento = scanner.nextLine();
	        System.out.println("Ingrese el codigo de seguridad (CVV):");
	        String cvv = scanner.nextLine();

	        System.out.println("Pago exitoso. Se ha cargado $" + total + " a su tarjeta de debito.");
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
	}
}