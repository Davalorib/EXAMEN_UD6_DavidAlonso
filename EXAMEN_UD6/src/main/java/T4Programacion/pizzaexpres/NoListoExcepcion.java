package T4Programacion.pizzaexpres;

public class NoListoExcepcion extends RuntimeException {
    public NoListoExcepcion() {
        super("El pedido aun no está listo");
    }
}
