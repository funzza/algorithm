package class002;

public class Code07_QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int)Math.random() * (right - left + 1), right);
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] -1);
            quickSort(arr, p[1] + 1, right);
        }
    }
g
    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;

        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else{
                left++;
            }
        }
        swap(arr, more, right);
        return new int[] {less +1, more};
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
