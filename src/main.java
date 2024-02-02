import javax.swing.*;

public class main {
    public static void main (String [] args)
    {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane(new ElementoGraficar().Pantalla);
        ventana.setSize(300, 300);
        ventana.pack();
        ventana.setVisible(true);
    }
}
