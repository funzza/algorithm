package class002;

public class Code01_MergeSort {


    public static void mergeSort(int[] arr) {

        process(arr, 0, arr.length - 1);

    }

    public static void process(int[] arr, int left, int right) {

        if (left == right) {
            return;
        }

        int middle = left + ((right - left) >> 1);
        process(arr, left, middle);
        process(arr, middle + 1, right);
        merge(arr, left, right, middle);
    }

    public static void merge(int[] arr, int left, int right, int middle) {

        int i = 0;
        int[] helpArr = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = middle + 1;

        while (leftIndex <= middle && rightIndex <= right) {
            helpArr[i++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while (leftIndex <= middle) {
            helpArr[i++] = arr[leftIndex++];
        }

        while(rightIndex <= right) {
            helpArr[i++] = arr[rightIndex++];
        }

        for (i = 0; i < helpArr.length; i++) {
            arr[left + i] = helpArr[i];
        }
    }


    public static void main(String[] args) {
        int[] nums = {3,6,2,6,7,8,1,4,9,5};

        mergeSort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    
}
