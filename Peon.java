import java.awt.*;
import java.util.LinkedList;

public class Peon extends Figura {
    private int valor = 1;
    private char srepresentacion = 'P';
    private int numllamadas = 0;

    @Override
    public int getValor() {
        return valor;
    }


    @Override
    public char getSrepresentacion() {
        return srepresentacion;
    }


    @Override
    public LinkedList<Posicion> movimientos(int x, int y, Figura[][] tablero) {//x columna y fila
        LinkedList<Posicion> resul = new LinkedList<Posicion>();

        if (this.getColor() == Color.white) {
            //diagonales
            if ((x + 1 < 8 && y - 1 >= 0 && tablero[y - 1][x + 1] != null && tablero[y - 1][x + 1].getColor() != this.getColor())) {
                resul.add(new Posicion(x + 1, y - 1));
            }
            if ((x - 1 >= 0 && y - 1 >= 0 && tablero[y - 1][x - 1] != null && tablero[y - 1][x - 1].getColor() != this.getColor())) {
                resul.add(new Posicion(x - 1, y - 1));

            }
            if (this.numllamadas == 0) {
                if (y - 1 >= 0 && y - 2 >= 0 && tablero[y - 1][x] == null && (tablero[y - 2][x] == null))
                    resul.add(new Posicion(x, y - 2));
            } else if (y - 1 >= 0 && tablero[y - 1][x] == null)
                resul.add(new Posicion(x, y - 1));
        } else {//negra
            //diagonales
            if ((x + 1 < 8 && y + 1 < 8 && tablero[y + 1][x + 1] != null && tablero[y + 1][x + 1].getColor() != this.getColor())) {
                resul.add(new Posicion(x + 1, y + 1));
            }
            if ((x - 1 >= 0 && y + 1 < 8 && tablero[y + 1][x - 1] != null && tablero[y + 1][x - 1].getColor() != this.getColor())) {
                resul.add(new Posicion(x - 1, y + 1));

            }

            if (this.numllamadas == 0) {
                if (y + 1 < 8 && y + 2 < 8 && tablero[y + 1][x] == null && (tablero[y + 2][x] == null))
                    resul.add(new Posicion(x, y + 2));
            } else if (y + 1 < 8 && tablero[y + 1][x] == null)
                resul.add(new Posicion(x, y + 1));
        }
        numllamadas++;

        return resul;
    }

    public String toString() {
        return "Peon{" +
                "valor=" + valor +
                ", srepresentacion=" + srepresentacion +
                '}';
    }
}
