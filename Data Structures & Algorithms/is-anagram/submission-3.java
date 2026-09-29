class Solution {
    public boolean isAnagram(String s, String t) {
        // compare both lenght are same !
        if (s.length() != t.length()){
            return false;
        }

        //initalise count[]
        int[] count = new int[26];

        for(int i = 0; i< s.length(); i++){
            count[s.charAt(i) - 'a']++; //Increment for s
            count[t.charAt(i) - 'a']--; //Decrement for t
        }

        //check if count is 0
        for( int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
