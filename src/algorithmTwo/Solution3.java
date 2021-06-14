package algorithmTwo;

//374. 猜数字大小
public class Solution3 {
    public int guessNumber(int n) {
        int start = 1, end = n;
        int half = 1;
        while ((start != end)) {
            half = (int) (((long) start + (long) end) / 2);
            int guess = guess(half);
            if (guess == 0) {
                return half;
            }
            if (guess == -1) {
                end = half - 1;
            } else {
                start = half + 1;
            }
        }
        return start;
    }

    int guess(int num) {
        int pick = 3;
        return Integer.compare(pick, num);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().guessNumber(4));
    }
}
