package sorting;

public class HeapSort extends Sorting {

    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            exchange(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    private static void maxHeapify(int[] nums, int i, int n) {
        int max = 2 * i + 1;
        if (max + 1 < n && nums[max] < nums[max + 1]) max++;
        if (max < n && nums[max] > nums[i]) {
            exchange(nums, i, max);
            maxHeapify(nums, max, n);
        }
    }

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}
