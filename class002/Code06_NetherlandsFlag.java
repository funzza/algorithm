package class002;

public class Code06_NetherlandsFlag {


    public static void netherLandsFlag1(int[] arr, int num) {
        int leftIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, ++leftIndex, i);
            }
        }
    }

    public static void netherLandsFlag2(int[] arr, int num) {
        int leftIndex = -1;
        int rightIndex = arr.length;

        int index = 0;

        while (index < rightIndex) {
            if (arr[index] < num) {
                swap(arr, ++leftIndex, index++);
            } else if (arr[index] > num) {
                swap(arr, --rightIndex, index);
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,7,5,3,2,5,5,6,1,2,8,7,2};

        // netherLandsFlag1(arr, 5);
        netherLandsFlag2(arr, 5);
        for (int num : arr) {
            System.out.println(num);
        }
    }
    
}
