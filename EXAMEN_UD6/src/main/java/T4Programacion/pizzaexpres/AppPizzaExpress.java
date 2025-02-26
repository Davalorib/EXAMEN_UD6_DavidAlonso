package T4Programacion.pizzaexpres;

import java.util.Scanner;

public class AppPizzaExpress {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        Empleado empleado1 = new Empleado("Pedro");
        Empleado empleado2 = new Empleado("Ana");

        empleado1.obtenerDetalles();
        empleado2.obtenerDetalles();

        System.out.println();

        Pedido pedido1nombre = new Pedido();
        String nombre1 = pedido1nombre.preguntarNombre();
        Cliente cliente1 = new Cliente(nombre1);
        Pedido pedido1 = new Pedido(cliente1);
        cliente1.pedir();
        String pizza1 = ent.next();
        CartaPizzas pizza1bien = CartaPizzas.valueOf(pizza1);
        pedido1.meterPizza(pizza1bien);
        double precio1 = pedido1.precio();
        System.out.println("El precio de tus pizzas es de "+precio1+"€");

        Estado actual = pedido1.getEstadoPedido();
        actual = actual.siguiente(actual);
        System.out.println("Pedido "+actual+". Total pedido: "+precio1);
        cliente1.preciofinal(precio1);
        System.out.println("Pasa por caja para pagar y recoger tu pedido cuando esté LISTO. Muchas gracias "+cliente1.getNombre());
        for (int i = 0; i < 2; i++) {
            actual = actual.siguiente(actual);
            System.out.println("Pedido "+actual+". Total pedido: "+precio1);
        }
//        empleado1.entregarPedido(pedido1);
        for (int i = 0; i < 2; i++) {
            actual = actual.siguiente(actual);
            System.out.println("Pedido "+actual+". Total pedido: "+precio1);
        }
        cliente1.pagar();
        empleado1.entregarPedido(pedido1);
        cliente1.recoger();
    }

}