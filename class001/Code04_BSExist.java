package class001;

public class Code04_BSExist{

    public static int exist(int[] arr, int num) {

        int left = 0;
        int right = arr.length - 1;
        int middle = ((right - left) >> 1) + left;

        while(left <= right) {
            if (num > arr[middle]) {
                left = middle + 1;
                middle = ((right - left) >> 1) + left;
            } else if (num < arr[middle]) {
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            } else {
                return middle;
            }
        }

        return -1;
    }
    

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,9,11,23,43,221};

        int result = exist(arr, 6);

        System.out.println(result);
    }


}