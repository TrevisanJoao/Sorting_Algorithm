package sorting;

public class SelectionSort extends Sorting {

    public static void selectionSort(int[] a) {
        for (int min, i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exchange(a, min, i);
        }
    }

    public int[] sortArray(int[] nums) {
        selectionSort(nums);
        return nums;
    }
}
