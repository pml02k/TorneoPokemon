import java.util.List;

public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;
    private int victorias;

    public Entrenador(String nombre, List<Pokemon> equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.victorias = 0;
    }

    public String getNombre() { return nombre; }
    public int getVictorias() { return victorias; }

    public void sumarVictoria() {
        victorias++;
    }

    public Pokemon usarPokemon(int ronda) {
        return (ronda >= 0 && ronda < equipo.size()) ? equipo.get(ronda) : null;
    }

    public List<Pokemon> getEquipo() { return equipo; }
}