public class Rectangulo {
    //Atributos
    private Coordenada esquina1;
    private Coordenada esquina2;

    //Constructor
    public Rectangulo(Coordenada c1,Coordenada c2){
        this.esquina1 = c1;
        this.esquina2 = c2;
    }

    //Setters y getters
    public Coordenada getEsquina1(){return this.esquina1;}
    public void setEsquina1(Coordenada c){this.esquina1 = c;}

    public Coordenada getEsquina2(){return this.esquina2;}
    public void setEsquina2(Coordenada c){this.esquina2 = c;}

    //Metodos
    public double calcularArea(){
        double base = Math.abs(this.esquina2.getX() - this.esquina1.getX());
        double altura = Math.abs(this.esquina2.getY() - this.esquina1.getY());

        return base * altura;
    }

    //-----------------
    @Override
    public String toString(){
        return "(E1: " + this.esquina1 + 
        " - E2: " + this.esquina2 + ")";
    }
}
