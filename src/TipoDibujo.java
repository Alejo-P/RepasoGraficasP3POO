import java.util.ArrayList;
public class TipoDibujo {
    //Atributos
    private String Lienzo;
    private ArrayList<Integer> Puntos;

    //Constructor
    public TipoDibujo(String lienzo, ArrayList<Integer> puntos) {
        Lienzo = lienzo;
        Puntos = puntos;
    }

    // Metodos (Getters)
    public String getLienzo() {
        return Lienzo;
    }

    public ArrayList<Integer> getPuntos() {
        return Puntos;
    }
}