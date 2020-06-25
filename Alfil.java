import java.util.LinkedList;

public class Alfil extends Figura {
    private int valor = 3;
    private char srepresentacion = 'A';

    @Override
    public int getValor() {
        return valor;
    }


    @Override
    public char getSrepresentacion() {
        return srepresentacion;
    }


    @Override
    public LinkedList<Posicion> movimientos(int x, int y, Figura[][] tablero) {
        LinkedList<Posicion> resul = new LinkedList<Posicion>();
        int i = 1;
        while (y - i >= 0 && x + i < 8 && tablero[y - i][x + i] == null) {
            resul.add(new Posicion( x + i,y - i));
            i++;
        }
            if (y - i >= 0 && x + i < 8) {//entonces hay una pieza
                if (tablero[y - i][x + i].getColor() != this.getColor()) {
                    resul.add(new Posicion(x + i,y - i));
                }
            }
        i = 1;
        while (y + i < 8 && x - i >= 0 && tablero[y + i][x - i] == null) {
            resul.add(new Posicion(x-i,y+i));
            i++;
        }
            if (y + i < 8 && x - i >= 0) {
                if (tablero[y + i][x - i].getColor() != this.getColor()) {
                    resul.add(new Posicion(x - i, y + i));
                }

            }
        i = 1;
        while (y - i >= 0 && x - i >= 0 && tablero[y - i][x - i] == null) {
            resul.add(new Posicion( x-i, y-i));
            i++;
        }
            if (y - i >= 0 && x - i >= 0) {
                if (tablero[y - i][x - i].getColor() != this.getColor()) {
                    resul.add(new Posicion(x - i, y - i));
                }
            }
        i = 1;
        while (y + i < 8 && x + i < 8 && tablero[y + i][x + i] == null) {
            resul.add(new Posicion(x+i, y+i));
            i++;
        }
        if (y + i < 8 && x + i < 8) {
            if (tablero[y + i][x + i].getColor() != this.getColor()) {
                resul.add(new Posicion(x + i, y + i));
            }
        }
        return resul;
    }

    @Override
    public String toString() {
        return "Alfil{" +
                "valor=" + valor +
                ", srepresentacion=" + srepresentacion +
                '}';
    }
}
