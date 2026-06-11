import sorting.BubbleSort;
import sorting.InsertionSort;
import sorting.SelectionSort;
import sorting.HeapSort;
import sorting.ShellSort;
import sorting.MergeSort;
import sorting.QuickSort;

import java.util.Random;

public class Main {

    static final long SEED = 42;

    public static void main(String[] args) {

        // --- Ascending ---
        System.out.println("=== Ascending ===");
        run(generateAscending(128),  generateAscending(256),  generateAscending(512),
            generateAscending(1024), generateAscending(2048), generateAscending(4096));

        // --- Descending ---
        System.out.println("\n=== Descending ===");
        run(generateDescending(128),  generateDescending(256),  generateDescending(512),
            generateDescending(1024), generateDescending(2048), generateDescending(4096));

        // --- Random (no duplicates) ---
        System.out.println("\n=== Random ===");
        run(generateRandom(128),  generateRandom(256),  generateRandom(512),
            generateRandom(1024), generateRandom(2048), generateRandom(4096));

        // --- Random with duplicates ---
        System.out.println("\n=== Random+Dups ===");
        run(generateRandomWithDups(128),  generateRandomWithDups(256),  generateRandomWithDups(512),
            generateRandomWithDups(1024), generateRandomWithDups(2048), generateRandomWithDups(4096));
    }

    private static void run(int[] a128, int[] a256, int[] a512,
                            int[] a1024, int[] a2048, int[] a4096) {
        int[][] arrays = {a128, a256, a512, a1024, a2048, a4096};
        int[]   sizes  = {128, 256, 512, 1024, 2048, 4096};

        for (int i = 0; i < arrays.length; i++) {
            int[] base = arrays[i];
            System.out.println("  -- Size: " + sizes[i] + " --");
            benchmark("Bubble Sort",    base, arr -> BubbleSort.bubbleSort(arr));
            benchmark("Insertion Sort", base, arr -> InsertionSort.insertionSort(arr));
            benchmark("Selection Sort", base, arr -> SelectionSort.selectionSort(arr));
            benchmark("Heap Sort",      base, arr -> HeapSort.heapSort(arr));
            benchmark("Shell Sort",     base, arr -> ShellSort.shellSort(arr));
            benchmark("Merge Sort",     base, arr -> MergeSort.mergeSort(arr));
            benchmark("Quick Sort",     base, arr -> QuickSort.quickSort(arr));
        }
    }

    private static void benchmark(String name, int[] base, java.util.function.Consumer<int[]> sort) {
        int[] arr    = base.clone();
        long start   = System.nanoTime();
        sort.accept(arr);
        long elapsed = System.nanoTime() - start;
        System.out.printf("    %-15s : %,d ns%n", name, elapsed);
    }

    private static int[] generateAscending(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i + 1;
        return arr;
    }

    private static int[] generateDescending(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }

    private static int[] generateRandom(int size) {
        int[] arr = generateAscending(size);
        Random rng = new Random(SEED);
        for (int i = size - 1; i > 0; i--) {
            int j   = rng.nextInt(i + 1);
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
        return arr;
    }

    private static int[] generateRandomWithDups(int size) {
        Random rng = new Random(SEED);
        int[] arr  = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rng.nextInt(size / 2) + 1;
        return arr;
    }
}
