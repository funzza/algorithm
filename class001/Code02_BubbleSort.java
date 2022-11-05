package class001;

public class Code02_BubbleSort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                }
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,6,7,8,1,4,9,5};

        sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}