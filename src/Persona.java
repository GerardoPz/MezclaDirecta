class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona otra) {

        return CharSequence.compare(this.nombre, otra.nombre);

    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}