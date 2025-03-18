import java.util.Scanner;

//Clase Principal
public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        //---------------------------Ejercicio
        //Creacion del contenedor de Rectangulos con capacidad n
        ContainerRect cr = new ContainerRect(4);


        //-------------------Actividad
        //Declaracion de los obj Rectangulo
        Rectangulo rect1;
        Rectangulo rect2;

        //Identificadores
        char letra1 = 'A';
        char letra2 = 'B';

        //Valores para X y Y
        double xe1, ye1, xe2, ye2;

        //----------------Primer Rectangulo
        System.out.println("Ingrese una esquina del 1er rectangulo (X - Y): ");
        xe1 = sc.nextDouble();
        ye1 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 1er rectangulo (X - Y): ");
        xe2 = sc.nextDouble();
        ye2 = sc.nextDouble();

        rect1 = new Rectangulo(new Coordenada(xe1, ye1), new Coordenada(xe2,ye2));

        cr.addRectangulo(rect1); // Agregar rectangulo al contenedor

        //----------------Segundo Rectangulo
        System.out.println("Ingrese una esquina del 2do rectangulo (X - Y): ");
        xe1 = sc.nextDouble();
        ye1 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 2do rectangulo (X - Y): ");
        xe2 = sc.nextDouble();
        ye2 = sc.nextDouble();

        rect2 = new Rectangulo(new Coordenada(xe1, ye1), new Coordenada(xe2,ye2));

        cr.addRectangulo(rect2); // Agregar rectangulo al contenedor

        //-------------------------Veridicacion de Caso
        if(Verificador.esSobrePos(rect1, rect2)){
            
            System.out.println("Rectangulo " + letra1 + " y " + letra2 + " se sobreponen.");
            printRect(rect1, letra1);
            printRect(rect2, letra2);
            System.out.println("Area de sobreposición: " + rectanguloSobre(rect1,rect2).calcularArea());
            System.out.println("\nRectángulo formado por la sobreposición: " + rectanguloSobre(rect1,rect2));    
        
        }else if(Verificador.esJunto(rect1, rect2)){
            
            System.out.println("Rectangulo " + letra1 + " y " + letra2 + " se juntan.");
            printRect(rect1, letra1);
            printRect(rect2, letra2);
        
        }else{

            System.out.println("Rectangulo " + letra1 + " y " + letra2 + " son disjuntos.");
            printRect(rect1, letra1);
            printRect(rect2, letra2);

        }

        //---------------------------Ejercicio
        System.out.println(cr); //Mostrar Contenido del contenedor

        //Cerrar Scanner
        sc.close();

    }

    //Metodo encargado de imprimir un OBJ de tipo rectangulo
    public static void printRect(Rectangulo rect, char letra){
        System.out.println("Rectangulo " + Character.toString(letra) + ": " + rect);
    }

    /*Metodo encargado de retornar el rectangulo resultante de la
     * sobreposicion entre r1 y r2
     */
    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        // Calcular los límites de intersección en X
        double xMin = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                            Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double xMax = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                            Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
    
        // Calcular los límites de intersección en Y
        double yMin = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                            Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
        double yMax = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                            Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
    
        return new Rectangulo(new Coordenada(xMin, yMin), new Coordenada(xMax, yMax));
    }

}
