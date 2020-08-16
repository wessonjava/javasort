import java.util.Scanner;

/**
 * @author wesson
 * @date 2020/8/13   22:45
 * 题目给定一个URL的前缀和后缀，通过","分割，需拼接成一个完整的URL，如前缀结尾 后缀开头没有"/"，补上/连接符，若都存在，自动去重。
 * 1分割得到前后缀
 * 2判断前缀末尾  后缀开头
 */
public class Action3 {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder(200);
        Scanner in = new Scanner(System.in);
        //获得前缀
        String s2 = in.nextLine();
        String[] s3 = s2.split("\\,");
        String prefix = s3[0];
        //获得后缀
        String suffix = s3[1];
        int length1 = prefix.length();
        if (prefix.charAt(length1 - 1) != '/' && suffix.charAt(0) != '/') {
            s.append(prefix + "/" + suffix);
        } else if (prefix.charAt(length1 - 1) == '/' && suffix.charAt(0) == '/') {
            String suffixnew = suffix.substring(1);
            s.append(prefix + suffixnew);
        } else if (prefix.charAt(length1 - 1) != '/' && suffix.charAt(0) == '/') {
            s.append(prefix + suffix);
        } else {
            s.append(prefix + suffix);
        }

        System.out.println(s.toString());
    }
}
