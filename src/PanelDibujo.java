import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class PanelDibujo extends JPanel {
    private ArrayList<TipoDibujo>Datos;
    private String Lienzo;
    private ArrayList<Integer>Puntos;
    private int x=0, y=0, fx=0, fy=0;
    public PanelDibujo(ArrayList<TipoDibujo> D)
    {
        super();
        this.Datos=D;
        Obtener_valores();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (this.Lienzo.equals("Linea"))
        {
            g.drawLine(this.x, this.y, this.fx, this.fy);
        }
        else if (this.Lienzo.equals("Rectangulo"))
        {
            g.drawRect(this.x, this.y, this.fx, this.fy);
        }
        else if (this.Lienzo.equals("Circulo"))
        {
            g.drawOval(this.x, this.y, this.fx, this.fy);
        }
        else if (this.Lienzo.equals("Texto"))
        {
            g.drawString("Texto de prueba", this.x, this.y);
        }
    }

    private void Obtener_valores()
    {
        for (TipoDibujo dibujo : Datos)
        {
            this.Lienzo=dibujo.getLienzo();
            this.Puntos=dibujo.getPuntos();
        }
        this.x=Puntos.get(0);
        this.y=Puntos.get(1);
        this.fx=Puntos.get(2);
        this.fy=Puntos.get(3);

    }
}
