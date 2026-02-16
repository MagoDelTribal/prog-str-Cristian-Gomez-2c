public class Alumno {
    public int id;
    public String name;
    private boolean isActivo;
    public double promedio;

    public Alumno(int id, String name, double promedio) {
        this.id = id;
        this.name = name;
        this.promedio = promedio;
        this.isActivo = true;
    }

    public double getPromedio(){
        return promedio;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }

    @Override
    public String toString() {
        // Agregué un espacio para que se vea mejor
        return "id: " + id + " | nombre: " + name + " | promedio: " + promedio + " | activo: " + isActivo;
    }
}