/*
    Learn about some simple sorting algorithms and compare their pros and cons:
        1. Selection Sort
        2. Bubble Sort
        3. Insert Sort
*/

public class Sorting {
    public static void printArray(int[] arr) {
        System.out.print("\t[");
        for (int i = 0; i <= arr.length - 2; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }


    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            printArray(arr);
            return;
        }

        // After each round of sorting, the leftmost number must be the smallest
        for (int i = 0; i <= arr.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                /*
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                */
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }

        System.out.println("Selection Sort:");
        printArray(arr);
    }


    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            printArray(arr);
            return;
        }

        // After each round of sorting, the rightmost number must be the largest
        for (int end = arr.length - 1; end >= 1; end--) {
            for (int j = 0; j <= end - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        System.out.println("Bubble Sort:");
        printArray(arr);
    }


    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            printArray(arr);
            return;
        }

        // After each round of sorting, the left side of the current position is always ordered
        // The time complexity is variable with the different situation of the data
        for (int end = 1; end <= arr.length - 1; end++) {  // Start at 1 because the single element do not need sort.
            // This is a dynamic progress, because once the new number is larger than its left one, the program will
            //   automatically interrupt. For this reason, the insertion sort is sometimes greater than the bubble sort.
            for (int j = end - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }

        System.out.println("Insertion Sort:");
        printArray(arr);
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {10, 21, 5, 48, 22, 64, 23, 56, 77, 41, 23, 10, 3, 51};
        System.out.println("The original array:");
        printArray(arr);

        // Look:    (N + N-1 + ... + 1) times
        // Compare: (N-1 + N-2 + ... + 1) times
        // Swap:    (1 + 1 + ... + 1) = N times
        // Time complexity: O(N^2), Ω(N^2), Θ(N^2)
        selectionSort(arr);

        // Look:    x
        // Compare: must be {x-1}
        // Swap:    [(s_1 < N) + (s_2 < N-1) + ... + (s_N-1 < 2)] times
        // Time complexity: O(N^2), Ω(N), Θ(N^2)
        bubbleSort(arr);

        // Look:    x
        // Compare: maybe arbitrary element in {1, 2, ..., x}
        // Swap:    Variable
        // Time complexity: O(N^2), Ω(N), Θ(N^2)
        insertionSort(arr);
    }
}
