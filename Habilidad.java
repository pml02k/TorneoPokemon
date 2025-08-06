public class Habilidad {
    private String nombre;
    private String descripcion;
    private int modificadorAtaque;
    private int modificadorDefensa;

    public Habilidad(String nombre, String descripcion, int modificadorAtaque, int modificadorDefensa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modificadorAtaque = modificadorAtaque;
        this.modificadorDefensa = modificadorDefensa;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getModificadorAtaque() { return modificadorAtaque; }
    public int getModificadorDefensa() { return modificadorDefensa; }

    @Override
    public String toString() {
        return nombre + " [+" + modificadorAtaque + " ATK, +" + modificadorDefensa + " DEF]";
    }
}