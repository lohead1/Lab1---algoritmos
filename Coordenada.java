public class Coordenada {
    // Atributos
    private double x;
    private double y;

    // Constructores
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    // Getters y setters
    public double getX() {return this.x;}
    public void setX(double x) {this.x = x;}

    public double getY() {return this.y;}
    public void setY(double y) {this.y = y;}

    // Metodos
    public double distancia(Coordenada c) {
        return Math.sqrt(Math.pow((c.x - this.x), 2) + Math.pow((c.y - this.y), 2));
    }

    public static double distancia(Coordenada c1, Coordenada c2) {
        return Math.sqrt(Math.pow((c2.x - c1.x), 2) + Math.pow((c2.y - c1.y), 2));
    }

    // ------------
    @Override
    public String toString() {
        return "[X: " + this.x + " - Y: " + this.y + "]";
    }
}
