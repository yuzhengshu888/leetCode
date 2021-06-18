package algorithmTwo;

import java.util.*;

/**
 * @description: 649. Dota2 参议院
 * @Author: yuzhengshu
 * @Date: 2021年6月18日 17:06
 */
public class Solution14 {
    public static String predictPartyVictory(String senate) {
        int length = senate.length();
        List<Character> list = new ArrayList<>(length);
        int countD = 0, countR = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'D') {
                countD++;
            } else {
                countR++;
            }
            list.add(c);
        }
        char delChar;
        int i = 0;
        while (countD > 0 && countR > 0) {
            if (i + 1 > list.size()) {
                i = 0;
            }
            delChar = list.get(i) == 'R' ? 'D' : 'R';
            //往后找
            boolean afterHas = false;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) == delChar) {
                    afterHas = true;
                    list.remove(j);
                    if (delChar == 'D') {
                        countD--;
                    } else {
                        countR--;
                    }
                    break;
                }
            }
            if (!afterHas) {
                for (int j = 0; j < i; j++) {
                    if (list.get(j) == delChar) {
                        list.remove(j);
                        if (delChar == 'D') {
                            countD--;
                        } else {
                            countR--;
                        }
                        i--;
                        break;
                    }
                }
            }
            i++;
        }
        return countD > 0 ? "Dire" : "Radiant";
    }

    public static String predictPartyVictory1(String senate) {
        char[] chars = senate.toCharArray();
        int length = chars.length;
        char delChar;
        int i = 0;
        boolean isEnd = false;
        while (!isEnd) {
            if (i + 1 > length) {
                i = 0;
            }
            delChar = chars[i] == 'R' ? 'D' : 'R';
            //往后找
            boolean afterHas = false;
            for (int j = i + 1; j < length; j++) {
                if (chars[j] == delChar) {
                    afterHas = true;
                    list.remove(j);
                    if (delChar == 'D') {
                        countD--;
                    } else {
                        countR--;
                    }
                    break;
                }
            }
            if (!afterHas) {
                for (int j = 0; j < i; j++) {
                    if (chars[j] == delChar) {
                        list.remove(j);
                        if (delChar == 'D') {
                            countD--;
                        } else {
                            countR--;
                        }
                        i--;
                        break;
                    }
                }
            }
            i++;
        }
        return countD > 0 ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String str = "RRDDDD";
        System.out.println(predictPartyVictory(str));
    }
}
