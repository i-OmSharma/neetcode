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
