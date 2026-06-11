package sorting;

public class InsertionSort extends Sorting {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                exchange(a, j - 1, j);
            }
        }
    }

    public int[] sortArray(int[] nums) {
        insertionSort(nums);
        return nums;
    }
}
