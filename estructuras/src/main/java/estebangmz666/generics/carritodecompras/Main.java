package estebangmz666.generics.carritodecompras;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CarritoDeCompras<Producto> carrito = new CarritoDeCompras<>();
        
        Producto p1 = new Producto("Laptop", 3500.99, UUID.randomUUID());
        Producto p2 = new Producto("Mouse Gamer", 150.75, UUID.randomUUID());
        Producto p3 = new Producto("Teclado Mecánico", 200.00, UUID.randomUUID());
        Producto p4 = new Producto("Monitor 4K", 800.00, UUID.randomUUID());
        Producto p5 = new Producto("Producto absurdamente caro", 999999.99, UUID.randomUUID());

        carrito.agregarProducto(p1);
        carrito.agregarProducto(p2);
        carrito.agregarProducto(p3);
        carrito.agregarProducto(p4);
        carrito.agregarProducto(p5);

        carrito.mostrarProductos();

        System.out.println("Producto más caro:");
        System.out.println(carrito.obtenerProductoMasCaro());

        double total = carrito.obtenerTotal(Producto::getPrecio);
        System.out.println("Total: $" + total);
    }
}