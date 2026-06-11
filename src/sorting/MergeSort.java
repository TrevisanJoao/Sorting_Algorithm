package sorting;

public class MergeSort extends Sorting {

    public static void mergeSort(int[] nums) {
        int[] aux = new int[nums.length];
        divide(nums, aux, 0, nums.length - 1);
    }

    private static void divide(int[] nums, int[] aux, int low, int high) {
        if (low >= high) return;
        int middle = (low + high) / 2;
        divide(nums, aux, low, middle);
        divide(nums, aux, middle + 1, high);
        conquer(nums, aux, low, middle, high);
    }

    private static void conquer(int[] nums, int[] aux, int low, int middle, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = nums[k];
        }
        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++) {
            if      (i > middle)          nums[k] = aux[j++];
            else if (j > high)            nums[k] = aux[i++];
            else if (aux[j] < aux[i])     nums[k] = aux[j++];
            else                          nums[k] = aux[i++];
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
}
