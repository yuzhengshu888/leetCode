package algorithmTwo;

/**
 * @description: 65. 有效数字
 * @Author: yuzhengshu
 * @Date: 2021年6月17日 15:31
 */
public class Solution10 {
    /**
     * 偷懒解法
     */
    public static boolean isNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        if (s.equals("+Infinity") || s.equals("Infinity") || s.equals("-Infinity") || s.endsWith("f") || s.contains("F") || s.endsWith("D") || s.endsWith("d")) {
            return false;
        }
        return true;
    }

    /**
     * 确定的有限状态机 DFA
     */
    public static boolean isNumber1(String s) {
        State state = State.STATE_INITIAL;
        for (char c : s.toCharArray()) {
            switch (state) {
                //起始状态
                case STATE_INITIAL: {
                    if (c == '-' || c == '+') {
                        state = State.STATE_INT_SIGN;
                    } else if (Character.isDigit(c)) {
                        state = State.STATE_INTEGER;
                    } else if (c == '.') {
                        state = State.STATE_POINT_WITHOUT_INT;
                    } else {
                        return false;
                    }
                    break;
                }
                //符号位
                case STATE_INT_SIGN: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_INTEGER;
                    } else if (c == '.') {
                        state = State.STATE_POINT_WITHOUT_INT;
                    } else {
                        return false;
                    }
                    break;
                }
                //整数部分
                case STATE_INTEGER: {
                    if (c == '.') {
                        state = State.STATE_POINT;
                    } else if (c == 'e' || c == 'E') {
                        state = State.STATE_EXP;
                    } else if (Character.isDigit(c)) {
                        state = State.STATE_INTEGER;
                    } else {
                        return false;
                    }
                    break;
                }
                //小数点(左有整数)
                case STATE_POINT: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = State.STATE_EXP;
                    } else {
                        return false;
                    }
                    break;
                }
                //小数点(左无整数)
                case STATE_POINT_WITHOUT_INT: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_FRACTION;
                    } else {
                        return false;
                    }
                    break;
                }
                //小数部分
                case STATE_FRACTION: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = State.STATE_EXP;
                    } else {
                        return false;
                    }
                }
                break;
                //字符e
                case STATE_EXP: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_EXP_NUMBER;
                    } else if (c == '-' || c == '+') {
                        state = State.STATE_EXP_SIGN;
                    } else {
                        return false;
                    }
                    break;
                }
                //指数符号
                case STATE_EXP_SIGN: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_EXP_NUMBER;
                    } else {
                        return false;
                    }
                    break;
                }
                //指数数字 这个状态可以合并
                case STATE_EXP_NUMBER: {
                    if (Character.isDigit(c)) {
                        state = State.STATE_EXP_NUMBER;
                    } else {
                        return false;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return state == State.STATE_INTEGER
                || state == State.STATE_POINT
                || state == State.STATE_FRACTION
                || state == State.STATE_EXP_NUMBER;
    }

    enum State {
        STATE_INITIAL, //起始状态
        STATE_INT_SIGN, //符合位
        STATE_INTEGER, //整数部分 完结
        STATE_POINT,  //小数点(左有整数) 完结
        STATE_POINT_WITHOUT_INT, //小数点(左无整数)
        STATE_FRACTION, //小数部分 完结
        STATE_EXP, //字符e
        STATE_EXP_SIGN,//指数符号
        STATE_EXP_NUMBER, //指数数字 完结
    }

    public static void main(String[] args) {
        String str = "3.";
        System.out.println(isNumber(str));
        System.out.println(isNumber1(str));
    }
}
