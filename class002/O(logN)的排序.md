## subject1 归并排序

    * 整体就是一个简单递归，左边排好序，右边排号序，使其整体有序
    * 让整体有序的过程里用了外排序方法
    * 利用master公式来求解时间复杂度
    * 归并排序的是指

    时间复杂度O(N*logN)，额外空间复杂度O(N)


归并排序的扩展

小和问题和逆序对问题

小和问题

在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和


逆序对问题

在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印出所有的逆序对。


荷兰国旗问题

问题一：

    给定一个数组arr,和一个数num,请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)。

问题二：

    给定一个数组arr,和一个数num,请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度O(1),时间复杂度O(N)


    
