package class002;

public class Code02_SmallSum {


    public static int smallSum(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int middle = left + ((right - left) >> 1);

        return 
            process(arr, left, middle) +
            process(arr, middle + 1, right) + 
            merge(arr, left, right, middle);    
    }

    public static int merge(int[] arr, int left, int right, int middle) {

        int[] help = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = middle + 1;
        int result = 0;

        while (leftIndex <= middle && rightIndex <= right) {
            result += arr[leftIndex] < arr[rightIndex] ? arr[leftIndex] * (right - rightIndex + 1) : 0;
            help[index++] = arr[leftIndex] <= arr[rightIndex] ? arr[leftIndex++] : arr[rightIndex++];
        }

        while(leftIndex <= middle) {
            help[index++] = arr[leftIndex++];
        }

        while(rightIndex <= right) {
            help[index++] = arr[rightIndex++];
        }

        for (index = 0; index < help.length; index++) {
            arr[left + index] = help[index];
        }

        return result;

    }


    public static void main(String[] args) {
        
        int[] arr = {1,3,4,2,5};

        System.out.println(smallSum(arr));
    }
    
}
  