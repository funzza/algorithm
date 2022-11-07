## subject1 常数时间的操作


*一个操作如果和样本的数据量没有关系，每次都是固定时间内完成的操作，叫做常数操作*

时间复杂度为一个算法流程中，常数操作数量的一个指标。常用O（big O）来表示。具体来说，先要对一个算法流程非常熟悉，然后去写出这个算法流程中，发生了多少常数操作，进而总结出常数操作数量的表达式。

在表达式中，只要高阶项，不要低阶项，也不要高阶项的系数，剩下的部分如果为f(N)，那么时间复杂度为O(f(N))。

评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是“常数项时间”。


## subject2 选择排序、冒泡排序细节与复杂度分析


### 选择排序

给定一个数组，数组长度为N。

从i(0)位置到N-1位置遍历，找到最小的元素，与0位置元素做交换，固定0位置元素为最小；

从i(1)位置到N-1位置遍历，找到最小的元素，与1位置元素做交换，固定1位置元素为第二小；

直到i = N -1，结束循环。

*时间复杂度为O(N^2),额外空间复杂度O(1)*

code:
````java
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
````
### 冒泡排序

给定一个数组nums，数组长度为N。

从0到N-2位置遍历，将当前每一个元素与后面一个元素做比较，前面的元素比后面的元素大则两两交换，一轮循环后，固定数组N-1元素为该数组中元素最大值；

第二轮循环，从0位置到N-3位置遍历...固定数组中N-2为该数组中元素第二大的值；

直到没有相邻元素需要交换，数组有序。

*时间复杂度O(N^2)，额外空间复杂度O(1)*

code:
````java
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
````

## subject3 异或运算 （^）

*相同为0不同为1*

**还可以理解为无进位相加**

* 0 ^ N = N     N ^ N = 0
* 异或运算满足交换律和结合律

code:
````java
    public static void swap() {
        int a = 甲;
        int b = 乙;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
````

第一条语句得：

    a = 甲 ^ 乙

    b = 乙

第二条语句得：

    a = 甲 ^ 乙

    b = a ^ b
      = (甲 ^ 乙) ^ 乙
      = 甲

第三条语句得：
    
    b = 甲

    a = a ^ b
      = (甲 ^ 乙) ^ 甲
      = 乙


### example
leetcode136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

题解： 此题可以利用异或相等得0的性质。将该数组所有元素进行异或，最后得到的元素为只出现了一次的元素。

code:
````java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
````
拓展：

给定一个非空整数数组，除了某两个元素只出现一次以外，其余每个元素均出现两次。找出那两个只出现了一次的元素。

题解：

    首先，将整个数组异或一边，得到的结果为两个只出现一次元素的异或结果。
    设这两个元素分别为a和b,结果为result，则result = a ^ b。
    因为a、b不相等，所以a、b的二进制值必然至少有一位不相等。
    而相等的元素其二进制值每一位都相等。
    我们不妨以a、b不相等的一位做区分，将元素分为在那一位为0的和在那一位为1的，相同的元素必然只会出现一组中，所以任意一组的除a、b外其它相同元素的个数都是偶数个。
    此时，元素被分为了两组，a、b不在一组中，那么将任意一组进行异或操作，最后的结果就是a或b。
    此时得到的结果与result进行异或，则找到另一个只出现一次的元素。

code:

````java
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
````

## subject4 插入排序
插入排序的基本思想是将一个记录插入到已经排好序的有序数组中，从而扩充该有序数组，直至这个有序数组的长度与需要排序的数组长度相等。

具体做法：

从有序数组的边界相邻后一个元素从右向左与有序数组的每一位进行比较，如果比数组中的元素值小，则两两交换。当遍历只位置为1或不比当前比较的有序数组中的元素值小则停止比较，有序数组长度+1。直至这个有序数组的长度与需要排序的数组长度相等。

*时间复杂度O(N^2)，额外空间复杂度O(1)*

当一个数组本身有序的时候，算法时间复杂度是O(N)。当我们要对一个大部分元素有序的数组进行排序时，可以使用插入排序。

code:
````java
    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
````

## subject5 二分法

### *在一个有序数组中，找某个数是否存在*

code:
````java
    public static int exist(int[] arr, int num) {

        int left = 0;
        int right = arr.length - 1;
        int middle = ((right - left) >> 1) + left;

        while(left <= right) {
            if (num > arr[middle]) {
                left = middle + 1;
                middle = ((right - left) >> 1) + left;
            } else if (num < arr[middle]) {
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            } else {
                return middle;
            }
        }

        return -1;
    }
````


### *在一个有序数组中，找 >= 某个数最左侧的位置*

````java
    public static int neartLeft(int[] arr, int num) {

        int left = 0;
        int right = arr.length - 1;
        int middle = ((right - left) >> 1) + left;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            if (num > arr[middle]) {
                left = middle + 1;
                middle = ((right - left) >> 1) + left;
            } else if (num < arr[middle]) {
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            } else {
                result = middle;
                right = middle - 1;
                middle = ((right - left) >> 1) + left;
            }
        }

        if (result < Integer.MAX_VALUE) {
            return result;
        } else {
            return -1;
        }
    }
````


### *局部最小值问题*


给定一个无序数组，相邻两个数一定不相等

局部最小：

    * 0位置的元素比1位置的元素小，则0位置的元素为局部最小
    * n-1位置的元素比n-2位置的元素小，则n-1位置的元素为局部最小
    * i位置的元素比i-1、i+1位置的元素小，则i位置的元素为局部最小


## subject6 对数器

    * 有一个需要测试的方法A
    * 有一个实现复杂度不好，但是容易实现的方法B
    * 实现一个随机样本产生器
    * 把方法A和方法B跑相同的随机样本，看看得到的结果是否一样
    * 如果有一个随机样本使得比对结果不一致，打印样本进行人工干预
    * 当样本数量很多时比对测试依然正确，可以确定方法A已经正确


## subject7 递归

*递归行为和时间复杂度的估算*










