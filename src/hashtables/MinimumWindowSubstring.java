import java.util.HashMap;

/**
 * #76. Minimum Window Substring
 *
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 */
class MinimumWindowSubstring {

    // the idea here is to use the hash tables and 2 pointers together
    static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()) map.put(c,map.getOrDefault(c,0) + 1);

        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;

        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }

                // found a window
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        // miss the left in window
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length())
        {
            return "";
        }

        return minLen > s.length()? "" : s.substring(minLeft, minLeft+minLen);
    }

    public static void main(String[] args) {
        System.out.println("The result of minWindow: "+minWindow("ABOBECODEBANC", "ABC"));
    }
}
