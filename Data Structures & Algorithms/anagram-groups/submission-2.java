class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        //Map frequency , Key: Frequency string, value : anagrams

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            //create frequency array
            int[] count = new int[26];
            for(char c: str.toCharArray()) {
                count[c - 'a']++;
            }

            //map uniqstirng with Count array
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i< 26; i++) {
                sb.append(count[i]);
                sb.append('#'); // seperator for 12 and 1,2 notget mixed
            } 
            String key = sb.toString();

            //Add into the Map
            if( !map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}


/* 
 * Approach to Group Anagrams using Character Frequency:
 * 1. Ek HashMap banao jiska Key = Frequency String ho aur Value = Anagrams ki List ho.
 * 2. Input array ke har string par loop chalao:
 *    - 'a' se 'z' ke liye 26 size ka ek frequency count array banao.
 *    - String ke har character ke liye, uska count index (char - 'a') par badhao.
 *    - Frequency array ko ek unique String key mein convert karo (jaise "1#0#1#...").
 *      Counts ko alag dikhane ke liye '#' separator use karo (taaki 12 aur 1,2 mix na hon).
 *    - Agar ye key map mein pehle se nahi hai, toh uske liye nayi empty list banao.
 *    - Original string ko is key wali list mein add kar do.
 * 3. Finally, HashMap ki saari values (lists) ko result ke roop mein return karo.
 */