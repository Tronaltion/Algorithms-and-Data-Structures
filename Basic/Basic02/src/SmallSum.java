public class SmallSum {
    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int M = L + ((R - L) >> 1);
        return process(arr, L, M)
                + process(arr, M + 1, R)
                + merge(arr, L, M, R);
    }


    public static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;

        int p1 = L;
        int p2 = M + 1;

        int count = 0;

        while (p1 <= M && p2 <= R) {
            count += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            //                  < rather than <=
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i <= help.length - 1; i++){
            arr[L + i] = help[i];
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 56, 4, 87, 12, 21, 3, 2, 41};

        int smallSum = process(arr, 0, arr.length - 1);
        System.out.println(smallSum);
    }
}
