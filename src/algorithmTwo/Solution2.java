package algorithmTwo;

//278. 第一个错误的版本
public class Solution2 {
    public int firstBadVersion(int n) {
        return findBug(1, n);
    }

    public int findBug(int start, int end) {
        int target = 1;
        if (start == end) {
            return start;
        }
        int half = (int) (((long) start + (long) end) / 2);
        boolean idBad = isBadVersion(half);
        if (idBad) {//在 0 - half中有一个
            target = findBug(start, half);
        } else {//在half+1 -n 中有一个
            target = findBug(half + 1, end);
        }
        return target;
    }

    boolean isBadVersion(long version) {
        if (version >= 1702766719) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().firstBadVersion(2126753390));
    }
}
