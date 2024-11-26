import java.io.DataOutput;
import java.util.Arrays;

class MergeSortDatosGenericos {
    public static void main(String[] args) {
        Integer[] numeros = {8, 3, 5, 1, 9, 4, 7};

        System.out.println("Arreglo original (enteros):");
        imprimirArreglo(numeros);

        numeros = mezclaDirecta(numeros);

        System.out.println("\nArreglo ordenado (enteros):");
        imprimirArreglo(numeros);

        String[] palabras = {"pera", "manzana", "banana", "naraja"};

        System.out.println("\nArreglo original (cadenas):");
        imprimirArreglo(palabras);

        palabras = mezclaDirecta(palabras);

        System.out.println("\nArreglo ordenado (cadenas):");
        imprimirArreglo(palabras);

        Persona[] personas = {
                new Persona("ana", 25),
                new Persona("gabriel", 25),
                new Persona("Ana", 30),
                new Persona("Luis", 25),
                new Persona("María", 22),
                new Persona("Pedro", 28)
        };

        personas = mezclaDirecta(personas);

        System.out.println("\nArreglo ordenado (personas):");
        imprimirArreglo(personas);
    }

    public static <T extends Comparable<T>> T[] mezclaDirecta(T[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mitad = arr.length / 2;
        T[] izquierda = Arrays.copyOfRange(arr, 0, mitad);
        T[] derecha = Arrays.copyOfRange(arr, mitad, arr.length);

        izquierda = mezclaDirecta(izquierda);
        derecha = mezclaDirecta(derecha);

        return mezclar(izquierda, derecha);
    }

    public static <T extends Comparable<T>> T[] mezclar(T[] izquierda, T[] derecha) {
        T[] resultado = Arrays.copyOf(izquierda, izquierda.length + derecha.length);
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                resultado[k++] = izquierda[i++];
            } else {
                resultado[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            resultado[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            resultado[k++] = derecha[j++];
        }

        return resultado;
    }

    public static <T> void imprimirArreglo(T[] arr) {
        for (T elemento : arr) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}