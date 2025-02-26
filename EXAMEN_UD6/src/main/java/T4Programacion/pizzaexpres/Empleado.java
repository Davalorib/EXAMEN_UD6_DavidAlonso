package T4Programacion.pizzaexpres;

import lombok.Getter;

@Getter
public class Empleado extends PizzaExpress implements AccionesPedido{

    public static int cantidadID = 0; //un contador de cantidad de IDs que es publico para poder acceder a él si es necesario
    public static final String ID_DEF = "EMP"; //una constante pública también para ir definiendo los IDs

    private String id_empleado;
    private String nombre;


    public Empleado(String nombre) {
        this.nombre = nombre;
        cantidadID++;
        this.id_empleado = calcularID();
    }

    //para calcular la ID
    private String calcularID() {
        return ID_DEF + String.format("%03d",cantidadID); //devuelve lo que contenga la constante de ID_DEF + el número del contador, lo rellena con ceros si no llega a 3 dígitos
    }
    //

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void siguienteEstado(Pedido pedido){
        Estado actual = pedido.getEstadoPedido();
        actual = actual.siguiente(actual);
        System.out.println(actual);
    }

    public void entregarPedido(Pedido pedido){
        if (pedido.getEstadoPedido() != Estado.LISTO){
            throw new NoListoExcepcion();
        } else {
            System.out.print("Entregando el pedido ");
            pedido.obtenerDetalles();
        }
    }

    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
    }

    public void obtenerDetalles() {
        System.out.println("Empleado: ["+nombre+", con id: "+id_empleado+"]");
    }

}
