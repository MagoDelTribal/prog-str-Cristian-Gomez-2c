public class validator {

    public static boolean idEsValido(int id) {
        return id > 0;
    }

    public static boolean nombreEsValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean idEstaRepetido(int id, persona[] lista, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (lista[i].id == id) {
                return true;
            }
        }
        return false;
    }
}