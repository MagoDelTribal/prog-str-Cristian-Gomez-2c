import java.util.Scanner;
public class Main{
    public static  void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int opc;
        /**
         * comenzamos con el ciclo qeu tendra el menu
         * @param opc  -> para recibir la opcion seleccionada
         */
        do {
            System.out.println("-----------Menu de opciones-----------");
            System.out.println("1:CalcularIMC ");
            System.out.println("2:Calcular are de un rectangulo");
            System.out.println("3:Convertir Celsius a Fahrenheit");
            System.out.println("4:calcular el area de un circulo");
            System.out.println("5:Salir");
            opc=sc.nextInt();

            switch (opc){
                case 1:
                    double pesoKG=obtenerDouble(sc,"ingresa tu peso en KG:");
                    double alturaM=obtenerDouble(sc, "ingresa tu altura en metros: ");
                    double IMC=calcularIMC(pesoKG, alturaM);
                    System.out.println("Su IMC es: "+IMC);
                    break;
                case 2:
                    double base=obtenerDouble(sc, "ingresa la base del rectangulo: ");
                    double altura=obtenerDouble(sc, "Ingresa la altura del rectangulo: ");
                    double area= areaRectangulo(base, altura);
                    System.out.println("el area del rectangulo es: "+area);
                    break;
                case 3:
                    double celsius=obtenerDouble(sc, "ingresa los grados celsius: ");
                    double fahrenheit=convertirCelsius(celsius);
                    System.out.println("los celcius: "+celsius+" es igua a Fahrenheit: "+fahrenheit);
                    break;
                case 4:
                    double radio=obtenerDouble(sc,"Dame el radio del circulo");
                    double areacirculo=calcularAreaCirculo(radio);
                    System.out.println("el area de tu circulo es: "+areacirculo);
                    break;
                case 5:
                    System.out.println("Estas saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion no valida ");
            }
        }while (opc!=5);
    }
    //BLOQUE DE METODOS
    /**
     * Metodo para obtener un numero double desde la consola
     *  @param sc -> objeto previamente instanciado
     *  @param mensaje -> mensaje a mosntrar en consola
     *  */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }
    /**
     * metodo para obtener y calcular IMC
     * @param pesoKG -> peso en kilos
     * @param alturaM ->altura en metros
     * @return imc
     */
    public static double calcularIMC(double pesoKG, double alturaM){
        return pesoKG / Math.pow(alturaM, 2);
    }
    /**
     * metodo para calcular el area de rectangulo
     *
     * @param base   -> expresado en centimetros
     * @param altura -> expresada en centimetros
     * @return double areaRectangulo
     */
    public static double areaRectangulo(double base, double altura){
        return  base*altura;
    }
    /**
     * metodo para convertis cesius
     * @param celsius -> esta sera la cantidad a convertir
     * @return double convertirCelsius
     */
    public static double convertirCelsius(double celsius){
        return (celsius*1.8)+32;
    }
    /**
     * area de un circulo
     * @param radio -> radio del circulo en centimetros
     * @return areaCirculo
     */
    public static double calcularAreaCirculo(double radio){
        return Math.PI * Math.pow(radio, 2);
    }

}