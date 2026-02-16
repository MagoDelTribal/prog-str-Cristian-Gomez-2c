public class Validator {

    public static boolean idEsValido(int id) {
        return id > 0;
    }

    public static boolean nombreEsValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean idEstaRepetido(int id, Alumno[] lista, int cantidad) {
        for (int
             i = 0; i < cantidad; i++) {
            if (lista[i].id == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean PromedioValido(double promedio){
        return promedio > 0 && promedio <=10;
    }
}