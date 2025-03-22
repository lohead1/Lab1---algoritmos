public class Verificador {
    //----------------
    public static boolean esSobrePos(Rectangulo r1,Rectangulo r2){
        //------------------------------------Eje Y
        double y1 = Math.min(r1.getEsquina1().getY(),r1.getEsquina2().getY());
        double y2 = Math.max(r1.getEsquina1().getY(),r1.getEsquina2().getY());
        double y3 = Math.min(r2.getEsquina1().getY(),r2.getEsquina2().getY());
        double y4 = Math.max(r2.getEsquina1().getY(),r2.getEsquina2().getY());

        //------------------------------------Eje X
        double x1 = Math.min(r1.getEsquina1().getX(),r1.getEsquina2().getX());
        double x2 = Math.max(r1.getEsquina1().getX(),r1.getEsquina2().getX());
        double x3 = Math.min(r2.getEsquina1().getX(),r2.getEsquina2().getX());
        double x4 = Math.max(r2.getEsquina1().getX(),r2.getEsquina2().getX());

        //Verifican si hay algun tipo de separacion en cualquiera de los ejes
        boolean sepY = y2 <= y3 || y4 <= y1;
        boolean sepX = x2 <= x3 || x4 <= x1;

        return !(sepY || sepX);

    }

    public static boolean esJunto(Rectangulo r1,Rectangulo r2){
        //------------------------------------Eje Y
        double y1 = Math.min(r1.getEsquina1().getY(),r1.getEsquina2().getY());
        double y2 = Math.max(r1.getEsquina1().getY(),r1.getEsquina2().getY());
        double y3 = Math.min(r2.getEsquina1().getY(),r2.getEsquina2().getY());
        double y4 = Math.max(r2.getEsquina1().getY(),r2.getEsquina2().getY());

        //------------------------------------Eje X
        double x1 = Math.min(r1.getEsquina1().getX(),r1.getEsquina2().getX());
        double x2 = Math.max(r1.getEsquina1().getX(),r1.getEsquina2().getX());
        double x3 = Math.min(r2.getEsquina1().getX(),r2.getEsquina2().getX());
        double x4 = Math.max(r2.getEsquina1().getX(),r2.getEsquina2().getX());

        /*Validan si hay algun tipo de separacion en cualquiera de los ejes
        ademas de validar si los ejes X o Y de los rectangulos estan juntos
        */
        boolean juntX = (x2 == x3 || x4 == x1) && !(y2 < y3 || y4 < y1);
        boolean juntY = (y2 == y3 || y4 == y1) && !(x2 < x3 || x4 < x1); 
        
        return (juntX || juntY); 

    }

    public static boolean esDisjunto(Rectangulo r1,Rectangulo r2){   
        //Verifica que no ocurra ninguno de los dos casos
        return !Verificador.esSobrePos(r1, r2) && !Verificador.esJunto(r1, r2);
    }
}
