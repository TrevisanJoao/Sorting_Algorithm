package sorting;

public class ShellSort extends Sorting {

    public static void shellSort(int[] nums) {
        int h = 1;
        while (3 * h + 1 < nums.length) h = 3 * h + 1;
        while (h > 0) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h && nums[j - h] > nums[j]; j -= h) {
                    exchange(nums, j - h, j);
                }
            }
            h /= 3;
        }
    }

    public int[] sortArray(int[] nums) {
        shellSort(nums);
        return nums;
    }
}
