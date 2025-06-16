// for (int i = 0; i < s.length(); i++) {
//     // odd
//     // even
//     // update start & end
// }
// return s.substring(start, end + 1);

class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for(int i=0; i < s.length(); i++)
        {
            int left = i, right = i;
            //odd
            while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            int len1 = right-left-1;

            left = i;
            right = i + 1;
            //even
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
            }
            int len2 = right - left - 1;

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();
        String input = "babad";
        String result = sol.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}