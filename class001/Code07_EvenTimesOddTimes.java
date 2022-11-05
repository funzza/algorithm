package class001;

public class Code07_EvenTimesOddTimes {
    
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0, onlyOne = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }

        int rightOne = eor & (~eor + 1);
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
    }

}
