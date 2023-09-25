package co.edu.upb.foodfusionu;

import java.util.Scanner;

public class Offers {

    static Scanner scanner = new Scanner(System.in);

        public static void verofertas() {
        int opcion = 0;

        String[] diasSemana = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};

        String[][] menuComidas = {
        {"Desayuno: Tostadas de aguacate y huevo.", "Almuerzo: Ensalada de pollo a la parrilla.", "Merienda: Batido de proteínas con frutas."},
        {"Desayuno: Batido de frutas y yogur.", "Almuerzo: Tacos de pavo con guarnición de quinua.", "Merienda: Manzana con mantequilla de almendras."},
        {"Desayuno: Avena con plátano y nueces.", "Almuerzo: Ensalada de atún con garbanzos.", "Merienda: Yogur griego con miel y almendras."},
        {"Desayuno: Yogur con granola y frutas.", "Almuerzo: Sandwich de pavo con aguacate.", "Merienda: Palitos de zanahoria con hummus."},
        {"Desayuno: Tortilla de espinacas y tomate.", "Almuerzo: Sopa de pollo con verduras.", "Merienda: Puñado de almendras y nueces."}
        };

        double[][] preciosComidas = {
        {5.99, 8.99, 3.49},
        {4.99, 9.99, 2.99},
        {6.99, 10.99, 4.49},
        {4.49, 7.99, 2.29},
        {5.49, 9.49, 3.99}
        };

        String[][] descuentos = {
        {"Descuento de Comida Rápida: 2x1 en pizzas medianas los lunes por la noche en una pizzería local.", "Descuento de Restaurante: 15% de descuento en la cuenta total en un restaurante de cocina mexicana."},
        {"Descuento de Desayuno: Desayuno completo a mitad de precio los martes por la mañana en una cafetería local.", "Descuento de Comida Rápida: Compra una hamburguesa y papas fritas y obtén un batido gratis en un local de comida rápida."},
        {"Descuento de Almuerzo: Menú ejecutivo con un 20% de descuento en un restaurante de comida internacional.", "Descuento de Postre: Compra un postre y obtén el segundo postre al 50% de descuento en una pastelería."},
        {"Descuento de Cena: 10% de descuento en la cuenta total de una cena en un restaurante de mariscos.", "Descuento de Comida Saludable: Compra una ensalada grande y obtén una bebida saludable gratis en un restaurante de comida saludable."},
        {"Descuento de Viernes Feliz: Descuento del 15% en bebidas y aperitivos durante el horario feliz en un bar y grill local.", "Descuento de Comida Asiática: 2x1 en platos de sushi los viernes por la noche en un restaurante de comida asiática."}
        };

        double[] porcentajesDescuento = {10, 15, 20, 10, 15};

        do {
        System.out.println("\n     °MENU PRINCIPAL°       ");
        System.out.println("1. Menu de Comidas");
        System.out.println("2. Descuentos");
        System.out.println("0. Salir");
        System.out.println("-----------------------------");
        System.out.print("Elija una opción: ");
        opcion = scanner.nextInt();

        if (opcion == 1) {
        mostrarMenuDeComidas(menuComidas, diasSemana, preciosComidas, porcentajesDescuento);
        } else if (opcion == 2) {
        mostrarDescuentos(descuentos, diasSemana, porcentajesDescuento);
        } else if (opcion != 0) {
        System.out.println("OPCIÓN INVÁLIDA \n REGRESANDO AL MENÚ");
        }

        } while (opcion != 0);
        }

        public static void mostrarMenuDeComidas(String[][] menuComidas, String[] diasSemana, double[][] preciosComidas, double[] porcentajesDescuento) {
        System.out.println("\n_______MENU DE COMIDAS_______");

        for (int i = 0; i < diasSemana.length; i++) {
            System.out.println((i + 1) + ". " + diasSemana[i]);
        }
        System.out.print("Elija un día de la semana: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= diasSemana.length) {
        System.out.println("\nDía: " + diasSemana[opcion - 1]);
        System.out.println("\n[MENU DE COMIDAS]");
        String[] comidas = menuComidas[opcion - 1];
        double[] precios = preciosComidas[opcion - 1];
        double descuento = porcentajesDescuento[opcion - 1];

        for (int i = 0; i < comidas.length; i++) {
        double precioOriginal = precios[i];
        double precioConDescuento = (precioOriginal * 0.5);
        System.out.println("Precio de Oferta");
        System.out.println(comidas[i] + " - Precio Original: $" + precioOriginal + " - Precio actual : $" + precioConDescuento);
        }
        } else {
        System.out.println("OPCIÓN INVÁLIDA \n REGRESANDO AL MENÚ");
        }
        }

        public static void mostrarDescuentos(String[][] descuentos, String[] diasSemana, double[] porcentajesDescuento) {
        System.out.println("\n_______DESCUENTOS_______");

        for (int i = 0; i < diasSemana.length; i++) {
        System.out.println((i + 1) + ". " + diasSemana[i]);
        }
        System.out.print("Elija un día de la semana: ");
        int opcion = scanner.nextInt();

        if (opcion >= 1 && opcion <= diasSemana.length) {
        System.out.println("\nDía: " + diasSemana[opcion - 1]);
        System.out.println("\nDESCUENTOS");
        String[] desc = descuentos[opcion - 1];
            

        for (int i = 0; i < desc.length; i++) {
        System.out.println(desc[i]);
        }
        }
        }
}