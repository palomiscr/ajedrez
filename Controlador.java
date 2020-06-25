import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Controlador implements MouseListener, KeyListener {
    private PropertyChangeSupport supportcontrol;
    private Point point;
    public static int numclicks=0;
    public Controlador(PropertyChangeSupport supportcontrol){
        this.supportcontrol=supportcontrol;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) {
            //click seleccion figura y click seleccion de movimiento
            point = e.getPoint();
            int c = (int) point.getX() / Vista.intervalo;
            int f = (int) point.getY() / Vista.intervalo;
            if (numclicks % 2 == 0) {
                //metodo estatico de validacion de figura
                //es el primero de la pareja de clicks
                supportcontrol.firePropertyChange("seleccion", 0, point);
            } else {
                supportcontrol.firePropertyChange("movimiento", 0, point);
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
    //fin de partida

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if( e.getKeyChar()=='f') {
            supportcontrol.firePropertyChange("finpartida", 0, 1);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
