package T4Programacion.pizzaexpres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Scanner;

@Getter @ToString @Setter
public class Pedido extends PizzaExpress{

    Scanner ent = new Scanner(System.in);

    private Cliente cliente;
    private ArrayList<CartaPizzas> listaPizzas;
    private Estado estadoPedido;

    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        estadoPedido = Estado.CREANDO;
        listaPizzas = new ArrayList<>();
    }

    public void meterPizza(CartaPizzas pizza){
        listaPizzas.add(pizza);
    }

    public double precio(){
        double precio = 0;
        for (CartaPizzas p:listaPizzas){
            precio += p.getPrecio();
        }
        return precio;
    }



    public String preguntarNombre(){
        System.out.println("Dame el nombre del nuevo cliente: ");
        return ent.next();
    }

    public void obtenerDetalles() {
        System.out.println("Pedido con las pizzas "+listaPizzas+" del cliente "+cliente.getNombre());
    }
}
