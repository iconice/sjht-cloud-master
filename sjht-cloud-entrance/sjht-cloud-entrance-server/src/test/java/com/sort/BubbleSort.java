package com.sort;

/**
 * ***************************************************
 * @ClassName com.sort.BubbleSort
 * @Description 冒泡排序
 * @Author maojianyun
 * @Date 2020/3/5 22:34
 * @Version V1.0
 * ****************************************************
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {11,3,29,49,30,7,50,63,46,11,1};
        BubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");//打印每个元素
        }
    }

    public static int[] bubbleSort(int[] arr) {
        int low=0;
        int high=arr.length-1;//设置变量的初始值
        while(low<high){
            int f1 =0,f2 =0;//每趟开始时,无记录交换
            for (int i= low; i< high; ++i) {         //正向冒泡,找到最大者
                if (arr[i]> arr[i+1]) {
                    int tmp = arr[i]; arr[i]=arr[i+1];arr[i+1]=tmp;
                    f1=i;
                }
            }
            high = f1;// 记录上次位置
            for (int j=high; j>low; --j) {          //反向冒泡,找到最小者
                if (arr[j]<arr[j-1]) {
                    int tmp = arr[j]; arr[j]=arr[j-1];arr[j-1]=tmp;
                    f2=j;
                }
            }
            low = f2; //修改low值
        }
        return arr;
    }
}
