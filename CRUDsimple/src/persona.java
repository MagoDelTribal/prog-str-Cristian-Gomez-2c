public class persona {
    public int id;
    public String name;
    private boolean isActivo;

    public persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActivo = true;
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
    public boolean isActivo() {
        return isActivo;
    }
    public void setActivo(boolean activo) {
        isActivo = activo;
    }
    @Override
    public String toString() {
        return "id: " + id + " | nombre: " + name + " | activo: " + isActivo;
    }
}