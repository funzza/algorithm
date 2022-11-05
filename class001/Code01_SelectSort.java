package class001;


public class Code01_SelectSort{

    public static void sort(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(i, minIndex, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,6,7,8,1,4,9,5};

        sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}