package hashtables;

import java.util.Arrays;

class IsAnagram {

    static boolean isAnagram_1(String s, String t) {
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        Arrays.sort(char_s);
        Arrays.sort(char_t);

        return  String.valueOf(char_s).equals(String.valueOf(char_t));
    }

    // another way is to
    static boolean isAnagram_2(String s, String t) {
        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++) arr[s.charAt(i) - 'a']++;
        for(int i=0; i<t.length(); i++) arr[t.charAt(i) - 'a']--;

        for(int i: arr) if (i!=0) return false;
        return true;

    }
}
