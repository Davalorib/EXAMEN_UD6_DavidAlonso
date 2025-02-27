package T4Programacion.pizzaexpres;

import java.util.Scanner;

public class AppPizzaExpress {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        Empleado empleado1 = new Empleado("Carlos");
        Empleado empleado2 = new Empleado("Sabrina");

        System.out.println("*** BIENVENIDO A LA PIZZERÍA POPEYE DE MUTXAMEL ***");
        empleado1.obtenerDetalles();
        empleado2.obtenerDetalles();

        System.out.println();

        System.out.println("Haz tu pedido... ¿cómo te llamas?");
        String nombre1 = ent.next();
        System.out.println();
        Cliente cliente1 = new Cliente(nombre1);
        Pedido pedido1 = new Pedido(cliente1);

        boolean si;
        double precio1;
        do {
            si = false;
            cliente1.pedir();

            try {
                String pizza1 = ent.next().toUpperCase();
                CartaPizzas pizza1bien = CartaPizzas.valueOf(pizza1);
                pedido1.meterPizza(pizza1bien);
            } catch (IllegalArgumentException e){
                System.out.println("El producto escogido no está disponible.");
            }

            precio1 = pedido1.precio();
            System.out.println("El precio actual de la cuenta es de " + precio1 + "€. ¿Quieres añadir otra pizza a tu pedido? [S/N]");
            if (ent.next().equalsIgnoreCase("s")) si = true;

        }while (si);

        if (precio1==0){
            System.out.println("NO has añadido ningún producto. Pedido finalizado");
            cliente1.cancelar(pedido1);
            System.out.println("El pedido ha sido "+pedido1.getEstadoPedido());
            System.exit(0);
        }

        System.out.println();
        empleado1.siguienteEstado(pedido1);
        System.out.println("Pedido "+pedido1.getEstadoPedido()+". Total pedido: "+precio1+"€.");
        cliente1.preciofinal(precio1);
        System.out.println("Pasa por caja para pagar y recoger tu pedido cuando esté listo. Muchas gracias "+cliente1.getNombre());
        System.out.println();
        for (int i = 0; i < 3; i++) {
            if (i==2) {
                try {
                    empleado1.entregarPedido(pedido1);
                } catch (NoListoExcepcion e){
                    System.out.println("El pedido todavía no está listo para entregarse. Estado: "+pedido1.getEstadoPedido());
                }
            }
            empleado1.siguienteEstado(pedido1);
            System.out.println(pedido1.getEstadoPedido()+"...");
        }

        System.out.println();

        empleado1.siguienteEstado(pedido1);
        System.out.println(pedido1.getEstadoPedido()+"!!!");
        cliente1.pagar();
        empleado1.entregarPedido(pedido1);
        cliente1.recoger();
    }

}