package T4Programacion.pizzaexpres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Getter @Setter @ToString
public class Cliente extends PizzaExpress implements AccionesPedido{

    Scanner ent = new Scanner(System.in);

    private static final int DESCUENTO_DEF = 20;

    private String nombre;
    private int descuento;


    public Cliente(String nombre) {
        this.nombre = nombre;
        this.descuento = DESCUENTO_DEF;
    }

    public void pedir(){
        System.out.println("Qué le apetece hoy al cliente?");
        for (CartaPizzas pizzas:CartaPizzas.values()){
            System.out.print(pizzas.name()+", ");
        }
    }

    public void preciofinal(Double precio){
        System.out.println("Total a pagar: "+precio*(100-getDescuento())/100+"€");
    }

    public void pagar(){
        System.out.println(nombre+" está pagando el pedido...");
    }

    public void recoger(){
        System.out.println(nombre+" está recogiendo el pedido...");
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
    }

    public void obtenerDetalles() {
        System.out.println("Cliente: ["+nombre+"]");
    }
}
