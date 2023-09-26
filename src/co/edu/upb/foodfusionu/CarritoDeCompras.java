package co.edu.upb.foodfusionu;

import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {
    private Map<String, Integer> items = new HashMap<>();
    private Map<String, Double> precios = new HashMap<>();

    public void agregarItem(String producto, int cantidad, double precio) {
        if (items.containsKey(producto)) {
            items.put(producto, items.get(producto) + cantidad);
        } else {
            items.put(producto, cantidad);
            precios.put(producto, precio);
        }
    }

    public void eliminarItem(String producto) {
        if (items.containsKey(producto)) {
            items.remove(producto);
            precios.remove(producto);
        }
    }

    public void modificarCantidad(String producto, int nuevaCantidad) {
        if (items.containsKey(producto)) {
            items.put(producto, nuevaCantidad);
        }
    }

    public void mostrarResumen() {
        System.out.println("Resumen del carrito de compras:");
        for (String producto : items.keySet()) {
            int cantidad = items.get(producto);
            double precio = precios.get(producto);
            double subtotal = cantidad * precio;
            System.out.println(producto + " - Cantidad: " + cantidad + " - Precio unitario: $" + precio + " - Subtotal: $" + subtotal);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (String producto : items.keySet()) {
            int cantidad = items.get(producto);
            double precio = precios.get(producto);
            total += cantidad * precio;
        }
        return total;
    }
}