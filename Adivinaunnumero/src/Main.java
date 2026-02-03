import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        boolean gano = false;
        int limiteIntentos = 7;
        int esmayor=0;
        int esmenor=0;
        int secreto= random.nextInt(100)+1; //sirve para genrar un numero entero entre 1...100
        System.out.println(secreto);
        System.out.println("Adivina el numero (1-100) "+"tienes: "+limiteIntentos+" intentos para lograrlo" );

        while(intentos<limiteIntentos){
            int numero=obtenerNumeroValido("Intento: "+(intentos+1),sc,min,max); //vamos a crear metodo para pedir un numero valido
            intentos++;
            if(numero==secreto){
                System.out.println("Felicidades ganaste en el intento: "+intentos);
                gano=true;
                if (esmayor>0 || esmenor>0){
                    System.out.println("veces en las que diste numeros mayores que el numero secreto: "+esmayor);
                    System.out.println("veces en las que diste numeros inferiores que el numero secreto: "+esmenor);
                }
                break;
            }else if(numero> secreto){
                System.out.println("El numero secreto es menor a "+numero);
                esmayor+=1;
            }else{
                System.out.println("El numero secreto es mayor a "+numero);
                esmenor+=1;
            }
        }
        if(!gano){ //bandera para saber si gano o perdio
            System.out.println("Perdiste, el numero secreto era: "+secreto);
            if (esmayor>0 || esmenor>0){
                System.out.println("veces en las que diste numeros mayores que el numero secreto: "+esmayor);
                System.out.println("veces en las que diste numeros menores que el numero secreto: "+esmenor);
            }
        }
    }
    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max){
        int entrada;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){ // para saber si el dato es numerico (int)
                entrada=sc.nextInt();
                if(entrada>=min && entrada<=max){
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera de rango (1-100)");
            }else{
                System.out.println("El dato ingresado no es numerico");
                sc.next(); //Consume el dato de entrada, para evitar un ciclo infinito
            }

        }

    }
}
