import java.util.LinkedList;

public class Caballo extends Figura {
    private int valor=3;
    private char srepresentacion='C';

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
        int dx[]={-2, -2, -1, +1, -1, +1, +2, +2};
        int dy[]={-1, +1, -2, -2, +2, +2, -1, +1};
        for (int i = 0; i < 8; i++) {
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(xx>=0 && xx<8 && yy>=0 && yy<8 &&(tablero[yy][xx]==null || tablero[yy][xx].getColor()!=this.getColor())){
                resul.add(new Posicion(xx, yy));
            }
        }
        return  resul;
    }
    public String toString() {
        return "Caballo{" +
                "valor=" + valor +
                ", srepresentacion=" + srepresentacion +
                '}';
    }
}
