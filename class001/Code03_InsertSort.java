package class001;

public class Code03_InsertSort {

    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,6,7,8,1,4,9,5};

        sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    
}
