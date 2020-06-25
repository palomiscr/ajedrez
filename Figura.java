import java.awt.*;
import java.util.LinkedList;

public abstract class Figura {
    private Color color;
    private Posicion posicion;
    public Figura clone(){
        return this;
    }
    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract int getValor() ;

    public abstract char getSrepresentacion() ;
    public abstract LinkedList<Posicion> movimientos(int x, int y, Figura[][] tablero);
    public abstract String toString();
}
