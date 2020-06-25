import java.util.LinkedList;

public class Dama extends Figura {
    private int valor=9;
    private char srepresentacion='D';

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
        i = 1;
        while (y + i < 8 && tablero[y + i][x] == null) {
            resul.add(new Posicion(x, y + i));
            i++;
        }
        if (y + i < 8 && tablero[y+i][x].getColor()!=this.getColor()) {
            resul.add(new Posicion(x, y + i));
        }
        i = 1;
        while (y - i >= 0 && tablero[y - i][x] == null) {
            resul.add(new Posicion(x, y - i));
            i++;
        }
        if (y - i >= 0 && tablero[y-i][x].getColor()!=this.getColor()) {
            resul.add(new Posicion(x,y-i ));
        }
        i = 1;
        while (x - i >= 0 && tablero[y][x - i] == null) {
            resul.add(new Posicion(x - i, y));
            i++;
        }
        if (x - i >= 0 && tablero[y][x-i].getColor()!=this.getColor()) {
            resul.add(new Posicion(x-i,y ));
        }
        i = 1;
        while (x + i <8 && tablero[y][x + i] == null) {
            resul.add(new Posicion(x + i, y));
            i++;
        }
        if (x + i <8&& tablero[y][x+i].getColor()!=this.getColor()) {
            resul.add(new Posicion(x+i,y ));
        }
        return resul;

    }
    public String toString() {
        return "Dama{" +
                "valor=" + valor +
                ", srepresentacion=" + srepresentacion +
                '}';
    }
}
