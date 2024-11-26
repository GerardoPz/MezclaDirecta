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
        int compararEdad = Integer.compare(this.edad, otra.edad);
        if(compararEdad != 0){
            return compararEdad;
        }
        return this.nombre.compareTo(otra.nombre);
    }

    @Override
    public String toString() {
        return nombre + "," + edad;
    }
}