/*
    Exclusive OR: ^ (Bitwise Operator)
        For every corresponding bit of 2 numbers: Same is 0, Different is 1.
        也可理解为 <无进位相加>

    Properties of XOR:
        1. 0 ^ N = N
           N ^ N = 0
        2. Commutative Law: a ^ b = b ^ a
            => the result of XOR is independent of the order of XOR
        3. Associative Law: a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c

    Problem 1.
        In an int arr[], there is only one number appears oddly times, and other numbers appear evenly times. The
    problem is:
    (1) How to find the odd-times number?
    (2) If there are two numbers appear oddly times, how to find them?
*/

public class ExclusiveOR {
    public static void printArray(int[] arr) {
        System.out.print("array = [");
        for (int i = 0; i <= arr.length - 2; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1] + "]");
        System.out.println("----------------------------------------------");
    }
    public static void printOddTimesNum1(int[] arr) {
        printArray(arr);

        // Get the odd-times number
        // 0 ^ N = N; N ^ N = 0
        // Use 0 ^= every element: the even-times numbers finally get 0;
        //                         the odd-times numbers finally get themselves.
        int eor = 0;
        for (int element : arr) {
            eor ^= element;
        }

        System.out.println("The odd-times number = " + eor);
    }

    public static void printOddTimesNum2(int[] arr) {
        printArray(arr);

        // Get the XOR of the two odd-times number
        int eor = 0;
        for (int element : arr) {
            eor ^= element;  // = a ^ b
        }

        System.out.println("exclusive OR in Oct = " + eor);
        System.out.println("             in Bin = " + Integer.toBinaryString(eor));

        int rightOne = eor & (~eor + 1);  // Extract the rightmost 1 with following 0s
        System.out.println("the rightest 1 of XOR is " +
                           Integer.toBinaryString(rightOne));  // 106 == 0110 1010
        System.out.println("----------------------------------------------");

        // Divide the two odd-times number
        int a = 0;  // eor’
        for (int element : arr) {
            // ____ __?_ & 0000 0010: If ? == 0, the result is 0000 0000, otherwise 0000 0010
            // 0000 0000: Filter all numbers whose bit is 0 on the location of 1 of 0000 0010
            // 0000 0010: Filter all numbers whose bit is 1 on the location of 1 of 0000 0010
            if ((element & rightOne) == 0B10) {
                a ^= element;  // a = 75 == 0100 1011
            }
        }
        int b = a ^ eor;  // b = 33 == 0010 0001

        System.out.println("a = " + a + " = " + Integer.toBinaryString(a));
        System.out.println("b = " + b + " = " + Integer.toBinaryString(b));
    }


    public static void main(String[] args) {
        int[] myList1 = {78, 78, 78, 78, 56, 56, 75, 75, 75, 33, 33};
        int[] myList2 = {78, 78, 78, 78, 56, 56, 75, 75, 75, 33, 33, 33};

        printOddTimesNum1(myList1);
        System.out.println("==============================================");
        printOddTimesNum2(myList2);
    }
}