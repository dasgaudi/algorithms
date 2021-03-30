class ShortestPalindrome {

    // the idea is to convert this problem into the longest palindrome
    /**
     * The LPS computation can determine, at any given index i in a string S, the maximum suffix length that
     * make up a suffix equal to the prefix. For example: S = "acexxxaceyyy": at S[6], S[7], and S[8] will be
     * marked with "1", "2", and "3" respectively because "a", "ac", and "ace" at this points in the string
     * make up substrings whose suffixes equal to the string's prefix. This computation can be done in one
     * linear scan of the string in O(N) time, using a secondary integer array in O(N) space.
     *
     * For our purpose in finding the longest palindrome prefix of a string, the idea is simple:
     * if we reverse the string, then appending it to the original string (after a special marker),
     * the palindromic prefix will show up at the end of the compound string! If we then apply the above algorithm,
     * by the end of the linear scan, we'll have a number that correspond to the maximum suffix length of
     * the entire compound string, which correspond to a suffix = prefix. And since a palindromic prefix, when
     * reversed and appended, will show up as the suffix, we will conveniently have computed the maximum
     * length of the palindromic prefix!
     *
     * For example: consider the string S = "abbaaax". The longest palindrome prefix is "abba".
     * 1. Create S' = "abbaaax#xaaabba"
     * 2. Compute LPS: lps[] = { 0,  0,  0,  1,  1,  1,  0,  0,  0,  1,  1,  1,  2,  3,  4 }
     *            from  S'[] = {'a','b','b','a','a','a','x','#','x','a','a','a','b','b','a'}
     * 3. The last element of LPS, 4, is our longest palindrome prefix length!
     */
    static String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    static int[] getTable(String s){
        int[] table = new int[s.length()];

        int index = 0;
        for(int i = 1; i < s.length(); ){
            if(s.charAt(index) == s.charAt(i)){
                table[i] = ++index;
                i++;
            } else {
                if(index > 0){
                    index = table[index-1];
                } else {
                    index = 0;
                    i ++;
                }
            }
        }
        return table;
    }

    public static void main(String[] args) {
        System.out.println("The shortest palindrome of aacecaaa: " +shortestPalindrome("aacecaaa"));
    }
}
