package class001;

public class Code05_BSNeartLeft {

    public static int neartLeft(int[] arr, int num) {

        int left = 0;
        int right = arr.length - 1;
        int middle = ((right - left) >> 1) + left;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            if (num > arr[middle]) {
                left = middle + 1;
                middle = ((right - left) >> 1) + left;
            } else if (num < arr[middle]) {
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            } else {
                result = middle;
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            }
        }

        if (result < Integer.MAX_VALUE) {
            return result;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,5,5,6,6,7,8,8,9,9,11,11,11,23,43,43,43,221};

        int result = neartLeft(arr, 999);

        System.out.println(result);
    }

    
}
