public class QuickSort {
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            // Choose a random number without overstepping the edge,
            //  and change it with the rightmost number
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);

            // Actually p is a tuple, but java do not have such a datatype,
            //  so here use an array to save the 2 value of corresponding edges.
            int[] p = partition(arr, L, R);  // (left edge, right edge)
            quickSort(arr, L, p[0]);  // sort the < section
            quickSort(arr, p[1], R);  // sort the > section
        }
    }


    public static int[] partition(int[] arr, int L, int R) {
        /* This is a function that deals with arr[1, 2, ..., r],
            where the arr[r] is as the partition value, r* -> arr[r],
            the array has been divided into 3 sections: <arr[r]  ==arr[r]  >arr[r].
         */

        int lessEdge = L - 1;  // Right edge of the < section
        int greaterEdge = R;  // Left edge of the > section

        int i = L;
        // i is the pointer of the current number,
        //  R is the pointer of the partition value,
        //  arr[R] is the partition value
        while (i < greaterEdge) {
            if (arr[i] < arr[R]) {
                swap(arr, ++lessEdge, i++);
            } else if (arr[i] > arr[R]) {
                swap(arr, --greaterEdge, i);
            } else {  // arr[i] == arr[num]
                i++;
            }
        }
        // Put the partition into the == section
        // Now there are three sections:    <           ==           >
        //                               lessEdge  lessEdge + 1  greaterEdge
        swap(arr, greaterEdge, R);

        // Except the == section, and return the 2 edges of the < & > section
        return new int[] { lessEdge, greaterEdge + 1 };
    }


    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 56, 4, 87, 12, 21, 3, 2, 41};

        quickSort(arr, 0, arr.length - 1);

        for (int j = 0; j <= arr.length - 1; j++) {
            System.out.print(arr[j] + ",\t");
        }
    }
}
