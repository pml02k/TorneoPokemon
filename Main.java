import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear equipo de Ash
        List<Pokemon> equipoAsh = new ArrayList<>();
        equipoAsh.add(new Pokemon("Charizard", "Fuego", 55, 35,
            new Habilidad("Llama Furia", "Ataque de fuego intenso", 15, 0)));
        equipoAsh.add(new Pokemon("Bulbasaur", "Planta", 40, 30,
            new Habilidad("Raíces curativas", "Defensa regenerada", 0, 10)));
        equipoAsh.add(new Pokemon("Squirtle", "Agua", 45, 40,
            new Habilidad("Torrente", "Ataque acuático potenciado", 10, 0)));
        equipoAsh.add(new Pokemon("Pikachu", "Eléctrico", 50, 30,
            new Habilidad("Impactrueno", "Ataque eléctrico veloz", 12, 0)));

        // Crear equipo de Misty
        List<Pokemon> equipoMisty = new ArrayList<>();
        equipoMisty.add(new Pokemon("Starmie", "Agua", 48, 32,
            new Habilidad("Giro Rápido", "Ataque giratorio veloz", 10, 0)));
        equipoMisty.add(new Pokemon("Psyduck", "Agua", 40, 38,
            new Habilidad("Confusión", "Ataque psíquico descontrolado", 15, 0)));
        equipoMisty.add(new Pokemon("Gyarados", "Agua", 58, 42,
            new Habilidad("Furia Marina", "Ataque de ola gigante", 20, 0)));
        equipoMisty.add(new Pokemon("Togepi", "Planta", 35, 30,
            new Habilidad("Alegría mágica", "Defensa emocional", 0, 12)));

        // Crear entrenadores
        Entrenador ash = new Entrenador("Ash", equipoAsh);
        Entrenador misty = new Entrenador("Misty", equipoMisty);

        // Crear torneo y registrar entrenadores
        Torneo torneo = new Torneo();
        torneo.agregarEntrenador(ash);
        torneo.agregarEntrenador(misty);

        // Iniciar el torneo completo
        torneo.iniciarTorneo();
    }
}