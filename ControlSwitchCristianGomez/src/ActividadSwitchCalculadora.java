import java.util.Scanner;
public class  ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int opc;
        System.out.println("-----------Menu de opciones-----------");
        System.out.println("1:Sumar");
        System.out.println("2:Restar");
        System.out.println("3:Multiplicar");
        System.out.println("4:Dividir");
        opc = es.nextInt();
        double n1, n2;
        /**
         * menu de opciones
         */
        switch (opc) {
            case 1:
                System.out.println("------------SUMA-------------");
                 n1 = obtenerDouble(es, "ingresa un numero: ");
                 n2 = obtenerDouble(es, "ingresa otro numero: ");
                double suma = obtenerSuma(n1, n2);
                System.out.println("la suma de: " + n1 + " + " + n2 + " = " + suma);
                break;
            case 2:
                System.out.println("----------RESTA---------");
                 n1 = obtenerDouble(es, "ingresa un numero: ");
                 n2 = obtenerDouble(es, "ingresa otro numero: ");
                double resta= obtenerResta(n1, n2);
                System.out.println("la resta de: " + n1 + " - " + n2 + " = " + resta);
                break;
            case 3:
                System.out.println("----------MULTIPLICACION---------");
                n1 = obtenerDouble(es, "ingresa un numero: ");
                n2 = obtenerDouble(es, "ingresa otro numero: ");
                double mult= obtenerMulti(n1, n2);
                System.out.println("la multiplicacion de: " + n1 + " X " + n2 + " = " + mult);
                break;
            case 4:
                System.out.println("----------DIVISION---------");
                n1 = obtenerDouble(es, "ingresa un numero: ");
                n2 = obtenerDouble(es, "ingresa otro numero: ");
                double div= obtenerDiv(n1, n2);
                System.out.println("la  division de: " + n1 + " / " + n2 + " = " + div);
                break;
            default:
                System.out.println("error de eleccion");
                break;
        }


    }

    public static double obtenerDouble(Scanner es, String mensaje) {
        System.out.println(mensaje);
        return es.nextDouble();
    }

    /**
     * @param n1 -> primer numero que se sumara
     * @param n2 -> segundo numero que se sumara
     * @return obtenerSuma -> la suma de los numeros
     */
    public static double obtenerSuma(double n1, double n2) {
        return n1 + n2;
    }

    /**
     * @param n1 ->primer numero
     * @param n2 ->numero que restara
     * @return obtenerResta -> el resultado de la resta
     */
    public static double obtenerResta(double n1, double n2) {
        return n1 - n2;
    }

    /**
     * @param n1 -> primer numero
     * @param n2 -> numero que multiplicara
     * @return obtenerMMultiplicacion -> el resultado de la multiplicacion de los numeros
     */
    public static double obtenerMulti(double n1, double n2) {
        return n1 * n2;
    }

    /**
     * @param n1 -> numero base
     * @param n2 -> numero que dividira al primero
     * @return obtenerDivision -> el resultado de la divisioon
     */
    public static double obtenerDiv(double n1, double n2){
        if(n1 <=0 || n2<=0) {
            throw new IllegalArgumentException("No puede haber un cero en division.");
        }
        else {
            return n1/n2;
        }
    }
}

