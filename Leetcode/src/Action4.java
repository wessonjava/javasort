import java.util.Scanner;

/**
 * @author wesson
 * @date 2020/8/13   23:32
 * 输入一个英文文章片段，翻转指定区间单词顺序，标点符号和普通字母一样处理，例如输入字符串"i am a maGua." 区间【0，3】，则输出"maGua. a am i"
 */
public class Action4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        String s = revStr(words, 1, 4);
        System.out.println(s);
    }

    public static String revStr(String s, int start, int end) {
        StringBuilder word = new StringBuilder();
        String[] strings = s.split("\\s");
        if (start != 0) {
            for (int i = 0; i < start; i++) {
                word.append(strings[i]).append(" ");
            }
        }
        for (int i = end; i >= start; i--) {
            if (i == start && strings.length - 1 == end) {
                word.append(strings[i]);
            } else {
                word.append(strings[i]).append(" ");
            }
        }
        if (strings.length > end) {
            for (int i = end + 1; i < strings.length; i++) {
                word.append(strings[i]).append(" ");
            }
        }
        return word.toString();
    }
}



