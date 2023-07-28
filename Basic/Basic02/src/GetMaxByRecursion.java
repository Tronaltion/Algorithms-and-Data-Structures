public class GetMaxByRecursion {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 56, 4, 87, 12, 21, 3, 2, 41};

        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }
}