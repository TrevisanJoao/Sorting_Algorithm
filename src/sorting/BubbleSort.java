package sorting;

public class BubbleSort extends Sorting {

    public static void bubbleSort(int[] a) {
        boolean exchange;
        do {
            exchange = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    exchange(a, i, i + 1);
                    exchange = true;
                }
            }
        } while (exchange);
    }

    public int[] sortArray(int[] nums) {
        bubbleSort(nums);
        return nums;
    }
}
