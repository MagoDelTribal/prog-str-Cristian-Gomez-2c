public class Gestion{
    public persona[] personas = new persona[20];
    public int contador = 0;

    public void agregarPersona(int id, String name) {
        if (contador < 20) {
            personas[contador] = new persona(id, name);
            System.out.println("sistema: " + name + " guardado.");
            contador++;
        }
    }

    public int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id && personas[i].isActivo()) {
                return i;
            }
        }
        return -1;
    }

    public void darBaja(int id) {
        int idd = buscarIndice(id);
        if (idd != -1) {
            personas[idd].setActivo(false);
            System.out.println("sistema: baja realizada.");
        } else {
            System.out.println("sistema: no encontrado.");
        }
    }

    public void mostrarActivas() {
        System.out.println("---ACTIVAS---");
        boolean hayPersonas = false;

        for (int i = 0; i < contador; i++) {
            if (personas[i].isActivo()) {
                System.out.println(personas[i].toString());
                hayPersonas = true;
            }
        }
        if (!hayPersonas) {
            System.out.println("no hay registros activos para mostrar.");
        }
    }

    public void actualizar(int id, String nuevoName) {
        int idd = buscarIndice(id);
        if (idd != -1) {
            personas[idd].setName(nuevoName);
            System.out.println("sistema: actualizado.");
        } else {
            System.out.println("sistema: no se puede actualizar.");
        }
    }
}