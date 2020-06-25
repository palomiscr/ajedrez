import java.util.LinkedList;

public class Rey extends Figura {
    private int valor = 4;
    private char srepresentacion = 'R';

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
        int dx[] = {-1, -1, -1, 0, 0, +1, +1, +1};
        int dy[] = {-1, 0, +1, -1, +1, -1, 0, +1};
        for (int k = 0; k < 8; k++) {
            if (y + dy[k] >= 0 && y + dy[k] < 8 && x + dx[k] < 8 && x + dx[k] >= 0 && (tablero[y + dy[k]][x + dx[k]] == null
                    || tablero[y + dy[k]][x + dx[k]].getColor() != this.getColor()))
                resul.add(new Posicion(x + dx[k], y + dy[k]));
        }
        return resul;

    }

    @Override
    public String toString() {
        return "Rey{" +
                "valor=" + valor +
                ", srepresentacion=" + srepresentacion +
                '}';
    }
}
