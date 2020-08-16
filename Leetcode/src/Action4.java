/**
 * @author wesson
 * @date 2020/8/13   23:32
 * 输入一个英文文章片段，翻转指定区间单词顺序，标点符号和普通字母一样处理，例如输入字符串"i am a magua." 区间【0，3】，则输出"magua. a am i"
 */

/*public class Action4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String[] wordArr = words.split("\\s");
        reversr(words, 0, 3);
    }

    public static String reversr(String s, int start, int end) {
        StringBuilder word = new StringBuilder();
        for (int i = end; i >= start; i--) {
            if (i == start) {
                word.append(wordArr[i]);
            }
            word.append(wordArr[i] + " ");
        }

    }
}

*/


