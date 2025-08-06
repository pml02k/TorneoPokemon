import java.util.Random;
import java.util.Scanner;

public class Batalla {
    private Pokemon p1;
    private Pokemon p2;
    private Entrenador e1;
    private Entrenador e2;

    public Batalla(Pokemon p1, Pokemon p2, Entrenador e1, Entrenador e2) {
        this.p1 = p1;
        this.p2 = p2;
        this.e1 = e1;
        this.e2 = e2;
    }

    public String ejecutarBatalla() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\nInicio de batalla");
        System.out.println(e1.getNombre() + " usa a " + p1.getNombre() + " (" + p1.getTipo() + ")");
        System.out.println(e2.getNombre() + " usa a " + p2.getNombre() + " (" + p2.getTipo() + ")");

        boolean activarHabilidad1 = preguntarAccion(scanner, e1.getNombre(), p1);
        boolean activarHabilidad2 = preguntarAccion(scanner, e2.getNombre(), p2);

        int atk1 = calcularAtaqueTotal(p1, p2.getTipo(), p2.getDefensa(), activarHabilidad1, random);
        int atk2 = calcularAtaqueTotal(p2, p1.getTipo(), p1.getDefensa(), activarHabilidad2, random);

        System.out.println(p1.getNombre() + " ataque final: " + atk1);
        System.out.println(p2.getNombre() + " ataque final: " + atk2);

        if (atk1 > atk2) {
            System.out.println("Ganador de la ronda: " + e1.getNombre());
            return e1.getNombre();
        } else if (atk2 > atk1) {
            System.out.println("Ganador de la ronda: " + e2.getNombre());
            return e2.getNombre();
        } else {
            System.out.println("Ronda empatada");
            return "Empate";
        }
    }

    private boolean preguntarAccion(Scanner scanner, String entrenador, Pokemon p) {
        System.out.println(entrenador + ", ¿deseas activar la habilidad de " + p.getNombre() + "? (s/n)");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

    private int calcularAtaqueTotal(Pokemon atacante, String tipoOponente, int defensaOponente,
                                    boolean usarHabilidad, Random random) {
        int bonusTipo = calcularVentajaTipo(atacante.getTipo(), tipoOponente);
        int bonusHabilidad = 0;

        if (usarHabilidad && random.nextBoolean()) {
            bonusHabilidad = atacante.getHabilidad().getModificadorAtaque();
            System.out.println("Habilidad activada: " + atacante.getHabilidad().getNombre());
        }

        return atacante.getAtaque() + bonusTipo + bonusHabilidad - defensaOponente;
    }

    private int calcularVentajaTipo(String tipo1, String tipo2) {
        if ((tipo1.equals("Fuego") && tipo2.equals("Planta")) ||
            (tipo1.equals("Agua") && tipo2.equals("Fuego")) ||
            (tipo1.equals("Planta") && tipo2.equals("Agua"))) {
            return 10;
        } else if ((tipo2.equals("Fuego") && tipo1.equals("Planta")) ||
                   (tipo2.equals("Agua") && tipo1.equals("Fuego")) ||
                   (tipo2.equals("Planta") && tipo1.equals("Agua"))) {
            return -10;
        } else {
            return 0;
        }
    }
}