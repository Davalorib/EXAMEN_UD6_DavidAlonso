package T4Programacion.pizzaexpres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter @ToString @Setter
public class Pedido extends PizzaExpress{

    private Cliente cliente;
    private ArrayList<CartaPizzas> listaPizzas;
    private Estado estadoPedido;

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


    public void obtenerDetalles() {
        System.out.println("pedido con las pizzas "+listaPizzas+" a "+cliente.getNombre());
    }
}
