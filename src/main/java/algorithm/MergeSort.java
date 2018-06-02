package algorithm;

import java.util.Arrays;

public class MergeSort {
    public static int[] getArray(int count) {
        int[] a = new int[count];
        for (int i = 0; i < count; i++) {
            a[i] = (int)(Math.random()*100);
        }
        return a;
    }

    // 冒泡排序
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]){

                    /*a[i] = a[i] ^ a[j];
                    a[j] = a[i] ^ a[j];
                    a[i] = a[j] ^ a[i];*/

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] a, int begain, int end) {
        if (begain >= end){
            return;
        }
        int mark = a[begain];
        int left = begain;
        int right = end;
        while (true){
            if(left >= right){
                break;
            }

            while (a[right] >= mark && right>left){
                right--;
            }

            while (a[left] <= mark && left<right){
                left++;
            }

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        a[begain] = a[left];
        a[left] = mark;
        quickSort(a,begain,left-1);
        quickSort(a,left+1,end);

    }

    // 合并排序
    public void mergeSort(int[] a,int step) {

        // somthing to do

        /*if (step > a.length/2){
            return;
        }
        int temp = step;
        for (int i = 0; i < a.length-1; ) {
            while (temp > 0 && a[i] < a[i+step]){



                i++;
                temp--;
            }


        }
        step = step * 2;
        mergeSort(a,step);*/
    }

    public static void main(String[] args) {
        int[] b = getArray(100);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print("|");
            if (i % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("==========================sort befor========================");
        long startTime = System.nanoTime();
        //Arrays.sort(b);   //  0.495022 ms

        //bubbleSort(b);    // 1.973946 ms

        //insertionSort(b);

        quickSort(b,0,b.length-1);

        long endTime = System.nanoTime();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]);
            System.out.print("|");
            if (i % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.println("startTime : "+ startTime);
        System.out.println("endTime   : "+ endTime);
        double total = (double) (endTime - startTime)/1000000;
        System.out.println("using time : " + total + " ms");
    }
}
