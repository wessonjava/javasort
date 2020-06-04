import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] elem = {13, 2, 15, 10, 3};
        //  insertSort(elem);
        //  insertSort2(elem);
        //  shellSort(elem);
        //  binaryIsertSort(elem);
        //  quickSort(elem,0,4);
        //  shellSort(elem);

        for (int i = 0; i < elem.length; i++) {
            System.out.println(elem[i]);
        }
    }

    /**
     * 1直接插入排序
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //取出下个元素 在前面已经排好序的列中扫描
            int temp = arr[i];
            for (int j = i; j >= 0; j--) {
                if (j > 0 && arr[j - 1] > temp) {
                    //后移该元素
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    /**
     * 2交换次数较多的直接插入法
     */
    public static void insertSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] <= arr[j]) {
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

            }
        }
    }

    /**
     * 3希尔排序
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {
            //直到gap=1
            for (int i = 0; i + gap < arr.length; i++) {
                for (int j = 0; j + gap < arr.length; j += gap) {
                    if (arr[j] > arr[j + gap]) {
                        //交换
                        int temp = arr[j];

                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }

            }
        }

    }

    /**
     * 4折半插入排序
     * 取已经排好序的数组的中间元素，与插入的数据进行比较  比较次数减少
     */
    public static void binaryIsertSort(int[] arr) {
        int low, high, m, temp, i, j;
        for (i = 1; i < arr.length; i++) {
            //折半查找插入位置
            low = 0;
            high = i - 1;
            while (low <= high) {
                m = (low + high) / 2;
                if (arr[m] > arr[i]) {
                    high = m - 1;


                } else {
                    low = m + 1;

                }
            }

            //统一移动元素并插入
            temp = arr[i];
            for (j = i - 1; j >= low; j--) {
                arr[j + 1] = arr[j];
            }
            arr[low] = temp;
        }
    }

    /**
     * 5冒泡排序
     */

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; 0 < i; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 6快速排序(递归)
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        //bash中放基数
        int bash = arr[left];
        int i = left, j = right;
        while (i != j) {
            //从右边网左边找，直到找到比bash小的数
            while (arr[j] >= bash && i < j) {
                j--;

            }
            //从左往右找 直到找到比bash大的数
            while (arr[i] <= bash && i < j) {
                i++;
            }
            //上面结束说明找到位置了或者i>=j了，交换两个数在数组中位置
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //将基数放到中间的位置
        arr[left] = arr[i];
        arr[i] = bash;

        //递归操作
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 7简单选择排序
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //交换
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    /**
     * 8
     */
    public static void e123() {

    }
}

