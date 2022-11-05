## subject1

**常数时间的操作**

*一个操作如果和样本的数据量没有关系，每次都是固定时间内完成的操作，叫做常数操作*

时间复杂度为一个算法流程中，常数操作数量的一个指标。常用O（big O）来表示。具体来说，先要对一个算法流程非常熟悉，然后去写出这个算法流程中，发生了多少常数操作，进而总结出常数操作数量的表达式。

在表达式中，只要高阶项，不要低阶项，也不要高阶项的系数，剩下的部分如果为f(N)，那么时间复杂度为O(f(N))。

评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是“常数项时间”。


## subject2

**选择排序、冒泡排序细节与复杂度分析**

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

## subject3

### 异或运算 （^）
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


