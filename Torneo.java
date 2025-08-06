import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private List<Batalla> historial = new ArrayList<>();

    public void agregarEntrenador(Entrenador e) {
        if (entrenador1 == null) {
            entrenador1 = e;
        } else {
            entrenador2 = e;
        }
    }

    public void iniciarTorneo() {
        for (int ronda = 0; ronda < 4; ronda++) {
            Pokemon p1 = entrenador1.usarPokemon(ronda);
            Pokemon p2 = entrenador2.usarPokemon(ronda);

            Batalla batalla = new Batalla(p1, p2, entrenador1, entrenador2);
            String ganador = batalla.ejecutarBatalla();

            if (ganador.equals(entrenador1.getNombre())) {
                entrenador1.sumarVictoria();
            } else if (ganador.equals(entrenador2.getNombre())) {
                entrenador2.sumarVictoria();
            }

            historial.add(batalla);
        }

        System.out.println("\nResultado final del torneo:");
        String resultado = determinarGanador();
        System.out.println("Ganador del torneo: " + resultado);
    }

    private String determinarGanador() {
        int victorias1 = entrenador1.getVictorias();
        int victorias2 = entrenador2.getVictorias();

        if (victorias1 > victorias2) {
            return entrenador1.getNombre();
        } else if (victorias2 > victorias1) {
            return entrenador2.getNombre();
        } else {
            return "Empate";
        }
    }
}