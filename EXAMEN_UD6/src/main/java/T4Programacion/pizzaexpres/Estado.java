package T4Programacion.pizzaexpres;

public enum Estado {

    CREANDO,CANCELADO,RECIBIDO,MONTANDO_PIZZA,HORNEANDO,PREPARANDO_PEDIDO,LISTO;

    public Estado siguiente(Estado estado){
        switch (estado){
            case CREANDO:
                return Estado.RECIBIDO;
            case CANCELADO:
                return Estado.CANCELADO;
            case RECIBIDO:
                return Estado.MONTANDO_PIZZA;
            case MONTANDO_PIZZA:
                return Estado.HORNEANDO;
            case HORNEANDO:
                return Estado.PREPARANDO_PEDIDO;
            case PREPARANDO_PEDIDO:
                return Estado.LISTO;
            case LISTO:
                return Estado.CREANDO;
            default:
                return Estado.CREANDO;
        }
    }

}
