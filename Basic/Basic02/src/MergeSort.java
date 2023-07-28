public class MergeSort {
    public static void divide(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 1);
        divide(arr, L, mid);
        divide(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;

        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i <= help.length - 1; i++) {
            arr[L + i] = help[i];
        }

        for (int j = 0; j <= arr.length - 1; j++) {
            System.out.print(arr[j] + ",\t");
        }
        System.out.println("L = " + L + ", M = " + M + ", R = " + R);
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 56, 4, 87, 12, 21, 3, 2, 41};

        divide(arr, 0, arr.length - 1);

        for (int j = 0; j <= arr.length - 1; j++) {
            System.out.print(arr[j] + ",\t");
        }
    }
}
