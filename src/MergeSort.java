import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static <T extends Comparable<T>> List<T> mergeSort(List<T> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int middle = arr.size() / 2;
        List<T> leftArray = new ArrayList<>(arr.subList(0, middle));
        List<T> rightArray = new ArrayList<>(arr.subList(middle, arr.size()));

        List<T> sortedLeftArray = mergeSort(leftArray);
        List<T> sortedRightArray = mergeSort(rightArray);

        return merge(sortedLeftArray, sortedRightArray);
    }

    // Método genérico para mezclar (merge) dos listas ordenadas
    private static <T extends Comparable<T>> List<T> merge(List<T> leftArr, List<T> rightArr) {
        List<T> result = new ArrayList<>();

        while (!leftArr.isEmpty() && !rightArr.isEmpty()) {
            if (leftArr.get(0).compareTo(rightArr.get(0)) <= 0) {
                result.add(leftArr.remove(0));
            } else {
                result.add(rightArr.remove(0));
            }
        }

        // Agregar los elementos restantes
        result.addAll(leftArr);
        result.addAll(rightArr);

        return result;
    }
}