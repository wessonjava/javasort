/**
 * @author wesson
 * @date 2020/7/2   21:29
 */
public class TestAbc {
    public static void main(String[] args) {
        String str = "abb";
        perfection(str.toCharArray(), 0);
    }

    /**
     * 字符串的排列组合，可重复
     * @param arr 待排列组合的字符数组
     * @param start 字符串的index
     */
    private static void perfection(char[] arr, int start) {
        if (arr.length - 1 == start) {
            System.out.println(arr);
        } else {
            char temp;
            for (int i = start; i < arr.length; i++) {
                temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;

                perfection(arr, start + 1);


            }
        }

    }


}

