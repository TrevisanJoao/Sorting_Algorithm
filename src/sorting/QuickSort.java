package sorting;

public class QuickSort extends Sorting {

    public static void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) return;
        int p = partition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                exchange(nums, ++i, j);
            }
        }
        exchange(nums, i + 1, high);
        return i + 1;
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }
}
