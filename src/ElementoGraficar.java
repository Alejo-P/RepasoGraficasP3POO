import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ElementoGraficar {
    JPanel Pantalla;
    private JLabel titulo;
    private JRadioButton lineaRadioButton;
    private JRadioButton rectanguloRadioButton;
    private JRadioButton circuloRadioButton;
    private JRadioButton textoRadioButton;
    private JSpinner puntox;
    private JSpinner puntoy;
    private JSpinner puntofinalx;
    private JSpinner puntofinaly;
    private JButton graficarButton;
    private JButton limpiarButton;

    private String Grafico="Linea";

    private final ArrayList<Integer>Puntos;
    private ArrayList<TipoDibujo>Datos;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        SpinnerNumberModel modeloPuntoX = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel modeloPuntoY = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel modeloPuntoFinalX = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel modeloPuntoFinalY = new SpinnerNumberModel(0, 0, 100, 1);

        puntox = new JSpinner(modeloPuntoX);
        puntoy = new JSpinner(modeloPuntoY);
        puntofinalx = new JSpinner(modeloPuntoFinalX);
        puntofinaly = new JSpinner(modeloPuntoFinalY);
    }

    public ElementoGraficar() {
        Puntos = new ArrayList<>();
        Datos = new ArrayList<>();
        Puntos.add(0);Puntos.add(0);Puntos.add(0);Puntos.add(0);

        lineaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafico=lineaRadioButton.getText();
            }
        });

        rectanguloRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafico=rectanguloRadioButton.getText();
            }
        });

        circuloRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafico=circuloRadioButton.getText();
            }
        });

        textoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Grafico=textoRadioButton.getText();
            }
        });

        puntox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = (int) puntox.getValue();
                Puntos.set(0, valor);
            }
        });

        puntoy.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = (int) puntoy.getValue();
                Puntos.set(1, valor);
            }
        });

        puntofinalx.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = (int) puntofinalx.getValue();
                Puntos.set(2, valor);
            }
        });

        puntofinaly.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int valor = (int) puntofinaly.getValue();
                Puntos.set(3, valor);
            }
        });

        graficarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datos.clear();
                Datos.add(new TipoDibujo(Grafico, Puntos));

                JFrame Grafico = new JFrame();
                Grafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Grafico.setSize(300, 300);
                Grafico.add(new PanelDibujo(Datos));
                Grafico.setVisible(true);
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Establecer todos los JSpinner en 0
                puntox.setValue(0);
                puntoy.setValue(0);
                puntofinalx.setValue(0);
                puntofinaly.setValue(0);

                // Seleccionar el JRadioButton "LineaRadioButton"
                lineaRadioButton.setSelected(true);
                rectanguloRadioButton.setSelected(false);
                circuloRadioButton.setSelected(false);
                textoRadioButton.setSelected(false);

                // Actualizar la variable Grafico con el valor del JRadioButton seleccionado
                Grafico = "Linea";
            }
        });
    }
}