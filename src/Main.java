import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "listas/personas.txt";
        String outputFile = "listas/personas_ordenadas.txt";

            List<Persona> sortedPersons = MergeSortExterno.externalSortInMemory(inputFile, 3, line -> {
                String[] parts = line.split(",");
                return new Persona(parts[0], Integer.parseInt(parts[1]));
            });

            // Escribir los datos ordenados en un archivo nuevo
            MergeSortExterno.writeToFile(outputFile, sortedPersons);

            System.out.println("La lista ha sido ordenada correctamente!!!\nDatos ordenados guardados en el archivo "+outputFile);
    }
}