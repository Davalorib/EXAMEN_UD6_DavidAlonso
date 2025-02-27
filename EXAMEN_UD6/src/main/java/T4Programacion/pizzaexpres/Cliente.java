package T4Programacion.pizzaexpres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Cliente extends PizzaExpress implements AccionesPedido{

    private static final int DESCUENTO_DEF = 20;

    private String nombre;
    private int descuento;


    public Cliente(String nombre) {
        this.nombre = nombre;
        this.descuento = DESCUENTO_DEF;
    }

    public void pedir(){
        System.out.println("¿Qué te apetece hoy, "+nombre+"?");
        System.out.println("=========CARTA==========");
        for (CartaPizzas pizzas:CartaPizzas.values()){
            System.out.println(pizzas.name()+": "+pizzas.getPrecio()+"€");
        }
        System.out.println("========================");
    }

    public void preciofinal(Double precio){
        System.out.println("Descuento a aplicar: "+descuento+"%. Total importe a pagar: "+precio*(100-getDescuento())/100+"€");
    }

    public void pagar(){
        System.out.println(nombre+" está pagando el pedido...");
    }

    public void recoger(){
        System.out.println("Pedido recogido por "+nombre);
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
    }

    public void obtenerDetalles() {
        System.out.println("Cliente: ["+nombre+"]");
    }
}
