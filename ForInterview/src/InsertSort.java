import java.util.Arrays;

/**
 * @author wesson
 */
public class InsertSort {
    //提交测试
    public static void main(String[] args) {
        int[] elem = {13, 2, 15, 10, 3};
        insertSort(elem);
        //  insertSort2(elem);
        //  shellSort(elem);
        //  binaryIsertSort(elem);
        //  quickSort(elem,0,4);
        //  shellSort(elem);
       // heapSort(elem);

        for (int i = 0; i < elem.length; i++) {
            System.out.println(elem[i]);
        }
    }

    /**
     * 1  插入算法  直接插入排序
     * 将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过为止
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
     * 1 插入算法  交换次数较多的直接插入法
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
     * 1 插入算法 希尔排序
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
     * 1 插入算法  折半插入排序
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
     * 2 交换算法 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
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
     * 2 交换算法 快速排序(递归)
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
     * 3 选择算法 简单选择排序
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
     * 3 选择算法 堆排序
     * 以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
     * 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
     * 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
     * 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            max_heapify(arr, i);
            //堆顶元素与Kn交换
            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }


    }

    private static void max_heapify(int[] arr, int limit) {
        if (arr.length <= 0 || arr.length < limit) {
            return;
        }
        int parentIdx = limit / 2;
        for (; parentIdx >= 0; parentIdx--) {
            if (parentIdx * 2 >= limit) {
                continue;
            }
            //左节点位置
            int left = parentIdx * 2;
            //右节点位置，若没有右节点 默认为左节点
            int right = (left + 1) >= limit ? left : (left + 1);

            int maxChildId = arr[left] >= arr[right] ? left : right;

            //交换父节点左右结点中最大值
            if (arr[maxChildId] > arr[parentIdx]) {
                int temp = arr[maxChildId];
                arr[parentIdx] = arr[maxChildId];
                arr[maxChildId] = temp;

            }
        }
    }

    /**
     * 4 归并排序
     * 归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * ③. 重复步骤②，直到所有元素排序完毕。
     */
    public static int[] mergingSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int num = arr.length >> 1;
        int[] leftArr = Arrays.copyOfRange(arr, 0, num);
        int[] rightArr = Arrays.copyOfRange(arr, num, arr.length);
        System.out.println("split two array: " + Arrays.toString(leftArr) + " And " + Arrays.toString(rightArr));
        return mergeTwoArray(mergingSort(leftArr), mergingSort(rightArr));
        //不断拆分为最小单元，再排序合并
    }

    private static int[] mergeTwoArray(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];
        //申请额外的空间存储合并之后的数组
        while (i < arr1.length && j < arr2.length) {
            //选取两个序列中的较小值放入新数组
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            //序列1中多余的元素移入新数组
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            //序列2中多余的元素移入新数组
            result[k++] = arr2[j++];
        }
        System.out.println("Merging: " + Arrays.toString(result));
        return result;
    }

    /**
     * 5 在线性时间内排序  基数排序（LSD 从低位开始）
     * <p>
     * 基数排序适用于：
     * (1)数据范围较小，建议在小于1000
     * (2)每个数值都要大于等于0
     * <p>
     * ①. 取得数组中的最大数，并取得位数；
     * ②. arr为原始数组，从最低位开始取每个位组成radix数组；
     * ③. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     *
     * @param arr 待排序数组
     */
    public static void radixSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        System.out.println("maxDigit: " + maxDigit);

        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];
            //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }

            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }
}


