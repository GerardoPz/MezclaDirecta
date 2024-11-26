import java.io.*;
import java.util.*;

public class MergeSortExterno {

    // Método principal de ordenación externa, ahora solo en memoria
    public static <T extends Comparable<T>> List<T> externalSortInMemory(String inputFile, int memoryLimit, DataParser<T> parser) throws IOException {
        List<T> allData = readAndDivideInputFile(inputFile, memoryLimit, parser);
        allData.sort(Comparable::compareTo);
        return allData;
    }

    private static <T> List<T> readAndDivideInputFile(String inputFile, int memoryLimit, DataParser<T> parser) throws IOException {
        List<T> allData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;

        while ((line = reader.readLine()) != null) {
            try {
                T data = parser.parse(line);
                allData.add(data);
            } catch (Exception e) {
                System.err.println("Error procesando línea: " + line + " - " + e.getMessage());
            }
        }
        reader.close();
        return allData;
    }

    public static <T> void writeToFile(String outputFile, List<T> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        }
    }
}

