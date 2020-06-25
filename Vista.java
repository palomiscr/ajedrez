import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

public class Vista extends Canvas implements PropertyChangeListener {
    private Graphics2D g2d;
    private Tablero tablero;
    private int size=8;
    private LinkedList<Posicion> movimientosposibles;
    public static int intervalo=50;
    private boolean fin;
    private boolean puedo=false;
    public Vista(Tablero tablero){
        this.tablero=tablero;
        fin=false;

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    // recibo de teclado, seleccion de figura y seleccion de movimiento
        if(evt.getPropertyName().equals("finpartida1")){//evento es 0. Pinto el final
            fin=true;
        }
        else if(evt.getPropertyName().equals("seleccion_procesada")){//evento es una linked list
            movimientosposibles=(LinkedList<Posicion>) evt.getNewValue();
            puedo=true;
        }
        else if(evt.getPropertyName().equals("movimiento_procesado")){//evento es el tablero actualizado

        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g2d=(Graphics2D) g;
        //pintar color tablero
        colorea();
        //pintar movimientos disponibles
        if(puedo) {
            pintarmovimientos();
            puedo=false;
        }
        //pintar lineas
        pintarlineas();
        //pintar letras
        if(!fin)
            pintarletras();
        else {
            pintarfinal();
        }

    }
    private void colorea(){
        Color claro=new Color(254, 206, 161);
        Color oscuro= new Color(208, 139, 78);

        for (int i = 0; i < size; i++) {
            if(i%2==0)
                g2d.setColor(claro);
            else
                g2d.setColor(oscuro);

            for (int j = 0; j <size ; j++) {
                g2d.fillRect(j*intervalo, i*intervalo, intervalo, intervalo);
                if(g2d.getColor().equals(claro))
                    g2d.setColor(oscuro);
                else
                    g2d.setColor(claro);

            }
        }
    }
    private void pintarlineas(){
        g2d.setColor(Color.BLACK);
        for (int i = 0; i <size+1 ; i++) {
            g2d.drawLine(0, i*intervalo, intervalo*size,i*intervalo );
            g2d.drawLine(i*intervalo, 0, i*intervalo, intervalo*size);
        }
    }
    private void pintarletras(){
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                Figura f=tablero.getTablero()[i][j];//accedo casi directamente a la matriz de tablero
                if(f!=null){
                    g2d.setColor(f.getColor());
                    g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
                    g2d.drawString(Character.toString(f.getSrepresentacion()), j*intervalo+10, i*intervalo+40);
                }
            }
        }
    }
    private void pintarfinal(){
        if(tablero.getvalorblancas()>tablero.getvalornegras()){
            g2d.setColor(Color.white);
            g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
            g2d.drawString("Han ganado blancas", 10, 4*intervalo);
        }
        else if(tablero.getvalorblancas()<tablero.getvalornegras()){
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
            g2d.drawString("Han ganado negras", 10, 4*intervalo);
        }
        else{
            g2d.setColor(Color.RED);
            g2d.setFont(new Font(Font.SANS_SERIF,Font.BOLD,80));
            g2d.drawString("Empate", intervalo, 4*intervalo);
        }
    }
    private void pintarmovimientos(){
        g2d.setColor(Color.green);
        for(Posicion p:movimientosposibles){
            g2d.fillRect(intervalo*p.getX(), intervalo*p.getY(), intervalo, intervalo);
        }
    }
}
