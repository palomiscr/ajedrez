import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class Tablero implements PropertyChangeListener {
    private PropertyChangeSupport supportmodelo;
    private Figura[][] tablero = new Figura[8][8];
    private int size = 8;
    //atributos de la pieza actual
        private LinkedList<Posicion> movimientosact;
        private Posicion posicionvieja;
        private Figura figuraaux;
        private int c;
        private int f;
    public Tablero(PropertyChangeSupport supportmodelo) {
        this.supportmodelo = supportmodelo;
        initpeones();
        initfiguras();

    }
    public int getSize(){
        return size;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        /*escuchare:
         * de teclado para fin de partida
         *
         * seleccion para buscar la figura que corresponde a esas coordenadas
         * EVENTO ES UN LINKED LIST DE POSICIONES.no se envia evento si no hay figura.
         *
         * movimiento para actualizar el tablero, quitarla de donde estaba antes y ponerla en la de ahora
         * si en la casilla habia alguien desaparece.
         * si se ha seleccionado algo, recojo point, si esta dentro de las posiciones posibles envio evento a vista
         * y actualizo tablero.
         * */
        if (evt.getPropertyName().equals("finpartida")) {
            supportmodelo.firePropertyChange("finpartida1", 0, 3);
        }
        else{
            Point point = (Point) evt.getNewValue();
             c = (int) point.getX() / Vista.intervalo;
             f = (int) point.getY() / Vista.intervalo;
        }
         if (evt.getPropertyName().equals("seleccion")) {
            if (tablero[f][c] != null) {
                Controlador.numclicks++;
                figuraaux = tablero[f][c].clone();
                                                                         //dado el tablero actual y la figura seleccionada con sus coordenadas
                movimientosact = figuraaux.movimientos(c, f, tablero);//averiguo que movimientos puede hacer
                if(movimientosact.isEmpty())
                    Controlador.numclicks++;//me salto el turno de movimiento si no hay movimientos disponibles
                posicionvieja = new Posicion(c, f);//guardo la posicion para moverla luego
                supportmodelo.firePropertyChange("seleccion_procesada", 0, movimientosact);
                //va a imprimir de verde
            }

        }  if (evt.getPropertyName().equals("movimiento")) {
            //si el click seleccionado corresponde a uno de los movimientos posibles pieza ellegida
            Posicion p = new Posicion(c, f);
            if (contains_mio(p)) {//si la lista actual de movimientos posibles contiene el movimiento en cuestion, se realiza
                Controlador.numclicks++;
                //posicion vieja la pongo en la nueva y la anterior la machaco
                tablero[f][c] = figuraaux.clone();//actualizo pieza, si ya habia una desaparece
                tablero[posicionvieja.getY()][posicionvieja.getX()] = null;
                supportmodelo.firePropertyChange("movimiento_procesado", 0, this);
                //le paso el tablero actualizado

            }
        }

    }

    private void initpeones() {
        for (int i = 0; i < size; i++) {
            Figura peon = new Peon();
            peon.setColor(Color.BLACK);
            tablero[1][i] = peon;

            Figura peon2 = new Peon();
            peon2.setColor(Color.WHITE);
            tablero[6][i] = peon2;
        }
    }

    private void initfiguras() {
        Figura[] aux = new Figura[8];
        Figura[] aux2 = new Figura[8];
        Figura alfil = new Alfil();
        Figura rey = new Rey();
        Figura dama = new Dama();
        Figura caballo = new Caballo();
        Figura torre = new Torre();


        Figura alfil2 = new Alfil();
        Figura rey2 = new Rey();
        Figura dama2 = new Dama();
        Figura caballo2 = new Caballo();
        Figura torre2 = new Torre();


        aux[0] = torre;
        aux[1] = caballo;
        aux[2] = alfil;
        aux[3] = dama;
        aux[4] = rey;
        aux[5] = alfil;
        aux[6] = caballo;
        aux[7] = torre;

        aux2[0] = torre2;
        aux2[1] = caballo2;
        aux2[2] = alfil2;
        aux2[3] = dama2;
        aux2[4] = rey2;
        aux2[5] = alfil2;
        aux2[6] = caballo2;
        aux2[7] = torre2;

        for (int j = 0; j < size; j++) {//primero pongo las blancas cerca de mi
            tablero[7][j] = aux[j];
            tablero[7][j].setColor(Color.WHITE);
        }


        for (int j = 0; j < size; j++) {//negras lejos
            tablero[0][j] = aux2[j];
            tablero[0][j].setColor(Color.BLACK);
        }

    }

    public void mostrarFinPartida() {//envia un evento para que la vista muestre algo especial

    }

    public Figura[][] getTablero() {
        return tablero;
    }

    public int getvalorblancas() {
        int valor = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Figura f = tablero[i][j];
                if (f != null && f.getColor() == Color.WHITE) {
                    valor += f.getValor();
                }
            }
        }
        return valor;
    }

    public int getvalornegras() {
        int valor = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Figura f = tablero[i][j];
                if (f != null && f.getColor() == Color.BLACK) {
                    valor += f.getValor();
                }
            }
        }
        return valor;
    }

    private boolean contains_mio(Posicion p) {
        boolean contiene = false;
        for (Posicion posicionlista : movimientosact) {
            if (posicionlista.getX() == p.getX() && posicionlista.getY() == p.getY())
                contiene = true;
        }
        return contiene;
    }
}
