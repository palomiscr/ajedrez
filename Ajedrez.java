import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeSupport;

public class Ajedrez {
    public Ajedrez(){

        PropertyChangeSupport supportcontrol=new PropertyChangeSupport(this);
        PropertyChangeSupport supportmodelo=new PropertyChangeSupport(this);

        Controlador controlador= new Controlador(supportcontrol);
        Tablero modelo =new Tablero(supportmodelo);
        Vista vista=new Vista(modelo);

        supportmodelo.addPropertyChangeListener(vista);
        supportcontrol.addPropertyChangeListener(modelo);
        vista.addKeyListener(controlador);
        vista.addMouseListener(controlador);
        Frame frame=new Frame();
        frame.setSize(50*8+2, 50*8+25);
        frame.add(vista);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

    }
    public static void main(String[] args) {
        Ajedrez ajedrez=new Ajedrez();
    }
}
