package algorithmOne;

import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:  71. 简化路径
 * @Author: yuzhengshu
 * @Date: 2021年6月11日 16:32
 */
public class Solution29 {
    /**
     * // => /
     * /./ =? /
     * /../ => 返回上一级
     * 末尾不能 /
     * eg:/a/./b/../../c/
     * /a/b/../../c/
     * /a/../c/
     * /c/
     * /c
     */
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String str : split) {
            switch (str) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            String character = stack.pollLast();
            res.append("/").append(character);
        }
        return res.toString();
    }

    /**
     * java nio
     */
    public String simplifyPath1(String path) {
        return Paths.get(path).normalize().toString();
    }

    public static void main(String[] args) {
        // /home
        String str = "/..//////";
        System.out.println(simplifyPath(str));
    }
}
