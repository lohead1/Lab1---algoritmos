public class ContainerRect {
    //Atributos
    private Rectangulo[] arrRect;
    private double[] distancias;
    private double[] areas;
    private int n; // cantidad maxima de rectangulos

    //Atributo de clase
    private static int numRec = 0;

    //Constructor
    public ContainerRect(int n){
        this.n = n;
        this.arrRect = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    //-----------Metodo estatico para acceder a la cantidad de Rectangulos
    public static int getNumRec(){return ContainerRect.numRec;}

    //Metodo de instancia
    public void addRectangulo(Rectangulo rect) {
        
        if(ContainerRect.numRec < this.n){
            
            this.arrRect[ContainerRect.numRec] = rect;
            this.distancias[ContainerRect.numRec] = rect.getEsquina1().distancia(rect.getEsquina2());
            this.areas[ContainerRect.numRec] = rect.calcularArea();
            ContainerRect.numRec++;

        }else{
            System.out.println("Capacidad maxima alcanzada");
        }
    }

    //Sobreescritura
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo\tCoordenadas\tDistancia\tÁrea\n");

        for (int i = 0; i < ContainerRect.numRec; i++) {
            sb.append((i + 1)).append("\t") // Índice del rectángulo
                .append(this.arrRect[i].toString()).append("\t") // Coordenadas
                .append(String.format("%.3f", this.distancias[i])).append("\t")
                .append(String.format("%.2f", this.areas[i])).append("\n"); 
        }

        return sb.toString();
    }

}
