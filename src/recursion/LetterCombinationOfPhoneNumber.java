package recursion;

import java.util.*;

class LetterCombinationOfPhoneNumber {

    private static final Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc"); map.put('3', "def");
        map.put('4', "ghi"); map.put('5', "jkl");
        map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");
    }

    static List<String> letterCombinations_1(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<String>();

        List<String> result = new ArrayList<>();
        letterCombinations_1(digits, 0, new StringBuilder(), map, result);

        return result;
    }

    static void letterCombinations_1(String digits, int i, StringBuilder path, Map<Character, String> map, List<String> result) {
        if (i == digits.length()) {
            result.add(path.toString());
            return ;
        }

        char[] chars = map.get(digits.charAt(i)).toCharArray();

        for (char c: chars) {
            path.append(c);
            letterCombinations_1(digits, i+1, path, map, result);
            path.setLength(path.length() - 1);
        }
    }

    static List<String> letterCombinations_2(String digits) {
        if (digits.isEmpty()) return new ArrayList<String>();

        List<String> res = new LinkedList<>();
        // init our buffer with first letters for each digit
        char[] buf = new char[digits.length()];
        for (int k = 0; k < buf.length; k++) {
            buf[k] = map.get(digits.charAt(k)).charAt(0);
        }

        // array of current letter's indices for each position
        int[] idx = new int[digits.length()];
        int i = 0;

        while (i < digits.length()) {
            res.add(new String(buf)); // add the current buffer to the result
            i = 0;

            // run through positions incrementing the corresponding index,
            // there could be two cases:
            // 1. we tried all letters at this position -> we must reset it and
            //     move to the next one;
            // 2. we find the position where we didn't try all, so we just
            //     increment corresponding index and break the loop,
            //     because we actually found the next combination.
            while (i < digits.length()) {
                idx[i] = (idx[i] + 1) % map.get(digits.charAt(i)).length();
                buf[i] = map.get(digits.charAt(i)).charAt(idx[i]);
                if (idx[i] != 0) break;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String digits = "23";
        // System.out.println("The result: "+ letterCombinations_1(digits));
        System.out.println("The result: "+ letterCombinations_2(digits));

    }
}