class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            //Increment left pointer
            while( left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            //Decremnt right pointer
            while( left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            //convert to lowercase and comapre by converting lower case

            if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
