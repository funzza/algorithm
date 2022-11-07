package class001;

public class Code08_GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }


    public static int process(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        }

        int middle = left + ((right - left) >> 1);
        int leftMax = process(arr, left, middle);
        int rightMax = process(arr, middle + 1, right);

        return Math.max(leftMax, rightMax);
    }


    public static void main(String[] args) {
        int[] arr = {1,3,2,444,2341,3,23,45,23,1,2,6,2343,2,3,2,36,645};
        
        int result = getMax(arr);

        System.out.println(result);
    }
    
}
