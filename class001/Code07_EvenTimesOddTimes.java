package class001;

public class Code07_EvenTimesOddTimes {
    
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }

        // 一个数取反后 得到的结果与原数的每一位都相反
        // 在取反的这个结果上再加上1,则至少有一位与原数相同
        // 而这一位就是这个数最右边的一个1（这里不能准确的总结出相关的数学规律，
        // 可以写几个数代入尝试）
        // 原数与补码（取反+1）进行与运算，得到其它位为0，原数最右最右边的一个1保留的数
        int onlyOne1 = 0;
        int rightOne = eor & (~eor + 1);        
        for (int cur : arr) {
            // 与运算：同1得1，其余得0
            // 所以，这里能够找到原数组中在那一位为0的数
            // 也就是说我们完成了分组的目的，将其全部进行异或，得到其中一个结果
            if ((cur & rightOne) == 0) {
                onlyOne1 ^= cur;
            }
        }

        int onlyOne2 = eor ^ onlyOne1;

        System.out.println(onlyOne1 + "&" + onlyOne2);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,5,6,6,7,7,8,8,9,9};

        printOddTimesNum2(arr);
    }

}
