import java.util.Scanner;

/**
 * @author wesson
 * @date 2020/8/12   01:42
 * <p>
 * 给定一个包含大写英文字母字符串S，要求你给出对S重新排列的所有不同的排列数，
 * 如S=ABA，则不同的排列有ABA，AAB,BAA
 * 输入
 * 长度不超过10的字符串S，确保大写
 * 输出
 * S的重排个数（包含本身）
 */
public class Action2 {
    public static void main(String[] args) {
        System.out.println("长度不超过10的字符串S，确保大写");
        Scanner in = new Scanner(System.in);

        String s = in.nextLine().toUpperCase();

        char[] chars = s.toCharArray();
        while (chars.length >= 10) {
            System.out.println("请重新输入");
            continue;
        }

    }
}
