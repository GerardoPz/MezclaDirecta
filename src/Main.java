import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {8,7,9,2,4};
        System.out.println("Arreglo original:");
        imprimirArreglo(numeros);

        System.out.println("\nIniciando el proceso de ordenación con mezcla directa...");
        numeros = mezclaDirecta(numeros);

        System.out.println("\nArreglo ordenado:");
        imprimirArreglo(numeros);
    }

    public static int[] mezclaDirecta(int[] arr) {
        // Caso base: Si el arreglo tiene solo un elemento, ya está ordenado
        if (arr.length <= 1) {
            return arr;
        }

        // Dividir el arreglo en dos mitades
        int mitad = arr.length / 2;
        System.out.println("Mitad: " + mitad);
        System.out.println("\nDividiendo el arreglo: " + Arrays.toString(arr));
        int[] izquierda = Arrays.copyOfRange(arr, 0, mitad);
        int[] derecha = Arrays.copyOfRange(arr, mitad, arr.length);
        System.out.println("Izquierda: " + Arrays.toString(izquierda));
        System.out.println("Derecha: " + Arrays.toString(derecha));

        // Ordenar recursivamente cada mitad
        izquierda = mezclaDirecta(izquierda);
        derecha = mezclaDirecta(derecha);

        // Mezclar las dos mitades ordenadas
        System.out.println("\nMezclando:");
        System.out.println("Izquierda ordenada: " + Arrays.toString(izquierda));
        System.out.println("Derecha ordenada: " + Arrays.toString(derecha));
        int[] resultado = mezclar(izquierda, derecha);
        System.out.println("Resultado de la mezcla: " + Arrays.toString(resultado));
        return resultado;
    }

    // Método para mezclar dos arreglos ordenados
    public static int[] mezclar(int[] izquierda, int[] derecha) {
        int[] resultado = new int[izquierda.length + derecha.length];
        int i = 0, j = 0, k = 0;

        // Combinar elementos de los dos arreglos
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                resultado[k++] = izquierda[i++];
            } else {
                resultado[k++] = derecha[j++];
            }
        }

        // Copiar los elementos restantes de la izquierda
        while (i < izquierda.length) {
            resultado[k++] = izquierda[i++];
        }

        // Copiar los elementos restantes de la derecha
        while (j < derecha.length) {
            resultado[k++] = derecha[j++];
        }

        return resultado;
    }

    public static void imprimirArreglo(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}