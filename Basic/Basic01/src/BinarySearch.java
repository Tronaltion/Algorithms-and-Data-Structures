/*
    Binary Search:
        Time Complexity: O(log_2(N))

        1. (Ordered Array) Search a specific number in this array.
        2. (Ordered Array) Get the leftmost number which is greater than a specific number;
                           or the rightmost number which is less than a specific number.
        3. (Unordered Array, Every number is different with its neighbors) Search an arbitrary local minimum value with the
             time complexity less than O(N).
*/

public class BinarySearch {
    public static void printArray(int[] arr) {
        System.out.print("\t[");
        for (int i = 0; i <= arr.length - 2; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }


    public static void searchNum1(int[] arr, int spec_num) {
        if (arr == null) {
            System.out.println("Array is null!");
            return;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = bisection(left, right);

        int count = 1;
        while (left < right) {
            if (arr[mid] > spec_num) {
                right = mid;
            } else if (arr[mid] < spec_num) {
                left = mid;
            } else if (arr[mid] == spec_num) {
                System.out.println("The number has been found! Position: " + mid);
                System.out.println("\tTotal loop times: " + count);
                return;
            }
            mid = bisection(left, right);
            count++;
        }
    }


    public static void searchNum2(int[] arr, int spec_num) {
        if (arr == null) {
            System.out.println("Array is null!");
            return;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid = bisection(left, right);

        // Notice the "=" condition in if statements
        leftmostSearch(arr, spec_num, left, right, mid);
        rightmostSearch(arr, spec_num, left, right, mid);
    }


    public static void leftmostSearch(int[] arr, int spec_num, int left, int right, int mid) {
        int leftmost = 0;

        while (left < right) {
            if (left == mid || right == mid + 1) {
                System.out.println("The leftmost number which is greater than " + spec_num + " is " + leftmost);
                System.out.println("\t Position: " + (mid + 1));
                return;
            }

            if (arr[mid] >= spec_num) {
                right = mid;
                leftmost = arr[mid];
            } else {
                left = mid;
            }
            mid = bisection(left, right);
        }
    }


    public static void rightmostSearch(int[] arr, int spec_num, int left, int right, int mid) {
        int rightmost = 0;

        while (left < right) {
            if (left == mid || right == mid + 1) {
                System.out.println("The rightmost number which is less than " + spec_num + " is " + rightmost);
                System.out.println("\t Position: " + mid);
                return;
            }

            if (arr[mid] <= spec_num) {
                left = mid;
                rightmost = arr[mid];
            } else {
                right = mid;
            }
            mid = bisection(left, right);
        }
    }


    public static void searchLocalMin(int[] arr) {
        // Observe whether there exists a local minimum at both ends of the array
        if (arr[0] < arr[1]) {
            System.out.println("The Local Minimum is " + arr[0]);
            System.out.println("\tPosition: " + 0);
            return;
        } else if (arr[arr.length - 2] > arr[arr.length - 1]) {
            System.out.println("The Local Minimum is " + arr[arr.length - 1]);
            System.out.println("\tPosition: " + (arr.length - 1));
            return;
        }

        // If the above code has not been executed, the data plot of this array must be like \.../, which means that
        //   there must be at least one inflection point (i.e., local minimum) in the array
        int left = 0;
        int right = arr.length - 1;
        int mid = bisection(left, right);

        while (left < right) {
            if (left == mid || right == mid + 1) {
                System.out.println("One of the local minimums is " + arr[mid]);
                System.out.println("\tPosition: " + mid);
                return;
            }

            if (arr[mid - 1] <= arr[mid]) {
                right = mid;
            } else {
                left = mid;
            }
            mid = bisection(left, right);
        }
    }


    public static int bisection(int left, int right) {
        return (int) left + (right - left) / 2;
    }


    public static void main(String[] args) {
        int[] ordered_arr = {3, 5, 10, 10, 21, 22, 23, 23, 23, 41, 48, 51, 56, 64, 77};
        int[] unordered_arr = {21, 10, 5, 48, 22, 64, 23, 56, 77, 23, 41, 23, 10, 3, 51};
        System.out.println("The Ordered Array:");
        printArray(ordered_arr);

        searchNum1(ordered_arr, 56);
        searchNum2(ordered_arr, 50);

        System.out.println("==================================================================");
        System.out.println("The Unordered Array:");
        printArray(unordered_arr);

        searchLocalMin(unordered_arr);
    }
}
